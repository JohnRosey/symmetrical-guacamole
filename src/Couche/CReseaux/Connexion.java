package Couche.CReseaux;

import Enum.state;

public class Connexion {

    private state state;

    private final int adrSourece;
    private int adrDestination;
    private final int id;
    private final int numeroConnexion;
    private int ps;
    private int nbRetransmissions;
    private String infoAtransmettre;

    public Connexion(state state, int adrSourece, int adrDestination, int id, int numeroConnexion) {
        this.state = state;
        this.adrSourece = adrSourece;
        this.adrDestination = adrDestination;
        this.id = id;
        this.numeroConnexion = numeroConnexion;
        this.ps=0;
        this.nbRetransmissions=0;
    }

    public state getEtatConnexion() {
        return state;
    }

    public void setEtatConnexion(state state) {
        this.state = state;
    }

    public int getNumeroConnexion() {
        return numeroConnexion;
    }


    public int getAdrSourece() {
        return adrSourece;
    }



    public int getAdrDestination() {
        return adrDestination;
    }

    public void setAdrDestination(int adrDestination) {
        this.adrDestination = adrDestination;
    }

    public int getId() {
        return id;
    }




    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void augmenterPs() {
        this.ps++;
    }
    public void diminuerPs() {
        this.ps--;
    }


    public int getNbRetransmissions() {
        return nbRetransmissions;
    }

    public void setNbRetransmissions(int nbRetransmissions) {
        this.nbRetransmissions = nbRetransmissions;
    }

    public String getInfoAtransmettre() {
        return infoAtransmettre;
    }

    public void setInfoAtransmettre(String infoAtransmettre) {
        this.infoAtransmettre = infoAtransmettre;
    }

    @Override
    public String toString() {
        return "Connexion{" +
                "state=" + state +
                ", adrSourece=" + adrSourece +
                ", adrDestination=" + adrDestination +
                ", id=" + id +
                ", numeroConnexion=" + numeroConnexion +
                ", ps=" + ps +
                ", nbRetransmissions=" + nbRetransmissions +
                ", infoAtransmettre='" + infoAtransmettre + '\'' +
                '}';
    }
}
