import java.util.Scanner;

public class Q4 {
    /**
     * Text Art
     * @author __Kutay Senyigit___
     * @version __26 OCT 2021__
     */

    public static void main(String[] args) {

          // Variables
          int n, i, j;
          Scanner scanner = new Scanner(System.in);
          System.out.println("Enter number of lines:");
          n = scanner.nextInt();
          i = 0;
         
          while (i < n) {
              j = 0;
              while (j <= i) {
                    j++;   
                  System.out.print("*");
                 
              }
              System.out.println();
              i++;
          }
          scanner.close();
    }
}
