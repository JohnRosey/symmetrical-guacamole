/*
 *  By GANSONRE ISMAEL
 *  * Copyright (c) 2022 GANSONRE ISMAEL. All rights reserved.
 */

package Paquet;


public class PaquetAquittement extends Paquet{

    public PaquetAquittement(int numeroConnexion, String typePaquet) {
        super(numeroConnexion, typePaquet);
    }

    @Override
    public String toString() {
        return "{ numero de connexion = " + getNumeroConnexion()+", typeDePaquet = "+getTypePaquet() + " }";
    }
}
