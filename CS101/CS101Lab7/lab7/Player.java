import javax.swing.plaf.BorderUIResource;

public class Player {
    // Variables

    // Static Data Members
    static int count = 0;
    static int allCount = 0;

    // Instance Data Members
    private int id;
    private String name;
    private String position;
    private String team;
    private int rosterNumber;
    private boolean isActive;

    private double gamesPlayed;
    private double pointsPerGame;
    private double assistsPerGame;
    private double reboundsPerGame;
    private double turnoversPerGame;
    private double efficiency;

    public Player(String name, String position, String team, int rosterNumber) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.rosterNumber = rosterNumber;
        gamesPlayed = 0;
        isActive = true;
        count++;
        allCount++;
        id = allCount;

        gamesPlayed = 0;
        pointsPerGame = 0;
        assistsPerGame = 0;
        reboundsPerGame = 0;
        turnoversPerGame = 0;
        efficiency = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        if (position.equals("SF") || position.equals("PF") || position.equals("SG") || position.equals("PG") || position.equals("C")){
            this.position = position;
        }
        else {
            System.out.println("Error: Invalid player position.");
        }
    }

    public void setRosterNumber(int rosterNumber) {
        this.rosterNumber = rosterNumber;
    }

    public String getName() {
        return name;
    }
    public double getEfficiency() {
        return efficiency;
    }
    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getId() {
        return id;
    }

    public int getRosterNumber() {
        return rosterNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void register(String name, String position, String team, int rosterNumber) {

        this.name = name;
        this.position = position;
        this.team = team;
        this.rosterNumber = rosterNumber;
        isActive = true;
        count++;
        allCount++;
        id = allCount;

    }
    public void remove() {
    count--;
    isActive = false;
    }
    public void retire() {
        count--;
        isActive = false;
    }
    public void transfer(String team) {
        if (!this.team.equals(team)) {
            this.team = team;
        }
        else {
            System.out.println("Player is already at " + team);
        }
    }
    public boolean isMoreEfficient (Player player) {
        if(this.efficiency > player.getEfficiency()) {
            return  true;
        }
        return false;
    }
    public boolean isBeforeThan( Player player) {
        return this.name.compareTo(player.getName()) < 0;
    }
    public void recordGame (int points , int assists, int rebounds , int turnovers) {

        double sumPoints, sumAssists, sumRebounds , sumTurnovers;
        sumPoints = pointsPerGame * gamesPlayed;
        sumAssists = assistsPerGame * gamesPlayed;
        sumRebounds = reboundsPerGame * gamesPlayed;
        sumTurnovers = turnoversPerGame * gamesPlayed;

        sumPoints += points;
        sumAssists += assists;
        sumRebounds += rebounds;
        sumTurnovers += turnovers;

        gamesPlayed++;

        pointsPerGame = sumPoints / gamesPlayed;
        assistsPerGame = sumAssists / gamesPlayed;
        reboundsPerGame = sumRebounds / gamesPlayed;
        turnoversPerGame = sumTurnovers / gamesPlayed;

        efficiency = pointsPerGame + (0.7 * assistsPerGame) + (0.7 * reboundsPerGame) - (0.9 * turnoversPerGame);
    }
    public String toString() {
        String result;
        result = "**************************************************\n" + "" +
                "Player ID: " + id + "\n" + "Player Name: " + name + "\nPlayer Position: " + position + "\n" + "Current Team: " + team + "\n" + "Jersey Number: " + rosterNumber +
        "\n--------------------------------------------------" +
        "\nStats: \n" + "PPG: " + pointsPerGame + "\nAPG: " + assistsPerGame + "\nRPG: " + reboundsPerGame + "\nTPG: " + turnoversPerGame + "\nEfficiency: " + efficiency +
        "\n--------------------------------------------------"
        + "\nRetirement Status:  ";
        if (isActive == true)
            result += "Active among " + count + " active player(s)";
        else {
            result += "Not Active";
        }
        result += "\n**************************************************";
        return result;
    }
}
