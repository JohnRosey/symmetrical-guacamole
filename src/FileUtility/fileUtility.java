package FileUtility;

import Couche.Transport;

import java.io.*;
import java.util.ArrayList;

public class fileUtility {
    /**
     * @param FilePath
     * @return Le contenue du chemin du fichier passee au main
     */
    public static ArrayList<String> Read(String FilePath) {

        File file = new File(FilePath);
       boolean boo=true;
        ArrayList<String> strs = new ArrayList<>();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String linetxt = null;
                StringBuilder result = new StringBuilder();
/*
* TODO:Mettre un compteur de ligne pour le fichier S_erc.txt afin qu'il puisse lire tout le fichier au complet
* */
                int count = 2;
                while ((linetxt = bufferedReader.readLine()) != null) {
                    // strProgram+=linetxt+" ";//Ajouter un espace lors du passage à la ligne suivante
                    if (count == 1) {
                        count++;
                        continue;
                    }
                    strs.add(linetxt);

                }
                //Affiche le contenue de strs
                System.out.println(strs);
                return strs;

            }
            catch (Exception e) {
                System.out.println("Impossible de lire le fichier r");
                e.printStackTrace();
            }
            finally {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            System.out.println("impossibile de trouver le fichier");
        }

        return strs;

    }
    /**
     * @param path
     * Methode qui permet d'ecrire dans un fichier prend en parametre la chaine a ecrire et le chemin du fichier
     *
     *
     */
    public static void Write(String str,String path ) {
        FileOutputStream o = null;
        byte[] buff = new byte[]{};
        str = str + "\r\n";
        try {
            File file = new File(path);

            buff = str.getBytes();
            o = new FileOutputStream(file, true);
            o.write(buff);
            o.flush();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @param Filepath
     * Methode qui permet d'effacer les fichiers textes dont le path est mit en parametre
     *
     */
    public static void Erase(String Filepath){

        File filepath= new File(Filepath);

        try{
            if(!filepath.exists()){
                filepath.createNewFile();
            }
            FileWriter fileWriter= new FileWriter(filepath);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path prend en parametre la localisation du fichier a lire S_lec
     *             Genere les donnnees avec setAdress et setAdressDestination
     *
     */
    public static void Generate_S_lec(String path) {
        File filepath= new File(path);


        try{
            if(!filepath.exists()){
                filepath.createNewFile();
                System.out.println("Ficher creer " + filepath.getName());

            }else {
                System.out.println("File deja existant.");
            }
            FileWriter fileWriter= new FileWriter(filepath);
            //adresseGen(source,dest);
            int dest = Transport.setAdresseDestination();
            int intDest= dest;
            int source= Transport.setAdresseSource(intDest);
           /* System.out.println("Les adresses sont :");

            System.out.println(source);

            System.out.println(dest);*/
         //Donnees generee

                String message = ("N_CONNECT" + " " + (dest) + " " + (source) + "\n" + "N_DATA test no :1 " + "\n" + "N_DISCONNECT" + "\n");

                    fileWriter.write(message);

                    //Donnees de test a ajouter

            //Donnees de test a ajouter

            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * TODO : Creer une fonction comme celle ci-dessous :  private static void adresseGen () qui genere les adresses  et les renvoie dans un tableau que le FileWriter puisse les ecrire dans le fichier
     */

    private static void adresseGen(int source , int dest){
        dest = Transport.setAdresseDestination();
        int intDest= dest;
        source= Transport.setAdresseSource(intDest);
        System.out.println("Les adresses sont :");

        System.out.println(source);
        System.out.println(intDest);
        System.out.println(dest);



    }

}

