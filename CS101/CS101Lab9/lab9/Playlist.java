import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String name;
    private String creator;
    private String genre;
    private ArrayList<Song> songs;

    public Playlist(String name, String creator, String genre, ArrayList<Song> songs) {
        this.name = name;
        this.creator = creator;
        this.genre = genre;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public Playlist () {
     name = "";
     creator = "";
     genre = "";
     songs = new ArrayList<Song>();

    }

    public boolean songExists(Song song) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).equals(song)) {
                return true;
            }
        }
        return false;
    }
    public void addSong( Song song) {
        if (!songExists(song)) {
            songs.add(song);
        }
        else {
            System.out.println("Song is already exist in the playlist!");
        }

    }
    public void removeSong(int index) {
        if (songs.size() < (index + 1)) {
            System.out.println("Could not delete! Song does not exist in the playlist!");
        }else {
            songs.remove(index);
        }

        /*
        if (songExists(song)) {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).equals(song)) {
                    songs.remove(i);
                }
            }


        }
        else {
            System.out.println("Could not delete! Song does not exist in the playlist!");
        }

         */
    }




    public void sortByDurationDesc() {
        Collections.sort(songs);

    }
    public String toString() {
       String result = "--------------------------------------------------------\n";
       result = result + "Playlist Name: " + name +
               "\nCreator Name: " + creator +
               "\nGenre: " + genre +
               "\n--------------------------------------------------------";
        for (int i = 0; i < songs.size(); i++) {
           result = result + songs.get(i).toString();
        }
        return result;
     }
 }
