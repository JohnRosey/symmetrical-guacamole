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


    /**
     * Constructeur prenant en parametre les files (FIFO) transportToNetwork et networkToTransport
     */
    public Transport(Queue<NDPU> transportToNetwork, Queue<NDPU> networkToTransport) throws IOException {
        this.transportToNetwork = transportToNetwork;
        this.networkToTransport = networkToTransport;


    }
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

    public static String setAdresseSource(int destination){

        int source;

        do {
            source = getRandomNumber(255);
        }while(destination == source);

        return String.valueOf(source);
    }


    /**
     * Methode qui permet de set l'adresse d'une source
     * @return String
     */
    public static String setAdresseDestination(){
        return String.valueOf(getRandomNumber(255));
    }
}

