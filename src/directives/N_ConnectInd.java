package directives;



/*
ETABLISSEMENT DE CONNEXION RESEAU
indication
N_ConnectInd

 */
public class N_ConnectInd {

    private int adressSource,adresseDestination;

    /**
     * @param adressSource
     * @param adresseDestination
     */
    public N_ConnectInd(int adressSource, int adresseDestination) {
        this.adressSource = adressSource;
        this.adresseDestination = adresseDestination;
    }


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
}
