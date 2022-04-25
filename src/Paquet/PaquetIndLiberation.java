/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Paquet;


public class PaquetIndLiberation extends Paquet {
    private int adrSource,adrDestination;
    private String raison;

    public PaquetIndLiberation(int numeroConnexion, String typePaquet, int adrSource, int adrDestination, String raison) {
        super(numeroConnexion, typePaquet);
        this.adrSource = adrSource;
        this.adrDestination = adrDestination;
        this.raison = raison;
    }

    public int getAdrSource() {
        return adrSource;
    }

    public void setAdrSource(int adrSource) {
        this.adrSource = adrSource;
    }

    public int getAdrDestination() {
        return adrDestination;
    }

    public void setAdrDestination(int adrDestination) {
        this.adrDestination = adrDestination;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Override
    public String toString() {
        return "PaquetIndLiberation { " +
                super.toString()+
                " adrSource = " + adrSource +
                ", adrDestination = " + adrDestination +
                ", raison = " + raison + '\'' +
                " }";
    }
}
