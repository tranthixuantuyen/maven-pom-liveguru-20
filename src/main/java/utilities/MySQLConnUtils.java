package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnUtils {
    public static Connection getMySQLConnections(){
        String hostName = "localhost";
        String dbName = "automationfc";
        String userName = "root";
        String password = "";
        return getMySQLConnections(hostName,dbName,userName,password);
    }
    private static Connection getMySQLConnections(String hostName,String dbName,String userName,String password){
        Connection conn = null;
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
            conn = DriverManager.getConnection(connectionURL,userName,password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
