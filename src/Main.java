/*
* By GANSONRE ISMAEL
 * Copyright (c) 2020 GANSONRE ISMAEL. All rights reserved.
* */


import Couche.CTransport.TransportCouche;
import Outil.fileUtility;


public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            new guix().setVisible(true);
            TransportCouche transport = new TransportCouche();
            //fileUtility.Generate_S_lec("Couche/Session/S_lec.txt");


//Point de depart
            transport.DemarrerCommunication();
        });


    }
}
