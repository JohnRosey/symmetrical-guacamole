/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Couche.CReseaux;

import Enum.Etat;

public class Connexion {

    private Etat etat;

    private final int adrSourece;
    private int adrDestination;
    private final int id;
    private final int numeroConnexion;
    private int p_s;
    private int nb_De_Retransmissions;
    private String DataToSend;

    public Connexion(Etat etat, int adrSourece, int adrDestination, int id, int numeroConnexion) {
        this.etat = etat;
        this.adrSourece = adrSourece;
        this.adrDestination = adrDestination;
        this.id = id;
        this.numeroConnexion = numeroConnexion;
        this.p_s =0;
        this.nb_De_Retransmissions =0;
    }

    public Etat getEtatConnexion() {
        return etat;
    }

    public void setEtatConnexion(Etat Etat) {
        this.etat = Etat;
    }

    public int getNumeroConnexion() {
        return numeroConnexion;
    }


    public int getAdrSourece() {
        return adrSourece;
    }



    public int getAdrDestination() {
        return adrDestination;
    }

    public void setAdrDestination(int adrDestination) {
        this.adrDestination = adrDestination;
    }

    public int getId() {
        return id;
    }




    public int getP_s() {
        return p_s;
    }

    public void setP_s(int p_s) {
        this.p_s = p_s;
    }

    public void augmenterPs() {
        this.p_s++;
    }
    public void diminuerPs() {
        this.p_s--;
    }


    public int getNb_De_Retransmissions() {
        return nb_De_Retransmissions;
    }

    public void setNb_De_Retransmissions(int nb_De_Retransmissions) {
        this.nb_De_Retransmissions = nb_De_Retransmissions;
    }

    public String getDataToSend() {
        return DataToSend;
    }

    public void setDataToSend(String dataToSend) {
        this.DataToSend = dataToSend;
    }

    @Override
    public String toString() {
        return "Connexion{" +
                "Etat=" + etat +
                ", adrSourece=" + adrSourece +
                ", adrDestination=" + adrDestination +
                ", id=" + id +
                ", numeroConnexion=" + numeroConnexion +
                ", ps=" + p_s +
                ", nbRetransmissions=" + nb_De_Retransmissions +
                ", infoAtransmettre='" + DataToSend + '\'' +
                '}';
    }
}
