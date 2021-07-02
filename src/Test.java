import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class Test {


    public static void main(String[] args) {

        try {

            PreparedStatement preparedStatement = FinalFiles.connection().prepareStatement("Insert Into Balance Values(?,?)");
            preparedStatement.setString(1, FinalFiles.testAcc);
            preparedStatement.setInt(2, 1000);
            preparedStatement.executeUpdate();


        }catch (Exception exception){
            System.out.println(exception);

        }



        System.out.println(FinalFiles.time());


    }
}
