package Couche;


import Paquet.NDPU;

import java.io.*;
import java.util.*;

public class Transport {

    private String S_lec="s_lec.txt"; // Contient les Requettes faites par la couche reseau (Instruction)
    private String S_ecr="s_ecr.txt";//La Couche transport ecrit les notification a transmetrre a la couche reseau (Resultat)

    private FileReader reader;
    private FileWriter writer;

    private FileInputStream inputFile;
    private FileInputStream outputFile;

    String message;
    private boolean disconnected;
    private boolean connect;

    //Les files FIFO qui possedent les trames  dans une queue ordonnee
    private Queue<NDPU> transportToNetwork;// Canal transport vers reseau
    private Queue<NDPU> networkToTransport;// Canal Reseau vers Transport
    ArrayList connnected;


    /**
     * Constructeur prenant en parametre les files (FIFO) transportToNetwork et networkToTransport
     */
    public Transport() throws IOException {
        this.transportToNetwork = transportToNetwork;
        this.networkToTransport = networkToTransport;

 connnected = new ArrayList();
 //Commencer();

    }
    /*public void Commencer() throws IOException {
        writer.flush();
        disconnected = false;
        message = "";
    }
    public void Arreter() throws IOException {
        writer.flush();
        inputFile.close();
        outputFile.close();
        reader.close();
        disconnected = true;
        message = "";
    }
*/
    /**
     * Methode qui permet de lire le fichier S_lec.txt
     */

    /**
     * Methode qui permet de selectionner un chiffre aleatoirement
     * @return int
     */
    public static int getRandomNumber(int max){

        Random random = new Random();
        return random.nextInt(max) + 1;

    }
    /**
     * Methode qui permet de set l'adresse d'une source
     * @return String
     */

    public static int setAdresseSource(int destination){

        int source;

        do {
            source = getRandomNumber(255);
        }while(destination == source);

        return source;
    }


    /**
     * Methode qui permet de set l'adresse d'une source
     * @return String
     *
     */
    public static int setAdresseDestination(){
        return (getRandomNumber(255));
    }
    /**
     * Methode networkWrite qui permet de lire le fichier S_lec.txt
     * jusqu'a ce qu'il voit une ligne qui conttient N_Disconnect ou jusqu'a la fin du fichier
     *
     * Si la ligne contient N_connect ,n_data  un paquet est ajouter a la file networkToTransport
     * @return String
     */
    public void networkWrite() throws FileNotFoundException {
 String LigneLue;
 String parametre;
 NDPU networkNDPU;
 try {
     networkNDPU = new NDPU();
     reader = new FileReader("src\\transactions\\S_ecr.txt");
     BufferedReader br = new BufferedReader(reader);
     while ((LigneLue = br.readLine()) != null) {
         parametre = LigneLue.split(" ")[0];
         if (parametre.equals("N_connect")) {
             networkNDPU.setType("N_connect.req");
             networkNDPU.setAdresseSource(setAdresseSource(Integer.parseInt(LigneLue.split(" ")[1])));
            // networkNDPU.setAdressedestination(setAdresseDestination(Integer.parseInt(LigneLue.split(" ")[2])));
             //**TODO
             // Faire la recherche dans le fichier de la liste des adresses connnectées et les ajouter au nouveau NDPU
             // **

             //https://www.candidjava.com/tutorial/program-to-search-word-in-a-file/


         }
     }
 } catch (IOException e) {
     e.printStackTrace();
 }
    }
}

