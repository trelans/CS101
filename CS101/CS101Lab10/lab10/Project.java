
public class Project {
    // Variables

    // static data members
    private static int INITIAL = 0;
    private static int MODIFIED = 1;
    private static int FINAL = 2;
    // instance data members

    private String ID;
    private double finalScore;
    private String segment;
    private String credibility;
    private int[] rawScores;
    private int[] modifiedScores;
    private Hackathon hackathon;

    public Project(String ID , int[] rawScores) {
        this.ID = ID;
        this.rawScores = rawScores;

        rawScores = new int[4];
        modifiedScores = new int[4];
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon hackathon) {
        this.hackathon = hackathon;
    }
    public void calcModifiedScores() {
        for (int i = 0; i < 4; i++) {
            modifiedScores[i] = rawScores[i];
        }
        int i2 = modifiedScores[1];
        int i3 = modifiedScores[2];
        int i4 = modifiedScores[3];
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


    }
    public void calcWeightAvg() {

      int indicatorCount =   hackathon.getIndicatorCount();
      int[] indicatorWeights = hackathon.getIndicatorWeights();
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
        }
        else if (finalScore >= 90) {
            segment = "A";
        }
        else if (finalScore >= 75) {
            segment = "B";
        }
        else if (finalScore >= 60) {
            segment = "C";
        }
        else if (finalScore >= 40) {
            segment = "D";
        }

    }
    public void calcCredibility() {
        if (segment.equals("A+")) {
           credibility = "Perfect";
        }
        else if (segment.equals("A")) {
            credibility = "Very Good";
        }
        else if (segment.equals("B")) {
            credibility = "Good";
        }
        else if (segment.equals("C")) {
            credibility = "Considerable";
        }
        else if (segment.equals("D")) {
            credibility = "Not appropriate";
        }

    }
    public String toString(int scoreType) {
        String result = "";
        if (scoreType == INITIAL)
             result = String.format("\n%-15s%-15d%-15d%-15d%-15d\n",ID,rawScores[0], rawScores[1], rawScores[2], rawScores[3]);
        else if (scoreType == MODIFIED)
             result = String.format("\n%-15s%-15d%-15d%-15d%-15d\n",ID,modifiedScores[0], modifiedScores[1], modifiedScores[2], modifiedScores[3]);
        else if (scoreType == FINAL)
             result = String.format("\n%-15s%-15d%-15d%-15d%-15d%-15.1f%-15s%-15s\n",ID,modifiedScores[0], modifiedScores[1], modifiedScores[2], modifiedScores[3],finalScore,segment,credibility);
        return result;
    }
}
