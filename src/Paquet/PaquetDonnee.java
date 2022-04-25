/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Paquet;


public class PaquetDonnee extends Paquet{
    String donnee;

    public PaquetDonnee(int numeroConnexion, String typePaquet, String donnee) {
        super(numeroConnexion, typePaquet);
        this.donnee = donnee;
    }

    public String getDonnee() {
        return donnee;
    }

    public void setDonnee(String donnee) {
        this.donnee = donnee;
    }

    @Override
    public String toString() {
        return "PaquetDonnee { "   +
                super.toString()+
                " donnee = " + donnee  +
                " }";
    }
}
