import java.util.Scanner;

public class Q1 {
    /**
     * Fib calculator
     * @author __Kutay Senyigit___
     * @version __26 OCT 2021__
     */

    public static void main(String[] args) {

	// Variables
        int first = 1;
        int second = 1;
        int n , result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input n:");
        n = scanner.nextInt();
        if (n == 1) {
            result = first;
        }
        else if (n == 2) {
            result = second;
        }

        else {
            int i = 2; 
            while ( i < n)  {
                result = first + second;
                first = second;
                second = result;
                i++;
            }
        }
        System.out.println("Fib(" + n + ")" + " is " + result);
        scanner.close();
    }
}
