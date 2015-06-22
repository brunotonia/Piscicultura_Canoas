package com.brunotonia.piscicultura.vo;

public class SessaoVO {

    private Long id = null;
    private String nome = null;
    private Integer nivel = null;

    public SessaoVO(Long id, String nome, Integer nivel) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public boolean isAdministrador() {
        return nivel == 0;
    }

    public boolean isOperacional() {
        return nivel == 1;
    }

    public boolean isParceiro() {
        return nivel == 2;
    }

}
