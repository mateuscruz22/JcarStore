/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jcarstore.TelaLogin;
import jcarstore.TelaAdministrador;
import jcarstore.TelaCadastroCliente;
import jcarstore.dao.AdministradorDAO;
import jcarstore.dao.ClienteDAO;
import jcarstore.models.Administrador;
import jcarstore.models.Cliente;
import jcarstore.models.Session;

/**
 * FXML Controller class
 *
 * @author Mateus Araújo Cruz
 */
public class TelaLoginController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Button btnEntrar;
    @FXML
    private Label txtMensagem;

    Administrador administrador = new Administrador();
    AdministradorDAO administradorDAO = new AdministradorDAO();
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnEntrarClick(ActionEvent event) {

        this.administrador = this.administradorDAO.getAdministrador(this.txtUsuario.getText(), this.txtSenha.getText());
        if (this.administrador != null) {
            this.txtMensagem.setText("Login realizado com sucesso!");           
            TelaAdministrador telaAdministrador = new TelaAdministrador();
            TelaLogin.getStage().close();
            try {
                telaAdministrador.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            this.txtMensagem.setText("Usuário ou senha incorretos.");
        }
        
        this.cliente = this.clienteDAO.getCliente(this.txtUsuario.getText(), this.txtSenha.getText());
        if (this.cliente != null) {
            this.txtMensagem.setText("Login realizado com sucesso!");
            
            Session session = new Session();
            
            session.setSessionCliente(clienteDAO.getObjectByEmail(this.txtUsuario.getText()));
           
            //TelaPainelDeControleCliente telaPainelDeControleCliente = new TelaPainelDeControleCliente();
            //TelaPainelDeControleCliente.getStage().close();
            System.out.println("entrou na desgraca");
            System.out.println("id: " + session.getSessionCliente().getNomeCliente());
            try {
                //telaPainelDeControleCliente.start(new Stage());
            } catch (Exception e) {
                Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            this.txtMensagem.setText("Usuário ou senha incorretos.");
        }
        
    }

    @FXML
    private void btnCadastrarClick(ActionEvent event) throws Exception {
        TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
        TelaLogin.getStage().close();
        telaCadastroCliente.start(new Stage());
    }

}
