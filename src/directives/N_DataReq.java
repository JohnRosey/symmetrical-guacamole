package directives;
/*
demande de transfert de donnes de reseau
Transfere de donnees
N_Data.Req
 */
public class N_DataReq {
    String donneeUser;

    /**
     * @param donneeUser
     */
    public N_DataReq(String donneeUser) {
        this.donneeUser = donneeUser;
    }

    public String getDonneeUser() {
        return donneeUser;
    }

    public void setDonneeUser(String donneeUser) {
        this.donneeUser = donneeUser;
    }

    @Override
    public String toString() {
        return "NDataReq{" +
                "donneeUser='" + donneeUser + '\'' +
                '}';
    }
}
