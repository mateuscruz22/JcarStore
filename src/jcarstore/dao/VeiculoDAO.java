/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.dao;

import javax.persistence.EntityManager;
import static jcarstore.dao.DBFrameworkDAO.getEntityManager;
import jcarstore.models.Veiculo;

/**
 *
 * @author Luiz
 */
public class VeiculoDAO {
    
    //Painel administrador: açoes sobre os veiculos
    public Veiculo salvar(Veiculo veiculo) throws Exception {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            //como transação com o banco de dados
            if (veiculo.getIdVeiculo() == null) {
                //insere caso nao exista o veiculo
                em.persist(veiculo);
            } else {
                //atualiza caso exita o veiculo
                veiculo = em.merge(veiculo);
            }
            em.getTransaction().commit();
        } finally {
            //acaba a transação com o banco de dados
            em.close();
        }
        return veiculo;
    }

    public void excluir(int id) {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            //procura no banco de dados o veiculo para excluir
            Veiculo veiculo = em.find(Veiculo.class, id);
            //removo o veiculo
            em.remove(veiculo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Veiculo consultarPorId(int id) {
        DBFrameworkDAO db = new DBFrameworkDAO();
        db.Connect("JcarStorePU");
        EntityManager em = getEntityManager();
        Veiculo veiculo = null;
        try {
            veiculo = em.find(Veiculo.class, id);
        } finally {
            em.close();
        }
        return veiculo;
    }
}
