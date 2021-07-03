import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class globalSendFile {




    public static int getAmount(String accountNumber){
        int balance = 0;

        try {
            PreparedStatement preparedStatement = FinalFiles.connection().prepareStatement("SELECT Balance FROM Balance WHERE accountNumber = ? ");
            preparedStatement.setString(1, accountNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                balance = resultSet.getInt("Balance");
            }
        }catch (Exception exception){
            System.out.println(exception);
        }

        return balance;
    }

    public static void receiveAmount(String accountNumber, int newBalance){

        try {
            PreparedStatement preparedStatement = FinalFiles.connection().prepareStatement("UPDATE Balance SET Balance = ? WHERE accountNumber = ?");
            preparedStatement.setInt(1, newBalance);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();

        }catch (Exception exception){
            System.out.println(exception);
        }



    }



    public static String Send(String SendaccountNumber, String receiveAccountNumber,int amount){

        //Account bal of the person we are sending to
        int foreignAccountBal = getAmount(receiveAccountNumber);
        int receiveNewAmount = amount + foreignAccountBal;

        //sender account bal
        int accountBal = getAmount(SendaccountNumber);
        int deductAmount = accountBal - amount;

        // new account bal of the receiver
        receiveAmount(receiveAccountNumber, receiveNewAmount);

        // new account bal of the sender
        receiveAmount(SendaccountNumber, deductAmount);


        return amount + " Has Been Sent to " + SendaccountNumber + " Your new Balance is: " + deductAmount;

    }

}
