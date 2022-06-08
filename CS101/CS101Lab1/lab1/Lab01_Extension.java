public class Lab01_Extension {
    /*
     * This program prints information about the Turkey's and Worlds dry and water area.
     * 6 October 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {

        // Constants
        final double TOTAL_AREA_OF_WORLD = 510072000;
        final double PERCENTAGE_OF_AREA_COVERED_BY_WATER = 70.8;
        final long TOTAL_AREA_OF_TURKEY = 783469;
        final double PERCENTAGE_OF_AREA_COVERED_BY_WATER_IN_TURKEY = 1.3;

        // Variables
        long areaOfWorldDry , areaOfWorldWater , turkeyDryArea, turkeyWaterArea  ;
        double percentOfTurkeysDryArea , percentOfTurkeysWaterArea;

        // Calculations
        areaOfWorldWater = (long) (TOTAL_AREA_OF_WORLD * PERCENTAGE_OF_AREA_COVERED_BY_WATER) / 100;
        areaOfWorldDry= (long) TOTAL_AREA_OF_WORLD - areaOfWorldWater;
    
        turkeyWaterArea = (long) (TOTAL_AREA_OF_TURKEY * PERCENTAGE_OF_AREA_COVERED_BY_WATER_IN_TURKEY) / 100;
        turkeyDryArea = TOTAL_AREA_OF_TURKEY - turkeyWaterArea;
        percentOfTurkeysDryArea = (double) turkeyDryArea / areaOfWorldDry * 100;
        percentOfTurkeysWaterArea = (double) turkeyWaterArea / areaOfWorldWater * 100;

        // Outputs
        System.out.println("Earth has " + areaOfWorldDry + "km2 dry land and " + areaOfWorldWater + "km2 water.");
        System.out.println("Turkey has " + turkeyDryArea + " km2 dry land and " + turkeyWaterArea + " km2 water.");
        System.out.println("Turkey has " + percentOfTurkeysDryArea  + " percent of the Earth's dry land.");
        System.out.println("Turkey has " + percentOfTurkeysWaterArea  + " percent of the Earth's water.");
    }
}
