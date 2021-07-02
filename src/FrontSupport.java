import java.util.Scanner;

public class FrontSupport {

    // Contains all the support files for the front -- what the user sees
    // Create, Login, forgotPassword


    static void Create(){
        String fullName, address, phoneNumber, password, reEnterPassword;
        int regNumber;

        System.out.println("Enter Name:........... ");
        Scanner scan1 = new Scanner(System.in);
        fullName  = scan1.next();

        System.out.println("Enter Reg Number:...... ");
        Scanner scan3 = new Scanner(System.in);
        regNumber = scan3.nextInt();

        System.out.println("Enter address:......... ");
        Scanner scan4 = new Scanner(System.in);
        address = scan4.next();


        System.out.println("Enter Phone Number:.... ");
        Scanner scan5 = new Scanner(System.in);
        phoneNumber = scan5.next();

        System.out.println("Enter Password:........ ");
        Scanner scan6 = new Scanner(System.in);
        password = scan6.next();

        System.out.println("Re-Enter Password:..... ");
        Scanner scan7 = new Scanner(System.in);
        reEnterPassword = scan6.next();

        String accountNumber = CreateAccount.AccountCreation(
                fullName, regNumber, address, phoneNumber, password, reEnterPassword);

        System.out.println("Created Account With The Following Account Number "+ accountNumber);

        System.out.println("\n Thank You for Creating an Account With CT");
        boolean menuRunning = true;

        while (menuRunning){
            menuRunning = postLogIn.postLogin(accountNumber, menuRunning);
        }
    }


    //Enables Login
    static void Login(){

        int counter = 3;
        String access = "";
        String pass = "";
        String grantAccess = "";
        Scanner accountNumberScan = new Scanner(System.in);

        System.out.print("Please Enter an account Number:  ");
        String loginAccountNumber = accountNumberScan.next();

        while(counter >= 0){
            Scanner logInScan = new Scanner(System.in);
            System.out.println("Please Enter A Password");
            pass = logInScan.next();
            access = Login.grantAuth(loginAccountNumber, pass);

            if(access.equals(FinalFiles.AUTHSIG)){
                System.out.println("Access Has Been Granted");
                grantAccess = "YES";
                break;
            }else {
                System.out.println("Access Has not been Granted, You Have " + counter + " Chances Left");
                grantAccess = "NO";
            }
            counter--;
        }

        if (grantAccess.equals("YES")){
            boolean status = true;

            while (status) {
                status = postLogIn.postLogin(loginAccountNumber, status);
            }
        }else{
            System.out.println("You May Need To Reset Your Password");

        }
    }


    public static String forgotPassword(){

        String accountNumber = "";
        String newPassword = "";

        Scanner scanAccountNumber = new Scanner(System.in);
        Scanner scanNewPassword = new Scanner(System.in);

        System.out.println("Enter Account Number: ");
        accountNumber =scanAccountNumber.next();

        System.out.println("Enter New Password: ");
        newPassword = scanNewPassword.next();

        return forgotPassword.forgotPassword(accountNumber, newPassword);
    }
}
