/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jcarstore.models.Cliente;
import jcarstore.dao.ClienteDAO;

/**
 *
 * @author gig9
 */
public class TelaCadastroClienteController {

    @FXML
    private Label txtMensagem;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnEntrar;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtFoto;
    @FXML
    private TextField txtDatanasc;
    @FXML
    private void btnEntrarClick(ActionEvent event) {
        Cliente cliente = new Cliente();
        cliente.setCpfCliente(Integer.valueOf(txtCpf.getText()));
        cliente.setNomeCliente(txtUsuario.getText());
        //cliente.setNascimentoCliente(txtDatanasc.getText()); //colocar data de nascimento como string
        cliente.setFotoCliente(txtFoto.getText());
        cliente.setEnderecoCliente(txtEndereco.getText());
        cliente.setEmailCliente(txtEmail.getText());
        cliente.setSenhaCliente(txtSenha.getText());
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insert(cliente);
        
    }
    
}
