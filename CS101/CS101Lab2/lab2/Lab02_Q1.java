import java.util.Scanner;

public class Lab02_Q1 {
    /*
     * This program prints some calculations about rectangle.
     * 12 OCT 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {
	// Variables
        double width, height, area, circumference, diagonal;

        Scanner scanner = new Scanner(System.in);
        // Gets input from user
        System.out.println("Enter the width of the rectangle:");
        width = scanner.nextDouble();
        System.out.println("Enter the height of the rectangle:");
        height = scanner.nextDouble();
        scanner.close();

        // Calculations
        area = width * height;
        circumference = (2 * height) + (2 * width);
        diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

        // Outputs
        System.out.println("The area of the rectangle is : " + area );
        System.out.println("The circumference of the rectangle is :" + circumference);
        System.out.println("The diagonal of the rectangle is : " + diagonal);

    }
}
