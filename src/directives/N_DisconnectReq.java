package directives;

/*
liberation de connexion de reseau
DEMANDE
N_Disconnect.Req
 */
public class N_DisconnectReq {
    private int adresseReponse;

    /**
     * @param adresseReponse
     */
    public N_DisconnectReq(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }


    public int getAdresseReponse() {
        return adresseReponse;
    }

    public void setAdresseReponse(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    @Override
    public String toString() {
        return "N_DisconnectReq{" +
                "adresseReponse=" + adresseReponse +
                '}';
    }
}
