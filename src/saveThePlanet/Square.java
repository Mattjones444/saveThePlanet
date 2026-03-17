package saveThePlanet;

import java.util.Scanner;

public abstract class Square {
	
	private String name;
	
    public Square(String name) {
    	this.name=name;
		
	}
    
    public String getName() {
    	return name;
    }
    
    public abstract void landOn(Player player, Scanner scanner);

}

