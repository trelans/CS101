import java.security.PublicKey;

public class Hackathon_Revision {
    static int MAX_NO_OF_PROJECTS = 9;
    static int INDICATOR_COUNT = 5  ;
    static int[] INDICATOR_WEIGHTS = new int[]{10, 15, 20, 25, 30};
    static int MAX_INVESTABLE_AMOUNT = 1500000;

    int projectCount;
    Project_Revision[] projects;

    public Hackathon_Revision() {
        projectCount  = 0;
        projects = new Project_Revision[MAX_NO_OF_PROJECTS];

    }
    public int GetProjectCount() {
        return projectCount;
    }
    public static int getMaxNoOfProjects() {
        return MAX_NO_OF_PROJECTS;
    }
    public static int getIndicatorCount() {
        return INDICATOR_COUNT;
    }
    public static int[] getIndicatorWeights() {
        return INDICATOR_WEIGHTS;
    }

    public void addProject(Project_Revision project) {
       projects[projectCount] = project;
       projectCount++;
       project.setHackathon(this);

    }
    public String toString(int scoreType) {
        String result = "";

        if (scoreType == 0 || scoreType == 1) {
            if (scoreType == 0) {
                result += "Initial Table\n";
            }
            else {
                result += "Modified Table\n";
            }
            result = result + "***********************************************************************" +
                   String.format("\n%-15s%-15s%-15s%-15s%-15s%-15s\n","Project ID","Indicator 1", "Indicator 2", "Indicator 3", "Indicator 4", "Indicator 5");
            for (int i = 0; i < projectCount ; i++) {
                result += projects[i].toString(scoreType);
            }
            result += "***********************************************************************";
        }
        else if (scoreType == 2) {
            result = "Final Table\n************************************************************************************************************************" +
                   String.format("\n%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n","Project ID","Indicator 1", "Indicator 2", "Indicator 3", "Indicator 4","Indicator 5", "Weighted Mean", "Segment", "Credibility");
            for (int i = 0; i < projectCount ; i++) {
                result += projects[i].toString(scoreType);
            }
            result += "************************************************************************************************************************";

        }
        else {
            result = "Error: Invalid Score Type";
        }

        return result;
    }
 
    public static void main(String[] args) {

        Hackathon_Revision hackathon =  new Hackathon_Revision();
        Project_Revision project1 = new Project_Revision("A1" , new int[]{100,240, 15, 26 , 67991});
        Project_Revision project2 = new Project_Revision("A2" , new int[]{20,407, 13, 11, 860657});
        Project_Revision project3 = new Project_Revision("A3" , new int[]{100,281, 13, 39, 193696});
        Project_Revision project4 = new Project_Revision("A4" , new int[]{80,1264, 4, 38, 382208});
        Project_Revision project5 = new Project_Revision("A5" , new int[]{20,1020, 12, 11, 958624});
        Project_Revision project6 = new Project_Revision("A6" , new int[]{100,1162, 17, 34, 1140003});

        hackathon.addProject(project1);
        hackathon.addProject(project2);
        hackathon.addProject(project3);
        hackathon.addProject(project4);
        hackathon.addProject(project5);
        hackathon.addProject(project6);


        project1.calcModifiedScores();
        project2.calcModifiedScores();
        project3.calcModifiedScores();
        project4.calcModifiedScores();
        project5.calcModifiedScores();
        project6.calcModifiedScores();

        project1.calcWeightAvg();
        project2.calcWeightAvg();
        project3.calcWeightAvg();
        project4.calcWeightAvg();
        project5.calcWeightAvg();
        project6.calcWeightAvg();

        project1.calcSegment();
        project2.calcSegment();
        project3.calcSegment();
        project4.calcSegment();
        project5.calcSegment();
        project6.calcSegment();


        project1.calcCredibility();
        project2.calcCredibility();
        project3.calcCredibility();
        project4.calcCredibility();
        project5.calcCredibility();
        project6.calcCredibility();





        System.out.println(  hackathon.toString(0));
        System.out.println();
        System.out.println(  hackathon.toString(1));
        System.out.println();
        System.out.println(  hackathon.toString(2));
     
        project6.makeDecision();

    }
    public static int GetBudget() { return MAX_INVESTABLE_AMOUNT;}

}
