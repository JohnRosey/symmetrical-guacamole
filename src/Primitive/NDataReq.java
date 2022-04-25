/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Primitive;

public class NDataReq extends Primitive{
    String donneeUser;

    public NDataReq(String donneeUser) {
        this.donneeUser = donneeUser;
    }

    public String getDonneeUser() {
        return donneeUser;
    }

    public void setDonneeUser(String donneeUser) {
        this.donneeUser = donneeUser;
    }

    @Override
    public String toString() {
        return " Primitive :N_Data.Req { " +
                " donneeUser = " + donneeUser +
                " }";
    }
}
