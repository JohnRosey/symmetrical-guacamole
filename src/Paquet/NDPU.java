package Paquet;

import com.company.Primitive;

public class NDPU {
    public Primitive type;
    public Paquet.paquet.Paquet paquet;
    public int adresseSource;
    public int adressedestination;
    public String routeAddr;
    public String data;
    public String target;
    public int ps, pr;
    public boolean flag;
    public int connection;
    public boolean status;



    @Override
    public String toString() {
        return "NDPU{" +
                "type=" + type +
                ", paquet=" + paquet +
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
}
