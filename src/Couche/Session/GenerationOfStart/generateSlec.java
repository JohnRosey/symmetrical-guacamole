/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Couche.Session.GenerationOfStart;

import Outil.fileUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class generateSlec {
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
    public static void main(String[] args) throws IOException {}
    public static void RandomData() throws IOException {
        //Erase("test.txt");
        Erase("src/Couche/Session/S_lec.txt");
        // create new text file and write some text to it and then read it
        //File file = new File("test.txt");
        File file = new File("src/Couche/Session/S_lec.txt");
        file.createNewFile();


        FileWriter fw = new FileWriter(file);


        ArrayList<String> NameAppSource = new ArrayList<>();
        ArrayList<String> NameAppDest = new ArrayList<>();
        ArrayList<String> TypeTrans = new ArrayList<>();


        NameAppSource.add("Facebook.exe");
        NameAppSource.add("Twitter.exe");
        NameAppSource.add("Instagram.exe");
        NameAppSource.add("Snapchat.exe");
        NameAppSource.add("Whatsapp.exe");
        NameAppSource.add("Google.exe");
        NameAppSource.add("Youtube.exe");
        NameAppSource.add("Linkedin.exe");
        NameAppSource.add("Gmail.exe");
        NameAppSource.add("Microsoft.exe");
        NameAppSource.add("Amazon.exe");
        NameAppSource.add("Google.exe");


        Collections.shuffle(NameAppSource);


        NameAppDest.add("Ads.exe");
        NameAppDest.add("Firebase.exe");
        NameAppDest.add("Ads.exe");
        NameAppDest.add("Firebase.exe");
        NameAppDest.add("reddit.exe");
        NameAppDest.add("Pintrest.exe");
        NameAppDest.add("Walmart.exe");
        NameAppDest.add("Costco.exe");
        NameAppDest.add("Target.exe");
        NameAppDest.add("Ebay.exe");
        NameAppDest.add("AWS.exe");
        NameAppDest.add("MongoDB.exe");


        Collections.shuffle(NameAppDest);

        ArrayList<String> data = new ArrayList<String>();

        data.add("Computer is a");
        data.add("Phone is b");
        data.add("Tablet is cc");
        data.add("Laptop is d");
        data.add("Smartwatch is e");
        data.add("Smartphone is f");
        data.add("Smart TV is g");
        data.add("Speaker is h");


        // Collections.shuffle((List<HashMap) data.values());

        TypeTrans.add("CONNECT");
        TypeTrans.add("DATA");
        TypeTrans.add("LIB");





        ///},




        //Collections.shuffle(TypeTrans);
        /*donnees du fichier S_Lec*/

        for (int i = 0; i < 3; i++) {
            try {
                fw.write(NameAppSource.get(i) + "       " + NameAppDest.get(i) + "       " + TypeTrans.get(1) + " " + data.get(i) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        for (int i =0;i<3;i++) {
            try {
                fw.write(NameAppSource.get(i) + "       " + NameAppDest.get(i) + "       " + TypeTrans.get(2) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i =0;i<3;i++)
        {
            try {
                fw.write(NameAppSource.get(i) +"       "+NameAppDest.get(i)+"       "+TypeTrans.get(0)+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }






String transaction = "";
        ArrayList<String> transactions = fileUtility.Lire_File("text.txt");

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




