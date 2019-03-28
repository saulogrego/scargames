package br.com.scargames.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name="nome")
    @Size(min=1,max=100)
    private String nome;
    
    @NotNull
    @Column(name="cpf")
    @Size(min=11,max=11)
    private String cpf;
    
    @NotNull
    @Column(name="dataNascimento")
    private Date dataNascimento;
    
    @NotNull
    @Column(name="sexo")
    @Size(min=1,max=1)
    private String sexo;
    
    @NotNull
    @Column(name="telefone")
    @Size(min=1,max=45)
    private String telefone;
    
    @NotNull
    @Column(name="email",unique=true)
    @Size(min=1,max=50)
    @Email
    private String email;
    
    @NotNull
    @Column(name="senha")
    @Size(min=6,max=100)
    private String senha;
    
    @OneToMany(mappedBy="id")
    private List<Endereco> enderecos;
    
    @OneToMany(mappedBy="id")
    private List<Cartao> cartoes;
    
    @OneToOne(mappedBy="usuario")
    private Biblioteca biblioteca;
    
    public Usuario() {
    }
    
    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public Usuario(Integer id, String nome, String cpf, Date dataNascimento, String sexo, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
