
package s;

import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDate.from;
import static java.util.Date.from;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import static s.ForgetController.notification;
import static s.send_email.sendemail;

/**
 * FXML Controller class
 *
 * @author alanwar
 */


public class Update_remove_tourController implements Initializable {

   
        @FXML
    private  ObservableList table_info=FXCollections.observableArrayList();
       
        @FXML
    private  TableView table;
          
      @FXML
     private ObservableList<String> dbTypeList = FXCollections.observableArrayList("Flight Number","From","To","Flight Type","Flight Time","Plane Name","Fight Date","show all tour");
             @FXML
    private ComboBox search;
          @FXML 
    private TextField select;
        
 
  public  void show(String a)
  {
       
        
try {
          table.getColumns().clear();
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","123321");
          Statement stm = con.createStatement();
          String insQury = a;
          ResultSet rs = stm.executeQuery(insQury); 
     
           table_info = FXCollections.observableArrayList();
        

           for(int i=0 ; i<(rs.getMetaData().getColumnCount())-2; i++){
                
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                table.getColumns().addAll(col); 
              
            }
           while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=(rs.getMetaData().getColumnCount())-2; i++){
                    //Iterate Column
              
                
                    row.add(rs.getString(i));
                }
                
                
               table_info.add(row);

            }

            //FINALLY ADDED TO TableView
           table.setItems(table_info);
   
        }
        catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }   
      
      
      
  }
   
    
        
  /*
        @FXML
    private TableColumn<user,String> col_from;

    @FXML
    private TableColumn<user,String> col_to;

  //@FXML
   //rivate TableColumn<user,String> col_number;

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

   
      
    /*
       
     ObservableList<user>listm;
     int index=-1;
     Connection con=null;
      ResultSet rs=null;
     
    Statement   stm=null;
   */
    String a=null;
    
   
    
    
    
    
    
    String t;
    @FXML
    private void remove(ActionEvent event) throws IOException { 
  
   t=table.getSelectionModel().getSelectedItem().toString();
     
    Parent scondparent = FXMLLoader.load(getClass().getResource("det.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
  
    }
  @FXML
    private void cheack(ActionEvent event) throws IOException { 
     
        if( this.select.getText().equals(""))
             System.out.print("please fill all textfield");
            
        if(  search.getValue().equals("Flight Number")&& !(this.select.getText().equals("")))
        {
            
           show("select * from add_tour where Flight Number='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
              if(  search.getValue().equals("From") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where Fromm='"+this.select.getText()+"'";
         show("select * from add_tour where Fromm='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
       if(  search.getValue().equals("To") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where Too ='"+this.select.getText()+"'";
         show("select * from add_tour where Too ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
       
        if(  search.getValue().equals("Flight Type") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where Flight Type ='"+this.select.getText()+"'";
         show("select * from add_tour where Flight Type ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
       
        if(  search.getValue().equals("Plane Name") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where Flight Type ='"+this.select.getText()+"'";
         show("select * from add_tour where Flight Type ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
       
       
       
         if(  search.getValue().equals("Fight Date") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where Fight Date ='"+this.select.getText()+"'";
         show("select * from add_tour where Fight Date ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
       
         if(  search.getValue().equals("show all tour") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour";
         show(a);
         System.out.print(a);
        }
       
       
       
       
                 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       search.setItems(dbTypeList);
    show("select * from add_tour");
    }    
    
}
