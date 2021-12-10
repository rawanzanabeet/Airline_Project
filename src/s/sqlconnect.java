/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author alanwar
 */
public class sqlconnect {
 Connection  con=null;

           
    public static Connection c() throws SQLException{
       DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
      String   url ="jdbc:oracle:thin:@localhost:1521:xe";
       Connection  con=DriverManager.getConnection(url,"sys as sysdba","123321");

        
        
        return null;
        
    }

    public static ObservableList<user> getd() throws SQLException{

      Connection   con=c();
        
          System.out.print("f_date");
    
          ObservableList<user>list=FXCollections.observableArrayList();
     
    Statement stm=con.createStatement();
      String insQry="select * from add_tour";
      
  ResultSet  rs=stm.executeQuery(insQry); 
         System.out.print("ergr");    
while(rs.next())
{
    System.out.print(rs.getString("from"));
    System.out.print(rs.getString("to"));
    System.out.print(rs.getString("p_name"));
    System.out.print(rs.getString("f_date"));
  list.add(new user(rs.getString("from"),rs.getString("to"),rs.getString("p_name"),rs.getString("f_date"),rs.getString("f_time"),rs.getString("f_number"),rs.getString("f_type")));
}
    
    
    
    
    
    
     
        return list;
        
    }

}