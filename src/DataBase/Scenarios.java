package DataBase;

import GUI.gui;
import GUI.newMemberWindow;

import java.sql.*;

public class Scenarios {
    public dataBase data;
    public Scenarios(){ }

    public String memberTable() throws SQLException {
        newMemberWindow nwGUI = new newMemberWindow();

        String sql =  "INSERT INTO Member VALUES (101, 'LeBron', 'James', 'KingJames23@Lakers.org', 2069896542, '68446', 56874)";
       // String sql2 = "INSERT INTO Member VALUES (564, " + nwGUI
        return sql;
    }

    public String getMemberInfo() {
        gui n = new gui();
        String s1 = "546";
        //  s1      = n.txtfld1.getText();

        String sql =  "INSERT INTO Member VALUES (" + s1 + ", 'LeBron', 'James', 'KingJames23@Lakers.org', 2069896542, '68446', 56874)";

        return sql;
    }
}
