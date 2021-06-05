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
        public Connection con;
        public Statement stmt;

        // Below are the USERNAME and PASSWORD used in mysql
        public static final String USER = "root";
        public static final String PASS = "ABab1234";

        /**
         * A class to connect to out database
         */
        public dataBase() {

            try {

               con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Takele_Abrham_db", USER, PASS);
               try {
                   stmt = con.createStatement();
                   System.out.println("Connected Successfully");

               } catch (SQLException e) {
                   e.printStackTrace();
               }

               // con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * A class to execute queries sent from
         * Scenarios class
         * @param sql The string passed
         * @return the query to be executed
         */

        public ResultSet query(String sql) throws SQLException {
            return stmt.executeQuery(sql);
        }

    }