import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class forgotPassword {


    public static void forgotPassword(String accountNumber, String newPassword){
        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement statement = connection.prepareStatement("Update Pass SET password = ? WHERE accountNumber = ?");
            statement.setString(1, newPassword);
            statement.setString(2, accountNumber);
            statement.executeUpdate();
            System.out.println("Password Change Successful");


        }catch (Exception exception){
            System.out.println(exception);
        }

    }

}
