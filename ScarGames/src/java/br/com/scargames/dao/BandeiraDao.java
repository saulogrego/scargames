package br.com.scargames.dao;

import br.com.scargames.domain.Bandeira;
import br.com.scargames.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class BandeiraDao {

    public List<Bandeira> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Bandeira> lista = session.createQuery("from Bandeira order by descricao asc").list();
            session.getTransaction().commit();
            return lista;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Bandeira consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Bandeira bandeira = (Bandeira)session.createQuery("from Bandeira where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return bandeira;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean inserir(Bandeira bandeira){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(bandeira);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean alterar(Bandeira bandeira){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(bandeira);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean excluir(Bandeira bandeira){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(bandeira);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
}
