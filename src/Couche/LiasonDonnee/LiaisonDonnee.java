package Couche.LiasonDonnee;

import Couche.CReseaux.Connexion;
import Couche.CReseaux.Reseaux;
import Outil.fileUtility;
import Paquet.*;


//definir un classe qui presenter la couche de liason de donnee

public class LiaisonDonnee {
    private final String pathLlec = "src/Couche/LiasonDonnee/L_lec.txt";
    private Reseaux reseaux;


    //    la couche reseau envoyer les paquet en utilisant le service de liason
    public void gestionPaquets(Paquet p) {

//        simuler l'envoie des paqeut par ecrire dan le fichier L_ecr
        fileUtility.write("Envoi du " + p.toString(), "src/Couche/LiasonDonnee/L_ecr.txt");

        //lancer le processus aleatoire pour simuler le reponde de diatant
        processusAleatoire(p);
    }

    //    une methode qui permet de simuler le reponde de diatant en utilisant un processus aleatoire
    public void processusAleatoire(Paquet p) {

        if (p.getClass() == PaquetAppel.class)
            reponseConnexionAleatoire(p);

        else if (p.getClass() == PaquetDonnee.class)
            reponseEmisDonneeAleatoire(p);

    }

    //    reponde au demande de connexion(paquet appel) aleatoire
    private void reponseConnexionAleatoire(Paquet p) {

//        la demande ne reçoit pas de réponse si l’adresse de la station source est un multiple de 19;
        if (((PaquetAppel) p).getAdresseSource() % 19 == 0) {

//            Paquet null pour signifier que le reseaux ne recoit pas de reponde,
//            null pour simuler une temporisation
            reseaux.recevoirPaquetDistant(null, p.getNumeroConnexion());

//            ercire le resultat dans le fihcier  L_lec
            fileUtility.write(p + " ne reçoit pas de réponse", pathLlec);
        }

//        le paquet reçu en réponse est un refus de connexion de la part du distant
//        si l’adresse de la station source est un multiple de 13;
        else if (((PaquetAppel) p).getAdresseSource() % 13 == 0) {

//            reseaux va recevoir un paquet indication liberation
            PaquetIndLiberation paquetIndLiberation = new PaquetIndLiberation(
                    p.getNumeroConnexion(), "00010011", ((PaquetAppel) p).getAdresseSource(),
                    ((PaquetAppel) p).getAdrDestination(), "00000001"
            );

            reseaux.recevoirPaquetDistant(paquetIndLiberation, p.getNumeroConnexion());

//            ercire le resultat dans le fihcier  L_lec
            fileUtility.write(p + "a recu la réponse: " + paquetIndLiberation, pathLlec);
        } else {

//          reseaux va recevoir un paquet Communication Etablie
            PaquetCommunicationEtablie paquetCommunicationEtablie = new PaquetCommunicationEtablie(
                    p.getNumeroConnexion(), "00001111",
                    ((PaquetAppel) p).getAdresseSource(), ((PaquetAppel) p).getAdrDestination()
            );

//            reseaux paquet communication établie
            reseaux.recevoirPaquetDistant(paquetCommunicationEtablie, p.getNumeroConnexion());

//            ercire le resultat dans le fihcier  L_lec
            fileUtility.write(p + "a recu la réponse: " + paquetCommunicationEtablie, pathLlec);
        }

    }

    //   reponde au tranfert d'un paquet(paquet appel) aleatoire
    private void reponseEmisDonneeAleatoire(Paquet p) {

        //Obtenir le p(s) par le type de paquet
        int psPaquetEmis = Integer.valueOf(p.getTypePaquet().substring(4, 7), 2);

        Connexion con = reseaux.findConnexionByNumeroConnexion(p.getNumeroConnexion());

//        L’émetteur ne reçoit pas de paquet d’acquittement si l’adresse de la station source est un multiple de 15;
        if (con.getAdrSourece() % 15 == 0) {
//            pas de reponde
            reseaux.recevoirPaquetDistant(null, p.getNumeroConnexion());
            fileUtility.write(p + " ne reçoit pas de réponse", pathLlec);
        }

//        Le paquet reçu en réponse est un acquittement négatif si
//        le numéro p(s) du paquet émis est égal à un nombre tiré aléatoirement dans l’intervalle [0,7] :
        else if (psPaquetEmis == (int) (7 * Math.random())) {
            //acquittement negative
            String strPrDistant = Integer.toBinaryString(psPaquetEmis);

            if (strPrDistant.length() == 1)
                strPrDistant = "00" + strPrDistant;
            else if (strPrDistant.length() == 2)
                strPrDistant = "0" + strPrDistant;

            PaquetAquittement paquetAquittement = new PaquetAquittement(p.getNumeroConnexion(), strPrDistant + "01001");
            reseaux.recevoirPaquetDistant(paquetAquittement, p.getNumeroConnexion());
            fileUtility.write(p + " a recu une aquittement negative : " + paquetAquittement, pathLlec);
        }

        //la réponse est un paquet d’acquittement positif.
        else {
            String strPrDistant = Integer.toBinaryString((psPaquetEmis + 1) % 8);

            if (strPrDistant.length() == 1)
                strPrDistant = "00" + strPrDistant;
            else if (strPrDistant.length() == 2)
                strPrDistant = "0" + strPrDistant;

            PaquetAquittement paquetAquittement = new PaquetAquittement(p.getNumeroConnexion(), strPrDistant + "00001");
            reseaux.recevoirPaquetDistant(paquetAquittement, p.getNumeroConnexion());
            fileUtility.write(p + " a recu une aquittement positive : " + paquetAquittement, pathLlec);
        }
    }

    public void setReseaux(Reseaux reseaux) {
        this.reseaux = reseaux;
    }
}
