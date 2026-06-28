/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musicmanagement;

import java.util.Scanner;

/**
 *
 * @author votha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();
        player.loadSampleSongs();
        
        int choice;

        do {
            System.out.println("\n===== MUSIC MANAGEMENT =====");
            System.out.println("1. View All Songs");
            System.out.println("2. Add Song");
            System.out.println("3. Remove Song");
            System.out.println("4. Search Song");
            System.out.println("5. Play Repeat");
            System.out.println("6. Shuffle Play");
            System.out.println("7. Previous Song");
            System.out.println("8. Next Song");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("View All Songs selected.");
                    player.viewAllSongs();
                    break;
                case 2:
                    System.out.println("Add Song selected.");
                    break;
                case 3:
                    System.out.println("Remove Song selected.");
                    break;
                case 4:
                    System.out.println("Search Song selected.");
                    break;
                case 5:
                    System.out.println("Play Repeat selected.");
                    Song song = player.playRepeat();
                    if(song == null)
                        System.out.println("No song is playing");
                    else
                        System.out.println("Repeat: "+ song);
                    break;
                case 6:
                    System.out.println("Shuffle Play selected.");
                    break;
                case 7:
                    System.out.println("Previous Song selected.");
                    break;
                case 8:
                    System.out.println("Next Song selected.");
                    Song next = player.nextSong();
                    if(next == null)
                        System.out.println("Playlist is empty");
                    else
                        System.out.println("Now Playing: "+ next);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose from 0 to 8.");
            }
        } while (choice != 0);

        scanner.close();
    }
    
}
