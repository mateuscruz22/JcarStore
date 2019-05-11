/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.dao;

import javax.persistence.EntityManager;
import static jcarstore.dao.DBFrameworkDAO.getEntityManager;
import jcarstore.models.Administrador;
import jcarstore.models.Cliente;
/**
 *
 * @author gig9
 */
public class AdministradorDAO {
    
    public Administrador salvar(Administrador administrador) throws Exception{
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (administrador.getIdAdministador()== null) {
                //Salva os dados da pessoa.
                em.persist(administrador);
            } else {
                //Atualiza os dados da pessoa.
                administrador = em.merge(administrador);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return administrador;
    }
    public void excluir(int id) {
        
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            // Consulta a pessoa na base de dados através do seu ID.
            Administrador administrador = em.find(Administrador.class, id);
            // Remove a pessoa da base de dados.
            em.remove(administrador);
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
}
