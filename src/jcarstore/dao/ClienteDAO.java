/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import static jcarstore.dao.DBFrameworkDAO.getEntityManager;
import jcarstore.models.Administrador;
import jcarstore.models.Cliente;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class ClienteDAO implements IDAO<Cliente> {

    @Override
    public boolean insert(Cliente cliente) throws PersistenceException {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            if (cliente.getIdCliente() == null) {
                em.persist(cliente);
            } else {
                em.merge(cliente);
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
    public boolean remove(Cliente cliente) throws PersistenceException {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(em.find(Cliente.class, cliente.getIdCliente()));
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
    public boolean update(Cliente cliente) {
        
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    @Override
    public Cliente getObjectById(int id) {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            Cliente cliente = em.find(Cliente.class, id);
            em.close();
            return cliente;
        } catch (PersistenceException e) {
            throw new PersistenceException(e);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Cliente> getAll() {
        
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        
        Query query = em.createQuery("SELECT c FROM Cliente c");
        return (List<Cliente>) query.getResultList();
    }
    
    public Cliente getCliente(String email, String senha) {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.emailCliente = :email AND c.senhaCliente = :senha")
                    .setParameter("email", email)
                    .setParameter("senha", senha)
                    .getSingleResult();
            return cliente;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Cliente getObjectByEmail(String email) {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.emailCliente = :email")
                    .setParameter("email", email)
                    .getSingleResult();
            return cliente;
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
