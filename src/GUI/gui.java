package GUI;

import DataBase.Scenarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.sql.SQLException;

/**
 * A class where all the gui components are stored
 * This is where the first window is created
 *
 * @author Abrham Takele
 */
public class gui extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 7250653526959884601L;

    // declare some things we need
    private JLabel introLbl, lbl1, lbl2;
    public JTextField txtfld1, txtfld2;
    private JButton btn1, btn2;
    private JTextArea txtArea1;
    public Scenarios scenarios = new Scenarios();

    /**
     * A class to create and send to main to be run
     *
     */
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

    /**
     * creates all the inside components of
     * the frame
     */
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

                /**
                 * Listen to when type in a query from
                 * the text field
                 * @param e our listener
                 */
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

                /**
                 * Listen to when type in a query from
                 * the text field
                 * @param e our listener
                 */
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
            pane.add(txtfld1);
            pane.add(txtfld2);
            pane.add(btn2);
            pane.add(txtArea1);
        }
        @Override
        public void actionPerformed (ActionEvent e){
    }

}
