/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import static java.awt.SystemColor.text;
import java.net.URL;
import static java.time.LocalDate.from;
import static java.util.Date.from;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author alanwar
 */
public class Update_remove_tourController implements Initializable {

        @FXML
    private TableView<user> table_info;
    @FXML
    private TableColumn<user,String> col_from;

    @FXML
    private TableColumn<user,String> col_to;

    @FXML
    private TableColumn<user,String> col_number;

    @FXML
    private TableColumn<user,String> col_p_name;

    @FXML
    private TableColumn<user,String> col_f_date;

    @FXML
    private TableColumn<user,String> col_f_time;

    @FXML
    private TableColumn<user,String> col_f_number;

    @FXML
    private TableColumn<user,String> col_f_type;
    /**
     * Initializes the controller class.
     */
    
    private void inittable(){
        initcols();
    }
    
     private void initcols(){
        col_from.setCellValueFactory(new PropertyValueFactory<>("from"));
        col_to.setCellValueFactory(new PropertyValueFactory<>("to"));
        col_number.setCellValueFactory(new PropertyValueFactory<>("number"));       
        col_p_name.setCellValueFactory(new PropertyValueFactory<>("p_name")); 
        col_f_date.setCellValueFactory(new PropertyValueFactory<>("f_date"));  
        col_f_time.setCellValueFactory(new PropertyValueFactory<>("f_time")); 
        col_f_number.setCellValueFactory(new PropertyValueFactory<>("f_number")); 
        col_f_type.setCellValueFactory(new PropertyValueFactory<>("f_type")); 
         
         edittablecols();
     }
    
     private void edittablecols(){
        col_from.setCellFactory(TextFieldTableCell.forTableColumn());
        col_from.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setFrom(e.getNewValue());
        });
        col_to.setCellFactory(TextFieldTableCell.forTableColumn());
         col_to.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setTo(e.getNewValue());
        });
        col_number.setCellFactory(TextFieldTableCell.forTableColumn());
         col_number.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setNumber(e.getNewValue());
        });
        col_p_name.setCellFactory(TextFieldTableCell.forTableColumn());
        col_p_name.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setP_name(e.getNewValue());
        });        
        col_f_date .setCellFactory(TextFieldTableCell.forTableColumn()); 
         col_f_date.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setF_date(e.getNewValue());
        });
        col_f_time .setCellFactory(TextFieldTableCell.forTableColumn()); 
         col_f_time.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setF_time(e.getNewValue());
        });
        col_f_number.setCellFactory(TextFieldTableCell.forTableColumn());        
         col_f_number.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setF_number(e.getNewValue());
        });
        col_f_type.setCellFactory(TextFieldTableCell.forTableColumn());
         col_f_type.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setF_type(e.getNewValue());
        });
     
     
     table_info.setEditable(true);
     
     
     }
    
    private void  localdata(){
        ObservableList<user>table_data=FXCollections.observableArrayList();
     
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     inittable();
     
    }    
    
}
