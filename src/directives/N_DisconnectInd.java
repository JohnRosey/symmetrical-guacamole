package directives;


/* indication
liberation  DE CONNEXION RESEAU

N_Disconnect.Ind
 */
public class N_DisconnectInd {
    private int adresseReponse;
    private String raison;

    /**
     * @param adrReponde
     * @param raison
     */
    public N_DisconnectInd(int adrReponde, String raison) {
        this.adresseReponse = adrReponde;
        this.raison = raison;
    }


    public int getAdrReponde() {
        return adresseReponse;
    }

    public void setAdrReponde(int adrReponde) {
        this.adresseReponse = adrReponde;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }


    @Override
    public String toString() {
        return "NDisconnectInd{" +
                "adrReponde=" + adresseReponse +
                ", raison='" + raison + '\'' +
                '}';
    }
}
