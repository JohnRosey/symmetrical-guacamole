package com.company;

import Couche.Transport;
import FileUtility.fileUtility;

public class Main {
    enum PRIMITIVE {
        UN, DEUX, TROIS
    }

    public static void main(String[] args) {
        
        for (PRIMITIVE primitive : PRIMITIVE.values()) {
            System.out.println(primitive);
        }

        //Reset tout les fichiers de log avant le lancement du programme
        resetAllFile();


//Mise en parametre du chemin du fichier de transaction

        fileUtility.Generate_S_lec("src\\transactions\\S_ecr.txt");
        //Affiche le contenu du fichier de transaction
        fileUtility.Read("src\\transactions\\S_ecr.txt");


    }

    private static void resetAllFile(){
        try{
        fileUtility.Erase("src\\transactions\\S_ecr.txt");
       // fileUtility.Erase("src/transactions/L_ecr.txt");
      //  fileUtility.Erase("src/transactions/L_lec.txt");
            }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Impossible d'effacer");


    }
    }

}