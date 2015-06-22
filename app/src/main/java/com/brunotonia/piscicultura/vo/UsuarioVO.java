package com.brunotonia.piscicultura.vo;

public class UsuarioVO {
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private Long nivel;
    private Long ativo;

    public UsuarioVO(String nome, String usuario, String senha, Long nivel, Long ativo) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public UsuarioVO(Long id, String nome, String usuario, String senha, Long nivel, Long ativo) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return id.toString() + " - " + nome;
    }

    public Long getId() {
        return id;
    }

    public String getIdtoString() {
        return Long.toString(id);
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public Long getAtivo() {
        return ativo;
    }

    public void setAtivo(Long ativo) {
        this.ativo = ativo;
    }

}
