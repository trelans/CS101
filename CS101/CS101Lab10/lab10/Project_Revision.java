import java.util.ArrayList;
import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;
import java.util.function.IntBinaryOperator;

public class Project_Revision {
    // Variables
    static String[][] investableArray = new String[3][Hackathon.getMaxNoOfProjects() + 2] ;
    boolean isInvestable;
    static int totalInvestmentRequired = 0;
    // static data members
    private static int INITIAL = 0;
    private static int MODIFIED = 1;
    private static int FINAL = 2;
    private static int investableProjectCount = 0;
    // instance data members
   static ArrayList<Project_Revision> projectsAPlus = new ArrayList<>();
   static ArrayList<Project_Revision> projectsA = new ArrayList<>();
   static ArrayList<Project_Revision> projectsB = new ArrayList<>();
   static ArrayList<Project_Revision> projectsC = new ArrayList<>();
   static ArrayList<Project_Revision> projectsD = new ArrayList<>();

   static ArrayList<Project_Revision> portfolio = new ArrayList<>();

   private String ID;
    private double finalScore;
    private String segment;
    private String credibility;
    private int[] rawScores;
    private int[] modifiedScores;
    private Hackathon_Revision hackathon;


    public Project_Revision(String ID , int[] rawScores) {
        this.ID = ID;
        this.rawScores = rawScores;

        rawScores = new int[Hackathon_Revision.getIndicatorCount()];
        modifiedScores = new int[Hackathon_Revision.getIndicatorCount()];
        investableArray[0][0] = "ProjectID";
        investableArray[1][0] = "Capital";
        investableArray[2][0] = "Payback";
        isInvestable = false;
    }

    public Hackathon_Revision getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon_Revision hackathon) {
        this.hackathon = hackathon;
    }
    public String getId() {
        return ID;
    }
    public void calcModifiedScores() {
        for (int i = 0; i < Hackathon_Revision.getIndicatorCount(); i++) {
            modifiedScores[i] = rawScores[i];
        }
        int i2 = modifiedScores[1];
        int i3 = modifiedScores[2];
        int i4 = modifiedScores[3];
        int i5 = modifiedScores[4];

        if (i2 > 0 && i2 <= 500) {
            modifiedScores[1] = 20;
        }
        else if (i2 > 500 && i2 <= 1000) {
            modifiedScores[1] = 80;
        }
        else if (i2 > 1000) {
            modifiedScores[1] = 100;
        }
        if (i3 > 0 && i3 <= 6) {
            modifiedScores[2] = 100;
        }
        else if (i3 > 6 && i3 <= 12) {
            modifiedScores[2] = 80;
        }
        else if (i3 > 12) {
            modifiedScores[2] = 20;
        }
        if (i4 >= 0 && i4 < 10) {
            modifiedScores[3] = 20;
        }
        else if (i4 >= 10 && i4 < 15) {
            modifiedScores[3] = 80;
        }
        else if (i4 >= 15) {
            modifiedScores[3] = 100;
        }   
         if (i5 > 0 && i5 <= 1000000) {
            modifiedScores[4] = 100;
        }
        else if (i5 >= 1000000 && i5 < 1500000) {
            modifiedScores[4] = 80;
        }
        else if (i5 >= 1500000) {
            modifiedScores[4] = 20;
        }


    }
    public void calcWeightAvg() {

      int indicatorCount =   Hackathon_Revision.getIndicatorCount();
      int[] indicatorWeights = Hackathon_Revision.getIndicatorWeights();
        double sum1 = 0; double sum2= 0;
        for (int i = 0; i < indicatorCount; i++) {
            sum1 = sum1 +(indicatorWeights[i] * modifiedScores[i]);
            sum2 = sum2 + (indicatorWeights[i]);
        }
        finalScore = sum1 / sum2;

    }
    public void calcSegment() {
        if (finalScore == 100) {
            segment = "A+";
            projectsAPlus.add(this);
        }
        else if (finalScore >= 90) {
            segment = "A";
            projectsA.add(this);
        }
        else if (finalScore >= 75) {
            segment = "B";
            projectsB.add(this);
        }
        else if (finalScore >= 60) {
            segment = "C";
            projectsC.add(this);
        }
        else if (finalScore >= 40) {
            segment = "D";
            projectsD.add(this);
        }

    }
    public void calcCredibility() {
        if (segment.equals("A+") && modifiedScores[4] == 100 || modifiedScores[4] == 80 || modifiedScores[4] == 20 ) {
           credibility = "INVEST";
           investableProjectCount++;
           isInvestable = true;
        }
        else if (segment.equals("A") && modifiedScores[4] == 100 || modifiedScores[4] == 80 || modifiedScores[4] == 20 ) {
            credibility = " INVEST";
            investableProjectCount++;
            isInvestable = true;
        }
        else if (segment.equals("B")  && modifiedScores[4] == 100 || modifiedScores[4] == 80) {
            credibility = "INVEST";
            investableProjectCount++;
            isInvestable = true;
        }
        else if (segment.equals("C")  && modifiedScores[4] == 100) {
            credibility = "INVEST";
            investableProjectCount++;
            isInvestable = true;
        }
        else {
            credibility = "DO NOT INVEST";
        }
        if(isInvestable) {
           

               investableArray[0][investableProjectCount] = ID ;
               investableArray[1][investableProjectCount] = String.valueOf(rawScores[4])  ;
               investableArray[2][investableProjectCount] = String.valueOf(rawScores[3]) + "%" ;

               investableArray[0][investableProjectCount + 1] = "TOTAL: " ;
               investableArray[1][investableProjectCount + 1] = String.valueOf(calcsum1())  ;
               investableArray[2][investableProjectCount + 1] = String.valueOf(calcsum2())  ;
            
            
        }

    }
    private int calcsum1 () {
        int sum = 0;
        for(int i = 1; i < investableProjectCount + 1 ; i++ ) {
            sum += Integer.parseInt(investableArray[1][i]);
        }
        totalInvestmentRequired = sum;
        return sum;
    }
    private double calcsum2() {
        int result = 0;
        for(int i = 1; i < investableProjectCount + 1 ; i++ ) {
            String f = investableArray[1][i].substring(0,investableArray[1][i].length() -1 );
            String s = investableArray[2][i].substring(0,investableArray[2][i].length()-1);
              
          int i1 = Integer.parseInt(f);
            int i2 = Integer.parseInt(s);

           result +=  (double )( i1 * i2)  / 100;
        }
        return result;
    }
    public static int getInvestableProjectCount() {
        return investableProjectCount;
    }
    public void makeDecision () {

        System.out.println("TASK 1");
        
        for(int j = 0; j <  investableArray[0].length; j++) {
            for(int i = 0 ; i < investableArray.length; i++) {
                if(investableArray[i][j] != null)
                     System.out.print(investableArray[i][j] + " ");
            }
            System.out.println("");
        }
     
//    System.out.println(Arrays.deepToString(investableArray));

        System.out.println("TASK 2");
        int currentSum = 0;
        int remainAmount = Hackathon_Revision.MAX_INVESTABLE_AMOUNT;
        if(Hackathon_Revision.GetBudget() < totalInvestmentRequired)  {
            int currentprice= 0;
            System.out.println("We cannot invest in all projects, we have to discard some of them.");
             int projectCount = hackathon.GetProjectCount();
             boolean isfinished = false;
            while(remainAmount > 0 && projectCount != 0 && !isfinished) {
                if(projectsAPlus.size() > 0) {
                    for(int i = 0; i < projectsAPlus.size(); i++) {
                      Project_Revision currentProject =  projectsAPlus.get(i);
                      if(currentProject.isInvestable) {
                          currentprice = currentProject.rawScores[4];
                          if(remainAmount - currentprice < 0) {
                              isfinished = true;
                              break;
                          }
                          else {
                              currentSum += currentprice;
                              remainAmount -= currentprice;
                              portfolio.add(currentProject);
                              projectCount--;
                          }
                      }

                    }
                }
                if(projectsA.size() > 0) {
                    for(int i = 0; i < projectsA.size(); i++) {
                      Project_Revision currentProject =  projectsA.get(i);
                      if(currentProject.isInvestable) {
                          currentprice = currentProject.rawScores[4];
                          if(remainAmount - currentprice < 0) {
                            isfinished = true;
                              break;
                          }
                          else {
                              currentSum += currentprice;
                              remainAmount -= currentprice;
                              portfolio.add(currentProject);
                              projectCount--;
                          }
                      }

                    }
                }
                if(projectsB.size() > 0) {
                    for(int i = 0; i < projectsB.size(); i++) {
                      Project_Revision currentProject =  projectsB.get(i);
                      if(currentProject.isInvestable) {
                          currentprice = currentProject.rawScores[4];
                          if(remainAmount - currentprice < 0) {
                            isfinished = true;
                              break;
                          }
                          else {
                              currentSum += currentprice;
                              remainAmount -= currentprice;
                              portfolio.add(currentProject);
                              projectCount--;
                          }
                      }

                    }
                }
                if(projectsC.size() > 0) {
                    for(int i = 0; i < projectsC.size(); i++) {
                      Project_Revision currentProject =  projectsC.get(i);
                      if(currentProject.isInvestable) {
                          currentprice = currentProject.rawScores[4];
                          if(remainAmount - currentprice < 0) {
                            isfinished = true;
                              break;
                          }
                          else {
                              currentSum += currentprice;
                              remainAmount -= currentprice;
                              portfolio.add(currentProject);
                              projectCount--;
                          }
                      }

                    }
                }
             
            }
           
        }

        System.out.println("Final Portfolio: ");
        String ids = "";
        for(int i = 0 ; i < portfolio.size(); i++) {
            ids += portfolio.get(i).getId() + ", ";
        }
        System.out.print(ids);

        System.out.println("Invested Amount: " + currentSum);
        System.out.println("Rest of Budget: " + remainAmount);

    }
    public String toString(int scoreType) {
        String result = "";
        if (scoreType == INITIAL)
             result = String.format("\n%-15s%-15d%-15d%-15d%-15d%-15d\n",ID,rawScores[0], rawScores[1], rawScores[2], rawScores[3], rawScores[4]);
        else if (scoreType == MODIFIED)
             result = String.format("\n%-15s%-15d%-15d%-15d%-15d%-15d\n",ID,modifiedScores[0], modifiedScores[1], modifiedScores[2], modifiedScores[3] , modifiedScores[4]);
        else if (scoreType == FINAL)
             result = String.format("\n%-15s%-15d%-15d%-15d%-15d%-15d%-15.1f%-15s%-15s\n",ID,modifiedScores[0], modifiedScores[1], modifiedScores[2], modifiedScores[3], modifiedScores[4],finalScore,segment,credibility);
        return result;
    }
}
