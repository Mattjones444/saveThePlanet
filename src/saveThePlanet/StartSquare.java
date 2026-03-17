package saveThePlanet;

import java.util.Scanner;

public class StartSquare extends Square {
	
    private int reward;

    public StartSquare(String name, int reward) {
        super(name);
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
    
    @Override
    public void landOn(Player player, Scanner scanner) {
        System.out.println("You landed on " + getName() + ".");
        System.out.println("You gained " + reward + " eco points.");
        player.addResources(reward);
        System.out.println("New balance: " + player.getResources());
    }

}
