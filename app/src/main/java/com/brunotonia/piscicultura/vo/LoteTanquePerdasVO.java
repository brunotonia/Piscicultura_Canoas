package com.brunotonia.piscicultura.vo;


public class LoteTanquePerdasVO {
    private Long id;
    private Integer individuos;
    private Long lTanque;
    private String data;
    private String observacao;

    public LoteTanquePerdasVO(Long id, Integer individuos, Long lTanque, String data, String observacao) {
        this.id = id;
        this.individuos = individuos;
        this.lTanque = lTanque;
        this.data = data;
        this.observacao = observacao;
    }

    public LoteTanquePerdasVO(Integer individuos, Long lTanque, String data, String observacao) {
        this.individuos = individuos;
        this.lTanque = lTanque;
        this.data = data;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndividuos() {
        return individuos;
    }

    public void setIndividuos(Integer individuos) {
        this.individuos = individuos;
    }

    public Long getlTanque() {
        return lTanque;
    }

    public void setlTanque(Long lTanque) {
        this.lTanque = lTanque;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return data;
    }
}
