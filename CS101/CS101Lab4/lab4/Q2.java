import java.util.Scanner;

public class Q2 {
    /**
     * Palindrome checker
     * @author __Kutay Senyigit___
     * @version __26 OCT 2021__
     */

    public static void main(String[] args) {

        // Variables
        String input;
        int stringLengthIndex;
        int i = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the string:");
        input = scanner.nextLine();
        stringLengthIndex = input.length() -1;

       while (i < stringLengthIndex) {
            if (input.charAt(i) != input.charAt(stringLengthIndex)) {
                System.out.println("It is not a palindrome.");
                count++;
                break;
            }
            i++;
            stringLengthIndex--;
    }
       if (count == 0) {
           System.out.println("It is a palindrome.");
       }
scanner.close();
}}
