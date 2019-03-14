package br.com.scargames.services;
import br.com.scargames.dao.EnderecoDao;
import br.com.scargames.domain.Endereco;
import br.com.scargames.util.HashMaker;
import java.util.List;


public class EnderecoService {

    private final EnderecoDao enderecoDao = new EnderecoDao();
    
    public List<Endereco> listar(){     
        return enderecoDao.listar();      
    }

    public Endereco consultar(Integer id){
        return enderecoDao.consultar(id);   
    }

    public boolean inserir (Endereco endereco){
        return enderecoDao.inserir(endereco);
    }

    public Boolean alterar (Endereco endereco){
        return enderecoDao.alterar(endereco);
    }

    public boolean excluir (Endereco endereco){
        return enderecoDao.excluir(endereco);
    }

}    


