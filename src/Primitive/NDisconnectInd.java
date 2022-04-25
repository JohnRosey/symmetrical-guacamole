/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Primitive;

public class NDisconnectInd extends Primitive{
    private int adresseReponse;
    private String raison;

    public NDisconnectInd(int adresseReponse, String raison) {
        this.adresseReponse = adresseReponse;
        this.raison = raison;
    }

    public int getAdresseReponse() {
        return adresseReponse;
    }

    public void setAdresseReponse(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @Override
    public String toString() {
        return " Primitive : N_Disconnect.Ind { " +
                " adresseReponse = " + adresseReponse +
                ", raison = " + raison +
                " }";
    }
}
