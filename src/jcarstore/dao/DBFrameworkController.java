/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class DBFrameworkController {
    
    private static EntityManager em;

    public DBFrameworkController() {}
    
    public void Connect(String persistenceName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceName);
        em = factory.createEntityManager();
    }
    
    public static EntityManager getEntityManager(){
        return em;
    }
    
}
