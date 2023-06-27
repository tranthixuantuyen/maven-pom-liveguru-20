package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return MySQLConnUtils.getMySQLConnections();
    }
    public static  void main (String[] args) throws SQLException, ClassNotFoundException {
    System.out.println("Get connection....");
        // lay ra doi tuong connection ket noi vao database
    Connection conn = MySQLTestConnection.getMyConnection();

    System.out.println("Opened connection...." +conn );

        // tao ra 1 doi tuong cua statement
        Statement statement = conn.createStatement();

        String sql = "Select * from employee;";

        //Thuc thi cau lenh SQL tra ve doi tuong ResultSet
        ResultSet rs = statement.executeQuery(sql);

        // Duyet tren ket qua tra ve
        while (rs.next()){
            // Di chuyen con tro xuong ban ghi ke tiep
            int empID = rs.getInt(1);
            String empFirstName = rs.getString(2);
            String empLastName = rs.getString("Last_Name");
            System.out.println("-------------------");
            System.out.println("Emp ID: "+empID);
            System.out.println("Emp Firstname: "+empFirstName);
            System.out.println("Emp Lastname: "+empLastName);

        }
        conn.close();
        System.out.println("---------Closed connection-------------");
    }
}
