package br.com.scargames.controller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.services.BandeiraService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bandeiraMB")
@ViewScoped
public class BandeiraMB implements Serializable{

    private Bandeira bandeira;
    private List<Bandeira> bandeiras;
    
    public BandeiraMB() {
        this.listar();
    }
    
    public void listar(){
        BandeiraService service = new BandeiraService();
        bandeiras = service.listar();
    }
    
    public String novo(){
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        BandeiraService service = new BandeiraService();
        if (service.inserir(bandeira)){
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Bandeira> getBandeiras() {
        return bandeiras;
    }

    public void setBandeiras(List<Bandeira> bandeiras) {
        this.bandeiras = bandeiras;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }
}
