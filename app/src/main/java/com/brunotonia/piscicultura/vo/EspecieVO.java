package com.brunotonia.piscicultura.vo;

public class EspecieVO {

    private Long id;
    private String especie;

    public EspecieVO(Long id, String especie) {
        this.id = id;
        this.especie = especie;
    }

    public EspecieVO(String especie) {
        this.especie = especie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return especie;
    }
}
