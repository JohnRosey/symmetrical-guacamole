package Couche.CReseaux;

import Couche.CTransport.TransportCouche;
import Couche.LiasonDonnee.LiaisonDonnee;
import Enum.state;
import Paquet.*;
import Primitive.*;

import java.util.ArrayList;
import java.util.Optional;

public class Reseaux {
    private final ArrayList<Connexion> TCR;

    private TransportCouche transport;

    private int counter;

    private final LiaisonDonnee liaisonDonnee;

    public Reseaux() {
        this.TCR = new ArrayList<>();
        this.counter = 1;
        this.liaisonDonnee = new LiaisonDonnee();
        this.liaisonDonnee.setReseaux(this);
    }

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

    private void ecrire_vers_transport(int id, Primitive p) {
        transport.lire_de_reseau(id, p);
    }



    private void decisionFournisseurAleatoire(int id, NConnectReq nConnectReq) {
        int adrSource = nConnectReq.getAdrSource();
        int adrDestination = nConnectReq.getAdrDestination();

        if (adrSource % 27 == 0) {
            NDisconnectInd nDisconnectInd = new NDisconnectInd(adrSource, "refus par  le Serveur");
            ecrire_vers_transport(id, nDisconnectInd);
        } else {
            Connexion connexion;
            connexion = new Connexion(state.en_attente_de_confirmation_etablissement,
                    adrSource, adrDestination, id, counter++);
            TCR.add(connexion);

            PaquetAppel p = new PaquetAppel(connexion.getNumeroConnexion(),
                    "00001011", adrSource, adrDestination);
            envoyerPaquet(p);
        }
    }


    public void gestionTransfertDonnee(Connexion connexion) {

//
        if (connexion.getNbRetransmissions() > 1) {

            connexion.augmenterPs();

            connexion.setNbRetransmissions(0);
        }

//        obtenir le p(s) courant
        int ps = connexion.getPs();

        String typePaquet, bitM, StringBinaire, strPrBinaire = "000";

        String msgSegment = segmenterMessage(connexion.getInfoAtransmettre(), ps);

        if (msgSegment == null) {
            return;
        }

        else if (segmenterMessage(connexion.getInfoAtransmettre(), ps + 1) == null)
            bitM = "0";

        else
            bitM = "1";


//
        StringBinaire = Integer.toBinaryString(ps % 8);

        //p(s)est en 3 bits,
        StringBinaire = switch (StringBinaire.length()) {
            case 1 -> "00" + StringBinaire;
            case 2 -> "0" + StringBinaire;
            default -> StringBinaire;
        };

        typePaquet = strPrBinaire + bitM + StringBinaire + "0";

        connexion.augmenterPs();
        envoyerPaquet(new PaquetDonnee(connexion.getNumeroConnexion(), typePaquet, msgSegment));
    }

    private void envoyerPaquet(Paquet p) {
        liaisonDonnee.gestionPaquets(p);
    }


    public void recevoirPaquetDistant(Paquet p, int nuemroConnexion) {

        if (p == null) {

            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);

            if (connexion.getEtatConnexion() == state.en_attente_de_confirmation_etablissement) {

                NDisconnectInd nDisconnectInd = new NDisconnectInd(connexion.getAdrSourece(), "la demande ne reçoit pas de réponse");
                ecrire_vers_transport(connexion.getId(), nDisconnectInd);
            }

            else {

                connexion.diminuerPs();

                connexion.setNbRetransmissions(connexion.getNbRetransmissions() + 1);
                gestionTransfertDonnee(connexion);
            }

        }

        else if (p.getClass() == PaquetIndLiberation.class) {

            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);
            TCR.remove(connexion);//liberer la resource

            NDisconnectInd nDisconnectInd = new NDisconnectInd(connexion.getAdrSourece(), "refus de connexion de la part du distant");
            ecrire_vers_transport(connexion.getId(), nDisconnectInd);
        }

        else if (p.getClass() == PaquetCommunicationEtablie.class) {
            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);

            connexion.setEtatConnexion(state.connexion_etablie);

            NConnectConf nConnectConf = new NConnectConf(connexion.getAdrSourece());
            ecrire_vers_transport(connexion.getId(), nConnectConf);
        }

        else if (p.getClass() == PaquetAquittement.class) {

            Connexion connexion = findConnexionByNumeroConnexion(nuemroConnexion);


            if ((connexion.getPs() % 8) != Integer.valueOf(p.getTypePaquet().substring(0, 3), 2)) {


                connexion.setPs(Integer.valueOf(p.getTypePaquet().substring(0, 3), 2));

                connexion.setNbRetransmissions(connexion.getNbRetransmissions() + 1);
                gestionTransfertDonnee(connexion);
            }
            else {
                gestionTransfertDonnee(connexion);
            }
        }
    }

    public String segmenterMessage(String msg, int ps) {

        if (msg.length() <= 128&&ps==0) return msg;

        if ((ps + 1) << 7 > msg.length()&& ps << 7 <msg.length())
            return msg.substring(ps * 128);

        else if(ps * 128>=msg.length())
            return null;

        return msg.substring(ps << 7, (ps + 1) << 7);
    }

    public Connexion findConnexionByNumeroConnexion(int id) {
        Optional<Connexion> connexionOptional = Optional.empty();
        for (Connexion connexion : TCR) {
            if (connexion.getNumeroConnexion() != id) {
                continue;
            }
            connexionOptional = Optional.of(connexion);
            break;
        }
        return connexionOptional.orElse(null);
    }

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
        return connexionOptional.orElse(null);
    }

    public void setTransport(TransportCouche transport) {
        this.transport = transport;
    }
}
