package com.brunotonia.piscicultura.vo;

public class BiometriaVO {
    private Long id;
    private Long lote_tanque;
    private String data;
    private Integer am1_ind;
    private Integer am2_ind;
    private Integer am3_ind;
    private Integer am4_ind;
    private Float am1_peso;
    private Float am2_peso;
    private Float am3_peso;
    private Float am4_peso;
    private Long responsavel;

    public BiometriaVO(Long id, Long lote_tanque, String data, Integer am1_ind, Integer am2_ind, Integer am3_ind, Integer am4_ind, Float am1_peso, Float am2_peso, Float am3_peso, Float am4_peso, Long responsavel) {
        this.id = id;
        this.lote_tanque = lote_tanque;
        this.data = data;
        this.am1_ind = am1_ind;
        this.am2_ind = am2_ind;
        this.am3_ind = am3_ind;
        this.am4_ind = am4_ind;
        this.am1_peso = am1_peso;
        this.am2_peso = am2_peso;
        this.am3_peso = am3_peso;
        this.am4_peso = am4_peso;
        this.responsavel = responsavel;
    }

    public BiometriaVO(Long lote_tanque, String data, Integer am1_ind, Integer am2_ind, Integer am3_ind, Integer am4_ind, Float am1_peso, Float am2_peso, Float am3_peso, Float am4_peso, Long responsavel) {
        this.lote_tanque = lote_tanque;
        this.data = data;
        this.am1_ind = am1_ind;
        this.am2_ind = am2_ind;
        this.am3_ind = am3_ind;
        this.am4_ind = am4_ind;
        this.am1_peso = am1_peso;
        this.am2_peso = am2_peso;
        this.am3_peso = am3_peso;
        this.am4_peso = am4_peso;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLote_tanque() {
        return lote_tanque;
    }

    public void setLote_tanque(Long lote_tanque) {
        this.lote_tanque = lote_tanque;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getAm1_ind() {
        return am1_ind;
    }

    public void setAm1_ind(Integer am1_ind) {
        this.am1_ind = am1_ind;
    }

    public Integer getAm2_ind() {
        return am2_ind;
    }

    public void setAm2_ind(Integer am2_ind) {
        this.am2_ind = am2_ind;
    }

    public Integer getAm3_ind() {
        return am3_ind;
    }

    public void setAm3_ind(Integer am3_ind) {
        this.am3_ind = am3_ind;
    }

    public Integer getAm4_ind() {
        return am4_ind;
    }

    public void setAm4_ind(Integer am4_ind) {
        this.am4_ind = am4_ind;
    }

    public Float getAm1_peso() {
        return am1_peso;
    }

    public void setAm1_peso(Float am1_peso) {
        this.am1_peso = am1_peso;
    }

    public Float getAm2_peso() {
        return am2_peso;
    }

    public void setAm2_peso(Float am2_peso) {
        this.am2_peso = am2_peso;
    }

    public Float getAm3_peso() {
        return am3_peso;
    }

    public void setAm3_peso(Float am3_peso) {
        this.am3_peso = am3_peso;
    }

    public Float getAm4_peso() {
        return am4_peso;
    }

    public void setAm4_peso(Float am4_peso) {
        this.am4_peso = am4_peso;
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
