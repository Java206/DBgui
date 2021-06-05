package GUI;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * A second frame that will register a new
 * Library member
 *
 * @author Abrham Takele
 */
public class newMemberWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private final JTextField userId;
    private final JTextField firstname;
    private final JTextField lastname;
    private final JTextField email;
    private final JTextField address;
    private final JTextField phoneNo;
    private final JTextField zipCode;
    private final JButton btnNewButton;

    /**
     * Create the frame.
     * And Run the second frame
     */

    public newMemberWindow() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/abrhamtakele/Desktop/Tcss 305/ajs7-powerpaint/images/BatMan.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New Member Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 15, 400, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblUser_ID = new JLabel("User_ID");
        lblUser_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUser_ID.setBounds(58, 70, 99, 43);
        contentPane.add(lblUser_ID);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAddress.setBounds(542, 152, 99, 24);
        contentPane.add(lblAddress);

        JLabel lblZipCode = new JLabel("ZipCode");
        lblZipCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblZipCode.setBounds(542, 245, 99, 24);
        contentPane.add(lblZipCode);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        userId = new JTextField();
        userId.setFont(new Font("Tahoma", Font.PLAIN, 32));
        userId.setBounds(214, 70, 228, 50);
        contentPane.add(userId);
        userId.setColumns(10);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        address = new JTextField();
        address.setFont(new Font("Tahoma", Font.PLAIN, 32));
        address.setBounds(707, 151, 228, 50);
        contentPane.add(address);
        address.setColumns(10);

        phoneNo = new JTextField();
        phoneNo.setFont(new Font("Tahoma", Font.PLAIN, 32));
        phoneNo.setBounds(707, 320, 228, 50);
        contentPane.add(phoneNo);
        phoneNo.setColumns(10);

        zipCode = new JTextField();
        zipCode.setFont(new Font("Tahoma", Font.PLAIN, 32));
        zipCode.setBounds(707, 235, 228, 50);
        contentPane.add(zipCode);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(e -> {
            String user = userId.getText();
            String firstName = firstname.getText();
            String lastName = lastname.getText();
            String emailId = email.getText();
            String mobileNumber = phoneNo.getText();
            int len = mobileNumber.length();
            String addr = address.getText();
            String zip = zipCode.getText();
            int len1 = zip.length();

            String msg = "" + firstName;
            msg += " \n";
            if (len != 10) {
                JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
            }

            if (len1 != 5) {
                JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
            }

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Takele_Abrham_db", "root", "ABab1234");

                String query = "INSERT INTO Member values('" + user + "','" + firstName + "','" + lastName + "','" + emailId + "','" +
                        mobileNumber + "','" + addr + "','" + zip + "')";

                Statement sta = connection.createStatement();
                int x = sta.executeUpdate(query);
                if (x == 0) {
                    JOptionPane.showMessageDialog(btnNewButton, "This is already exist");
                } else {
                    JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is successfully created");
                    userId.setText(""); firstname.setText("");lastname.setText("");email.setText("");
                    phoneNo.setText("");address.setText("");zipCode.setText("");
                }
                connection.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}