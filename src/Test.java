import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class Test {


    public static void main(String[] args) {

        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement preparedStatement = connection.prepareStatement("Insert Into Balance Values(?,?)");
            preparedStatement.setString(1, FinalFiles.testAcc);
            preparedStatement.setInt(2, 1000);
            preparedStatement.executeUpdate();


        }catch (Exception exception){
            System.out.println(exception);

        }






/*

        double double_random = rand.nextDouble();
        float float_random = rand.nextFloat();

        for (int i = 0; i < 11; i++){
            int int_random = rand.nextInt(10);
            String kaya = Integer.toString(int_random);
            number = number + kaya;
        }

        System.out.println(number);

 */

    }
}
