import java.util.Scanner;

public class Lab02_Q2 {
    /*
     * This program prints some calculations about odometer.
     * 12 OCT 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {

        // Constants
    final double KILOMETERS_COST = 0.1;
    final int OIL_CHANGE_PERCENTAGE = 30;
    final int BATTERY_PERCENTAGE = 15;
    final int BRAKES_PERCENTAGE = 25;
    final int TIRE_PERCENTAGE = 13;
    final int OTHER_PERCENTAGE = 17;

        // Variables
        double kilometersTraveled;
        double kilometersCost;
        double oilChange;
        double batteryPercentage;
        double brakes;
        double tire;
        double other;

        // Getting Input
        System.out.print("Enter the odometer reading of the car in kilometers: ");
        Scanner scan = new Scanner(System.in);
        kilometersTraveled = scan.nextDouble();
        scan.close();
        // Calculations
        kilometersCost = kilometersTraveled * KILOMETERS_COST;
        oilChange = kilometersCost * OIL_CHANGE_PERCENTAGE / 100;
        batteryPercentage = kilometersCost * BATTERY_PERCENTAGE / 100;
        brakes = kilometersCost * BRAKES_PERCENTAGE / 100;
        tire = kilometersCost * TIRE_PERCENTAGE / 100;
        other = kilometersCost * OTHER_PERCENTAGE / 100;
        //  Outputs
        System.out.println();
        System.out.println("***************************************************");
        System.out.printf("*****%-3s%-5s%-3s%-1s\n","" ,"Maintenance Cost Distribution Table","", "*****");
        System.out.println("***************************************************");
        System.out.printf("*%-22s%%%-10d%13.2f%4s\n", "Oil Change", OIL_CHANGE_PERCENTAGE, oilChange, "*");
        System.out.printf("*%-22s%%%-10d%13.2f%4s\n", "Battery", BATTERY_PERCENTAGE, batteryPercentage, "*");
        System.out.printf("*%-22s%%%-10d%13.2f%4s\n", "Brakes", BRAKES_PERCENTAGE, brakes, "*");
        System.out.printf("*%-22s%%%-10d%13.2f%4s\n", "Tire", TIRE_PERCENTAGE, tire, "*");
        System.out.printf("*%-22s%%%-10d%13.2f%4s\n", "Other", OTHER_PERCENTAGE, other, "*");
        System.out.printf("*%-22s%-11s%13.2f%4s\n", " ", "TOTAL", kilometersCost , "*");
        System.out.println("***************************************************");
    }
}
