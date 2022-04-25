/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Primitives;

public class NConnectConf extends Primitive{

    private final int adresseReponse;


    public NConnectConf(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }



    @Override
    public String toString() {
        return " Primitives :N_Connect.Conf { " +
                " adresseReponse = " + adresseReponse +
                " }";
    }
}
