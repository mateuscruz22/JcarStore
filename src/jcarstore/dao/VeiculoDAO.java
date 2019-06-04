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
import jcarstore.models.Veiculo;

/**
 *
 * @author Luiz
 */
public class VeiculoDAO implements IDAO<Veiculo> {

    @Override
    public boolean insert(Veiculo veiculo){ 
              DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            if (veiculo.getIdVeiculo() == null) {
                em.persist(veiculo);
            } else {
                em.merge(veiculo);
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
       throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(Veiculo veiculo) {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.find(Veiculo.class, veiculo.getIdVeiculo());
            em.remove(veiculo);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Veiculo veiculo) {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
        em.close();

        return true;    }

    @Override
    public Veiculo getObjectById(int id) {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            Veiculo veiculo = em.find(Veiculo.class, id);
            em.close();
            return veiculo;
        } catch (PersistenceException e) {
            throw new PersistenceException(e);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }    
    }

    @Override
    public List<Veiculo> getAll() {
         DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        
        Query query = em.createQuery("SELECT c FROM Veiculo c");
        return (List<Veiculo>) query.getResultList();
        }
    }

    

    

