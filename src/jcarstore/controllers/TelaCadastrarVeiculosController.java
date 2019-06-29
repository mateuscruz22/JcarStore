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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jcarstore.TelaCadastroVeiculo;
import jcarstore.dao.VeiculoDAO;
import jcarstore.models.Veiculo;

/**
 * FXML Controller class
 *
 * @author gig9
 */
public class TelaCadastrarVeiculosController implements Initializable {

    @FXML
    private Label txtMensagem;
    @FXML
    private TextField txtFoto;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtPrecocusto;
    @FXML
    private TextField txtPrecovenda;
    @FXML
    private TextField txtAno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnConfirmarClick(ActionEvent event) {
        Veiculo veiculo = new Veiculo();
        veiculo.setAnoVeiculo(Integer.parseInt(txtAno.getText()));
        veiculo.setDescricaoVeiculo(txtDescricao.getText());
        veiculo.setFotoVeiculo(txtFoto.getText());
        veiculo.setMarcaVeiculo(txtMarca.getText());
        veiculo.setModeloVeiculo(txtModelo.getText());
        veiculo.setPrecoCusto(Double.parseDouble(txtPrecocusto.getText()));
        veiculo.setPrecoVenda(Double.parseDouble(txtPrecovenda.getText()));
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.insert(veiculo);
        Alert alert1 = new  Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("");
        alert1.setHeaderText("Cadastro realizado com sucesso!");
        ButtonType aceitar = new ButtonType("Ok", ButtonBar.ButtonData.CANCEL_CLOSE);
        
        alert1.getButtonTypes().setAll(aceitar);
        Optional<ButtonType> result1 = alert1.showAndWait();
        TelaCadastroVeiculo.getStage().close();
        
        
    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
        TelaCadastroVeiculo.getStage().close();
    }
    
}
