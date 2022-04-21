package Couche.CTransport;
import Enum.state;

/*
une classe qui presenter une communication entre deux extremite,
les deux extremite peuvent etre deja connecte ou non connecte.
 */
public class Communication {
    int id;//identifiant d’extrémité de connexion
    private final String appSource;
    private String appDestination;
    private state state;
    private String Data;//les donnees que a envoyer
    private int adrSource,adrDestination;

    public Communication(int id, String appSource, String appDestination, state state, int adSource, int adDestination) {
        this.id = id;
        this.appSource = appSource;
        this.appDestination = appDestination;
        this.state = state;
        this.adrSource = adSource;
        this.adrDestination = adDestination;
    }

    public int getId() {
        return id;
    }

    public String getAppSource() {
        return appSource;
    }

    public String getAppDestination() {
        return appDestination;
    }

    public state getEtatConnexion() {
        return state;
    }

    public void setEtatConnexion(state state) {
        this.state = state;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public int getAdrSource() {
        return adrSource;
    }

    public void setAdrSource(int adSource) {
        this.adrSource = adSource;
    }

    public int getAdrDestination() {
        return adrDestination;
    }

    public void setAdrDestination(int adDestination) {
        this.adrDestination = adDestination;
    }
}
