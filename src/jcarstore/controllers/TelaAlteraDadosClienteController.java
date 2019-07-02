/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
    @FXML
    private Label txtMensagem;

    /**
     @FXML
    private TextField txtEmail;
    * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente=clienteDAO.getObjectById(Session.getSessionCliente().getIdCliente());
        //puxar o dados do session é burrice pq ele nao atualiza, eu nao ia ficar fazendo método set pra ele
        //era muito mais fácil deixar o session como inteiro em vez do objeto todo .. fazer igual a linha 58, chamando apenas o id
        
        txtEndereco.setText(cliente.getEnderecoCliente()); 
        txtSenha.setText(cliente.getSenhaCliente());
        txtEmail.setText(cliente.getEmailCliente());
        txtNome.setText(cliente.getNomeCliente());
        
        // TODO
    }    

    
    

    @FXML
    private void btnAlterarDados(ActionEvent event) {
            Cliente cliente = new Cliente();
            
            cliente.setEnderecoCliente(txtEndereco.getText());
            System.out.println("Cliente alterado " + cliente.getEnderecoCliente() );
            cliente.setSenhaCliente(txtSenha.getText());
            cliente.setEmailCliente(txtEmail.getText());
            cliente.setNomeCliente(txtNome.getText());
            cliente.setIdCliente(Session.getSessionCliente().getIdCliente());
            
           
            

            ClienteDAO clientedao = new ClienteDAO();
            clientedao.update(cliente);
            Alert alert = new  Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Cadastro atualizado com sucesso!");
            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll( okButton);

            Optional<ButtonType> result = alert.showAndWait();
            
            
            
        
    }
    
       
}
