package Couche.CTransport;

import Enum.state;
import Couche.CReseaux.Reseaux;
import Outil.fileUtility;
import Primitive.*;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;


@SuppressWarnings("ALL")
public class TransportCouche {
    private final ArrayList<Communication> TCT;

    private final Reseaux reseaux;

    private int counter = 1;

    public TransportCouche() {

        //suppression de S_ecr, L_ecr et L_ecr
        ResetData();

        this.TCT = new ArrayList<>();
        
        this.reseaux = new Reseaux();
        this.reseaux.setTransport(this);
    }

    public static void ResetData() {
        fileUtility.Erase("src/Couche/Session/S_ecr.txt");
        fileUtility.Erase("src/Couche/LiasonDonnee/L_ecr.txt");
        fileUtility.Erase("src/Couche/LiasonDonnee/L_lec.txt");
    }
    private void ecrire_vers_reseau(int id, Primitive p) {
        reseaux.lire_de_transport(id, p);
    }

    public void lire_de_reseau(int id, Primitive p) {
        String Filepath = "src/Couche/Session/S_ecr.txt";

        if (p.getClass() == NDisconnectInd.class) { //si c'est une primitive NDisconnectInd

            NDisconnectInd nDisconnectInd = (NDisconnectInd) p;
            AtomicReference<Communication> commnuicationALiberer = new AtomicReference<>(rechercheCommunication(id));

            //ecrire le resultat de la reception dans la ficier S_ecr
            assert commnuicationALiberer.get() != null;
            String strLog = commnuicationALiberer.get().getAppSource() + " a recu la primitive " + p;
            fileUtility.write(strLog, Filepath);

            //liberer les resources
            TCT.remove(commnuicationALiberer);
            strLog = commnuicationALiberer.get().getAppSource() + "{adresse: " + commnuicationALiberer.get().getAdrSource() +
                    "} déconnecté du " + commnuicationALiberer.get().getAppDestination() + "adresse de provenance " + commnuicationALiberer.get().getAdrDestination() + ", Raison: "
                    + nDisconnectInd.getRaison();

            //ecrire le resultat de la conexxion dans S_ecr
            fileUtility.write(strLog, Filepath);

        } else if (p.getClass() == NConnectConf.class) { //si c'est une primitive NConnectConf
            Communication commnuicationEtablie = rechercheCommunication(id);
            assert commnuicationEtablie != null;
            commnuicationEtablie.setEtatConnexion(state.connexion_etablie);


            //ecrire le resultat de la reception dans la ficier S_ecr
            String strLog = commnuicationEtablie.getAppSource() + " a recu la primitive " + p;
            fileUtility.write(strLog, Filepath);


            //ecrire le resultat de la connexion dans S_ecr
            strLog = commnuicationEtablie.getAppSource() +
                    " a réussi à se connecter au " + commnuicationEtablie.getAppDestination() + ", adresse de provenance: " + commnuicationEtablie.getAdrSource() +
                    ", adresse destination: " + commnuicationEtablie.getAdrDestination() +
                    " Etat: " + commnuicationEtablie.getEtatConnexion();
            fileUtility.write(strLog, Filepath);

            /*
            Une fois la connexion établie et app source a des données a émettre,
            ET peut envoyer le primitive NDataReq avec l'id d'extremite
             */
            if (commnuicationEtablie.getData() != null) {
                ecrire_vers_reseau(commnuicationEtablie.getId(), new NDataReq(commnuicationEtablie.getData()));
            }
        }
    }

    public void DemarrerCommunication() {
        ArrayList<String> transactions = fileUtility.Read("src/Couche/Session/S_lec.txt");


        transactions.parallelStream().forEach(str -> {
            try {
                gererTransactions(str);
            } catch (InterruptedException e) {
                System.err.println("erreur de thread");
            }
        });


    }


    public synchronized void gererTransactions( String transaction) throws InterruptedException {
        sleep(0xaL);

        String appSource = transaction.split(" {7}", 4)[0];
        String appDestination = transaction.split(" {7}", 4)[1];
        String typeTrans = transaction.split(" {7}", 4)[2];


        //chercher la communication entre  lemetteur et recepteur)
        Communication communication = rechercheCommunication(appSource, appDestination);


        if ("LIB".equals(typeTrans)) {//si c'est une demande de liberation

            if (communication != null && communication.getEtatConnexion() == state.connexion_etablie) {

                ecrire_vers_reseau(communication.getId(), new NDisconnectReq(communication.getAdrSource()));

                TCT.remove(communication);

                //ecrire le resultat dans fihcier S_ecr
                String msg_to_S_ecr = communication.getAppSource() + " " + "est déconnecté du " + " " + communication.getAppDestination() + "\n" +
                        ", Raison: disconnected Closed by Client \n";

                fileUtility.write(msg_to_S_ecr, "src/Couche/Session/S_ecr.txt");
            }
            return;
        }

        //verfier si ce app a deja communicate avec la couche transport
        if (communication != null && communication.getEtatConnexion() == state.connexion_etablie) {
            //si c'est une demande d'envoyer le data
            if (typeTrans.equals("DATA")) {
                //envoyer  la primitive NDataReq a la couche reseau
                communication.setData(transaction.split(" {7}", 4)[3]);
                ecrire_vers_reseau(communication.getId(), new NDataReq(communication.getData()));
            }
        } else {//sion, peu import le type de transation est DATA ou CONECT,
            //on va d'abord essayer d'etablir la connexion

            //generer l'adresse source et l'adresse destination
            int[] adresses = AdresseGestionnaire.genererAdresses(appSource, appDestination);

            //creer une nouveau object Communication
            Communication newCon = new Communication(counter++, appSource, appDestination, state.en_attente_de_confirmation_etablissement,
                    adresses[0], adresses[1]);

            //l'ajoute dans la table TCT
            TCT.add(newCon);

            //si c'est une demande d'envoyer les donnees,
            if (typeTrans.equals("DATA"))
                //stocker les user donnes dans l'object newCon
                newCon.setData(transaction.split(" {7}", 4)[3]);


            //enovoyer le prrmitive nConnectReq , avec l'identifiant d'extremite
            NConnectReq nConnectReq = new NConnectReq(adresses[0], adresses[1]);
            ecrire_vers_reseau(newCon.getId(), nConnectReq);

        }
        sleep(10L);
    }

    private Communication rechercheCommunication(String nomSrc, String nomDes)
    {
        return switch (TCT.size()) {
            case 0 -> null;
            default -> TCT.stream().filter(c -> c.getAppDestination().equals(nomDes) && c.getAppSource().equals(nomSrc)).findFirst().orElse(null);
        };
    }

    //    une methode qui premet de trouver un object Communication par l'ideantifiant d'extremite
    private  Communication rechercheCommunication(int id)
    {
        return switch (TCT.size()) {
            case 0 -> null;
            default -> TCT.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        };
    }
}
