package Couche;

import Paquet.NDPU;

import java.io.IOException;
import java.util.*;

public class Reseau {
    private Queue<NDPU> transportToNetwork;// Canal transport vers reseau
    private Queue<NDPU> networkToTransport;// Canal Reseau vers Transport
    private Queue<NDPU> networkToPaquetProcessing;// Canal Transport vers Transport
    private Queue<NDPU> paquetProcessingToNetwork;// Canal Transport vers Transport
    private Timer timer;
    private boolean disconnected;
    private boolean connect;

    public Reseau() {
        this.transportToNetwork = new ArrayDeque<NDPU>();
        this.networkToTransport = new ArrayDeque<NDPU>();


        this.timer = new Timer();
        this.disconnected = false;
        this.connect = false;
    }
}
