import java.nio.file.FileAlreadyExistsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class withDrawAndDeposit {
    //private int amount = 0;


    public static String Withdraw(int amount, String accountNumber){
        int bal = 0;
        int withdrawAmount = 0;
        String returnVal = "";

        //grab our balance
        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Balance FROM Balance WHERE accountNumber = ? ");
            preparedStatement.setString(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                bal = resultSet.getInt("Balance");
            }


        }catch (Exception exception){
            System.out.println(exception);

        }
        //manipulate our Balance Provided its greater than 0
        if (bal > 0){
            bal = bal - amount;
            returnVal = amount + " Has been withdrawn, Your new Balance is: " + bal;
        }else {
            System.out.println("You Cannot withdraw anymore, Your Balance is 0");
        }
        try{
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            //statement to update the balance
            PreparedStatement preparedStatement = connection.prepareStatement("Update Balance SET Balance = ? WHERE accountNumber=?");
            preparedStatement.setInt(1, bal);
            preparedStatement.setString(2, accountNumber);

            //Statement to update the Withdraw table
            PreparedStatement preparedStatement2 = connection.prepareStatement("insert into Withdraw VALUES(?, ?, ?)");
            preparedStatement2.setString(1, accountNumber);
            preparedStatement2.setInt(2, amount);
            preparedStatement2.setString(3, FinalFiles.Date);

            preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();

        }catch (Exception exception){
            System.out.println(exception);
        }

        return returnVal;

    }

    public static String firstTimeDeposit(int amount, String accountNumber){
        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement preparedStatement = connection.prepareStatement("Insert Into Balance Values(?,?)");
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setInt(2, amount);
            preparedStatement.executeUpdate();


        }catch (Exception exception){
            System.out.println(exception);

        }

        int bal = 0;
        String returnVal = "";

        //grab our balance
        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Balance FROM Balance WHERE accountNumber = ? ");
            preparedStatement.setString(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                bal = resultSet.getInt("Balance");
            }


        }catch (Exception exception){
            System.out.println(exception);

        }

        returnVal = amount + " Has been deposited into your account, Your balance is: " + bal;

       return returnVal;

    }

    public static String deposit(int amount, String accountNumber){
        int bal = 0;
        String returnVal = "";

        //grab our balance
        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Balance FROM Balance WHERE accountNumber = ? ");
            preparedStatement.setString(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                bal = resultSet.getInt("Balance");
            }


        }catch (Exception exception){
            System.out.println(exception);

        }
        //Increase the Balance by the amount deposited
        bal = bal + amount;

        try{
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            //statement to update the balance
            PreparedStatement preparedStatement = connection.prepareStatement("Update Balance SET Balance = ? WHERE accountNumber=?");
            preparedStatement.setInt(1, bal);
            preparedStatement.setString(2, accountNumber);

            //Statement to update the deposit table
            PreparedStatement preparedStatement2 = connection.prepareStatement("insert into deposits VALUES(?, ?, ?)");
            preparedStatement2.setString(1, accountNumber);
            preparedStatement2.setInt(2, amount);
            preparedStatement2.setString(3, FinalFiles.Date);

            preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();

        }catch (Exception exception){
            System.out.println(exception);
        }
        returnVal = amount + " Has been deposited into Your account, Your Balance is: " + bal;
        return returnVal;

    }

    public static void main(String[] args) {
       // System.out.println(deposit(100, FinalFiles.testAcc));
    }
}
