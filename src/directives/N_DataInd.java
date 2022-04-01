package directives;
/*
indication de transfere de donnees de reseau
Transfere de donnees
N_Data.Req
 */
public class N_DataInd {
    String donneeUser;

    /**
     * @param donneeUser
     */
    public N_DataInd(String donneeUser) {
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
        return "N_DataInd{" +
                "donneeUser='" + donneeUser + '\'' +
                '}';
    }
}
