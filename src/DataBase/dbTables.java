package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbTables {
    public dataBase data;
    public Connection con;
    public dbTables(){ }

    public String memberTable() throws SQLException {
        String memTbl;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Book");
        while (rs.next())
            // System.out.println(rs);
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
        con.close();


        return "hello";
    }

}
