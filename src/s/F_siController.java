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
import org.controlsfx.control.Notifications;
import static s.SecondController.notification;

/**
 * FXML Controller class
 *
 * @author alanwar
 */
public class F_siController implements Initializable {
    public static void notification(String a,String b)
  {
       Notifications not;
        not = Notifications.create();
             not.title(a);
            not.text(b);

          not.hideAfter(Duration.seconds(8));
           not .position(Pos.BOTTOM_RIGHT);
             not.onAction(new EventHandler<ActionEvent>(){
       
                     @Override
        public void handle(ActionEvent event) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }     });
          not.showError();
             
      
      
      
      
  }
    
    
    
    
    
    @FXML
    private TextField email;
    
        @FXML
    private TextField password;
    
    
    
  @FXML
    private void sig(ActionEvent event) throws IOException, SQLException { 
      DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        String insQry="select * from maneger where email='" +this.email.getText()+"'and passwordd='"+this.password.getText()+"'";
        System.out.print(insQry);
        ResultSet rs=stm.executeQuery(insQry);
        boolean flag=false;
        
while(rs.next()){

if(rs.getString("email").equals(this.email.getText())&& rs.getString("passwordd").equals(this.password.getText()))
flag=true;


}

 if(flag==true)
 {
     
         Parent scondparent = FXMLLoader.load(getClass().getResource("d.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
     
     
 }
 else{
     
     
     notification( "Erorr","Wrong password or email"); 
     
     
     
     
 }
//create account



//already have an account

        
        
        con.close();
    
    
    
    
    
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
