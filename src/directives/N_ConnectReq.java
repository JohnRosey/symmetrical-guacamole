package directives;
/*
ETABLISSEMENT DE CONNEXION RESEAU
N_Connect.Req

 */
public class N_ConnectReq {
    private int adrSource,adrDestination;

    public N_ConnectReq(int adrSource, int adrDestination) {
        this.adrSource = adrSource;
        this.adrDestination = adrDestination;
    }

    public int getAdrSource() {
        return adrSource;
    }

    public void setAdrSource(int adrSource) {
        this.adrSource = adrSource;
    }

    public int getAdrDestination() {
        return adrDestination;
    }

    public void setAdrDestination(int adrDestination) {
        this.adrDestination = adrDestination;
    }

    @Override
    public String toString() {
        return "NConnectReq{" +
                "adrSource=" + adrSource +
                ", adrDestination=" + adrDestination +
                '}';
    }
}
