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
   public boolean end;

    //Les files FIFO qui possedent les trames  dans une queue ordonnee
    private Queue<NDPU> transportToNetwork;// Canal transport vers reseau
    private Queue<NDPU> networkToTransport;// Canal Reseau vers Transport

    ArrayList connnected;


    /**
     * Constructeur prenant en parametre les files (FIFO) transportToNetwork et networkToTransport
     */
    public Transport() throws IOException {
        this.transportToNetwork = new ArrayDeque<NDPU>();
        this.networkToTransport = new ArrayDeque<NDPU>();

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
    public void networkWrite() throws IOException
    {
        System.out.println();
        System.out.println();
        System.out.println("Debut methode");
        NDPU networkNDPU ;
        String[] slipt;
        boolean valid = false;
        boolean end = false;
        System.out.println("networkWrite executed");
        File f1=new File("S_ecr.txt");
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String read;
        String input="Java";   // Input word to be searched
        int count=0;   //Intialize the word to zero
        while((read=br.readLine())!=null)   //Reading Content from the file
        {

            System.out.println();
            System.out.println("Debut while");

            networkNDPU = new NDPU();
            if(read.contains("N_CONNECT"))
            {
                slipt = read.split(" ");
                networkNDPU.adresseSource = Integer.parseInt((slipt[1]));
                networkNDPU.adressedestination = Integer.parseInt(slipt[2]);
                valid = true;
                networkNDPU.type = "N_CONNECT.req";
                System.out.println(networkNDPU.adresseSource + " " +networkNDPU.adressedestination + " " + networkNDPU.type);
            }

            if(read.contains("N_DATA"))
            {
                slipt = read.split(" ");
                networkNDPU.setType("N_DATA.req");
                String data = "";
                for (int i = 0; i < slipt.length; i++)
                {
                    data += slipt[i] + " ";
                    valid = true;
                }
                networkNDPU.setData(data);

                System.out.println(networkNDPU.data);
            }

            transportToNetwork.add(networkNDPU);
            System.out.println(transportToNetwork.toString());

        }
        System.out.println(transportToNetwork);


    }

    public void networkRead () throws IOException{
        System.out.println("Debut methode\n");
        System.out.println("networkRead executed");
        while(!end)
        {
            try
            {
                    if(transportToNetwork.size()>0){
                        if(networkToTransport.peek().getClass() == NDPU.class){
                        NDPU ndpu4Network=(NDPU)transportToNetwork.poll();
                        if(Objects.equals(ndpu4Network.type, "N_CONNECT.ind")){
                            if(connnected.contains(ndpu4Network.connection)){
                                 String msg="connection:"+ndpu4Network.connection+" "+ndpu4Network.adresseSource+" "+ndpu4Network.adressedestination+" "+ndpu4Network.type;
                                 System.out.println(msg);

                            }
                        }
                        else if(Objects.equals(ndpu4Network.type, "N_CONNECT.conf")){
                            String msg ="connection:"+ndpu4Network.connection+"connection etablie";
                            System.out.println(msg);

                        }
                        else if(Objects.equals(ndpu4Network.type, "N_DATA.ind"))
                            {
                            if(connnected.contains(ndpu4Network.connection)){
                                String msg=ndpu4Network.data;
                                System.out.println(msg);
                            }
                            else if(Objects.equals(ndpu4Network.type, "N_DISCONNECT.ind")){
                            if(connnected.contains(ndpu4Network.connection)){
                                connnected.remove(ndpu4Network.connection);
                                String msg="connection:"+ndpu4Network.connection+" "+ndpu4Network.adresseSource+" "+ndpu4Network.adressedestination+" "+ndpu4Network.type;
                                System.out.println(msg);

                            }
                            else if(Objects.equals(ndpu4Network.connection, "255")){
                                System.out.println("connection declinned by the network");
                            }
                            }

                        }
                    }
                }
            }
            catch(Exception e){
                System.out.println("erreur");

            }
        }
    }
}



