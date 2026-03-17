package saveThePlanet;
import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Square>squares;
	
	
	public Board() {
		squares=new ArrayList<>();
		setupBoard();
	}
	
	public void setupBoard() {
		squares.clear();
		
		squares.add(new StartSquare("Eco Hub", 50));
		
        // Field 1 - 3 areas
        squares.add(new Area("Solar Farm", "Renewable Energy", 30, 15, 25, 10));
        squares.add(new Area("Wind Turbine Site", "Renewable Energy", 35, 15, 25, 12));
        squares.add(new Area("Hydro Plant", "Renewable Energy", 40, 20, 30, 14));

        // Field 2 - 3 areas
        squares.add(new Area("Forest Restoration", "Conservation", 45, 20, 35, 16));
        squares.add(new Area("Wetland Protection", "Conservation", 50, 20, 35, 18));
        squares.add(new Area("Wildlife Reserve", "Conservation", 55, 25, 40, 20));
        
        // Neutral square
        squares.add(new NeutralSquare("Community Awareness Day"));
        
        // Field 3 - 2 areas (least costly)
        squares.add(new Area("Plastic Recycling", "Recycling", 20, 10, 20, 8));
        squares.add(new Area("Metal Recycling", "Recycling", 25, 10, 20, 10));

        // Field 4 - 2 areas (most costly)
        squares.add(new Area("Electric Bus Network", "Green Transport", 60, 30, 50, 22));
        squares.add(new Area("High-Speed Rail Hub", "Green Transport", 70, 35, 55, 26));
        
	}
        
        public Square getSquare(int position) {
            return squares.get(position);
        }

        public int getBoardSize() {
            return squares.size();
        }

        public List<Square> getSquares() {
            return squares;
        }
        
        public void displayBoard() {
            System.out.println("------ GAME BOARD ------");
            for (int i = 0; i < squares.size(); i++) {
                System.out.println(i + ": " + squares.get(i).getName());
            }
		
		
	}
}



