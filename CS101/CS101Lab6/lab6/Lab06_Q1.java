/**
 * Methods
 * @author __Kutay Senyigit___
 * @version __9 NOV 2021__
 */
import java.util.Scanner;

public class Lab06_Q1 {

    public static void main(String[] args) {
        int input;

        System.out.print("Enter number to be examined: ");
        Scanner scanner = new Scanner(System.in);
        input =  scanner.nextInt();

        System.out.println("Number of digits: " + countDigits(input) +
                "\nSum of digits: " + sumOfDigits(input));

        System.out.print(input + " is ");
        if (!isFibonacci(input)) {
            System.out.print("not ");
        }
        System.out.print("a Fibonacci number.\n");

        System.out.print(input + " is ");
        if (!isHarshad(input)) {
            System.out.print("not ");
        }
        System.out.print("a Harshad number.\n");

        System.out.print(input + " is ");
        if (!isNarcissistic(input)) {
            System.out.print("not ");
        }
        System.out.print("Narcissistic.\n");

        System.out.print(input + " is ");
        if (!isPrime(input)) {
            System.out.print("not ");
        }

        System.out.print("a Prime number. ");
        scanner.close();

    }
    public static boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }
        int number = i / 2;
        for (int a = 2; a <= number; a++) {
            if (i % a  == 0) {

                return false;
            }
        }
        return true;
    }
   public static int sumOfDigits(int i) {
       int sum = 0;

       while (i != 0) {
           sum = sum + i % 10;
           i = i / 10;
       }

       return sum;
    }

   public static boolean isHarshad(int i) {
    if (i % sumOfDigits(i) == 0) {
        return true;
    }
    return false;

    }

   static boolean isPerfectSquare(int i) {
        if ((int) Math.sqrt(i) * Math.sqrt(i) == i) {
            return true;
        }
        return false;
    }

   static boolean isFibonacci(int i) {
      int case1 =  (i*i*5) + 4;
      int case2=  (i*i*5) - 4;
       if (isPerfectSquare(case1) || isPerfectSquare(case2) )
             return true;
       return false;
    }

    static int power (int n , int p) {
        int result = 1;
        for (int i = 1; i <= p ; i++) {
            result = result * n;
        }
        return result;
    }
    static int countDigits(int c) {
        int count = 0;
        while (c >0) {
            c = c / 10;
            count++;
        }
        return count;
   }
    static boolean isNarcissistic(int i) {
        int sum = 0;
        int number = i;
      while (i != 0) {
          sum = sum + power(i % 10 , countDigits(number));
          i = i / 10;
      }
      if (sum == number) {
          return true;
      }
      return false;
    }

}