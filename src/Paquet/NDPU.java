package Paquet;

/**
 * Structure public de NDPU qui represente les paquets
 */
public class NDPU {
    public String type;
    public int adresseSource;
    public int adressedestination;
    public String routeAddr;
    public String data;
    public String target;
    public int ps, pr;
    public boolean flag;
    public int connection;
    public boolean status;

    public NDPU(String type, int adresseSource, int adressedestination, String routeAddr, String data, String target, int ps, int pr, boolean flag, int connection, boolean status) {
        this.type = type;
        this.adresseSource = adresseSource;
        this.adressedestination = adressedestination;
        this.routeAddr = routeAddr;
        this.data = data;
        this.target = target;
        this.ps = ps;
        this.pr = pr;
        this.flag = flag;
        this.connection = connection;
        this.status = status;
    }

    public NDPU() {

    }


    @Override
    public String toString() {
        return "NDPU{" +
                "type=" + type +
                ", adresseSource=" + adresseSource +
                ", adressedestination=" + adressedestination +
                ", routeAddr='" + routeAddr + '\'' +
                ", data='" + data + '\'' +
                ", target='" + target + '\'' +
                ", ps=" + ps +
                ", pr=" + pr +
                ", flag=" + flag +
                ", connection=" + connection +
                ", status=" + status +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAdresseSource() {
        return adresseSource;
    }

    public void setAdresseSource(int adresseSource) {
        this.adresseSource = adresseSource;
    }

    public int getAdressedestination() {
        return adressedestination;
    }

    public void setAdressedestination(int adressedestination) {
        this.adressedestination = adressedestination;
    }

    public String getRouteAddr() {
        return routeAddr;
    }

    public void setRouteAddr(String routeAddr) {
        this.routeAddr = routeAddr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
