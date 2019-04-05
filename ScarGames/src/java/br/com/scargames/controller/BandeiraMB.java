package br.com.scargames.controller;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.services.BandeiraService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "bandeiraMB")
@ViewScoped
public class BandeiraMB implements Serializable{

    private Bandeira bandeira = new Bandeira();
    private List<Bandeira> bandeiras;
    
    public BandeiraMB() {
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
    
    public String alterar(){
        BandeiraService service = new BandeiraService();
        if (service.alterar(bandeira)){
            return "list.xhtml?faces-redirect=true";
        }else{
            return null;
        }
    }
    
    public void recuperarBandeira(){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        this.bandeira = (Bandeira)session.getAttribute("bandeira");
    }
    
    public String carregarDados(Bandeira bandeira){
        HttpServletRequest servReq = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = servReq.getSession(true);
        session.setAttribute("bandeira", bandeira);
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Bandeira bandeira){
        BandeiraService service = new BandeiraService();
        if (service.excluir(bandeira)){
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
