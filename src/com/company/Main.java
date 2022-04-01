package com.company;

import Read_and_Write.Read_and_Write;

public class Main {
    enum PRIMITIVE {
        UN, DEUX, TROIS
    }

    public static void main(String[] args) {
        
        for (PRIMITIVE primitive : PRIMITIVE.values()) {
            System.out.println(primitive);
        }
        //Mise en parametre du chemin du fichier de transaction
        Read_and_Write.Read("src/transactions/S_ecr.txt");

    }

}