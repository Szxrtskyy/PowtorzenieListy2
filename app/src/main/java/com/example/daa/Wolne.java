package com.example.daa;

import java.util.Date;

public class Wolne {
    String plan;
    Boolean czySwieto;
    String data;
    String jakie;

    public Wolne(String plan, Boolean czySwieto, String data, String jakie) {
        this.plan = plan;
        this.czySwieto = czySwieto;
        this.data = data;
        this.jakie = jakie;
    }

    @Override
    public String toString() {
        return  data +
                jakie + '\n' +
                plan;

    }
}
