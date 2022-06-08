import java.util.Scanner;

public class Lab05_Q1 {
    /**
     * City Builder
     * @author __Kutay Senyigit___
     * @version __2 NOV 2021__
     */

    public static void main(String[] args) {
	    //Variables
        String inputCityBuilder;
        int max;
        int currentNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter city plan string:");
        inputCityBuilder = scanner.nextLine();

        // Finding max int digit of given string
        max = Integer.parseInt(inputCityBuilder.charAt(0) + "");
        for (int i = 0; i < inputCityBuilder.length(); i++) {
            currentNumber = Integer.parseInt(inputCityBuilder.charAt(i) + "");
            if (currentNumber >= max) {
                max = currentNumber;
            }
        }

        for (int lineNo = max; lineNo > 0;  lineNo--) {
            for (int i = 0; i < inputCityBuilder.length(); i++) {
                currentNumber  = Integer.parseInt(inputCityBuilder.charAt(i) + "");
                if (lineNo <= currentNumber) {
                        System.out.print("*");

                }
                else {
                        System.out.print(" ");
                }
            }
            System.out.println();
        }

    scanner.close();
    }
}
