package com.thiago.trabalhon2;

public class Produto {

    private int id, kmL, LitrosTanque;
    private String automovel;
    private Double vGas, vEta, Labas, valor;

    public Produto() {

    }

    public Produto(int kmL, int litrosTanque, String automovel, Double vGas, Double vEta, Double labas) {
        this.kmL = kmL;
        LitrosTanque = litrosTanque;
        this.automovel = automovel;
        this.vGas = vGas;
        this.vEta = vEta;
        Labas = labas;
    }

    public Produto(int id, int kmL, int litrosTanque, String automovel, Double vGas, Double vEta, Double labas) {
        this.id = id;
        this.kmL = kmL;
        LitrosTanque = litrosTanque;
        this.automovel = automovel;
        this.vGas = vGas;
        this.vEta = vEta;
        Labas = labas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKmL() {
        return kmL;
    }

    public void setKmL(int kmL) {
        this.kmL = kmL;
    }

    public int getLitrosTanque() {
        return LitrosTanque;
    }

    public void setLitrosTanque(int litrosTanque) {
        LitrosTanque = litrosTanque;
    }

    public String getAutomovel() {
        return automovel;
    }

    public void setAutomovel(String automovel) {
        this.automovel = automovel;
    }

    public Double getvGas() {
        return vGas;
    }

    public void setvGas(Double vGas) {
        this.vGas = vGas;
    }

    public Double getvEta() {
        return vEta;
    }

    public void setvEta(Double vEta) {
        this.vEta = vEta;
    }

    public Double getLabas() {
        return Labas;
    }

    public void setLabas(Double labas) {
        Labas = labas;
    }

    public static double calcular(double vGas, double vEta){
        return vEta/vGas;
    }

}
