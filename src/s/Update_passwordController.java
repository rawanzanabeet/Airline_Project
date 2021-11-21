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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;
import static s.ForgetController.notification;

/**
 * FXML Controller class
 *
 * @author alanwar
 */
public class Update_passwordController implements Initializable {
 
    public static void notification(String a,String b,int z)
  {
       Notifications not;
        not = Notifications.create();
             not.title(a);
            not.text(b);

          not.hideAfter(Duration.seconds(30));
           not .position(Pos.BOTTOM_RIGHT);
             not.onAction(new EventHandler<ActionEvent>(){
       
                     @Override
        public void handle(ActionEvent event) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }     });
             if(z==0)
          not.showError();
             
             else if(z==1)
                not.showInformation();
      
      
      
  }
     @FXML
    private TextField neww;
    
       @FXML
    private TextField con_new;
      @FXML
    private TextField email;
                 
  @FXML
    private void back(ActionEvent event) throws IOException, SQLException, MessagingException { 
            Parent scondparent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
        
        
        
        
        
        
        
    } 
             
  @FXML
    private void update(ActionEvent event) throws IOException, SQLException, MessagingException { 
    if(this.con_new.getText().equals(this.neww.getText()))
    {
       
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        String insQry="update travelerr set passwordd='" +this.neww.getText()+"' where email='"+this.email.getText()+"'";
        System.out.print(insQry);
     
          notification( "Update_Sucessfly","update new password in database",1);  
        
        
    }
        
    if(!(this.con_new.getText().equals(this.neww.getText())))
    {
       notification( "Inequality Erorr","There is a difference between new password and confrim password",0);  
    }
    
    
    
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
