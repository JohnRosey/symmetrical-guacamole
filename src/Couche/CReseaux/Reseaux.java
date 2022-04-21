package Couche.CReseaux;

import Couche.CTransport.TransportCouche;
import Couche.LiasonDonnee.LiaisonDonnee;
import Enum.state;
import Paquet.*;
import Primitive.*;

import java.util.ArrayList;
import java.util.Optional;

//une classe qui presenter la couche Reseaux
public class Reseaux {
    //table de controle de couche Reseaux
    private final ArrayList<Connexion> TCR;

    //son couche Superieure -> couche Transport
    private TransportCouche transport;

    //definir un counter ,qui va presenter le numero de connexion (auto-increment)
    private int counter;

    //son couche inferieure -> couche LiaisonDonnee
    private final LiaisonDonnee liaisonDonnee;

    public Reseaux() {
        this.TCR = new ArrayList<>();
        this.counter = 1;
        this.liaisonDonnee = new LiaisonDonnee();
        this.liaisonDonnee.setReseaux(this);
    }

    //    la methode qui permet de lire les primitive envoye par la couche transport
    public void lire_de_transport(int id, Primitive p) {
        if (p.getClass() == NConnectReq.class)//si c'est un primitive NConnectReq

//            reponde aleatoirement de primitive NConnectReq
            decisionFournisseurAleatoire(id, (NConnectReq) p);

        else if (p.getClass() == NDataReq.class) {//si c'est un primitive NDataReq
            Connexion connexion = findConnexionByid(id);
            connexion.setInfoAtransmettre(((NDataReq) p).getDonneeUser());

//            lancer le processus de transfert des donnees
            gestionTransfertDonnee(connexion);
        } else if (p.getClass() == NDisconnectReq.class) {//si c'est un primitive NDisconnectReq
            Connexion connexion = findConnexionByid(id);

//            liberer les resource
            TCR.remove(connexion);

//            envoyer le paquet Indication Liberation
            envoyerPaquet(new PaquetIndLiberation(connexion.getNumeroConnexion(), "00000001",
                    connexion.getAdrSourece(), connexion.getAdrDestination(), "ET terminer la liaison de donne"));
        }

    }

    //    Une methode qui evoyer les primitive et id vers la couche transport
    private void ecrire_vers_transport(int id, Primitive p) {
        transport.lire_de_reseau(id, p);
    }


    //    le Fournisseur reseau peut refuser ou accepter le demande de connexion du couche transport
//    ce processus est aleatoire
    private void decisionFournisseurAleatoire(int id, NConnectReq nConnectReq) {
        int adrSource = nConnectReq.getAdrSource();
        int adrDestination = nConnectReq.getAdrDestination();

//        si l’adresse de la station source est un multiple de 27, le fournisseur refuse la connexion.
        if (adrSource % 27 == 0) {
            NDisconnectInd nDisconnectInd = new NDisconnectInd(adrSource, "refus par  le Serveur");
            ecrire_vers_transport(id, nDisconnectInd);
        } else {//sion accepter , et envoyer le paquet appel
            //creer un nouveau object Connexion,et l'ajouter dasn la table de controle
            Connexion connexion;
            connexion = new Connexion(state.en_attente_de_confirmation_etablissement,
                    adrSource, adrDestination, id, counter++);
            TCR.add(connexion);

            //envoyer le paquet appel, en utilissant le service liason donnee(ecrit dans le fihcier L_ecr)
            PaquetAppel p = new PaquetAppel(connexion.getNumeroConnexion(),
                    "00001011", adrSource, adrDestination);
            envoyerPaquet(p);
        }
    }


    //    une methode qui gerer les transfert des donnees
    public void gestionTransfertDonnee(Connexion connexion) {

//        si le nb de Retransmissions d'un paquet >1, on ne peut pas retransmettre ce paquet encore,
//        on doit transmettre la prochain paquet(si il y en a)
        if (connexion.getNbRetransmissions() > 1) {

//            on va envoyer la prochaine paqeut, donc ,augementer p(s) ,
            connexion.augmenterPs();

//            reset le NbRetransmissions=0, parce que on va envoyer la prochaine paqeut
            connexion.setNbRetransmissions(0);
        }

//        obtenir le p(s) courant
        int ps = connexion.getPs();

        String typePaquet, bitM, strPsBinaire, strPrBinaire = "000";

//        Car dans le specification,Nous envoyons uniquement des informations, nous ne recevons pas d'informations,donc p(r)est tousjour 0!!!
        String msgSegment = segmenterMessage(connexion.getInfoAtransmettre(), ps);

//        si il y a plus de paquet a transmettre , arrêter de transmettre
        if (msgSegment == null) {
            return;
        }

        // si le paquet est le dernier (ou l’unique) segment du message.
        else if (segmenterMessage(connexion.getInfoAtransmettre(), ps + 1) == null)
            bitM = "0";

        else
            bitM = "1";


//        transforme un int en binaire et en type String
        //module 8 numerotation
        strPsBinaire = Integer.toBinaryString(ps % 8);

        //p(s)est en 3 bits, si strPsBinaire est petite , on va remplissage avec les 0
        strPsBinaire = switch (strPsBinaire.length()) {
            case 1 -> "00" + strPsBinaire;
            case 2 -> "0" + strPsBinaire;
            default -> strPsBinaire;
        };

        typePaquet = strPrBinaire + bitM + strPsBinaire + "0";

        //apres construire le paquet de donnee, augmenter le p(s)
        connexion.augmenterPs();

        //envoyer le paquet de donne
        envoyerPaquet(new PaquetDonnee(connexion.getNumeroConnexion(), typePaquet, msgSegment));
    }

    //une methode qui envoyer un paquet en utlisant le service de liason de donne
    private void envoyerPaquet(Paquet p) {
        liaisonDonnee.gestionPaquets(p);
    }


    //une methode qui permet de recevoir le paquet de dianstant(en simulant par une processus alelatoire)
    public void recevoirPaquetDistant(Paquet p, int nuemroConnexion) {

        //si p==null -> on ne recoit pas de reponde
        if (p == null) {

            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);

            //si dans cette connexion, app source a envoye paquet appel, mais il ne recois pas de reponde
            if (connexion.getEtatConnexion() == state.en_attente_de_confirmation_etablissement) {

                //envoyer le primitive nDisconnectInd a la couche transport
                NDisconnectInd nDisconnectInd = new NDisconnectInd(connexion.getAdrSourece(), "la demande ne reçoit pas de réponse");
                ecrire_vers_transport(connexion.getId(), nDisconnectInd);
            }

            //si dans cette connexion, app source a envoye un paquet de donnee, mais il ne recois pas de reponde
            else {

                //p(s) - 1, parce que la fenetre d'anticpation = 1
                connexion.diminuerPs();

                //augementer le NbRetransmissions, et essayer de retransmettre le paquet
                connexion.setNbRetransmissions(connexion.getNbRetransmissions() + 1);
                gestionTransfertDonnee(connexion);
            }

        }

        //si on a recu un Paquet Indication Liberation
        else if (p.getClass() == PaquetIndLiberation.class) {

            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);
            TCR.remove(connexion);//liberer la resource

            //envoyer le primitive nDisconnectInd vers la couche transport
            NDisconnectInd nDisconnectInd = new NDisconnectInd(connexion.getAdrSourece(), "refus de connexion de la part du distant");
            ecrire_vers_transport(connexion.getId(), nDisconnectInd);
        }

        //si on a recu un Paquet Communication Etablie
        else if (p.getClass() == PaquetCommunicationEtablie.class) {
            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);

            //changer l'etat de connexion de cette connexion courante
            connexion.setEtatConnexion(state.connexion_etablie);

            //envoyer le primitive nConnectConf vers la couche transport
            NConnectConf nConnectConf = new NConnectConf(connexion.getAdrSourece());
            ecrire_vers_transport(connexion.getId(), nConnectConf);
        }

        //si on a recu un Paquet de aquittement
        else if (p.getClass() == PaquetAquittement.class) {

            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);

            /*
            si p(r) de pacquet auquittement != p(s) de expéditeur, cela indique que:
            le prochiane paquet doit etre evoye != le le prochiane paquet que le récepteur veut recevoir
            donc, dan ce cas , on a recu un paquet d'aquittement negative
             */
            if ((connexion.getPs() % 8) != Integer.valueOf(p.getTypePaquet().substring(0, 3), 2)) {


                //Attribuer p(r) à p(s)
                connexion.setPs(Integer.valueOf(p.getTypePaquet().substring(0, 3), 2));

                //Retransmettre le dernier paquet
                connexion.setNbRetransmissions(connexion.getNbRetransmissions() + 1);
                gestionTransfertDonnee(connexion);
            } //si on a recu un auquittement positive, envoyer la prochiane paquet
            else {
                gestionTransfertDonnee(connexion);
            }
        }
    }

    //processus de segmentation de message
    public String segmenterMessage(String msg, int ps) {

        //si le longeur<128 , ne faire pas le segmenattion
        if (msg.length() <= 128&&ps==0) return msg;

            //si il est la dernier segment
        if ((ps + 1) << 7 > msg.length()&& ps << 7 <msg.length())
            return msg.substring(ps * 128);

            //si tous les segments sont deja envoyes
        else if(ps * 128>=msg.length())
            return null;

            //dans l'autre cas, on va faire la segmenation
        return msg.substring(ps << 7, (ps + 1) << 7);
    }

    //une methode qui permet de trouver un Connexion par numero de connexion
    public Connexion findConnexionByNumeroConnexion(int id) {
        //A container object which may or may not contain a non-null value. If a value is present, isPresent() returns true.
        Optional<Connexion> connexionOptional = Optional.empty();
        for (Connexion connexion : TCR) {
            if (connexion.getNumeroConnexion() != id) {
                continue;
            }
            connexionOptional = Optional.of(connexion);
            break;
        }
        //si on a trouve que ce app est dans la table TCT(cette app a deja connecte )
        return connexionOptional.orElse(null);
    }

    //une methode qui permet de trouver un Connexion par l'identifiant d'extremite
    public Connexion findConnexionByid(int id) {
        Optional<Connexion> connexionOptional;
        Optional<Connexion> found = Optional.empty();
        for (Connexion connexion : TCR) {
            if (connexion.getId() == id) {
                found = Optional.of(connexion);
                break;
            }
        }
        connexionOptional = found;
        //si on a trouve que ce app est dans la table TCT(cette app a deja connecte )
        return connexionOptional.orElse(null);
    }

    //Le setteur de vriable membre transport
    public void setTransport(TransportCouche transport) {
        this.transport = transport;
    }
}
