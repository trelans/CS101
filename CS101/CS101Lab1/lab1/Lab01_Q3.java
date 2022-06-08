public class Lab01_Q3 {
    /*
     * This program prints information about the Turkey's and Worlds dry and water area.
     * 6 October 2021
     * @author Kutay Şenyiğit
     */
    public static void main(String[] args) {

        // Constants
        final double TOTAL_AREA_OF_WORLD = 510072000;
        final double PERCENTAGE_OF_AREA_COVERED_BY_WATER = 70.8;
        final double TOTAL_AREA_OF_TURKEY_PERCENTAGE = 0.1536;
        final double PERCENTAGE_OF_AREA_COVERED_BY_WATER_IN_TURKEY = 1.3;

        // Variables
        long areaOfWorldDry , areaOfWorldWater , turkeyArea, turkeyDryArea, turkeyWaterArea  ;
        double percentOfTurkeysDryArea , percentOfTurkeysWaterArea;

        // Calculations
        areaOfWorldWater = (long) (TOTAL_AREA_OF_WORLD * PERCENTAGE_OF_AREA_COVERED_BY_WATER) / 100;
        areaOfWorldDry= (long) TOTAL_AREA_OF_WORLD - areaOfWorldWater;
        turkeyArea = (long) (TOTAL_AREA_OF_WORLD * TOTAL_AREA_OF_TURKEY_PERCENTAGE) / 100;
        turkeyWaterArea = (long) (turkeyArea * PERCENTAGE_OF_AREA_COVERED_BY_WATER_IN_TURKEY) / 100;
        turkeyDryArea = turkeyArea - turkeyWaterArea;
        percentOfTurkeysDryArea = (double) turkeyDryArea / areaOfWorldDry * 100;
        percentOfTurkeysWaterArea = (double) turkeyWaterArea / areaOfWorldWater * 100;
        // Outputs
        System.out.println("Earth has " + areaOfWorldDry + "km2 dry land and " + areaOfWorldWater + "km2 water.");
        System.out.println("Turkey has " + turkeyDryArea + " km2 dry land and " + turkeyWaterArea + " km2 water.");
        System.out.println("Turkey has " + percentOfTurkeysDryArea  + " percent of the Earth's dry land.");
        System.out.println("Turkey has " + percentOfTurkeysWaterArea  + " percent of the Earth's water.");
    }
}
