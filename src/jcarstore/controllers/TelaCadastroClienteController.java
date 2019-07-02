/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jcarstore.TelaCadastroCliente;
import jcarstore.TelaLogin;
import jcarstore.models.Cliente;
import jcarstore.dao.ClienteDAO;

/**
 *
 * @author gig9
 */
public class TelaCadastroClienteController implements Initializable{
    
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
    private Button btnCancelar;
    @FXML
    private void btnEntrarClick(ActionEvent event) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCpfCliente(txtCpf.getText());
        cliente.setNomeCliente(txtUsuario.getText());
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String dateString = format.format(new Date());
        if(isDateValid(txtDatanasc.getText())==true){
            cliente.setNascimentoCliente(format.parse(txtDatanasc.getText())); //colocar data de nascimento como string
            cliente.setFotoCliente(txtFoto.getText());
            cliente.setEnderecoCliente(txtEndereco.getText());
            cliente.setEmailCliente(txtEmail.getText());
            cliente.setSenhaCliente(txtSenha.getText());
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.insert(cliente);


            Alert alert = new  Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Cadastro realizado com sucesso!");
            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll( okButton);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()== okButton){

                TelaLogin telaLogin = new TelaLogin();
                TelaCadastroCliente.getStage().close();
                telaLogin.start(new Stage());
            
            }
        } else{
            Alert alert = new  Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Data de nascimento inválida");
            ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll( okButton);

            Optional<ButtonType> result = alert.showAndWait();
        }
        
        
        
        
        
        
    }
    public static boolean isDateValid(String strDate) {
    String dateFormat = "dd/MM/uuuu";

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
    .ofPattern(dateFormat)
    .withResolverStyle(ResolverStyle.STRICT);
    try {
        LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
        return true;
    } catch (DateTimeParseException e) {
       return false;
    } 
}
    
    @FXML
    private void btnCancelarClick(ActionEvent event) throws Exception {
        TelaLogin telaLogin = new TelaLogin();
        TelaCadastroCliente.getStage().close();
        telaLogin.start(new Stage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MaskFieldUtil.cpfField(txtCpf);
        MaskFieldUtil.dateField(txtDatanasc);
    }
    
}
