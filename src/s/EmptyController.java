/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import oracle.jdbc.pool.OracleDataSource;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class EmptyController implements Initializable {
      private static boolean isshowflight;
    private static boolean isuesrprofile;
    private static boolean ischangepassword;
    private static boolean islogout;
     @FXML
    private AnchorPane pane2;
     @FXML
    private ImageView showflight;
      @FXML
    private AnchorPane showflightpan;
          @FXML
    private Button text1;
    
              @FXML
    private AnchorPane userprofile;

    @FXML
    private ImageView userp1;

    @FXML
    private Button text2;
        @FXML
    private AnchorPane changepass;

    @FXML
    private ImageView userp11;

    @FXML
    private Button text3;
 @FXML
    private AnchorPane logout;

    @FXML
    private ImageView userp111;

    @FXML
    private Button text4;
    
    @FXML
    private AnchorPane pane1;

   @FXML
    private Button  bookbutton;
      @FXML
    private AnchorPane pane21;

        @FXML
    private AnchorPane oo;

            @FXML
    private AnchorPane mainBlackPanel;

    @FXML
    private AnchorPane blackPanel;

    @FXML
    private AnchorPane booktour;

    @FXML
    private Button add;

    @FXML
    private Text passwordHText;

    @FXML
    private Text emailHText;

    @FXML
    private Button cancel;

    @FXML
    private TextField TD;

    @FXML
    private TextField GL;

    @FXML
    private Button TBOOK;
       @FXML
    private AnchorPane lll;

    @FXML
    void ACTI(ActionEvent event) {
        
  if(event.getSource()==cancel){
    lll.setVisible(false);
    mainBlackPanel.setVisible(false);
 
    
          
}
  String airplane;
   if(event.getSource()==add){
     //  System.out.println("j");
    lll.setVisible(false);
    mainBlackPanel.setVisible(false);//complite the code to stor the data in data base,chech if the plan id full
    
     try {
       
           OracleDataSource ods=new  OracleDataSource();
           ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
         
           ods.setUser("sys as sysdba");
           ods.setPassword("123321");
          
           Connection conn =ods.getConnection();
            Statement st=conn.createStatement();
            String s="select * From book where Tour_id= '"+TD.getText()+"'";
            ResultSet rs=st.executeQuery(s);
         //   ResultSet r ;
                   String air="null";
                   int flag=0;
            while(rs.next()){
                ////0
               if(rs.getString(1).equals(TD.getText())){
                   flag=1;
               air=rs.getString(2);
             
             
               
 
            ////
     /* String y=r.getString(2);
             
           int io =Integer.parseInt(y)-1;
          */
          //   String oi="Update airplane set airplane_number='"+io+"', where airplane_number= '"+air+"'";
               }}
              String j= "select *From airplane order by airplane_number";
               ResultSet   r=st.executeQuery(j);
                String num="null";
                int aia=0;
                 String oi="null";
                 while(r.next()){
                ////0
               if(r.getString(1).equals(air)){                  
              num=r.getString(2);
                String y=r.getString(2); 
                int aya=Integer.parseInt(y);
                 if(aya==0){aia=0;
            break; }
         if(aya!=0){  int io =Integer.parseInt(y)-1;
                 //  System.out.println(io);
            
             
               oi="Update airplane set number_of_seats='"+io+"'where airplane_number= '"+air+"'";    
             aia=1;
 //st.executeUpdate(oi);
               JOptionPane.showMessageDialog(null, "Done !!");}
             if(aia==0)break;
               }
                   //  System.out.println(num);
                 }
            
        /*     String j= "select *From airplane where airplane_number= '"+ air+"'";
             System.out.println(air);
              r=st.executeQuery(j);*/
              //  String y=r.getString(2);
                  // System.out.println("j;ljawd;as");
                 if(flag==0)              JOptionPane.showMessageDialog(null, "Tour id incorrect");
                 else{
                if(aia==1)st.executeUpdate(oi);
                if(aia==0)     JOptionPane.showMessageDialog(null, "This plane is full");
                 }
           conn.close();
           TD.setText(" ");
         //  ser.setText(" ");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getSQLState());
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
 
    
          
}
    }
  private String bd=null;
    @FXML
    private DatePicker teacherDOBFieldEdit;
    
       @FXML
    void BDT() {
     String oldDate,newDate[];String mon=" ";
    newDate=new String[3];
    oldDate=teacherDOBFieldEdit.getValue().toString();
    newDate=oldDate.split("-");
    if(newDate[1].equals("01"))mon="Jan";
    if(newDate[1].equals("02"))mon="Feb";
    if(newDate[1].equals("03"))mon="Mar";
    if(newDate[1].equals("04"))mon="Apr";
    if(newDate[1].equals("05"))mon="May";
    if(newDate[1].equals("06"))mon="Jun";
    if(newDate[1].equals("07"))mon="Jul";
    if(newDate[1].equals("08"))mon="Aug";
    if(newDate[1].equals("09"))mon="Sep";
    if(newDate[1].equals("10"))mon="Oct";
    if(newDate[1].equals("11"))mon="Nov";
    if(newDate[1].equals("12"))mon="Dec";
    int day=Integer.parseInt(newDate[2]);
    bd=day+"/"+mon+"/"+newDate[0];
   
    
    }
    void B( ) {
         String oldDate,newDate[];String mon=" ";
       newDate=new String[3];
     newDate= bd.split("/");
      if(newDate[1].equals("01"))mon="Jan";
    if(newDate[1].equals("02"))mon="Feb";
    if(newDate[1].equals("3"))mon="Mar";
    if(newDate[1].equals("04"))mon="Apr";
    if(newDate[1].equals("05"))mon="May";
    if(newDate[1].equals("06"))mon="Jun";
    if(newDate[1].equals("07"))mon="Jul";
    if(newDate[1].equals("08"))mon="Aug";
    if(newDate[1].equals("09"))mon="Sep";
    if(newDate[1].equals("10"))mon="Oct";
    if(newDate[1].equals("11"))mon="Nov";
    if(newDate[1].equals("12"))mon="Dec";
    int day=Integer.parseInt(newDate[2]);
          DatePicker jk;

    bd=newDate[2]+"-"+mon+"-"+newDate[0];
  
  
    }
      @FXML
    private TableView   showCourseTable;
        @FXML
    private TextField ser;
            @FXML
     private ObservableList guestInfo= FXCollections.observableArrayList();
         @FXML
    void mouseclickedd(MouseEvent event) //
    {   if(event.getSource()==pane2)//search 
        //ser===>search by area
//sed===>search by date
    {
        //ssn, name travele,address,email,phone,password,date
          if(ser.getText().isEmpty()==true&&bd==null)//intiall
          {
           try {
         showCourseTable.getColumns().clear();
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       //   String url = "jdbc:oracle:thin:@192.168.1.212:1521:xe";
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","123321");
          Statement stm = con.createStatement();
          String insQury = "select *From add_man order by flight_number";
          ResultSet rs = stm.executeQuery(insQury); 
     
           guestInfo = FXCollections.observableArrayList();
        

           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                showCourseTable.getColumns().addAll(col); 
              
            }
           while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
              
                
                    row.add(rs.getString(i));
                }
                
                
               guestInfo.add(row);

            }

            //FINALLY ADDED TO TableView
          showCourseTable.setItems(guestInfo);
   
        }
        catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }    
          }
          else if(ser.getText().isEmpty()==true&&bd!=null){
          
          }
           else if(ser.getText().isEmpty()==false&&bd==null){
               
           try {
          showCourseTable.getColumns().clear();
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       //"select *From EMPLOYEE where SSN= "+sn;
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","123321");
          Statement stm = con.createStatement();
            String insQury = "select *From add_man where flight_number = "+ser.getText();
           ResultSet rs = stm.executeQuery(insQury); 
     
           guestInfo = FXCollections.observableArrayList();
        

           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                showCourseTable.getColumns().addAll(col); 
              
            }
           while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
              
                
                    row.add(rs.getString(i));
                }
                
                
               guestInfo.add(row);

            }

            //FINALLY ADDED TO TableView
           showCourseTable.setItems(guestInfo);
   
        }
        catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }       
          }
           else if(ser.getText().isEmpty()==false&&bd!=null){
          this.B();
              System.out.println(bd);
          }
        //
}
        
        if(event.getSource()==showflightpan){
    
    showflightpan.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text1.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
          isshowflight=true;     
          isuesrprofile=false;
          ischangepassword=false;
          islogout=false;
          pane1.setVisible(true);
          oo.setVisible(false);
          
}
        if(event.getSource()==userprofile){
    
    userprofile.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text2.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
      isshowflight=false;     
          isuesrprofile=true;
          ischangepassword=false;
          islogout=false;
      
                       
}
if(event.getSource()==changepass){
    
    changepass.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text3.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                  isshowflight=false;     
          isuesrprofile=false;
          ischangepassword=true;
          islogout=false;     
}
if(event.getSource()==logout){
    
    logout.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text4.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                              isshowflight=false;     
          isuesrprofile=false;
          ischangepassword=false;
          islogout=true;     
}



    }   
        
        
       
    
    @FXML
    void panneaction(MouseEvent event) {
if(event.getSource()==showflightpan&& !isshowflight){
    
    showflightpan.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text1.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}
if(event.getSource()==userprofile&& !isuesrprofile){
    
    userprofile.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text2.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}
if(event.getSource()==changepass && !ischangepassword){
    
    changepass.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text3.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}
if(event.getSource()==logout && !islogout){
    
    logout.setStyle("-fx-background-color:  #1C2833; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text4.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}
      if(event.getSource()== pane2){
    

   pane2.setStyle("-fx-background-color: #3e6db0; -fx-background-radius: 50; -fx-border-radius: 50;"); 
        }
       if(event.getSource()== pane21){
    

   pane21.setStyle("-fx-background-color: #3e6db0; -fx-background-radius: 50; -fx-border-radius: 50;"); 
        }
      
     
}
        
        
    
    
     @FXML
    void panneexited(MouseEvent event) {
        if(event.getSource()==showflightpan && !isshowflight){
    
    showflightpan.setStyle("-fx-background-color: #b4d7Fe#3d6cb5 ; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text1.setStyle("-fx-background-color: transparent;-fx-text-fill:     #3d6cb2;");
                       
}
        if(event.getSource()==userprofile && !isuesrprofile){
    
    userprofile.setStyle("-fx-background-color:#b4d7Fe#3d6cb5 ; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text2.setStyle("-fx-background-color: transparent;-fx-text-fill:  #3d6cb2;");
                       
}
        if(event.getSource()==changepass && !ischangepassword){
    
    changepass.setStyle("-fx-background-color: #b4d7Fe#3d6cb5; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text3.setStyle("-fx-background-color: transparent;-fx-text-fill:#3d6cb2  ;");
                       
}
        if(event.getSource()==logout && !islogout){
    
    logout.setStyle("-fx-background-color:#b4d7Fe#3d6cb5 ; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text4.setStyle("-fx-background-color: transparent;-fx-text-fill: #3d6cb2;");
                       
}
if(event.getSource()== pane2){
    

   pane2.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50; -fx-border-radius: 50;-fx-border-color:  #1c2833;"); 
        }
if(event.getSource()== pane21){
    

   pane21.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50; -fx-border-radius: 50;-fx-border-color:  #1c2833;"); 
        }
      
    }
    
        @FXML
    void mousepressed(MouseEvent event) {
if(event.getSource()==showflightpan&& !isshowflight){
    
    showflightpan.setStyle("-fx-background-color: #3d6cb2; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text1.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}
if(event.getSource()==userprofile&& !isuesrprofile){
    
    userprofile.setStyle("-fx-background-color: #3d6cb2; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text2.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}
if(event.getSource()==changepass && !ischangepassword){
    
    changepass.setStyle("-fx-background-color: #3d6cb2; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text3.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}
if(event.getSource()==logout && !islogout){
    
    logout.setStyle("-fx-background-color: #3d6cb2; -fx-border-color: #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5 #b4d7Fe#3d6cb5;");
                       
      text4.setStyle("-fx-background-color: transparent;-fx-text-fill:  #b4d7Fe#3d6cb5;");
                       
}

if(event.getSource()==pane21){
    mainBlackPanel.setVisible(true);
     lll.setVisible(true);
     
}
    }

    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         isshowflight=false;     
          isuesrprofile=false;
          ischangepassword=false;
          islogout=false;     
           try {
         showCourseTable.getColumns().clear();
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       //   String url = "jdbc:oracle:thin:@192.168.1.212:1521:xe";
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","123321");
          Statement stm = con.createStatement();
          String insQury = "select *From add_man order by flight_number";
          ResultSet rs = stm.executeQuery(insQury); 
     
           guestInfo = FXCollections.observableArrayList();
        

           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                showCourseTable.getColumns().addAll(col); 
              
            }
           while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
              
                
                    row.add(rs.getString(i));
                }
                
                
               guestInfo.add(row);

            }

            //FINALLY ADDED TO TableView
          showCourseTable.setItems(guestInfo);
   
        }
        catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }    
    }    
    
}
