/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


public class CController implements Initializable {
boolean c;
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
 
  
          
     public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    
    
  @FXML
    private TextField email;
    
       @FXML
    private TextField ssn;
       
        @FXML
    private TextField number;
        
      
         
          @FXML
    private PasswordField password;
          
           @FXML
    private TextField address;
           
            @FXML
    private TextField name;
    
            
    @FXML
    private DatePicker date;
            
            
            
                    @FXML
    private Label lable;
    
  
  @FXML
    private void cheack(ActionEvent event) throws IOException { 
        c= isValid(email.getText());
            if(email.getText().isEmpty() || ssn.getText()=="" || number.getText()=="" || password.getText()=="" || address.getText()=="" || name.getText()==""){
             notification("Invlaid_input","please fill all trxtfield",0); 
                lable.setText("Please fill all textfield");
            
            
            }
            
            else if(!c){
            lable.setText("email is invalid");
             notification("Invlaid_input"," the email is invalid",0); 
            }  
         
            else if(number.getText().length()!=10 || ssn.getText().length()!=10){
              lable.setText("numberphone or ssn is invalid");
              notification("Invlaid_input"," please cheack the numberphone",0); 
    }
    
    
            else{
                
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        String insQry="insert into travelerr values(" +this.ssn.getText()+",'"+this.name.getText()+"','"+this.address.getText()+"','"+this.email.getText()+"','"+this.number.getText()+"','"+this.password.getText()+"','"+this.date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "')";
        System.out.print(insQry);
        stm.executeQuery(insQry);
     
        
           notification(" done_Sucessfly","The data insert into database",1);
           
this.address.setText("");
this.email.setText("");
this.lable.setText("");
this.name.setText("");
this.password.setText("");
this.ssn.setText("");



    Parent scondparent = FXMLLoader.load(getClass().getResource("second.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();



     con.commit();
        con.close();
        
 
        
        
        
   
      
    } catch (SQLException ex) {

    }
                
                
                
            }
    
    }  
    
    
     
            
            
            
            
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
