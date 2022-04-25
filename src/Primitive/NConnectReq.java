/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Primitive;

public class NConnectReq extends Primitive{
    private int adrSource,adrDestination;

    public NConnectReq(int adrSource, int adrDestination) {
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
        return " Primitive :NConnect.Req { " +
                " adrSource = " + adrSource +
                ", adrDestination = " + adrDestination +
                " }";
    }
}
