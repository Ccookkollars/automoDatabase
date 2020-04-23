package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnector {
String url = "jdbc:mysql://database-1.cde4bwcff8jh.us-east-2.rds.amazonaws.com";
String userName = "caleb";
String password = "kylekyle";
String dbName = "/schema_1";
String driver = "com.mysql.cj.jdbc.Driver";
Connection connection;

public DBConnector(){
    connectToDB();    
}

public DBConnector(String url, String dbName, String userName, String password)
{
    this.url = url;
    this.dbName = dbName;
    this.userName= userName;
    this.password = password;
    connectToDB();
}

public Connection getConnection(){
    return connection;
}

private void connectToDB(){
    
 try{
 connection = DriverManager.getConnection(url + dbName, userName, password);
 } catch(Throwable e){
   System.out.print(e);     
 } 
}

public void closeConnection(){
    try{
    connection.close();
    } catch(Throwable e){
        
    }
}

public String testConnection(){
    return connection.toString();
}

 
   
    
}
