package Controller;

import GUI.gui;
/**
 * A main to run the application
 *
 * @author Abrham Takele
 */
public class Main {

    /**
     * This is the main class and where the gui
     * is ran
     * @param args
     */
    public static void main(String[] args) {
        gui newGui = new gui();
        newGui.createGUI();
    }
}
