package com.cleverson.loja_livros.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_AUTOR")
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    @Email(message = "Emial não esta formato válido!")
    private String email;
    @Column(nullable = false)
    private LocalDateTime datahoraCriacao;
    @Column(nullable = false, length = 400)
    private String descricao;

    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size String descricao) {
        this.nome = nome;
        this.email = email;
        this.datahoraCriacao = LocalDateTime.now();
        this.descricao = descricao;
    }

    public Autor(String nome, String email, LocalDateTime datahoraCriacao, String descricao) {
        this.nome = nome;
        this.email = email;
        this.datahoraCriacao = datahoraCriacao;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDatahoraCriacao() {
        return datahoraCriacao;
    }

    public void setDatahoraCriacao(LocalDateTime datahoraCriacao) {
        this.datahoraCriacao = datahoraCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(uuid, autor.uuid) && Objects.equals(nome, autor.nome)
                && Objects.equals(email, autor.email) && Objects.equals(descricao, autor.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, nome, email, descricao);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
