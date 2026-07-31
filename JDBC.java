
import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("com.mysql.cj.jdbc.driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url  = "jdbc:mysql://localhost:3306/universalit";
        String uname = "root";
        String password= "Ravya@123";
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from employee");
        while (rs.next()){
            System.out.println("Employee id" + "  " +rs.getInt(1));
            System.out.println("Employee name" + "  " + rs.getString(2));

        }


    }
}
