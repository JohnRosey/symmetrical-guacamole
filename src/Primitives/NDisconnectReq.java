/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Primitives;

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
        return " Primitives : N_Disconnect.Req { " +
                " adresseReponse = " + adresseReponse +
                " }";
    }
}
