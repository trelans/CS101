import java.util.ArrayList;
import java.util.Scanner;





public class MusicAppReview {
    public static void main(String[] args) {
        int howManyLogin, howManyCreate;

        ArrayList<String> userNames = new ArrayList<String>();
        ArrayList<String> passwords = new ArrayList<String>();
        boolean login = false;
        
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        int input;
        ArrayList<Playlist> playlists = new ArrayList<Playlist>();
        Playlist playlist = null;
        

        System.out.println("--------------------------------------------------------\n" +
                    "Welcome to Music App! Get Ready to create your playlist!\n"  +
                    "--------------------------------------------------------\n" +
                    "Create a new User" );

        String usernameInput;
        String passwordInput;
        System.out.println("How many user you want to create? ");
        howManyCreate = 0;
        howManyCreate = scanner.nextInt();
    
      
        for(int i = 0 ; i < howManyCreate; i++) {
            scanner.nextLine();
            System.out.println("Enter username:");
            usernameInput =  scanner.nextLine();
            userNames.add(usernameInput);
            System.out.println("Enter password:");
            passwordInput = scanner.next();
            passwords.add(passwordInput);
        
        
        
            System.out.println("New user creation successful. Continue to login.");
        }
        while(!login) {
            System.out.println("Enter username:");
            usernameInput = scanner.next();
            System.out.println("Enter password");
            passwordInput = scanner.next();
            for(int i = 0; i < userNames.size(); i++) {
                if(userNames.get(i).equals(usernameInput)) {
                    if(passwords.get(i).equals(passwordInput)) {
                        login = true;
                    }
                }
            }
            if(!login) {
                System.out.println("User " + usernameInput +"does not exist! \nYou need to login first");
            }


        }
   


    



        if(login) {
        do {


            System.out.println( "Login successful!\n" +
                    "1 - Create a new Playlist\n" +
                    "2 - Display the Playlist\n" +
                    "3 - Sort the Playlist\n" +
                    "4 - Remove song by index from the current Playlist\n" +
                    "5 - Display all Playlists\n" +
                    "6 - Exit");

            input = scanner.nextInt();
                if (input == 1) {
                    // Create a new Playlist
                    playlist = new Playlist();
                    playlists.add(playlist);

                    System.out.println("How many songs do you want to add to playlist?:");
                    input = scanner.nextInt();
                    for (int i = 1; i <= input; i++) {
                        scanner.nextLine();
                        System.out.println( "Enter artist name for Song "+ i  + ": \n");
                        String artistName = scanner.nextLine();
                        System.out.println( "Enter album name for Song "+ i  + ": \n");
                        String albumName = scanner.nextLine();
                        System.out.println( "Enter song name for Song "+ i  + ": \n");
                        String songName = scanner.nextLine();
                        System.out.println( "Enter song duration in seconds for Song "+ i  + ": \n");
                        int songDuration = scanner.nextInt();
                        System.out.println( "Enter the times song has been played for Song "+ i  + ": \n");
                        int songTimesPlayed = scanner.nextInt();
                        Song song = new Song(songName, artistName, albumName , songDuration ,songTimesPlayed);

                        playlist.addSong(song);

                    }
                    // Setting playlist name
                    scanner.nextLine();
                    System.out.println("Enter playlist name: ");
                    String playlistName = scanner.nextLine();
                    playlist.setName(playlistName);

                    // Setting creator Name of playlist
                    System.out.println("Enter creator of playlist: ");
                    String creatorOfPlayList = scanner.nextLine();
                    playlist.setCreator(creatorOfPlayList);

                    // Setting genre of playlist
                    System.out.println("0-Country\n" +
                            "1-Electronic\n" +
                            "2-Pop Music\n" +
                            "3-Rock Music\n" +
                            "4-Jazz\n" +
                            "5-Classical");
                    int inp  = scanner.nextInt();
                    if (inp == 0) {
                        playlist.setGenre("Country");
                    }
                    else if (inp == 1) {
                        playlist.setGenre("Electronic");
                    }
                    else if (inp == 2) {
                        playlist.setGenre("Pop Music");
                    }
                    else if (inp == 3) {
                        playlist.setGenre("Rock Music");
                    }
                    else if (inp == 4) {
                        playlist.setGenre("Jazz");
                    }
                    else if (inp == 5) {
                        playlist.setGenre("Classical");
                    }
                }
                else if (input == 2) {
                    System.out.println("Displaying the playlist: " + playlist.getName());
                    System.out.println(playlist);
                }
                else if (input == 3) {
                    // Sort the Playlist
                    playlist.sortByDurationDesc();
                    System.out.println("Sorted playlists:\n" + playlist);

                }
                else if (input == 4) {
                    // Remove song by index from the current Playlist
                    System.out.println("Which song do you want to remove? (Remove by index)");
                    int inp = scanner.nextInt();
                    playlist.removeSong(inp);

                }
                else if (input == 5) {
                    // Display all Playlists
                    for (int i = 0; i < playlists.size(); i++) {
                        System.out.println( "Displaying the playlist: " + playlists.get(i).getName() + "\n");
                        System.out.println(playlists.get(i));

                    }
                }
                else if (input == 6) {
                    // Exit
                    isExit = true;
                }

        } while (!isExit);



       
    }

  
    scanner.close();

    }
 

}


