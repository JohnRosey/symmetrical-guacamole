/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Paquet;


public class Paquet {
    private int numeroConnexion;
    private String typePaquet;

    public Paquet(int numeroConnexion, String typePaquet) {
        this.numeroConnexion = numeroConnexion;
        this.typePaquet = typePaquet;
    }

    public int getNumeroConnexion() {
        return numeroConnexion;
    }

    public void setNumeroConnexion(int numeroConnexion) {
        this.numeroConnexion = numeroConnexion;
    }

    public String getTypePaquet() {
        return typePaquet;
    }

    public void setTypePaquet(String typePaquet) {
        this.typePaquet = typePaquet;
    }

    @Override
    public String toString() {
        return
                " numeroConnexion= " + numeroConnexion +
                ", typeDePaquet= " + typePaquet ;

    }
}
