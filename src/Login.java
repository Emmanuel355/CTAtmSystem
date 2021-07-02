import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {

    public static String getPassword(String accountNumber){
        String password = "";
        try{
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement dataStatement = connection.prepareStatement("SELECT password FROM Pass WHERE accountNumber = ?");
            dataStatement.setString(1, accountNumber);
            ResultSet resultSet = dataStatement.executeQuery();

            while (resultSet.next()){
                password = resultSet.getString("password");

            }

        }catch (Exception exception){
            System.out.println(exception);

        }

        return password;
    }

    //Gets Authentication
   public static String grantAuth(String accountNumber, String password /*, int chances*/){
        String getPassword = getPassword(accountNumber);
        String authSig;

        if (getPassword.equals(password)){
            authSig = FinalFiles.AUTHSIG;
        }else {
            authSig = FinalFiles.AUTHSIGFAIL;
        }

        return authSig  ;

   }

}
