package GUI;


import DataBase.dataBase;
import DataBase.dbTables;
import com.mysql.cj.result.OffsetDateTimeValueFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class gui extends JFrame implements ActionListener {

    private static final long serialVersionUID = 7250653526959884601L;

    // declare some things we need
    private JLabel introLbl, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    private JTextField txtfld1, txtfld2, txtfld3, txtfld4, txtfld5, txtfld6, txtfld7;
    private JButton btn1, btn2;
    private JTextArea txtArea1;

    public dataBase data;
    public Connection con;
    public dbTables t;

        public void createGUI () {


            // make window object
            gui GUI = new gui();
            GUI.init(); // init all our things!

            // set window object size
            GUI.setSize(800, 450);
            GUI.setTitle("Library Management System");
            GUI.setVisible(true);
            GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        public void init () {


            // create container to hold GUI in window
            Container pane = this.getContentPane();
            pane.setLayout(null);

            // intro label
            introLbl = new JLabel();
            introLbl.setBounds(10, 5, 300, 20);
            //introLbl.setSize(10,10);
            introLbl.setText("Quick Search");

            //1
            lbl1 = new JLabel("Member ID");
            lbl1.setBounds(10, 30, 80, 20);
            txtfld1 = new JTextField();
            txtfld1.setBounds(80, 30, 100, 20);

            //2
            lbl2 = new JLabel("ISBN No");
            lbl2.setBounds(10, 60, 80, 20);
            txtfld2 = new JTextField();
            txtfld2.setBounds(80, 60, 100, 20);

            // 3
            lbl3 = new JLabel("Reserve Date");
            lbl3.setBounds(10, 90, 80, 20);
            txtfld3 = new JTextField();
            txtfld3.setBounds(80, 90, 100, 20);

            // 4
            lbl4 = new JLabel("Hold");
            lbl4.setBounds(10, 120, 80, 20);
            txtfld4 = new JTextField();
            txtfld4.setBounds(80, 120, 100, 20);

            // 5
            lbl5 = new JLabel("Genre ID");
            lbl5.setBounds(10, 150, 80, 20);
            txtfld5 = new JTextField();
            txtfld5.setBounds(80, 150, 100, 20);

            // 6
            lbl6 = new JLabel("Inventory");
            lbl6.setBounds(10, 180, 80, 20);
            txtfld6 = new JTextField();
            txtfld6.setBounds(80, 180, 100, 20);

            // 7
            lbl7 = new JLabel("Vendor ID");
            lbl7.setBounds(10, 210, 80, 20);
            txtfld7 = new JTextField();
            txtfld7.setBounds(80, 210, 100, 20);

            // generate button
            btn1 = new JButton("button!");
            btn1.setBounds(10, 240, 100, 20);

            // generate button
            btn2 = new JButton("Test!");
            btn2.setBounds(10, 270, 100, 20);

            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        txtArea1.setText(t.memberTable());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
            //add listener to button
            btn2.addActionListener(this);

            //text area output (with formatted font)
            txtArea1 = new JTextArea("hello!");
            txtArea1.setFont(new Font("monospaced", Font.PLAIN, 12));
            txtArea1.setBounds(250, 20, 500, 350);

            //add all of the things to the pane
            pane.add(introLbl);
            pane.add(lbl1);
            pane.add(lbl2);
            pane.add(lbl3);
            pane.add(lbl4);
            pane.add(lbl5);
            pane.add(lbl6);
            pane.add(lbl7);
            pane.add(txtfld1);
            pane.add(txtfld2);
            pane.add(txtfld3);
            pane.add(txtfld4);
            pane.add(txtfld5);
            pane.add(txtfld6);
            pane.add(txtfld7);
            pane.add(btn1);
            pane.add(btn2);
            pane.add(txtArea1);
        }


        //handles action and all the things ^_^

        @Override
        public void actionPerformed (ActionEvent e){
//
//            btn2.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    txtArea1.setText("It worked!!!");
//                }
//            });

//            try {
//                //parse some data from input
//                int temp1 = Integer.parseInt(txtfld1.getText());
//                int temp2 = Integer.parseInt(txtfld2.getText());
//
//                //do what we want to do with whatever data
//
//
//                //basic error catching
//            } catch (NumberFormatException ex) {
//                System.out.println("Exception: " + ex);
//                JOptionPane.showMessageDialog(this, "Please enter a warning message");
//            } catch (ArrayIndexOutOfBoundsException ex) {
//                //warnings..
//            } catch (NegativeArraySizeException ex) {
//                //warnings..
//            }
        }

}
