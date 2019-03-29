package br.com.scargames.services;
import br.com.scargames.dao.BandeiraDao;
import br.com.scargames.domain.Bandeira;
import java.util.List;


public class BandeiraService {

    private final BandeiraDao bandeiraDao = new BandeiraDao();
    
    public List<Bandeira> listar(){     
        return bandeiraDao.listar();      
    }

    public Bandeira consultar(Integer id){
        return bandeiraDao.consultar(id);   
    }

    public boolean inserir (Bandeira bandeira){
        return bandeiraDao.inserir(bandeira);
    }

    public Boolean alterar (Bandeira bandeira){
        return bandeiraDao.alterar(bandeira);
    }

    public boolean excluir (Bandeira bandeira){
        return bandeiraDao.excluir(bandeira);
    }

}    

