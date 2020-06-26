package com.example.welcome.eride_app;

import android.os.Build;

public class abc {
    String serial;
    String model;
    String id;
    String manf ;
    String  brand;
    String  type;
    String  user ;
    String base;
    String incre ;
    String sdk;
    String board;
    String host;
    String fingerprint;
    public abc()
    {
    }

    public abc(String serial, String model, String id, String manf, String brand, String type, String user, String base, String incre, String sdk, String board, String host, String fingerprint) {
        this.serial = serial;
        this.model = model;
        this.id = id;
        this.manf = manf;
        this.brand = brand;
        this.type = type;
        this.user = user;
        this.base = base;
        this.incre = incre;
        this.sdk = sdk;
        this.board = board;
        this.host = host;
        this.fingerprint = fingerprint;
    }

    public String getId() {
        return serial;
    }

    public String getModel() {
        return model;
    }

    public String getSerial() {
        return id;
    }



}
