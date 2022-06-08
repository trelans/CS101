

public class Hackathon {
    static int MAX_NO_OF_PROJECTS = 9;
    static int INDICATOR_COUNT = 4  ;
    static int[] INDICATOR_WEIGHTS = new int[]{10 ,25,30,35};
    

    int projectCount;
    Project[] projects;

    public Hackathon() {
        projectCount  = 0;
        projects = new Project[MAX_NO_OF_PROJECTS];

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

    public void addProject(Project project) {
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
                   String.format("\n%-15s%-15s%-15s%-15s%-15s\n","Project ID","Indicator 1", "Indicator 2", "Indicator 3", "Indicator 4");
            for (int i = 0; i < projectCount ; i++) {
                result += projects[i].toString(scoreType);
            }
            result += "***********************************************************************";
        }
        else if (scoreType == 2) {
            result = "Final Table\n************************************************************************************************************************" +
                   String.format("\n%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n","Project ID","Indicator 1", "Indicator 2", "Indicator 3", "Indicator 4", "Weighted Mean", "Segment", "Credibility");
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

        Hackathon hackathon =  new Hackathon();
        Project project1 = new Project("A1" , new int[]{100,240, 15, 26});
        Project project2 = new Project("A2" , new int[]{20,407, 13, 11});
        Project project3 = new Project("A3" , new int[]{100,281, 13, 39});
        Project project4 = new Project("A4" , new int[]{80,1264, 4, 38});
        Project project5 = new Project("A5" , new int[]{20,1020, 12, 11});
        Project project6 = new Project("A6" , new int[]{100,1162, 17, 34});

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

    }

}
