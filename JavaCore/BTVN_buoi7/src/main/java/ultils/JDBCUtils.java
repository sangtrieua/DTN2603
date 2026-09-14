package ultils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    public static Connection getConnection(){
        Connection conn = null;
        String url="jdbc:mysql://localhost:3306/dtn2603_testing_system";
        String user="root";
        String password="123456";
        try {
            conn= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
