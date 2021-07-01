import java.nio.file.FileAlreadyExistsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class withDrawAndDeposit {
    //private int amount = 0;


    public static String Withdraw(int amount, String accountNumber){
        int bal = 0;
        int returnAmount = 0;
        String returnVal = "";
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

        if (bal > 0){
            returnAmount = bal - amount;
            returnVal = amount + " Has been withdrawn, Your new Balance is: " + returnAmount;
        }else {
            System.out.println("You Cannot withdraw anymore, Your Balance is 0");
        }
        try{
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement preparedStatement = connection.prepareStatement("Update Balance SET Balance = ? WHERE accountNumber=?");
            preparedStatement.setInt(1, returnAmount);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();

        }catch (Exception exception){
            System.out.println(exception);
        }

        return returnVal;

    }

    public static void firstTimeDeposit(int amount, String accountNumber){
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
    }

    public static String deposit(int amount, String accountNumber){
        int balance = 0;
        try {
            Class.forName(FinalFiles.dataBaseDriver);
            Connection connection = DriverManager.getConnection(FinalFiles.LinuxDatabaseURL);
            PreparedStatement preparedStatement = connection.prepareStatement("Update Balance SET Balance = ? WHERE accountNumber = ?");
            PreparedStatement balanceQuery = connection.prepareStatement("SELECT Balance FROM Balance WHERE accountNumber = ? ");
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();

            balanceQuery.setString(1, accountNumber);

            ResultSet resultSet = balanceQuery.executeQuery();

            while (resultSet.next()){
                balance = resultSet.getInt("Balance");
            }

        }catch (Exception exception){
            System.out.println(exception);

        }

        return "Deposited " + amount + " into account " + accountNumber + " Your New Balance is: " + balance;
    }



   /*
    public int getAmount() {
        return amount;
    }

    */


    public static void main(String[] args) {
        System.out.println(deposit(100, FinalFiles.testAcc));
    }
}
