package directives;
/*
ETABLISSEMENT DE CONNEXION RESEAU
 N_Connect.Conf


 */
public class N_ConnectConf{

    private int adrReponde;


    public N_ConnectConf(int adrReponde) {
        this.adrReponde = adrReponde;
    }

    public int getAdrReponde() {
        return adrReponde;
    }

    public void setAdrReponde(int adrReponde) {
        this.adrReponde = adrReponde;
    }

    @Override
    public String toString() {
        return "N_ConnectConf{" +
                "adrReponde=" + adrReponde +
                '}';
    }
}
