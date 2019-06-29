/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jcarstore.TelaCadastroVeiculo;
import jcarstore.TelaEditarVeiculo;
import jcarstore.dao.VeiculoDAO;
import jcarstore.models.Veiculo;


/**
 * FXML Controller class
 *
 * @author Mateus Araújo Cruz
 */
public class TelaGerenciarVeiculosController implements Initializable {

    @FXML
    private TableColumn<Veiculo, Integer> idVeiculoCol;
    @FXML
    private TableColumn<Veiculo, String> modeloCol;
    @FXML
    private TableColumn<Veiculo, String> marcaCol;
    @FXML
    private TableColumn<Veiculo, String> anoCol;
    @FXML
    private TableColumn<Veiculo, String> descricaoCol;
    @FXML
    private TableColumn<Veiculo, Float> precoCustoCol;
    @FXML
    private TableColumn<Veiculo, Float> precoVendaCol;
    @FXML
    private TableView<Veiculo> tabela;
    @FXML
    private Button BtnCadastrar;
    @FXML
    private Button BtnAtualizar;
    
    private static Veiculo vSelecionado;

    public static Veiculo getvSelecionado() {
        return vSelecionado;
    }

    

    public void iniciaTable(){
        idVeiculoCol.setCellValueFactory(new PropertyValueFactory("idVenda"));
        modeloCol.setCellValueFactory(new PropertyValueFactory("idCliente"));
        marcaCol.setCellValueFactory(new PropertyValueFactory("idVeiculo"));
        anoCol.setCellValueFactory(new PropertyValueFactory("dataVenda"));
        descricaoCol.setCellValueFactory(new PropertyValueFactory("lucroVenda"));
        precoCustoCol.setCellValueFactory(new PropertyValueFactory("dataVenda"));
        precoVendaCol.setCellValueFactory(new PropertyValueFactory("lucroVenda"));
        tabela.setItems(atualizaTable());
    }

    private ObservableList<Veiculo> atualizaTable() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        return FXCollections.observableArrayList(veiculoDAO.getAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaTable();
        
        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    vSelecionado = (Veiculo) newValue;
                    
                } 
            });
    }  

    @FXML
    private void BtnCadastrarClick(ActionEvent event) throws Exception {
        TelaCadastroVeiculo telaCadastroVeiculo = new TelaCadastroVeiculo();
        telaCadastroVeiculo.start(new Stage());
    }

    @FXML
    private void BtnAtualizarClick(ActionEvent event) throws Exception {
        TelaEditarVeiculo telaEditarVeiculo = new TelaEditarVeiculo();
        telaEditarVeiculo.start(new Stage());
        
    }

    @FXML
    private void BtnAtualizartabelaClick(ActionEvent event) {
        tabela.setItems(atualizaTable());
    }
    
}
