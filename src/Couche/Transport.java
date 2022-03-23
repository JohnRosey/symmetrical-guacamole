package Couche;


import Paquet.NDPU;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

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

    //Les files FIFO
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
    public void LireTransport(){
        File fichier = new File(S_lec);
        NDPU transportToReseau =new NDPU(); ;//utilisation du protocole NDPU pour faire le transport vers reseau
      try(Scanner lecture =new Scanner(fichier)){
          while(lecture.hasNextLine()){
              String LectureLigne = lecture.nextLine();


      }
      }catch (FileNotFoundException e) {
              e.printStackTrace();
    }
    }
}

