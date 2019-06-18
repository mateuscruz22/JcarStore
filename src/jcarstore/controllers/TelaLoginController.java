/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.security.Principal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
import jcarstore.dao.AdministradorDAO;
import jcarstore.dao.ClienteDAO;
import jcarstore.models.Administrador;
import jcarstore.models.Cliente;

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
        
    }

}
