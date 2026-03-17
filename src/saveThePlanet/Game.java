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
	

    }