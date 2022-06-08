import java.util.Scanner;

public class Lab03_Q2 {
    /*
     * This program takes a year as a input and tells its century and if it is leap year.
     * 19 OCT 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {

        // Variables
        int year, century;
        Scanner scanner = new Scanner(System.in);

        // Getting input
        System.out.print("Enter the year to be evaluated:");
        year = scanner.nextInt();
        scanner.close();

        // Century calculation
        if (year % 100 == 0) {
            century = year / 100;
        }
        else {
            century = (year / 100) + 1;
        }

        if (century % 10 == 1) {
            System.out.print("The year " + year + " is in the "+ century +"st century and is");
        }
        else if (century % 10 == 2) {
            System.out.print("The year " + year + " is in the "+ century +"nd century and is");
        }
        else if (century % 10 == 3) {
            System.out.print("The year " + year + " is in the "+ century +"rd century and is");
        }
        else  {
            System.out.print("The year " + year + " is in the "+ century +"th century and is");
        }

        // Leap year calculation
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(" a leap year.");
                }
                else {
                    System.out.println(" not a leap year.");
                }
            }
            else {
                System.out.println(" a leap year.");
            }
        }
        else {
            System.out.println(" not a leap year.");
        }

    }
}
