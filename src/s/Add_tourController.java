/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static s.SecondController.notification;

/**
 * FXML Controller class
 *
 * @author alanwar
 */
public class Add_tourController implements Initializable {

         @FXML
    private TextField from;
           
            @FXML
    private TextField to;
    
       @FXML
    private TextField p_num;
           
            @FXML
    private DatePicker p_date;
    
    
       @FXML
    private TextField f_time;
           
            @FXML
    private TextField f_num;
            
            
        @FXML
    private RadioButton type;
        
        
          @FXML
    private RadioButton type2;
            
             @FXML
    private TextField p_name;
             
             
                @FXML
    private TextField seat;
             
             
             
       String a="Economy"  ;
        String b="Cabin_Class"  ;
        String insQry;
        
      
  @FXML
    private void back(ActionEvent event) throws IOException, SQLException {   
        Parent scondparent = FXMLLoader.load(getClass().getResource("d.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
        
        
    }
        
        
  @FXML
    private void add(ActionEvent event) throws IOException, SQLException {    
    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        if (type.isSelected())
        
        {
        
         insQry="insert into add_man values('" +this.f_num.getText()+"',"+this.p_num.getText()+",'"+this.from.getText()+"','"+this.to.getText()+"','"+a+"','"+this.f_time.getText()+"','" +     this.p_name.getText() +"','"                                 +    this.p_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +"','"+this.to.getText() + "')";
      
        }
          if (type2.isSelected())
        
        {
        
         insQry="insert into add_man values('" +this.f_num.getText()+"',"+this.p_num.getText()+",'"+this.from.getText()+"','"+this.to.getText()+"','"+b+"','"+this.f_time.getText()+"','" +     this.p_name.getText() +"','"                                 +    this.p_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "','"+this.to.getText() + "')";
      
        }
        
           if (type2.isSelected() && type.isSelected())
              
               notification( "Erorr","please Selected just type of plane type ");
          
        
        
        
        
        
        
        
        System.out.print(insQry);
        stm.executeQuery(insQry);
     
 
   
//create account

    
    
    
    
    
    
    
    
    
    
    
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
