/* Testing rebase functionality here */
import java.sql.*;
import java.util.Scanner;

public class Demo2 {
    public staticc void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/universalit";
        String uname = "root";
        String password = "Ravya@123";
        Connection con = DriverManager.getConnection(url, uname, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from accounts");
        while (rs.next()){
            System.out.println(rs.getInt(1) + rs.getString(2));
                    }

        System.out.println("Transaction begins");
        con.setAutoCommit(false);
        st.executeUpdate("update accounts set balance = balance - 2000 where name = 'Milan'");
        st.executeUpdate("update accounts set balance = balance + 2000 where name = 'Anushka'");
        System.out.println("Confirm your transation");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if(option.equalsIgnoreCase("yes")){
            con.commit();
            System.out.println("Transaction committed");
        }else {
            con.rollback();
            System.out.println("Transaction rolled back");
        }
        System.out.println("After Transaction ");
        ResultSet rs1 = st.executeQuery("Select * from accounts");

    }

}
