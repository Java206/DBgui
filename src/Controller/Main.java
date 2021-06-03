package Controller;

import DataBase.dataBase;
import GUI.gui;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static Connection con;
   // public Connection con;
    public static void main(String[] args) throws SQLException {
//        dataBase data = new dataBase();
//        data.connectToDatabase();

        gui newgui = new gui();
        newgui.createGUI();
    }
}
