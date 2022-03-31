package com.company;

public class Main {
    enum PRIMITIVE {
        UN, DEUX, TROIS
    }

    public static void main(String[] args) {
        
        for (PRIMITIVE primitive : PRIMITIVE.values()) {
            System.out.println(primitive);
        }

    }

}