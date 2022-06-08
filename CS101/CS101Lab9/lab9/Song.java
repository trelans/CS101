

public class Song implements Comparable{

    private String title;
    private String artist;
    private String album;
    private int duration;
    private int timePlayed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String secToMinDuration(int duration) {
        // 210

        int sec = duration % 60;
        int min = duration / 60;
        if (sec < 10 ) {
            return min + ":0" + sec;
        }
        return min + ":" + sec;
    }
    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public Song(String title, String artist, String album , int duration , int timePlayed ) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.timePlayed = timePlayed;
    }


    @Override
    public int compareTo(Object o) {
        Song other = (Song) o;

        return this.duration - other.duration;

    }
    public String toString(){
        String result = "\n--------------------------------------------------------\n";
        result = result + "Song Name: " + this.title +
        "\nArtist Name: " + artist +
        "\nAlbum Name: " + album +
        "\nDuration: " + secToMinDuration(duration) +
        "\nTimes Played: " + timePlayed;

        return result;
    }
}
