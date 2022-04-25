/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Outil;

import java.io.*;
import java.util.ArrayList;

/*
une classe FichierGestionnaire, qui definir les methode static pour la lecture , ecriture des fichiers
 */
public class fileUtility {

    /**
     * @param fichierPath
     * @return Le contenue du chemin du fichier passee au main
     */
    public static ArrayList<String> Lire_File(String fichierPath) {
        File file = new File(fichierPath);
        boolean boo = file.exists() && file.isFile();
        ArrayList<String> strs = new ArrayList<>();
        if (boo) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String linetxt;
                new StringBuilder();

                int count = 1;
                while ((linetxt = bufferedReader.readLine()) != null) {
                    if (count == 1) {
                        count++;
                        continue;
                    }
                    strs.add(linetxt);

                }
                return strs;
            } catch (Exception e) {
                System.out.println("erreur de lire fichier");
                e.printStackTrace();
            } finally {
                try {
                    assert bufferedReader != null;
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
    public static void write(String str, String path ) {
        FileOutputStream o;
        byte[] buff;
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
            if(!filepath.exists()) {
                final var newFile = filepath.createNewFile();
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
     *             Genere les donnnees avec aleatoirement
     *
     */
}
