package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame implements ActionListener {

    private static final long serialVersionUID = 7250653526959884601L;


    // declare some things we need
    private JLabel introLbl, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    private JTextField txtfld1, txtfld2, txtfld3, txtfld4, txtfld5, txtfld6, txtfld7;
    private JButton btn1;
    private JTextArea txtArea1;


    public static void main(String[] args) {

        // make window object
        gui GUI = new gui();
        GUI.init(); // init all our things!

        // set window object size
        GUI.setSize(800, 450);
        GUI.setTitle("Library Database");
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init() {


        // create container to hold GUI in window
        Container pane = this.getContentPane();
        pane.setLayout(null);

        // intro label
        introLbl = new JLabel();
        introLbl.setBounds(10, 10, 300, 20);
        introLbl.setText("Quick intro to app");


        //1
        lbl1 = new JLabel("input1");
        lbl1.setBounds(10, 30, 80, 20);
        txtfld1 = new JTextField();
        txtfld1.setBounds(70, 30, 100, 20);

        //2
        lbl2 = new JLabel("input2");
        lbl2.setBounds(10, 60, 80, 20);
        txtfld2 = new JTextField();
        txtfld2.setBounds(70, 60, 100, 20);

        // 3
        lbl3 = new JLabel("input3");
        lbl3.setBounds(10, 90, 80, 20);
        txtfld3 = new JTextField();
        txtfld3.setBounds(70, 90, 100, 20);

        // 4
        lbl4 = new JLabel("input4");
        lbl4.setBounds(10, 90, 80, 20);
        txtfld4 = new JTextField();
        txtfld4.setBounds(70, 90, 100, 20);

        // 5
        lbl5 = new JLabel("input5");
        lbl5.setBounds(10, 90, 80, 20);
        txtfld5 = new JTextField();
        txtfld5.setBounds(70, 90, 100, 20);

        // 6
        lbl6 = new JLabel("input6");
        lbl6.setBounds(10, 90, 80, 20);
        txtfld6 = new JTextField();
        txtfld6.setBounds(70, 90, 100, 20);

        // 7
        lbl7 = new JLabel("input7");
        lbl7.setBounds(10, 90, 80, 20);
        txtfld7 = new JTextField();
        txtfld7.setBounds(70, 90, 100, 20);

        // generate button
        btn1 = new JButton("button!");
        btn1.setBounds(10, 200, 100, 20);

        //add listener to button
        btn1.addActionListener(this);

        //text area output (with formatted font)
        txtArea1 = new JTextArea("My Text Area!");
        txtArea1.setFont(new Font("monospaced", Font.PLAIN, 12));
        txtArea1.setBounds(250, 20, 500, 350);

        //add all of the things to the pane
        pane.add(introLbl);
        pane.add(lbl1);
        pane.add(lbl2);
        pane.add(lbl3);
        pane.add(txtfld1);
        pane.add(txtfld2);
        pane.add(txtfld3);
        pane.add(btn1);
        pane.add(txtArea1);
    }


    //handles action and all the things ^_^

    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            //parse some data from input
            int temp1 = Integer.parseInt(txtfld1.getText());
            int temp2 = Integer.parseInt(txtfld2.getText());

            //do what we want to do with whatever data


            //basic error catching
        } catch (NumberFormatException ex) {
            System.out.println("Exception: " + ex);
            JOptionPane.showMessageDialog(this, "Please enter a warning message");
        } catch (ArrayIndexOutOfBoundsException ex) {
            //warnings..
        } catch (NegativeArraySizeException ex) {
            //warnings..
        }
    }
}
