
package s;
import com.teknikindustries.bulksms.SMS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.awt.Panel;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDate.from;
import java.util.Base64;
import static java.util.Date.from;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import static s.ForgetController.notification;
import static s.send_email.sendemail;

/**
 * FXML Controller class
 *
 * @author alanwar
 */


public class Update_remove_tourController implements Initializable {

   
        @FXML
    private  ObservableList table_info=FXCollections.observableArrayList();
       
        @FXML
    private  TableView table;
          
      @FXML
     private ObservableList<String> dbTypeList = FXCollections.observableArrayList("Flight Number","From","Arrival_Area","Flight Type","Flight Time","Plane Name","Fight Date","show all tour");
             @FXML
    private ComboBox search;
          @FXML 
    private TextField select;
        
 
  public  void show(String a)
  {
       
        
try {
          table.getColumns().clear();
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","123321");
          Statement stm = con.createStatement();
          String insQury = a;
          ResultSet rs = stm.executeQuery(insQury); 
     
           table_info = FXCollections.observableArrayList();
        

           for(int i=0 ; i<(rs.getMetaData().getColumnCount())-2; i++){
                
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                table.getColumns().addAll(col); 
              
            }
           while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=(rs.getMetaData().getColumnCount())-2; i++){
                    //Iterate Column
              
                
                    row.add(rs.getString(i));
                }
                
                
               table_info.add(row);

            }

            //FINALLY ADDED TO TableView
           table.setItems(table_info);
   
        }
        catch (Exception ex) {
          //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(null, ex.toString());
        }   
      
      
      
  }
   
    
        
  /*
        @FXML
    private TableColumn<user,String> col_from;

    @FXML
    private TableColumn<user,String> col_to;

  //@FXML
   //rivate TableColumn<user,String> col_number;

    @FXML
    private TableColumn<user,String> col_p_name;

    @FXML
    private TableColumn<user,String> col_f_date;

    @FXML
    private TableColumn<user,String> col_f_time;

    @FXML
    private TableColumn<user,String> col_f_number;

    @FXML
    private TableColumn<user,String> col_f_type;
    /**
     * Initializes the controller class.
     */

   
      
    /*
       
     ObservableList<user>listm;
     int index=-1;
     Connection con=null;
      ResultSet rs=null;
     
    Statement   stm=null;
   */
    String a=null;
    
   
    
    
    
    
    
    String h;
    String ttt;
    Panel b;
     @FXML
    void removvvv(ActionEvent event) throws IOException {
    //    System.out.print("rawaaaan");
      // SMS smstut=new SMS();	
       // smstut.SendSMS("rawanzanabeet", "rawan*123", "YOU DO IT RAWAAAN", "+970592971072", "https://www.bulksms.com/developer/eapi/submission/send_sms/submission/send_sms/2/2.0");
 

    // This URL is used for sending messages
    String myURI = "https://api.bulksms.com/v1";

    // change these values to match your own account
    String myUsername = "rawanzanabeett";
    String myPassword = "rawan*123";

    // the details of the message we want to send
    String myData = "{to: \"+970592971072\", encoding: \"UNICODE\", body: \"Dobrá práce! Jak se máš?\"}";

    // if your message does not contain unicode, the "encoding" is not required:
    // String myData = "{to: \"1111111\", body: \"Hello Mr. Smith!\"}";

    // build the request based on the supplied settings
    URL url = new URL(myURI);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.setDoOutput(true);

    // supply the credentials
    String authStr = myUsername + ":" + myPassword;
    String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
    request.setRequestProperty("Authorization", "Basic " + authEncoded);

    // we want to use HTTP POST
    request.setRequestMethod("POST");
    request.setRequestProperty( "Content-Type", "application/json");

    // write the data to the request
    OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream());
    out.write(myData);
    out.close();

    // try ... catch to handle errors nicely
    try {
      // make the call to the API
      InputStream response = request.getInputStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(response));
      String replyText;
      while ((replyText = in.readLine()) != null) {
        System.out.println(replyText);
      }
      in.close();
    } catch (IOException ex) {
      System.out.println("An error occurred:" + ex.getMessage());
      BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()));
      // print the detail that comes with the error
      String replyText;
      while ((replyText = in.readLine()) != null) {
        System.out.println(replyText);
      }
      in.close();
    }
    request.disconnect();
  }

       
    
  
    
    
    
    
    @FXML
    private void remove(ActionEvent event) throws IOException { 
  
            try {
                ttt=table.getSelectionModel().getSelectedItem().toString();
                FXMLLoader x=new FXMLLoader(getClass().getResource("det.fxml"));
                Parent root =(Parent) x.load();
                DetController oc =x.getController();
                
                oc.fxmlloaderr(ttt);
                Stage st=new Stage();
                st.setScene(new Scene(root));
                st.show();
            } catch (SQLException ex) {
                Logger.getLogger(Update_remove_tourController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
  @FXML
    private void cheack(ActionEvent event) throws IOException { 
     
        if( this.select.getText().equals(""))
             System.out.print("please fill all textfield");
            
        if(  search.getValue().equals("Flight Number")&& !(this.select.getText().equals("")))
        {
            
           show("select * from add_tour where FLIGHT_NUMBER='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
              if(  search.getValue().equals("From") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where Fromm='"+this.select.getText()+"'";
         show("select * from add_tour where Fromm='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
       if(  search.getValue().equals("Arrival_Area") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where Arrival_Area ='"+this.select.getText()+"'";
         show("select * from add_tour where Arrival_Area ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
       
        if(  search.getValue().equals("Flight Type") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where FLIGHT_TYPE ='"+this.select.getText()+"'";
         show("select * from add_tour where FLIGHT_TYPE ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
        
       
        if(  search.getValue().equals("Flight Time") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where FLIGHT_TIME ='"+this.select.getText()+"'";
         show("select * from add_tour where FLIGHT_TIME ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
       
       
       
         if(  search.getValue().equals("Plane Name") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where PLANE_NAME ='"+this.select.getText()+"'";
         show("select * from add_tour where PLANE_NAME ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
       
         if(  search.getValue().equals("To") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour where FLIGHT_DATE ='"+this.select.getText()+"'";
         show("select * from add_tour where FLIGHT_DATE ='"+this.select.getText()+"'");  
         System.out.print(a);
        }
         if(  search.getValue().equals("show all tour") && !(this.select.getText().equals("")))
        {
            a="select * from add_tour";
         show(a);
         System.out.print(a);
        }
       
       
       
       
                 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       search.setItems(dbTypeList);
    show("select * from add_tour");
    }    
    
}
