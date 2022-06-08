import java.util.Scanner;

public class Lab03_Q1 {
    /*
     * This program takes weight and height of a user and tell them their BMI;
     * 19 OCT 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {

        // Variables
        double weight, height , bmi;
        String category;

        Scanner scanner = new Scanner(System.in);

        // Getting input from user
        System.out.print("Enter your weight in kilograms:");
        weight = scanner.nextDouble();
        System.out.print("Enter your height in meters:");
        height = scanner.nextDouble();
        scanner.close();

        //Calculation
        bmi = weight / (Math.pow(height , 2));

        //Conditions
        if (bmi < 18.5) {
            category = "underweight";
        }
        else if (bmi > 18.5 && bmi < 25) {
            category = "healthy";
        }
        else if (bmi > 25 && bmi < 30) {
            category = "overweight";
        }
        else {
            category = "obese";
        }

        //Printing result
        System.out.println("Your BMI is " +  bmi +" and you are in the category of " + category );

    }
}

