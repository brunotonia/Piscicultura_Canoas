package com.brunotonia.piscicultura.vo;

public class LoteVO {
    private Long id;
    private Integer numero;
    private Long especie;
    private Long fornecedor;
    private Long etapa;
    private Integer indv_inicio;
    private String data_inicio;
    private Integer indv_final;
    private String data_final;

    public LoteVO(Long id, Integer numero, Long especie, Long fornecedor, Long etapa, Integer indv_inicio, String data_inicio, Integer indv_final, String data_final) {
        this.id = id;
        this.numero = numero;
        this.especie = especie;
        this.fornecedor = fornecedor;
        this.etapa = etapa;
        this.indv_inicio = indv_inicio;
        this.data_inicio = data_inicio;
        this.indv_final = indv_final;
        this.data_final = data_final;
    }

    public LoteVO(Integer numero, Long especie, Long fornecedor, Long etapa, Integer indv_inicio, String data_inicio) {
        this.numero = numero;
        this.especie = especie;
        this.fornecedor = fornecedor;
        this.etapa = etapa;
        this.indv_inicio = indv_inicio;
        this.data_inicio = data_inicio;
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

    public Long getEspecie() {
        return especie;
    }

    public void setEspecie(Long especie) {
        this.especie = especie;
    }

    public Long getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Long fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getEtapa() {
        return etapa;
    }

    public void setEtapa(Long etapa) {
        this.etapa = etapa;
    }

    public Integer getIndv_inicio() {
        return indv_inicio;
    }

    public void setIndv_inicio(Integer indv_inicio) {
        this.indv_inicio = indv_inicio;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Integer getIndv_final() {
        return indv_final;
    }

    public void setIndv_final(Integer indv_final) {
        this.indv_final = indv_final;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

    @Override
    public String toString() {
        return "Lote" + numero;
    }
}
