package br.com.scargames.services;
import br.com.scargames.dao.JogoDao;
import br.com.scargames.domain.Jogo;
import br.com.scargames.util.HashMaker;
import java.util.List;


public class JogoService {

    private final JogoDao jogoDao = new JogoDao();
    
    public List<Jogo> listar(){     
        return jogoDao.listar();      
    }

    public Jogo consultar(Integer id){
        return jogoDao.consultar(id);   
    }

    public boolean inserir (Jogo jogo){
        return jogoDao.inserir(jogo);
    }

    public Boolean alterar (Jogo jogo){
        return jogoDao.alterar(jogo);
    }

    public boolean excluir (Jogo jogo){
        return jogoDao.excluir(jogo);
    }

}    

