package DataBase;

import java.sql.*;
/**
 * A class to call the queries on the first page
 *
 * @author Abrham Takele
 */
public class Scenarios {
    public dataBase data;
    public Scenarios(){
        data = new dataBase();
    }

    /**
     * This class will get the user_Id from members table
     * by sending the query to our database
     * @param s1 a String sent by the listener
     * @return returns string
     */
    public String getMemberInfo(String s1) throws SQLException {

        String query = "select * from Member where User_Id = " + s1 ;
        ResultSet result = data.query(query);
        if(result == null) System.out.println("Wrong ID");

        StringBuilder s = new StringBuilder();
        while(true) {
            assert result != null;
            if (!result.next()) break;
            int userid = result.getInt("User_Id");
            String fName  = result.getString("Fname");
            String lName  = result.getString("Lname");
            String email  = result.getString("Email");
            int phoneNO = result.getInt("Phone_no");
            String add  = result.getString("Address");
            int zip = result.getInt("ZipCode");

            s.append("User_ID: ").append(userid).append("\n FName: " +
                    "").append(fName).append("\n LName: ").append(lName).
                    append("\n Email: ").append(email).append("\n Phone_no: " +
                    "").append(phoneNO).append("\n Address: ").append(add).append(
                            "\n ZipCode: ").append(zip);
        }

        return s.toString();
    }
    /**
     * This class will get the ISBN_Number from Book table
     * by sending the query to our database
     * @param s2 a String sent by the listener
     * @return returns string
     */
    public String book(String s2) throws SQLException {

        String bookQuery = "select * from Book where ISBN_Number = " + s2 ;
        ResultSet bookResult = data.query(bookQuery);
        if(bookResult == null) System.out.println("Wrong ISBN_no");

        StringBuilder s = new StringBuilder();
        while(true) {
            assert bookResult != null;
            if (!bookResult.next()) break;
            int isbn_number= bookResult.getInt("ISBN_Number");
            String title  = bookResult.getString("Title");
            String authorFname  = bookResult.getString("AuthorFname");
            String authorLname  = bookResult.getString("AuthorLname");
            String edition = bookResult.getString("Edition");
            String category  = bookResult.getString("Category");

            s.append("ISBN_Number: ").append(isbn_number).append("\nTitle: ").
                    append(title).append("\n AuthorFname: ").append(authorFname).
                    append("\n AuthorLname: ").append(authorLname).append("\n Edition: ").
                    append(edition).append("\n Category: ").append(category);
        }

        return s.toString();
    }
}
