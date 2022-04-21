package Primitive;

public class NConnectConf extends Primitive{

    private final int adresseReponse;


    public NConnectConf(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }



    @Override
    public String toString() {
        return " Primitive :N_Connect.Conf { " +
                " adresseReponse = " + adresseReponse +
                " }";
    }
}
