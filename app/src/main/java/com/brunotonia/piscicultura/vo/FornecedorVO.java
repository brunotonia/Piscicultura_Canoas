package com.brunotonia.piscicultura.vo;

public class FornecedorVO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String ddd;
    private String telefone;
    private String contato;

    public FornecedorVO(String nome, String cpf, String email, String ddd, String telefone, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.ddd = ddd;
        this.telefone = telefone;
        this.contato = contato;
    }

    public FornecedorVO(Long id, String nome, String cpf, String email, String ddd, String telefone, String contato) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.ddd = ddd;
        this.telefone = telefone;
        this.contato = contato;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
