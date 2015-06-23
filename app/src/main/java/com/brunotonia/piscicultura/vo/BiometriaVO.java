package com.brunotonia.piscicultura.vo;

public class BiometriaVO {
    private Long id;
    private Long loteTanque;
    private String data;
    private Integer a1_ind;
    private Float a1_peso;
    private Integer a2_ind;
    private Float a2_peso;
    private Integer a3_ind;
    private Float a3_peso;
    private Integer a4_ind;
    private Float a4_peso;
    private Long responsavel;

    public BiometriaVO(Long id, Long loteTanque, String data,
                       Integer a1_ind, Float a1_peso, Integer a2_ind, Float a2_peso,
                       Integer a3_ind, Float a3_peso, Integer a4_ind, Float a4_peso,
                       Long responsavel) {
        this.id = id;
        this.loteTanque = loteTanque;
        this.data = data;
        this.a1_ind = a1_ind;
        this.a1_peso = a1_peso;
        this.a2_ind = a2_ind;
        this.a2_peso = a2_peso;
        this.a3_ind = a3_ind;
        this.a3_peso = a3_peso;
        this.a4_ind = a4_ind;
        this.a4_peso = a4_peso;
        this.responsavel = responsavel;
    }

    public BiometriaVO(Long loteTanque, String data,
                       Integer a1_ind, Float a1_peso, Integer a2_ind, Float a2_peso,
                       Integer a3_ind, Float a3_peso, Integer a4_ind, Float a4_peso,
                       Long responsavel) {
        this.loteTanque = loteTanque;
        this.data = data;
        this.a1_ind = a1_ind;
        this.a1_peso = a1_peso;
        this.a2_ind = a2_ind;
        this.a2_peso = a2_peso;
        this.a3_ind = a3_ind;
        this.a3_peso = a3_peso;
        this.a4_ind = a4_ind;
        this.a4_peso = a4_peso;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoteTanque() {
        return loteTanque;
    }

    public void setLoteTanque(Long loteTanque) {
        this.loteTanque = loteTanque;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getA1_ind() {
        return a1_ind;
    }

    public void setA1_ind(Integer a1_ind) {
        this.a1_ind = a1_ind;
    }

    public Integer getA2_ind() {
        return a2_ind;
    }

    public void setA2_ind(Integer a2_ind) {
        this.a2_ind = a2_ind;
    }

    public Integer getA3_ind() {
        return a3_ind;
    }

    public void setA3_ind(Integer a3_ind) {
        this.a3_ind = a3_ind;
    }

    public Integer getA4_ind() {
        return a4_ind;
    }

    public void setA4_ind(Integer a4_ind) {
        this.a4_ind = a4_ind;
    }

    public Float getA1_peso() {
        return a1_peso;
    }

    public void setA1_peso(Float a1_peso) {
        this.a1_peso = a1_peso;
    }

    public Float getA2_peso() {
        return a2_peso;
    }

    public void setA2_peso(Float a2_peso) {
        this.a2_peso = a2_peso;
    }

    public Float getA3_peso() {
        return a3_peso;
    }

    public void setA3_peso(Float a3_peso) {
        this.a3_peso = a3_peso;
    }

    public Float getA4_peso() {
        return a4_peso;
    }

    public void setA4_peso(Float a4_peso) {
        this.a4_peso = a4_peso;
    }

    public Long getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Long responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Data '" + data;
    }
}
