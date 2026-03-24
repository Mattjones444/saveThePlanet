package saveThePlanet;

import java.util.ArrayList;
import java.util.List;


public class Player {
	
	
	
	private String name;
    private int resources;
    private int position;
    private List<Area> ownedAreas;

    public Player(String name, int startingResources) {
        this.name = name;
        this.resources = startingResources;
        this.position = 0;
        this.ownedAreas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getResources() {
        return resources;
    }

    public int getPosition() {
        return position;
    }

    public List<Area> getOwnedAreas() {
        return ownedAreas;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void addResources(int amount) {
        resources += amount;
    }

    public void deductResources(int amount) {
        resources -= amount;
        if (resources < 0) {
            resources = 0;
        }
    }

    public void addArea(Area area) {
        ownedAreas.add(area);
    }

    public boolean isOutOfResources() {
        return resources <= 0;
    }

    public void displayStatus() {
        System.out.println("Player: " + name);
        System.out.println("Resources: " + resources);
        System.out.println("Position: " + position);
        System.out.println("Owned areas: " + ownedAreas.size());
    }
    
    public void displayBalance() {
        System.out.println(name + "'s current resources: " + resources);
    }

}
