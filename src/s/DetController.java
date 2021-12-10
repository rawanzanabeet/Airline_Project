/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;




public class DetController implements Initializable{
String hh;
    
    
    
    @FXML
    private Button browse;

    @FXML
    private TextArea url_img;

    @FXML
    private ImageView im;

    @FXML
    private Button update;

    @FXML
    private TextArea url_img1;

    @FXML
    private Button browse1;

    @FXML
    private Button update1;

    @FXML
    public TextField f_num;
    
    @FXML
    private TextField from;

    @FXML
    private TextField too;

    @FXML
    private TextField type;

    @FXML
    private TextField time;

    @FXML
    private TextField p_name;

    @FXML
    private TextField f_date;

    @FXML
    private TextField seat;

    @FXML
    private TextField tiket_price;
    private String[] x;
    
    
   
    
   
 File file ;
String path;
     
    @FXML
        private Label label;
   
 
    Stage stage = null;
    

 
 
 
        // create a File chooser
        FileChooser fil_chooser = new FileChooser();
        FileInputStream fis;
        String s;
              
 @FXML
ImageView imm; 
        
 @FXML
    private void update(ActionEvent event) throws IOException, SQLException { 
        
       
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        String insQry="select * from add_tour";
        ResultSet rs=stm.executeQuery(insQry);
      System.out.print(rs);
 
             
while(rs.next()){
    s=rs.getString("image_from");
System.out.print(rs.getString("image_from"));


} 
       
         FileInputStream inputstream = new FileInputStream(s); 
Image image = new Image(inputstream); 
 imm.setImage(image); 
        
        
        
        
    }
  
     @FXML
     void browse(javafx.event.ActionEvent event) throws IOException, SQLException {    
  
       file  = fil_chooser.showOpenDialog(stage);
 
                if (file != null) {
                     
               System.out.print(file.getAbsolutePath());
       url_img.setText(file.getAbsolutePath());
       path=file.getAbsolutePath();
    FileInputStream inputstream = new FileInputStream(file.getAbsolutePath()); 
Image image = new Image(inputstream); 
 im.setImage(image);
   stage.show();
        
                }
     }
     
 /*  // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(labell.getWidth(), labell.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
   */
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
String []h;
String []h2;
    void myFunction(String t) {
       this.f_num.setText(t);
       h=t.split(",");
         this.f_num.setText(h[0]);
         this.from.setText(h[1]);
         this.too.setText(h[2]);
         this.type.setText(h[3]);
         this.time.setText(h[4]);
         this.p_name.setText(h[5]);
         this.f_date.setText(h[6]);
         

     System.out.print("rawaaaaaaaaaaaaaaaaaan you done it");
    }

}
