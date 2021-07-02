import java.util.Scanner;

public class postLogIn {

    public static boolean postLogin(String accountNumber, boolean status){
        System.out.println("Welcome, Your account Number: " + accountNumber);

        System.out.println("The Following Options Are Currently Available:  ");
        System.out.println("1. Deposit Money \n" +
                           "2. Withdraw Money \n" +
                           "3. Change Account Details \n" +
                           "4. LogOut");

        System.out.println("Please Select An Option From The Above: ");
        Scanner scan  = new Scanner(System.in);
        int option = scan.nextInt();

        if (option == 1){
            Scanner checkFirst = new Scanner(System.in);
            System.out.println("Is This your first Time deposit? Yes/No ");

            Scanner depositScan  = new Scanner(System.in);
            String check = checkFirst.next();
            if (check.equals("Yes") || check.equals("YES") || check.equals("YeS")){
                System.out.println("Please Enter An Amount You Want To Deposit: ");
                int amount = depositScan.nextInt();
                System.out.println(withDrawAndDeposit.firstTimeDeposit(amount, accountNumber));


            }else {
                System.out.println("Please Enter An Amount You Want To Deposit: ");
                int amount = depositScan.nextInt();
                System.out.println(withDrawAndDeposit.deposit(amount, accountNumber));

            }

            status = true;
        }else if (option == 2){
            System.out.println("Please Enter An Amount You Want To WithDraw: ");
            Scanner withdrawScan  = new Scanner(System.in);
            int amount = withdrawScan.nextInt();
            System.out.println(withDrawAndDeposit.Withdraw(amount, accountNumber));
            status = true;

        }else if (option == 3){
            System.out.println("Kaya");
            status = true;

        }else if (option == 4){
            System.out.println("Login out......");
            status = false;
        }


        return status;
    }


    public static void main(String[] args) {

        boolean isrunning = true;

        while (isrunning) {
            isrunning = postLogin("010001", isrunning);
        }

    }






}
