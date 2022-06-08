public class Trainer {
    /* name: Full name of the trainer registered.
- speciality: The speciality of the trainer as text (e.g., physiotherapist, dietitian, gym coach etc.)
- isPlayerCovid: Holds the COVID-19 status of the player as a boolean. Value is true if the
player is tested covid positive.
- lastTestDate: Holds the value of the date when the player took a COVID test lastly. You can
assume that date is a String with “YYYY-MM-DD” format.
- injuryStatus: Shows the injury status of the player as text. If the player is healthy, the value is
null.
- player: An instance of the Player class which the trainer is responsible for.
*/
private String name;
private String speciality;
private boolean isPlayerCovid;
private String lastTestDate;
private String injuryStatus;
private Player player;

public Trainer(String name , String speciality , Player player) {
this.name = name;
this.speciality = speciality;
this.player = player;
lastTestDate = null;
isPlayerCovid = false;
injuryStatus = "Healthy";

}
public void recordCovidTest(boolean isCovid, String testDate ) {
    lastTestDate = testDate;
    isPlayerCovid = isCovid;
}
public void updateInjuryStatus(String status) {
injuryStatus = status;
if(status == null) {
injuryStatus = "Healthy";
}

}
public String toString () {
    String result = "************************************"+ 
    "\nTrainer Name: " + name + 
    "\nTrainer Specialty: " + speciality + 
    "\nPlayer Name: " + player.getName() +
    "\nIs COVID-19 positive?: " + isPlayerCovid +
    "\nLast test date: " + lastTestDate +
    "\nInjury status: " + injuryStatus +
    "\n************************************" ;
    return result;
}
}
