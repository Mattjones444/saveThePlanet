package saveThePlanet;

import java.util.Scanner;

public class Area extends Square {

    private String field;
    private int purchaseCost;
    private int developmentCost;
    private int majorDevelopmentCost;
    private int baseUsageCost;
    private Player owner;
    private int developmentLevel;

    public Area(String name, String field, int purchaseCost, int developmentCost,
                int majorDevelopmentCost, int baseUsageCost) {
        super(name);
        this.field = field;
        this.purchaseCost = purchaseCost;
        this.developmentCost = developmentCost;
        this.majorDevelopmentCost = majorDevelopmentCost;
        this.baseUsageCost = baseUsageCost;
        this.owner = null;
        this.developmentLevel = 0;
    }

    public String getField() {
        return field;
    }

    public int getPurchaseCost() {
        return purchaseCost;
    }

    public int getDevelopmentCost() {
        return developmentCost;
    }

    public int getMajorDevelopmentCost() {
        return majorDevelopmentCost;
    }

    public int getBaseUsageCost() {
        return baseUsageCost;
    }

    public Player getOwner() {
        return owner;
    }

    public int getDevelopmentLevel() {
        return developmentLevel;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int calculateUsageCost() {
        return baseUsageCost * (developmentLevel + 1)*2;
    }

    public void offerDevelopment(Player player, Scanner scanner) {
        if (developmentLevel < 3) {
            System.out.println("This area is currently at development level " + developmentLevel + ".");
            System.out.println("Development cost: " + developmentCost);
            System.out.println("Current usage cost: " + calculateUsageCost());
            System.out.print("Would you like to develop it to level " + (developmentLevel + 1) + "? (Y/N): ");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                if (player.getResources() >= developmentCost) {
                    player.deductResources(developmentCost);
                    developmentLevel++;

                    System.out.println(getName() + " has been developed to level " + developmentLevel + ".");
                    System.out.println("New usage cost: " + calculateUsageCost());
                    System.out.println("Remaining resources: " + player.getResources());
                } else {
                    System.out.println("You do not have enough resources to develop this area.");
                }
            } else {
                System.out.println("No development made.");
            }
        } else {
            System.out.println("This area is already at the maximum development level.");
        }
    }

    @Override
    public void landOn(Player player, Scanner scanner) {

        if (owner == null) {
            System.out.println("This area is currently unowned.");
            System.out.println("Purchase cost: " + purchaseCost);
            System.out.print("Would you like to purchase it? (Y/N): ");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                if (player.getResources() >= purchaseCost) {
                    player.deductResources(purchaseCost);
                    owner = player;
                    player.addArea(this);

                    System.out.println(player.getName() + " now owns " + getName() + ".");
                    System.out.println("Remaining resources: " + player.getResources());
                } else {
                    System.out.println("You do not have enough resources to purchase this area.");
                }
            } else {
                System.out.println(player.getName() + " chose not to purchase " + getName() + ".");
            }

        } else if (owner == player) {
            System.out.println("You already own this area.");
            offerDevelopment(player, scanner);

        } else {
            int cost = calculateUsageCost();

            System.out.println(getName() + " is owned by " + owner.getName() + ".");
            System.out.println("Development level: " + developmentLevel);
            System.out.println("You must pay " + cost + " resources.");

            player.deductResources(cost);
            owner.addResources(cost);

            System.out.println(player.getName() + "'s remaining resources: " + player.getResources());
            System.out.println(owner.getName() + "'s new resources: " + owner.getResources());
        }
    }
}