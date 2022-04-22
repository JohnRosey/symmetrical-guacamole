package Couche.LiasonDonnee;

import Couche.CReseaux.Connexion;
import Couche.CReseaux.Reseaux;
import Outil.fileUtility;
import Paquet.*;



public class LiaisonDonnee {
    private final String pathLlec = "src/Couche/LiasonDonnee/L_lec.txt";
    private Reseaux reseaux;


    public void gestionPaquets(Paquet p) {

        fileUtility.write("Envoi du " + p.toString(), "src/Couche/LiasonDonnee/L_ecr.txt");

        processusAleatoire(p);
    }

    public void processusAleatoire(Paquet p) {

        if (p.getClass() == PaquetAppel.class)
            reponseConnexionAleatoire(p);

        else if (p.getClass() == PaquetDonnee.class)
            reponseEmisDonneeAleatoire(p);

    }

    private void reponseConnexionAleatoire(Paquet p) {

        if (((PaquetAppel) p).getAdresseSource() % 19 == 0) {

            reseaux.recevoirPaquetDistant(null, p.getNumeroConnexion());

            fileUtility.write(p + " ne reçoit pas de réponse", pathLlec);
        }

//
        else if (((PaquetAppel) p).getAdresseSource() % 13 == 0) {

            PaquetIndLiberation paquetIndLiberation = new PaquetIndLiberation(
                    p.getNumeroConnexion(), "00010011", ((PaquetAppel) p).getAdresseSource(),
                    ((PaquetAppel) p).getAdrDestination(), "00000001"
            );

            reseaux.recevoirPaquetDistant(paquetIndLiberation, p.getNumeroConnexion());

            fileUtility.write(p + "a recu la réponse: " + paquetIndLiberation, pathLlec);
        } else {

            PaquetCommunicationEtablie paquetCommunicationEtablie = new PaquetCommunicationEtablie(
                    p.getNumeroConnexion(), "00001111",
                    ((PaquetAppel) p).getAdresseSource(), ((PaquetAppel) p).getAdrDestination()
            );

            reseaux.recevoirPaquetDistant(paquetCommunicationEtablie, p.getNumeroConnexion());

            fileUtility.write(p + "a recu la réponse: " + paquetCommunicationEtablie, pathLlec);
        }

    }

    private void reponseEmisDonneeAleatoire(Paquet p) {

        int psPaquetEmis = Integer.valueOf(p.getTypePaquet().substring(4, 7), 2);

        Connexion con = reseaux.findConnexionByNumeroConnexion(p.getNumeroConnexion());

        if (con.getAdrSourece() % 15 == 0) {
            reseaux.recevoirPaquetDistant(null, p.getNumeroConnexion());
            fileUtility.write(p + " ne reçoit pas de réponse", pathLlec);
        }


        else if (psPaquetEmis == (int) (7 * Math.random())) {
            String strPrDistant = Integer.toBinaryString(psPaquetEmis);

            if (strPrDistant.length() == 1)
                strPrDistant = "00" + strPrDistant;
            else if (strPrDistant.length() == 2)
                strPrDistant = "0" + strPrDistant;

            PaquetAquittement paquetAquittement = new PaquetAquittement(p.getNumeroConnexion(), strPrDistant + "01001");
            reseaux.recevoirPaquetDistant(paquetAquittement, p.getNumeroConnexion());
            fileUtility.write(p + " a recu une aquittement negative : " + paquetAquittement, pathLlec);
        }

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
