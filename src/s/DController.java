/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author alanwar
 */
public class DController implements Initializable {
@FXML
    private Button bar1;
    @FXML
    private Button bar2;
    @FXML
    private Pane pareslide;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          pareslide.setTranslateX(-250);
            bar1.setVisible(false);
       bar2.setVisible(true);
    }    
       @FXML
    private void log_out(ActionEvent event) throws IOException, SQLException {    
        
    Parent scondparent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();


        
    }
    
        
    @FXML
    private void run2(MouseEvent event) {
               TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pareslide);
        slide.setToX(-250);
        slide.play();
        
        
        pareslide.setTranslateX(0);
        slide.setOnFinished((ActionEvent e) -> {
   bar1.setVisible(false);
       bar2.setVisible(true);
       
    });
    }

    @FXML
    private void run1(MouseEvent event) {
         TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pareslide);
        slide.setToX(0);
        slide.play();
        
        
        pareslide.setTranslateX(-250);
        slide.setOnFinished((ActionEvent e) -> {
   bar1.setVisible(true);
       bar2.setVisible(false);
       
    });
    
    
} 
  
  @FXML
    private void add_tour(ActionEvent event) throws IOException { 
        
        
    Parent scondparent = FXMLLoader.load(getClass().getResource("add_tour.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();

        
        
        
        
        
    }
    }  
    
    
    

