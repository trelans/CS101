import java.util.Scanner;

public class Q4_Revision {
    /**
     * Text Art
     * @author __Kutay Senyigit___
     * @version __26 OCT 2021__
     */

    public static void main(String[] args) {

        // Variables
        int n, i, j , k;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of lines:");
        n = scanner.nextInt();
        i = 1;
       
        while (i <= n) {
           k = 1;

              while(k <= n - i) {

                System.out.print(" ");
                k++;
              }
              j= 1;

            while (j <= (2*i -1)) {
                  j++;   
                System.out.print("*");
               
            }
            System.out.println();
            k = 1;
            j = 1;
            i++;
        }
        scanner.close();
    }
}
