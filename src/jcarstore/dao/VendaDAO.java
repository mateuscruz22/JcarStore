/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import static jcarstore.dao.DBFrameworkDAO.getEntityManager;
import jcarstore.models.Venda;

/**
 *
 * @author gig9
 */
public class VendaDAO implements IDAO<Venda> {

    @Override
    public boolean insert(Venda venda) {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        
        
        try {
            em.getTransaction().begin();
            if (venda.getIdVenda()== null) {
                em.persist(venda);
            } else {
                em.merge(venda);
            }
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.out.println("Erro: " + e);
            return false;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Venda venda) {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            //procura no banco de dados o veiculo para excluir
            em.find(Venda.class, venda.getIdVenda());
            //removo o veiculo
            em.remove(venda);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (PersistenceException e) {
            System.out.println("Erro: " + e);
            return false;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }   
    }

    @Override
    public boolean update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Venda venda) {
    
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.merge(venda);
        em.getTransaction().commit();
        em.close();

        return true;    
    }

    @Override
    public Venda getObjectById(int id) {
    
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            Venda venda = em.find(Venda.class, id);
            em.close();
            return venda;
        } catch (PersistenceException e) {
            throw new PersistenceException(e);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }
    

    @Override
    public List<Venda> getAll() {
    
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        
        //Query query = em.createQuery("SELECT v.idVenda AS idVenda, c.nomeCliente FROM Venda v INNER JOIN Cliente c");
        Query query = em.createQuery("SELECT v FROM Venda v");

        return (List<Venda>) query.getResultList();
        
    }
    
}
