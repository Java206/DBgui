package GUI;

import DataBase.Scenarios;
import DataBase.dataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.sql.SQLException;

public class gui extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 7250653526959884601L;

    // declare some things we need
    private JLabel introLbl, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    public JTextField txtfld1, txtfld2, txtfld3, txtfld4, txtfld5, txtfld6, txtfld7;
    private JButton btn1, btn2;
    private JTextArea txtArea1;
    public Scenarios scenarios = new Scenarios();

        public void createGUI () {


            // make window object
            gui GUI = new gui();
            GUI.init(); // init all our things!

            // set window object size
            GUI.setSize(1000, 600);
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
            introLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
            introLbl.setBounds(10, 5, 300, 20);
            //introLbl.setSize(10,10);
            introLbl.setText("Quick Search");

            //1
            lbl1 = new JLabel("Member ID");
            lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbl1.setBounds(10, 60, 100, 25);
            txtfld1 = new JTextField();
            txtfld1.setBounds(120, 60, 100, 25);

            //2
            lbl2 = new JLabel("ISBN No");
            lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbl2.setBounds(10, 100, 100, 25);
            txtfld2 = new JTextField();
            txtfld2.setBounds(120, 100, 100, 25);

            // 3
            lbl3 = new JLabel("Reserve Date");
            lbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbl3.setBounds(10, 140, 100, 25);
            txtfld3 = new JTextField();
            txtfld3.setBounds(120, 140, 100, 25);

            // 4
            lbl4 = new JLabel("Hold");
            lbl4.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbl4.setBounds(10, 180, 100, 25);
            txtfld4 = new JTextField();
            txtfld4.setBounds(120, 180, 100, 25);

            // 5
            lbl5 = new JLabel("Genre ID");
            lbl5.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbl5.setBounds(10, 220, 100, 25);
            txtfld5 = new JTextField();
            txtfld5.setBounds(120, 220, 100, 25);

            // 6
            lbl6 = new JLabel("Inventory");
            lbl6.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbl6.setBounds(10, 260, 100, 25);
            txtfld6 = new JTextField();
            txtfld6.setBounds(120, 260, 100, 25);

            // 7
            lbl7 = new JLabel("Vendor ID");
            lbl7.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbl7.setBounds(10, 300, 100, 25);
            txtfld7 = new JTextField();
            txtfld7.setBounds(120, 300, 100, 25);

            // generate button
            btn2 = new JButton("New Memeber");
            btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btn2.setBounds(375, 500, 200, 25);

            btn2.addActionListener(e -> {
                newMemberWindow jfrm1= new newMemberWindow();
                jfrm1.setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();

            });
            //add listener to button
            btn2.addActionListener(this);


            txtArea1 = new JTextArea();
            txtArea1.setFont(new Font("Tahoma", Font.PLAIN, 20));
            txtArea1.setBounds(350, 20, 500, 350);

            //JTextField function=new JTextField();
            txtfld1.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    String s1;

                    s1  = txtfld1.getText();
                    txtArea1.setText("Member Id entered: " + s1);
                    try {
                      //  scenarios.getMemberInfo();
                        txtArea1.setText(scenarios.getMemberInfo(s1));
                    } catch (SQLException ev) {
                        ev.printStackTrace();
                    }

                }});

            txtfld2.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e){
                    String s2;

                    s2  = txtfld2.getText();
                    txtArea1.setText("Member Id entered: " + s2);
                    try {
                        //  scenarios.getMemberInfo();
                        txtArea1.setText(scenarios.book(s2));
                    } catch (SQLException ev) {
                        ev.printStackTrace();
                    }

                }});

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
            pane.add(btn2);
            pane.add(txtArea1);
        }


        //handles action and all the things ^_^

        @Override
        public void actionPerformed (ActionEvent e){

        }

}
