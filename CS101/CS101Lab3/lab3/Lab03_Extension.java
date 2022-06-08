import java.util.Scanner;

public class Lab03_Extension {
    /*
     * This is a bank program.
     * 19 OCT 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {
        // Variables
        String pin = "1234";
        String enteredPin;
        double accountBalance = 1000;
        double selectedMenuItem;
        double withdrawAmount;
        double limit;

        // Getting PIN from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN:");
        enteredPin = scanner.nextLine();

        // Checking PIN if its correct
        if (!enteredPin.equals(pin)) {
            // Wrong PIN
            System.out.println("Invalid PIN! Bye!");
        
        }
        else {
            // Correct PIN
            System.out.println("1- Request a credit card");
            System.out.print("2- Withdraw money\n" +
                    "3- Open a new account\n" +
                    "4- Change PIN\n" +
                    "Select an operation:");
            selectedMenuItem = scanner.nextDouble();

            if (selectedMenuItem == 1) {
                // Requested Credit Card
                System.out.println("Enter the card limit (cannot exceed 2 * your balance):");
                limit = scanner.nextDouble();
                if(limit <= 0 || limit > (2 * accountBalance)) {
                    // Wrong amount
                    System.out.println("You entered an invalid amount! Bye!");
                }
                else {
                    // Successfull
                    System.out.println("Your credit card request has been successfully received! Bye!");
                }

            }
            else if (selectedMenuItem == 2) {
                   // Withdraw money selected
                   System.out.print("Enter the amount to withdraw: ");
                   withdrawAmount = scanner.nextDouble();
                   scanner.close();
                   accountBalance = accountBalance - withdrawAmount;
                   System.out.println("Your new balance is " + accountBalance +" TRY. Bye!");
            }
            else if (selectedMenuItem == 3) {
                // Open account selected
                System.out.print("1- TRY\n" +
                        "2- USD\n" +
                        "3- EUR\n" +
                        "4- XAU\n" +
                        "Select currency type:");
                selectedMenuItem = scanner.nextDouble();
                scanner.close();
                if (selectedMenuItem == 1) {
                    System.out.println("Your new TRY account is now opened! Bye!");
                }
                else if (selectedMenuItem == 2){
                    System.out.println("Your new USD account is now opened! Bye!");
                }
                else if (selectedMenuItem == 3){
                    System.out.println("Your new EUR account is now opened! Bye!");
                }
                else if (selectedMenuItem == 4){
                    System.out.println("Your new XAU account is now opened! Bye!");
                }
                else {
                    System.out.println("Your selection is invalid! Bye!");
                }
            }
            else if (selectedMenuItem == 4) {
                // Change PIN Selected
                System.out.print("Enter your new PIN: ");
                scanner.nextLine();
                enteredPin = scanner.nextLine();
                scanner.close();
                pin = enteredPin;
                System.out.println("Your PIN is changed to "+ pin.charAt(0) + "**" + pin.charAt(3)  +". Bye!");
            }
        }


    }
}
