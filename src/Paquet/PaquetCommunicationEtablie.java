/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Paquet;

public class PaquetCommunicationEtablie extends Paquet {
    private int adrSource,adrDestination;

    public PaquetCommunicationEtablie(int numeroConnexion, String typePaquet, int adrSource, int adrDestination) {
        super(numeroConnexion, typePaquet);
        this.adrSource = adrSource;
        this.adrDestination = adrDestination;
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

    @Override
    public String toString() {
        return "PaquetDeCommunicationEtablie { " +
                super.toString()+
                " adresseSource = " + adrSource +
                ", adrDestination = " + adrDestination +
                " }";
    }
}
