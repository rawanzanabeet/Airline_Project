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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author alanwar
 */
public class SecondController implements Initializable {
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
  private CheckBox view;  
  
  @FXML
  private TextField email;
    
   @FXML
  private PasswordField password;  
   
   
   @FXML
  private TextField word;  
   
    
       
  @FXML
    private void forget(ActionEvent event) throws IOException {
        Parent scondparent = FXMLLoader.load(getClass().getResource("forget.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
        
        
        
        
        
        
        
    }
    
    
     
  @FXML
    private void view_pass(ActionEvent event) throws IOException {
        
        if(view.isSelected())
        {
           password.setText(word.getText());
           password.setVisible(false);
           word.setVisible(true);
           
        } 
        else{
            word.setText(password.getText());
             password.setVisible(true);
           word.setVisible(false); 
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
  @FXML
    private void sign_in(ActionEvent event) throws IOException {
        try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        String insQry="select * from travelerr where email='" +this.email.getText()+"'and passwordd='"+this.password.getText()+"'";
        System.out.print(insQry);
        ResultSet rs=stm.executeQuery(insQry);
        boolean flag=false;
        
while(rs.next()){
flag=true;
System.out.print(rs.getString("email"));


}
if(flag==false){
  notification( "you dont have account","please signup before in app");
   
//create account
}

else{
        Parent scondparent = FXMLLoader.load(getClass().getResource("empty.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();

//already have an account
}
        
        
        con.commit();
        con.close();
        
        
 
        
        
        
   
      
    } catch (SQLException ex) {

    }
        
        
        
        
    }
    
    
    
    
    
    @FXML
    private void sign_up(ActionEvent event) throws IOException {
           Parent scondparent = FXMLLoader.load(getClass().getResource("c.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
