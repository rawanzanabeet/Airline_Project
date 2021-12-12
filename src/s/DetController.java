/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private TextArea url_img2;

    @FXML
    private Button browse2;
    
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
 String path2;    
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
ImageView im2; 
    private String bs;
        
 @FXML
    private void update(ActionEvent event) throws IOException, SQLException { 
        
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        String insQry="select * from add_tour"+"' where FLIGHT_NUMBER='"+1+"' and FROMM='"+"palestine"+"' and Arrival_Area='"+"a"+"' and FLIGHT_TIME='"+"11:00"+"'";
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
     
     
     
      @FXML
     void browse2(javafx.event.ActionEvent event) throws IOException, SQLException {    
  
       file  = fil_chooser.showOpenDialog(stage);
 
                if (file != null) {
                     
               System.out.print(file.getAbsolutePath());
       url_img2.setText(file.getAbsolutePath());
       path2=file.getAbsolutePath();
    FileInputStream inputstream = new FileInputStream(file.getAbsolutePath()); 
Image image = new Image(inputstream); 
 im2.setImage(image);
   stage.show();
        
                }
     }
     
     
    @FXML
    void backk(ActionEvent event) throws IOException {
      

    Parent scondparent = FXMLLoader.load(getClass().getResource("update_remove_tour.fxml")); 
        Scene scene2 = new Scene(scondparent);
        Stage Window=(Stage)((Node)event.getSource()).getScene().getWindow();
       Window.setScene(scene2);
       
        Window.show();
        
        
        
        
        
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

    void fxmlloaderr(String t) throws SQLException, FileNotFoundException {
 
      String xs;
      
        this.f_num.setText(t);
       h=t.split(",");
       String pattern = "[";
         String pattern2 = "]";
       h[0]=h[0].replace(pattern,"");
   h[0]=h[0].replaceAll(" ", "");
   h[1]=h[1].replaceAll(" ", "");
   h[2]=h[2].replaceAll(" ", "");
   h[3]=h[3].replaceAll(" ", "");
   h[4]=h[4].replaceAll(" ", "");
   h[5]=h[5].replaceAll(" ", "");
   h[6]=h[6].replaceAll(" ", "");
    h[6]=h[6].replace(pattern2,"");
         this.f_num.setText(h[0]);
         this.from.setText(h[1]);
         this.too.setText(h[2]);
         this.type.setText(h[3]);
         this.time.setText(h[4]);
         this.p_name.setText(h[5]);
         this.f_date.setText(h[6]);
       
        
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
        String insQry="select * from airplane where airplane_number='"+h[0]+"'";
        ResultSet rs=stm.executeQuery(insQry);
    rs.next();
    
    this.seat.setText(rs.getString(2));
    this.tiket_price.setText(rs.getString(3));
        System.out.print(rs.getString(1));
         

        System.out.print(rs.getString(2));
        
        System.out.print(rs.getString(3));
        //   System.out.print(rs.getString(8));
          // System.out.print(rs.getString(9));
             DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
       
        insQry="select * from add_tour"+" where FLIGHT_NUMBER='"+h[0]+"' and FROMM='"+h[1]+"'and FLIGHT_TIME='"+h[4]+"'";
       rs=stm.executeQuery(insQry);
      System.out.print(rs);
 
             
while(rs.next()){
    s=rs.getString("image_from");
System.out.print(rs.getString("image_from"));


} 
       
         FileInputStream inputstream = new FileInputStream(s); 
Image image = new Image(inputstream); 
 im.setImage(image); 
        
          insQry="select * from add_tour"+" where FLIGHT_NUMBER='"+h[0]+"' and FROMM='"+h[1]+"'and FLIGHT_TIME='"+h[4]+"'";
       rs=stm.executeQuery(insQry);
      System.out.print(rs);
 
while(rs.next()){
           bs = rs.getString("image_too");
System.out.print(rs.getString("image_too"));


} 
     
           FileInputStream inputstrea= new FileInputStream(bs); 
         Image imag = new Image(inputstrea); 
         im2.setImage(imag); 
       
         
     System.out.print("rawaaaaaaaaaaaaaaaaaan you done it");
    }
    @FXML
    void save(ActionEvent event) throws SQLException {
        
    }
    @FXML
    void save2(ActionEvent event) throws SQLException {
        
  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
  String n=url_img.getText();
  String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection con=DriverManager.getConnection(url,"sys as sysdba","123321");
        Statement stm=con.createStatement();
       String insQry="update add_tour set IMAGE_TOO ='"+n+"' where FLIGHT_NUMBER='"+h[0]+"' and FROMM='"+h[1]+"' and FLIGHT_TIME='"+h[4]+"'";
       System.out.print(insQry);
       stm.executeUpdate(insQry);
      con.commit();
      con.close();;
        
        
        
        
        
    }
    

}
