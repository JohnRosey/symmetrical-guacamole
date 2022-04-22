/*
* By GANSONRE ISMAEL
 * Copyright (c) 2020 GANSONRE ISMAEL. All rights reserved.
* */


import Couche.CTransport.TransportCouche;
import ViewInterface.guix;
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            new guix().setVisible(true);
            TransportCouche transport = new TransportCouche();
            transport.DemarrerCommunication();
        });


    }
}
