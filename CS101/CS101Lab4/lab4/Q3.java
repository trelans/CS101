
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Max min avg finder
 * @author __Kutay Senyigit___
 * @version __26 OCT 2021__
 */

public class Q3 {

    public static void main(String[] args) {
        // variables
        int input;
        int n;
        int sum;
        int min = 0; // to determine min value
        int max = 0; // to determine max value
        double average;
        Scanner scanner = new Scanner(System.in);

        sum = 0; // starts with 0
        input = 0;
        System.out.print("Please input n: ");
        n = scanner.nextInt();

        System.out.println("Now input " + n + " positive integers: ");
        int i = 0;
        while (i < n) {

            input = scanner.nextInt();

            if (i == 0) {
                min = input; // min compare initial value
                max = input; // max compare initial value
            }
            if (n == 1) {
                min = input; // min compare initial value
                max = input; // max compare initial value
                break;
            }
           
            sum = sum + input;


            if (min > input && input >= 0) {
                min = input;   // finds min
            }
            if (max < input) {
                max = input; // finds max
            }
            i++;
        }

        average = (double) sum / n;  // calculates average
        // outputs
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Average: " + average);

        scanner.close();


    }
}
