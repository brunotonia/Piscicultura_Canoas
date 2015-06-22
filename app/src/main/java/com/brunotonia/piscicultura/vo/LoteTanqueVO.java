package com.brunotonia.piscicultura.vo;

public class LoteTanqueVO {

    private Long id;
    private Long lote;
    private Long tanque;
    private String inicio;
    private String fim;

    public LoteTanqueVO(Long lote, Long tanque, String inicio) {
        this.lote = lote;
        this.tanque = tanque;
        this.inicio = inicio;
    }

    public LoteTanqueVO(Long id, Long lote, Long tanque, String inicio) {
        this.id = id;
        this.lote = lote;
        this.tanque = tanque;
        this.inicio = inicio;
    }

    public LoteTanqueVO(Long id, Long lote, Long tanque, String inicio, String fim) {
        this.id = id;
        this.lote = lote;
        this.tanque = tanque;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLote() {
        return lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }

    public Long getTanque() {
        return tanque;
    }

    public void setTanque(Long tanque) {
        this.tanque = tanque;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "Lote " + lote + " Tanque " + tanque;
    }
}
