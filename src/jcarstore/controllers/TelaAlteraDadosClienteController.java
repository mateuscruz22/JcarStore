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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import jcarstore.dao.ClienteDAO;
import jcarstore.models.Cliente;

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
    private TextField txtFoto;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField txtFmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void btnAlteraDados(ActionEvent event) {
        
            Cliente cliente = new Cliente();

            cliente.setEnderecoCliente(txtEndereco.getText());
            cliente.setSenhaCliente(txtSenha.getText());
            cliente.setEmailCliente(txtFmail.getText());
            cliente.setFotoCliente(txtFoto.getText());

            ClienteDAO clientedao = new ClienteDAO();
            clientedao.update(cliente);
        
        }
    
       
}
