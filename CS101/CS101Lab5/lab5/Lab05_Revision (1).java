import java.util.Scanner;

/**
 * City Building Revision
 * @author __Kutay Senyigit___
 * @version __3 NOV 2021__
 */
public class Lab05_Revision {
    public static void main(String[] args) {
        // write your code here
        String inputCityBuilder;
        int max;
        int currentNumber = 0;;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter city plan string:");
        inputCityBuilder = scanner.nextLine();
        int numberOfD = 0;
        int currentPindex = -10;
        boolean isAfterP = false;
        int afterPnumber= -3123;
   
        max = 0;
        // Finding max int digit of given string
        if(Character.isDigit(inputCityBuilder.charAt(0))) {
            max = Integer.parseInt(inputCityBuilder.charAt(0) + "");
        }
        
        for (int i = 0; i < inputCityBuilder.length(); i++) {
            if(Character.isDigit(inputCityBuilder.charAt(i))) {
                currentNumber = Integer.parseInt(inputCityBuilder.charAt(i) + "");
                if (currentNumber >= max) {
                    max = currentNumber;
                }
            }
            else {
                i++;
            }
        }

        for (int lineNo = max; lineNo > 0;  lineNo--) {
            for (int i = 0; i < inputCityBuilder.length(); i++) {
                if(Character.isDigit(inputCityBuilder.charAt(i))) {
                  if(currentPindex + 1 != i) {
                    currentNumber  = Integer.parseInt(inputCityBuilder.charAt(i) + "");
                    if(i == currentPindex + 2) {
                        isAfterP = false;
                    }
                    if (lineNo <= currentNumber ) {
                    
                            System.out.print("*");
                
    

                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
                else {
                    if(inputCityBuilder.charAt(i) == 'P') {
                        if(lineNo == 1) {
                             afterPnumber =  currentNumber  = Integer.parseInt(inputCityBuilder.charAt(i+1) + "");
                            currentPindex = i;
                        
                            isAfterP = true;
                            for (int j = 0; j < afterPnumber; j++) {
                               System.out.print("*");
                            }
                    
                        }
                        else {
                            afterPnumber =  currentNumber  = Integer.parseInt(inputCityBuilder.charAt(i+1) + "");
                            for (int j = 0; j < afterPnumber; j++) {
                                System.out.print(" ");
                            }
                         
                        
                        }
                        currentPindex = i;
                    }
                }
            }
            System.out.println();
        }
       
        scanner.close();
        
    }
}
