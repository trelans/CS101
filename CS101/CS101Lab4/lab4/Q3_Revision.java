
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Max min avg finder
 * @author __Kutay Senyigit___
 * @version __26 OCT 2021__
 */

public class Q3_Revision {

    public static void main(String[] args) {
        // variables
        int input;
        int sentinel;
        int sum;
        int min = 0; // to determine min value
        int max = 0; // to determine max value
        int n = 0;
        double average;
        Scanner scanner = new Scanner(System.in);

        sum = 0; // starts with 0
        input = 0;
        System.out.print("Please input n: ");
        sentinel = scanner.nextInt();

    
        while(true) {
                n++;
                System.out.println("Please input a positive integer: ");
          
            input = scanner.nextInt();
            
            if (n == 1) {
                min = input; // min compare initial value
                max = input; // max compare initial value
            }
            if(sentinel == input) {
                break;
            }
            sum = sum + input;
           

            if (min > input && input >= 0) {
                min = input;   // finds min
            }
            if (max < input) {
                max = input; // finds max
            }
        }
        scanner.close();
        average = (double) sum / (n-1);  // calculates average
        // outputs
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Average: " + average);
      
  


    }
   
}
