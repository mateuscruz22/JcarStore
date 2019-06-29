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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jcarstore.dao.VeiculoDAO;
import jcarstore.dao.VendaDAO;
import jcarstore.models.Veiculo;
import jcarstore.models.Venda;
import jcarstore.models.Session;

/**
 * FXML Controller class
 *
 * @author Luiz
 */
public class TelaListaComprasController implements Initializable {

    @FXML
    private TableView<Veiculo> tableView;
    @FXML
    private TableColumn<Veiculo, Integer> columID;
    @FXML
    private TableColumn<Veiculo, String> columModelo;
    @FXML
    private TableColumn<Veiculo, String> columMarca;
    @FXML
    private TableColumn<Veiculo, Double> columAno;
    @FXML
    private TableColumn<Veiculo, String> columDescricao;
    @FXML
    private TableColumn<Veiculo, Double> columPrecoVenda;
    @FXML
    private TableColumn<Veiculo, String> columFoto;
    @FXML
    private Button btnComprar;
    
    
    private Veiculo selecionado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaTable();
        
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    selecionado = (Veiculo) newValue;
                    
                } 
            });
    }    
    
    public void iniciaTable(){
        columID.setCellValueFactory(new PropertyValueFactory("idVeiculo"));
        columModelo.setCellValueFactory(new PropertyValueFactory("modeloVeiculo"));
        columMarca.setCellValueFactory(new PropertyValueFactory("marcaVeiculo"));
        columAno.setCellValueFactory(new PropertyValueFactory("anoVeiculo"));
        columDescricao.setCellValueFactory(new PropertyValueFactory("descricaoVeiculo"));
        columPrecoVenda.setCellValueFactory(new PropertyValueFactory("precoVendaVeiculo"));
        columFoto.setCellValueFactory(new PropertyValueFactory("fotoVeiculo"));
        tableView.setItems(atualizaTable());
    
    }
    
    public ObservableList<Veiculo> atualizaTable(){
        VeiculoDAO veiculodao = new VeiculoDAO();
        return FXCollections.observableArrayList(veiculodao.getAll());
  }

    @FXML
    private void ComprarVeiculo(ActionEvent event) {
            
        Alert alert = new  Alert(AlertType.CONFIRMATION);
        alert.setTitle("Atenção");
        alert.setContentText("Deseja realmente comprar?");
        ButtonType cancelButton = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        ButtonType okButton = new ButtonType("OK");
        alert.getButtonTypes().setAll( cancelButton, okButton);
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get()== okButton){
            System.out.println(selecionado.getModeloVeiculo());
            Venda venda = new Venda();
            venda.setIdVeiculo(selecionado);
            venda.setIdCliente(Session.getSessionCliente());
            venda.setLucroVenda((float) (selecionado.getPrecoCusto()-selecionado.getPrecoVenda()));
            VendaDAO vendadao = new VendaDAO ();
            vendadao.insert(venda);
            
            Alert alert1 = new  Alert(AlertType.INFORMATION);
            alert1.setTitle("Parabéns");
            alert1.setHeaderText("Você acabou de comprar um carro!");
            ButtonType aceitar = new ButtonType("Ok", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(aceitar);
            Optional<ButtonType> result1 = alert1.showAndWait();
            
           
        }
       
    }
   
}
