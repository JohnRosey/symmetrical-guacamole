package Couche;

import Paquet.NDPU;

import java.util.Queue;
import java.util.Timer;

public class Reseau {
    private Queue<NDPU> canalTransportToReseau;//Canal transport vers reseau
    private Queue<NDPU> canalReseauToTransport;//Canal Reseau vers Transport

    private Queue<NDPU> canalReseauToProcessing; //Canal Reseau vers Process
    private Queue<NDPU> canalProcessingToReseau; //Canal Process vers Reseau
    private Timer timer;
    private boolean disconnected;
    private boolean connect;

    public Reseau(Queue<NDPU> canalTransportToReseau, Queue<NDPU> canalReseauToTransport, Queue<NDPU> canalReseauToProcessing, Queue<NDPU> canalProcessingToReseau) {
        this.canalTransportToReseau = canalTransportToReseau;
        this.canalReseauToTransport = canalReseauToTransport;
        this.canalReseauToProcessing = canalReseauToProcessing;
        this.canalProcessingToReseau = canalProcessingToReseau;
    }
}