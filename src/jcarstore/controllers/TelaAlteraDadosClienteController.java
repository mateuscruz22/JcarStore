/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import jcarstore.dao.ClienteDAO;
import jcarstore.models.Cliente;
import jcarstore.models.Session;

/**
 * FXML Controller class
 *
 * @author Luiz
 */
public class TelaAlteraDadosClienteController implements Initializable {

    @FXML
    private TextField txtSenha;
    @FXML
    private TextField txtEndereco;
    @FXML
    private Button btnAltera;
    @FXML
    private AnchorPane anchorPane;
  
    Cliente cliente = new Cliente();
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNome;

    /**
     @FXML
    private TextField txtEmail;
    * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtEndereco.setText(Session.getSessionCliente().getNomeCliente());
        txtSenha.setText(Session.getSessionCliente().getSenhaCliente());
        txtEmail.setText(Session.getSessionCliente().getEmailCliente());
        txtNome.setText(Session.getSessionCliente().getNomeCliente());
        
        // TODO
    }    

    
    
    
    @FXML
    private void btnAlteraDados(ActionEvent event) {
        
            Cliente cliente = new Cliente();

            cliente.setEnderecoCliente(txtEndereco.getText());
            System.out.println("Cliente alterado " + cliente.getEnderecoCliente() );
            cliente.setSenhaCliente(txtSenha.getText());
            cliente.setEmailCliente(txtEmail.getText());
            cliente.setNomeCliente(txtNome.getText());
            cliente.setIdCliente(Session.getSessionCliente().getIdCliente());
            
           
            

            ClienteDAO clientedao = new ClienteDAO();
            clientedao.update(cliente);
        
        }
    
       
}
