import java.util.Scanner;

public class Lab02_Q1_Revision {
    /*
     * This program prints some calculations about rectangle.
     * 13 OCT 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {
	// Variables
        double radius , area, circumference ;

        Scanner scanner = new Scanner(System.in);
        // Gets input from user
        System.out.println("Enter the radius of the circle:");
        radius = scanner.nextDouble();
    
        scanner.close();
        // Calculations
        area = Math.PI * Math.pow(radius, 2);
        circumference = Math.PI * 2 * radius;

        // Outputs
        System.out.println("The area of the circle is : " + area );
        System.out.println("The circumference of the rectangle is :" + circumference);


    }
}
