/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author alanwar
 */
public class FXMLDocumentController implements Initializable {
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
    private Label label;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
           Parent scondparent = FXMLLoader.load(getClass().getResource("second.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    }
    
    
       @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException {
           Parent scondparent = FXMLLoader.load(getClass().getResource("second.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    }
    
        @FXML
    private void signb(ActionEvent event) throws IOException {
          Parent scondparent = FXMLLoader.load(getClass().getResource("f_si.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
    
    
    
    
    }
    
        @FXML
    private void handleButtonAction3(ActionEvent event) throws IOException {
        try{
Desktop.getDesktop().browse(new URL("https://software-s119.slack.com/ssb/redirect").toURI());
}
catch(Exception e)
{


}
        
               
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
