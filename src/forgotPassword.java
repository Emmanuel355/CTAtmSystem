import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class forgotPassword {


    public static String forgotPassword(String accountNumber, String newPassword){
        String returnString = "";
        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement statement = connection.prepareStatement("Update Pass SET password = ? WHERE accountNumber = ?");
            statement.setString(1, newPassword);
            statement.setString(2, accountNumber);
            statement.executeUpdate();

            returnString = "Password Reset Successfull, You can Now Login using Your New Password.";



        }catch (Exception exception){
            System.out.println(exception);
        }

        return returnString;

    }

}
