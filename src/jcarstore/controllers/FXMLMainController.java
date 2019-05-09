/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import jcarstore.dao.DBFrameworkController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.persistence.EntityManager;
import jcarstore.models.Cliente;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class FXMLMainController implements Initializable {
    
    private static EntityManager em;
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        DBFrameworkController db = new DBFrameworkController();
        db.Connect("JcarStorePU");
        
        em = DBFrameworkController.getEntityManager();
        
        //TESTE: INSERE UM REGISTRO NO BANCO DE DADOS
        Cliente cliente1 = new Cliente();
        cliente1.setNomeCliente("Nome");
        cliente1.setEmailCliente("email@email.com");
        cliente1.setSenhaCliente("senha");
        
        em.getTransaction().begin();
        em.persist(cliente1);
        em.getTransaction().commit();
        
        System.out.println("Registro atualizado com sucesso!");
        label.setText("Registro atualizado com sucesso!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
