package Paquet;


public class PaquetAppel extends Paquet{
    private int adresseSource,adrDestination;


    public PaquetAppel(int numeroConnexion, String typePaquet, int adresseSource, int adrDestination) {
        super(numeroConnexion, typePaquet);
        this.adresseSource = adresseSource;
        this.adrDestination = adrDestination;
    }

    public int getAdresseSource() {
        return adresseSource;
    }

    public void setAdresseSource(int adresseSource) {
        this.adresseSource = adresseSource;
    }

    public int getAdrDestination() {
        return adrDestination;
    }

    public void setAdrDestination(int adrDestination) {
        this.adrDestination = adrDestination;
    }

    @Override
    public String toString() {
        return  "Paquet d'Appel { " +
                super.toString()+
                " adresseSource = " + adresseSource +
                ", adrDestination = " + adrDestination +
                " }";
    }
}
