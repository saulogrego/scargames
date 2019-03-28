package br.com.scargames.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="jogo")
public class Jogo implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name="titulo")
    @Size(min=1,max=100)
    private String titulo;
    
    @NotNull
    @Column(name="classificacao")
    private Integer classificacao;
    
    @NotNull
    @Column(name="sinopse")
    @Size(min=1,max=1000)
    private String sinopse;
    
    @NotNull
    @Column(name="requisitos")
    @Size(min=1,max=200)
    private String requisitos;
    
    @NotNull
    @Column(name="nota")
    private Double nota;
    
    @JoinColumn(name="genero",referencedColumnName="id")
    @ManyToOne(optional=false)
    private Genero genero;
    
    @JoinColumn(name="produtora",referencedColumnName="id")
    @ManyToOne(optional=false)
    private Produtora produtora;
    
    @OneToOne(mappedBy="jogo")
    private Biblioteca biblioteca;

    public Jogo() {
    }

    public Jogo(Integer id, String titulo, Integer classificacao, String sinopse, String requisitos, Double nota, Genero genero, Produtora produtora) {
        this.id = id;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
        this.requisitos = requisitos;
        this.nota = nota;
        this.genero = genero;
        this.produtora = produtora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogo other = (Jogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
