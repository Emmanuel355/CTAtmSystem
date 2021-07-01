import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

public class Test {


    public static void main(String[] args) {
        Random rand = new Random();

        String number = "ACC";
        final String DatabaseURL = "jdbc:ucanaccess://C:\\Users\\Emmanuel_Chilombo\\IdeaProjects\\ATM System\\DataModel\\AtmDatabase.accdb";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection(DatabaseURL);
            System.out.println("Connected Successfully");
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
