import java.util.Scanner;

public class Lab02_Q3 {
    /*
     * This program prints some properties about a string.
     * 12 OCT 2021
     * @author Kutay Şenyiğit
     */

    public static void main(String[] args) {
        // Variables
        String title;
        int numberOfChar;
        String allUpperCase;
        String removedSpace;
        char atPosition5;
        String from3rdTo8;
        int firstOccurenceA;
        int lastOccurenceA;

        // Getting input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title:");
        title = scanner.nextLine();
        scanner.close();
        System.out.println("--------------------------------------");

        // Calculations
        numberOfChar = title.length();
        allUpperCase = title.toUpperCase();
        removedSpace = title.trim();
        atPosition5 = title.charAt(5);
        from3rdTo8 = title.substring(2,7);
        firstOccurenceA = title.indexOf("a");
        lastOccurenceA = title.lastIndexOf("a");

        //Outputs
        System.out.println("Number of characters:" + numberOfChar);
        System.out.println("All uppercase:" + allUpperCase);
        System.out.println("Remove leading and trailing blank characters:" + removedSpace);
        System.out.println("Character at index position 5:" + atPosition5);
        System.out.println("Title from 3rd character to 8th character (not included):" + from3rdTo8);
        System.out.println("First occurence of character 'a':" + firstOccurenceA);
        System.out.println("Last occurence of character 'a':" + lastOccurenceA);




    }
}
