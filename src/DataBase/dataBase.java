package DataBase;

import java.sql.*;

/**
 * A class that models a SQL database. A client is able to execute queries and
 * receive the results.
 * (NOTE: all exceptions must be handled by the client.)
 *
 * @author Abrham Takele
 */
public class dataBase {


    // Below are the USERNAME and PASSWORD used in mysql
    public static final String USER = "root";
    public static final String PASS = "ABab1234";
    public dataBase() throws SQLException {
    }

    public void connectToDatabase() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Takele_Abrham_db", USER, PASS);
            //here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            Scenarios t = new Scenarios();
            //String sql = "CREATE TABLE Users (username, password, fullname, email) VALUES (KingJames23, LJames23, LeBron James, KingJames23@Lakers.org)";

            stmt.executeUpdate(t.getMemberInfo());

                //Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Book");
                while (rs.next())
                    // System.out.println(rs);
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)
                            + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
                con.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}