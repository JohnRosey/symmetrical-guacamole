package com.company;
/**
 * Primitives utilisee lors de l'echange entre la couche ET et ER
 * voir documents
 */
public enum Primitive {
    //Etablisement de la connexion
    N_CONNECT_req,
    N_CONNECT_ind,
    N_CONNECT_resp,
    N_CONNECT_conf,

    //Transfert de donnees
    N_DATA_req,
    N_DATA_ind,

    //Liberation de connexion
    N_DISCONNECT_req,
    N_DISCONNECT_ind,
    ;

    Primitive() {
    }
}
