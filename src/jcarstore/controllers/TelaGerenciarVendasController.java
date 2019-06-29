/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jcarstore.dao.VeiculoDAO;
import jcarstore.dao.VendaDAO;
import jcarstore.models.Veiculo;
import jcarstore.models.Venda;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class TelaGerenciarVendasController implements Initializable{

    @FXML
    private TableView<Venda> tabela;
    @FXML
    private TableColumn<Venda, Integer> idVendaCol;
    @FXML
    private TableColumn<Venda, String> nomeClienteCol;
    @FXML
    private TableColumn<Venda, String> modeloVeiculoCol;
    @FXML
    private TableColumn<Venda, String> dataVendaCol;
    @FXML
    private TableColumn<Venda, Float> lucroObtidoCol;
    @FXML
    private Button btnDeletar;
    
    private Venda selecionado;
    
    public void iniciaTable(){
        idVendaCol.setCellValueFactory(new PropertyValueFactory("idVenda"));
        nomeClienteCol.setCellValueFactory(new PropertyValueFactory("idCliente"));
        modeloVeiculoCol.setCellValueFactory(new PropertyValueFactory("idVeiculo"));
        dataVendaCol.setCellValueFactory(new PropertyValueFactory("dataVenda"));
        lucroObtidoCol.setCellValueFactory(new PropertyValueFactory("lucroVenda"));
        tabela.setItems(atualizaTable());
    }

    private ObservableList<Venda> atualizaTable() {
        VendaDAO vendaDAO = new VendaDAO();
        return FXCollections.observableArrayList(vendaDAO.getAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaTable();
        
        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    selecionado = (Venda) newValue;
                    
                } 
            });
    }

    @FXML
    private void showDeletarVenda(ActionEvent event) {
        Alert alert = new  Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setContentText("Deseja realmente deletar ?");
        ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType okButton = new ButtonType("OK");
        alert.getButtonTypes().setAll( cancelButton, okButton);
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == okButton){
            if(selecionado != null){
                VendaDAO vendaDAO = new VendaDAO();
                vendaDAO.remove(selecionado.getIdVenda());
                tabela.setItems(atualizaTable());
            }
            
        }
    }
    
}