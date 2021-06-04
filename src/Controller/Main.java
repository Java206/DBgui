package Controller;

import DataBase.dataBase;
import GUI.gui;

import java.sql.SQLException;

public class Main {
   // public Connection con;
    public static void main(String[] args) throws SQLException {
//        dataBase data = new dataBase();
//        data.connectToDatabase();

        gui newGui = new gui();
        newGui.createGUI();
    }
}
