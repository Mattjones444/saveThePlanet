package saveThePlanet;

import java.util.Scanner;

public class NeutralSquare extends Square {
	
    public NeutralSquare(String name) {
        super(name);
    }

        @Override
        public void landOn(Player player, Scanner scanner) {
            System.out.println("This is a neutral square.");
            System.out.println("Nothing happens this turn.");
    }

}
