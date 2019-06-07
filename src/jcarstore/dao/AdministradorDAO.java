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
import jcarstore.models.Administrador;
/**
 *
 * @author gig9
 */
public class AdministradorDAO implements IDAO<Administrador> {

    @Override
    public boolean insert(Administrador administrador) throws PersistenceException {
    
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            if (administrador.getIdAdministador()== null) {
                em.persist(administrador);
            } else {
                em.merge(administrador);
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
    public boolean remove(Administrador administrador) throws PersistenceException {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(em.find(Administrador.class, administrador.getIdAdministador()));
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
    public boolean update(Administrador administrador) {
        
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.merge(administrador);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public Administrador getObjectById(int id) {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            Administrador administrador = em.find(Administrador.class, id);
            em.close();
            return administrador;
        } catch (PersistenceException e) {
            throw new PersistenceException(e);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Administrador> getAll() {
        
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        
        Query query = em.createQuery("SELECT c FROM Administrador c");
        return (List<Administrador>) query.getResultList();
    }

    
    
    
}
