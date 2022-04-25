/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Couche.CTransport;
import Enum.Etat;


public class Communication {
    final int id;
    private final String appSource;
    private final String appDestination;
    private Etat Etat;
    private String Data;
    private int adrSource,adrDestination;

    public Communication(int id, String appSource, String appDestination, Etat Etat, int adSource, int adDestination) {
        this.id = id;
        this.appSource = appSource;
        this.appDestination = appDestination;
        this.Etat = Etat;
        this.adrSource = adSource;
        this.adrDestination = adDestination;
    }

    public int getId() {
        return id;
    }

    public String getAppSource() {
        return appSource;
    }

    public String getAppDestination() {
        return appDestination;
    }

    public Etat getEtatConnexion() {
        return Etat;
    }

    public void setEtatConnexion(Etat Etat) {
        this.Etat = Etat;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public int getAdrSource() {
        return adrSource;
    }

    public void setAdrSource(int adSource) {
        this.adrSource = adSource;
    }

    public int getAdrDestination() {
        return adrDestination;
    }

    public void setAdrDestination(int adDestination) {
        this.adrDestination = adDestination;
    }
}
