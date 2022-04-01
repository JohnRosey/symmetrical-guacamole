package directives;

/**
 *
 */
/*
ETABLISSEMENT DE CONNEXION RESEAU
demande
N_Connect.Req

 */
public class N_ConnectReq {

    private int adressSource,adresseDestination;



    public int getAdressSource() {
        return adressSource;
    }

    public void setAdressSource(int adressSource) {
        this.adressSource = adressSource;
    }

    public int getAdresseDestination() {
        return adresseDestination;
    }

    public void setAdresseDestination(int adresseDestination) {
        this.adresseDestination = adresseDestination;
    }



    /**
     * @param adrSource
     * @param adrDestination
     */
    public N_ConnectReq(int adrSource, int adrDestination) {
        this.adressSource = adrSource;
        this.adresseDestination = adrDestination;
    }


    @Override
    public String toString() {
        return "N_ConnectReq{" +
                "adressSource=" + adressSource +
                ", adresseDestination=" + adresseDestination +
                '}';
    }
}
