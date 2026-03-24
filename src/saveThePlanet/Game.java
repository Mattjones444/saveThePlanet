package saveThePlanet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	private static final int STARTING_RESOURCES = 100;
	
    private List<Player> players;
    private Scanner scanner;
    private Dice dice;
	
    public Game() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
        dice = new Dice();
    }

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

            Player player = new Player(name, STARTING_RESOURCES);
            players.add(player);

            System.out.println(name + " registered as Player " + (i + 1));
            System.out.println("Starting resources: " + player.getResources());
            System.out.println();
        }
    }

    public void takeTurn(Player player, Board board) {
        System.out.println("\n" + player.getName() + ", it's your turn.");
        player.displayBalance();
        System.out.print("Press Enter to roll the dice...");
        scanner.nextLine();

        int roll1 = dice.roll();
        int roll2 = dice.roll();
        int total = roll1 + roll2;

        System.out.println("You rolled " + roll1 + " and " + roll2 + " (Total: " + total + ")");

        int oldPosition = player.getPosition();
        int newPosition = (oldPosition + total) % board.getBoardSize();

        if (newPosition < oldPosition) {
            System.out.println("You passed Eco Hub! You gain 50 resources.");
            player.addResources(50);
            player.displayBalance();
        }

        player.setPosition(newPosition);

        Square square = board.getSquare(newPosition);
        System.out.println("You landed on: " + square.getName());

        square.landOn(player, scanner);
    }

    public void startGame() {
    	boolean gameOver=false;
        displayName();
        setupPlayers();

        Board board = new Board();
         
    while(!gameOver) {
    	for(Player player:players) {
        	takeTurn(player,board);
        	
        	if(player.isOutOfResources()) {
        	    System.out.println(player.getName() + " has run out of resources!");
        	    gameOver = true;
        	    break;
        	}
        }
   
    }
        
       
    }
}