package DataBase;

import java.sql.*;

/**
 * A class that models a SQL database. A client is able to execute queries and
 * receive the results.
 * (NOTE: all exceptions must be handled by the client.)
 *
 * @author Brandon Soto
 */
public final class dataBase {


    public static final String DBNAME = "Takele_Abrham_db";  // Like "testDB"

    /**
     * JDBC driver name and database URL
     */
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * Gives access to all Databases
     */
    static final String ALL_DBS_URL = "jdbc:mysql://localhost/?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false";

    /**
     * Gives access to a given DB
     */
    static final String GIVEN_DB_URL = "jdbc:mysql://localhost/" + DBNAME + "?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false";

    // Below are the USERNAME and PASSWORD used in mysql
    public static final String USER = "root";
    public static final String PASS = "ABab1234";

    /**
     * A variable for connecting to MySQL Server
     */
    public static Connection conn = null;

    /**
     * A variable for Preparing Statements
     */
    public static PreparedStatement ps = null;

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        // Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // Open a connection with MySQL server
        System.out.println("Connecting to all Databases path...");
        conn = DriverManager.getConnection(ALL_DBS_URL, USER, PASS);
        System.out.println("Connected to all Databases!");

        // Test if there is the db in MySQL Server
        // if not then create one
        System.out.println("Testing if " + DBNAME + " exists...");
        ps = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS " + DBNAME + ";");
        ps.executeUpdate();
        // Now db exists for sure!

        // Open a connection with given DB
        System.out.println("Connecting to " + DBNAME + " path...");
        conn = DriverManager.getConnection(GIVEN_DB_URL, USER, PASS);
        System.out.println("Connected to " + DBNAME + "!");

        // then you can do all sort of queries that you want to do
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Member");
        while (rs.next())
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        conn.close();
    }
}