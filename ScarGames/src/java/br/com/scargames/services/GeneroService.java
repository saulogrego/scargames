package br.com.scargames.services;
import br.com.scargames.dao.GeneroDao;
import br.com.scargames.domain.Genero;
import br.com.scargames.util.HashMaker;
import java.util.List;


public class GeneroService {

    private final GeneroDao generoDao = new GeneroDao();
    
    public List<Genero> listar(){     
        return generoDao.listar();      
    }

    public Genero consultar(Integer id){
        return generoDao.consultar(id);   
    }

    public boolean inserir (Genero genero){
        return generoDao.inserir(genero);
    }

    public Boolean alterar (Genero genero){
        return generoDao.alterar(genero);
    }

    public boolean excluir (Genero genero){
        return generoDao.excluir(genero);
    }

}    

