package br.com.scargames.controller;

import br.com.scargames.domain.Genero;
import br.com.scargames.services.GeneroService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "generoMB")
@ViewScoped
public class GeneroMB implements Serializable{

    private Genero genero = new Genero();
    private List<Genero> generos;
    private GeneroService service;
    
    public GeneroMB() {
        service = new GeneroService();
        generos = service.listar();
    }
    
    public void novo(){
        genero = new Genero();
    }
    
    public void inserir(){
        if (service.inserir(genero)){
            UtilMessages.messageInfo("Gênero cadastrado com sucesso!");
            generos = service.listar();
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('gestaoGenero').hide();");
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar o gênero!");
        }
    }
    
    public void carregarDados(Genero genero){
        this.genero = genero;
    }
    
    public void excluir(Genero genero){
        if (service.excluir(genero)){
            UtilMessages.messageInfo("Gênero excluído com sucesso!");
            generos = service.listar();
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir o gênero!");
        }
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}
