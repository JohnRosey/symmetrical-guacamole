package directives;

/*
ETABLISSEMENT DE CONNEXION RESEAU
N_Disconnect.Req
 */
public class N_DisconnectReq {
    private int adresseReponse;

    public N_DisconnectReq(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    public int getAdrReponde() {
        return adresseReponse;
    }

    public void setAdrReponde(int adresseReponse) {
        this.adresseReponse = adresseReponse;
    }

    @Override
    public String toString() {
        return "N_DisconnectReq{" +
                "adresseReponse=" + adresseReponse +
                '}';
    }
}
