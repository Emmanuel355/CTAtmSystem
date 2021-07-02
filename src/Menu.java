import net.ucanaccess.commands.IFeedbackAction;

import java.util.Scanner;

public class Menu {


    public static void main(String[] args) {

        boolean isRunning = true;
        Scanner scan = new Scanner(System.in);


            System.out.println("Welcome to CT Banking System, You have the following Options:\n" +
                    "1. Create Account \n" +
                    "2. Log To Your Account \n" +
                    "3. Forgot Password \n" +
                    "4. Exit System");



            System.out.print("Please Select an option");
            int option = scan.nextInt();

            switch (option){
                case 1:
                    FrontSupport.Create();
                    break;

                case 2:
                    // LogInto an account, This is only for Existing Accounts
                    FrontSupport.Login();
                    break;


                case 3:
                    //Allows You To Change The Password
                    FrontSupport.forgotPassword();

                case 4:










        }




    }

    // Enable account Creation





}