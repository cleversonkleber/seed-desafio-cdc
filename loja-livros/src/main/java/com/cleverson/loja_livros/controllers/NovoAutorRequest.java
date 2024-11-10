package com.cleverson.loja_livros.controllers;

import com.cleverson.loja_livros.entities.Autor;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

public class NovoAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size
    private String descricao;

    public NovoAutorRequest(
            @NotBlank String nome,
            @NotBlank @Email String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome,this.email, this.descricao);
    }
}
