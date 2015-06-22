package com.brunotonia.piscicultura.vo;

public class TanqueVO {

    private Long id;
    private Integer numero;
    private Integer etapa;
    private Integer estado;
    private Integer linha;
    private Integer coluna;

    public TanqueVO(Integer numero, Integer etapa, Integer estado, Integer linha, Integer coluna) {
        this.numero = numero;
        this.etapa = etapa;
        this.estado = estado;
        this.linha = linha;
        this.coluna = coluna;
    }

    public TanqueVO(Long id, Integer numero, Integer etapa, Integer estado, Integer linha, Integer coluna) {
        this.id = id;
        this.numero = numero;
        this.etapa = etapa;
        this.estado = estado;
        this.linha = linha;
        this.coluna = coluna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getEtapa() {
        return etapa;
    }

    public void setEtapa(Integer etapa) {
        this.etapa = etapa;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return "Tanque " + numero;
    }
}
