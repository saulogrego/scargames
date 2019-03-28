package br.com.scargames.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cartao")
public class Cartao implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name="numero")
    @Size(min=16,max=16)
    private String numero;
    
    @NotNull
    @Column(name="vencimento")
    private Date vencimento;
    
    @JoinColumn(name="bandeira", referencedColumnName="id")
    @ManyToOne(optional=false)
    private Bandeira bandeira;
    
    @JoinColumn(name="usuario",referencedColumnName="id")
    @ManyToOne(optional=false)
    private Usuario usuario;

    public Cartao() {
    }

    public Cartao(Integer id, String numero, Date vencimento, Bandeira bandeira, Usuario usuario) {
        this.id = id;
        this.numero = numero;
        this.vencimento = vencimento;
        this.bandeira = bandeira;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Cartao other = (Cartao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
