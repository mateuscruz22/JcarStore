/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.dao;

import javax.persistence.EntityManager;
import static jcarstore.dao.DBFrameworkDAO.getEntityManager;
import jcarstore.models.Cliente;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class ClienteDAO {

    public Cliente salvar(Cliente cliente) throws Exception {

        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (cliente.getIdCliente() == null) {
                //Salva os dados da pessoa.
                em.persist(cliente);
            } else {
                //Atualiza os dados da pessoa.
                cliente = em.merge(cliente);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return cliente;
    }

    public void excluir(int id) {
        
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            // Consulta a pessoa na base de dados através do seu ID.
            Cliente cliente = em.find(Cliente.class, id);
            // Remove a pessoa da base de dados.
            em.remove(cliente);
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Cliente consultarPorId(int id) {
        
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        Cliente cliente = null;
        
        try {
            //Consulta uma pessoa pelo seu ID.
            cliente = em.find(Cliente.class, id);
        } finally {
            em.close();
        }
        return cliente;
    }
}
