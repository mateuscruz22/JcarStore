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
import jcarstore.TelaCadastroVeiculo;
import jcarstore.TelaEditarVeiculo;
import jcarstore.controllers.TelaGerenciarVeiculosController;
import jcarstore.dao.VeiculoDAO;
import jcarstore.models.Veiculo;

/**
 * FXML Controller class
 *
 * @author gig9
 */
public class TelaEditarVeiculosController implements Initializable {

    @FXML
    private Label txtMensagem;
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
    private TextField txtFoto;
    @FXML
    private TextField txtAno;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtAno.setText(Integer.toString(TelaGerenciarVeiculosController.getvSelecionado().getAnoVeiculo()));
        txtDescricao.setText(TelaGerenciarVeiculosController.getvSelecionado().getDescricaoVeiculo());
        txtModelo.setText(TelaGerenciarVeiculosController.getvSelecionado().getModeloVeiculo());
        txtFoto.setText(TelaGerenciarVeiculosController.getvSelecionado().getFotoVeiculo());
        txtMarca.setText(TelaGerenciarVeiculosController.getvSelecionado().getMarcaVeiculo());
        txtPrecocusto.setText(Double.toString(TelaGerenciarVeiculosController.getvSelecionado().getPrecoCusto()));
        txtPrecovenda.setText(Double.toString(TelaGerenciarVeiculosController.getvSelecionado().getPrecoVenda()));
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
        veiculo.setIdVeiculo(TelaGerenciarVeiculosController.getvSelecionado().getIdVeiculo());
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.update(veiculo);
        
        Alert alert1 = new  Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("");
        alert1.setHeaderText("Veículo editado com sucesso!");
        ButtonType aceitar = new ButtonType("Ok", ButtonBar.ButtonData.CANCEL_CLOSE);
        
        alert1.getButtonTypes().setAll(aceitar);
        Optional<ButtonType> result1 = alert1.showAndWait();
        TelaEditarVeiculo.getStage().close();
        
        
        
    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
        TelaEditarVeiculo.getStage().close();
    }
    
}
