import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class CreateAccount {
    // Enables the user to create an account
    // Requires their full name, regNumber, and other personal details
    // requires the creating of a password
    // Creates a base for authentication
    // Saves the data to a database
    // upon creation, the users details are printed to a text file
    // returns a number

    public String AccountCreation(String fullName, int regNumber, String address, String phoneNumber, String password,
                                  String reEnterPassword){

        // All main variable in the function
        final String DatabaseURL = "jdbc:ucanaccess://C:\\Users\\Emmanuel_Chilombo\\IdeaProjects\\AtmSystem\\DataModel\\AtmDatabase.accdb";
        final int upperBound = 10;
        Random rand = new Random();
        String number = "ACC";


        // Generate a System generated Account number


        for (int i = 0; i < 11; i++){
            int int_random = rand.nextInt(upperBound);
            String kaya = Integer.toString(int_random);
            number = number + kaya;
        }
        try {
            // Database Statements
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection(DatabaseURL);
            PreparedStatement dataStatement = connection.prepareStatement("INSERT INTO Client VALUES(?,?,?,?,?)");
            PreparedStatement dataStatement2 = connection.prepareStatement("INSERT INTO Pass VALUES(?,?)");

            if (password == reEnterPassword){
                    // Enter Data into the Database provided the user Has entered the correct Password and Confirmation Passwords

                    dataStatement.setString(1, number);
                    dataStatement.setString(2, fullName);
                    dataStatement.setInt(3, regNumber);
                    dataStatement.setString(4, address);
                    dataStatement.setString(5, phoneNumber);

                    //Enter the Password into the database for authentication
                    dataStatement2.setString(1, number);
                    dataStatement2.setString(2, password);

                    //execute the update into the database
                    dataStatement.executeUpdate();
                    dataStatement2.executeUpdate();

                    // Print the details of the account creation
                    PrintWriter writer = new PrintWriter(fullName+".txt");
                    writer.println("Your Account Has successfully Created with the following details: ");
                    writer.println(" -- " + fullName);
                    writer.println(" -- " + regNumber);
                    writer.println(" -- " + address);
                    writer.println(" -- " + phoneNumber);
                    writer.println("Your Account Number is: " + number);
                    writer.println("Thank You for creating an account with us, You can Now access our Systems using your password and account number");
                    writer.close();
            }else{
                System.out.println("Passwords Do Not Match, Please Check Your Passwords ");
            }


        }catch (Exception exception){
            System.out.println(exception);

        }
       return number;
    }

}
