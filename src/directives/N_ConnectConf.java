package directives;



/*
ETABLISSEMENT DE CONNEXION RESEAU
Confirmation
 N_Connect.Conf


 */
public class N_ConnectConf{

    private int adresseReponse;


    /**
     * @param adresseReponse
     */
    public N_ConnectConf(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    public int getAdresseReponse() {
        return adresseReponse;
    }

    public void setAdresseReponse(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }
}
