import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class globalFile {



    public static void main(String[] args) {

        try {
            PreparedStatement preparedStatement = FinalFiles.connection().prepareStatement("DELETE FROM Client WHERE accountName=ACC78627756403");
            preparedStatement.executeUpdate();

        }catch (Exception exception){
            System.out.println(exception);
        }




    }

}
