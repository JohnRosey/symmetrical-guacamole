package directives;



/*
ETABLISSEMENT DE CONNEXION RESEAU
REPONSE
N_Connect.Resp

 */
public class N_ConnectResp {

    private int adresseReponse;


    /**
     * @param adresseReponse
     */
    public N_ConnectResp(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    public int getAdresseReponse() {
        return adresseReponse;
    }

    public void setAdresseReponse(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }
}
