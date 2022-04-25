/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Primitive;

public class NDisconnectReq extends Primitive{
    private int adresseReponse;

    public NDisconnectReq(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    public int getAdresseReponse() {
        return adresseReponse;
    }

    public void setAdresseReponse(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    @Override
    public String toString() {
        return " Primitive : N_Disconnect.Req { " +
                " adresseReponse = " + adresseReponse +
                " }";
    }
}
