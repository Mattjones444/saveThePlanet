package saveThePlanet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
    private List<Player> players;
    private Scanner scanner;
    private Dice dice;
	
    public Game() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
        dice = new Dice();
    }

    // Displays the name of the game at the beginning
    public void displayName() {
        System.out.println("====================================================");
        System.out.println("        🌍  WELCOME TO SAVE THE PLANET 🌱");
        System.out.println("====================================================");
        System.out.println("      Build sustainable projects and protect");
        System.out.println("        the future of our planet!");
        System.out.println();
        System.out.println("      Invest wisely. Develop responsibly.");
        System.out.println("             Every action matters.");
        System.out.println("====================================================");
    }
    
    // Setup the number of players and names of players
    public void setupPlayers() {

        System.out.print("Enter number of players (2-4): ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfPlayers; i++) {

            String name;
            boolean duplicate;

            do {
                duplicate = false;

                System.out.print("Enter name for Player " + (i + 1) + ": ");
                name = scanner.nextLine();

                for (Player player : players) {
                    if (player.getName().equalsIgnoreCase(name)) {
                        duplicate = true;
                        System.out.println("That name is already taken. Please choose a different name.");
                        break;
                    }
                }

            } while (duplicate);

            Player player = new Player(name, 100);
            players.add(player);

            System.out.println(name + " registered as Player " + (i + 1));
            System.out.println();
        }
    }
	

    }