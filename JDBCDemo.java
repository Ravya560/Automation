import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("com.mysql.cj.jdbc.driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url  = "jdbc:mysql://localhost:3306/universalit";
        String uname = "root";
        String password= "Ravya@123";
        Connection con = DriverManager.getConnection(url,uname,password);
        ResultSet rs = null;
       // Statement st = con.createStatement();
        String query =  ("select * from employee");
        String insertquery = ("Insert into employee values('4','Ravya','IT')");
        try{
            con = DriverManager.getConnection(url,uname,password);
            Statement st1 = con.createStatement();
            boolean execute = st1.execute(insertquery);
            if(execute){
                ResultSet set = st1.getResultSet();
                set.next();
                System.out.println(set.getString(2));
            }else{
                int count = st1.executeUpdate(insertquery);
                System.out.println("no of rows updated" + count);
            }
         //   int count = st1.executeUpdate(insertquery);

        }
        finally {
            if(rs != null){
                rs.close();

            }else {
                if(con != null){
                    con.close();
                }
            }
        }



    }}
