/**
 * This Class launches the Game Arena with a Boarder
 * @author Daniel Lewis
 *
 */


public class Gameplay {
/**
	 * @param GAWMax Gets the Max Width Coordinate of the GameArena on the X-Axis
	 * @param GAHMax Gets the Max Height Coordinate of the GameArena on the Y-Axis
	 * @param GAWMid Calculates the Central Coordinate of the GameArena on the X-Axis
	 * @param GAHMid Calculates the Central Coordinate of the GameArena on the Y-Axis
	 * @param GAWMin Calculates the Minimum Coordinate of the GameArena on the X-Axis
	 * @param GAHMin Calculates the Minimum Coordinate of the GameArena on the Y-Axis
	 * @param EdgesX Calculates the space in the GameArena which is used for the boarders at the GAWMin and GAWMax and to Calculate the Play Area (PWMin & PWMax)
	 * @param EdgesY Calculates the space in the GameArena which is used for the boarders at the GAHMin and GAHMax and to Calculate the Play Area (PHMin & PHMax)
	 * @param PWMax Calculates the Playable Width Max Coordinate on the X-Axis Minus the Boarder (GAWMax-EdgesX)
	 * @param PHMAX Calculates the Playable Width Max Coordinate on the Y-Axis Minus the Boarder (GAHMax-EdgesY)
	 * @param PWMid Calculates the Central Coordinate of the Playable Area on the X-Axis (PWMax / 2)
	 * @param PHMid Calculates the Central Coordinate of the Playable Area on the Y-Axis (PHMax /2)
	 * @param PWMin Calculates the Minimum Coordinate of the Playable Area on the X-Axis
	 * @param PHMin Calculates the Minimum Coordinate of the Playable Area on the Y-Axis
	 * @param Nboard Creates a Rectangle to form a Border at the TOP of the GameArena
	 * @param Eboard Creates a Rectangle to form a Border at the RIGHT of the GameArena
	 * @param Sboard Creates a Rectangle to form a Border at the BOTTOM of the GameArena
	 * @param Wboard Creates a Rectangle to form a Border at the LEFT of the GameArena
	 */
	
	public void Gameplay () {
	
		GameArena arena = new GameArena (1000,1000);
		double GAWMax=arena.getArenaWidth (); // GameArena Max Width
		double GAHMax=arena.getArenaHeight (); // GameArena Max Height
		double GAWMid=arena.getArenaWidth() / 2; //GameArena Midpoint on X axis
		double GAHMid=arena.getArenaHeight() / 2; //Game Arena Midpoint on Y Axis
		double GAWMin=GAWMax-GAWMax; // GameArena Min Co-ordinate on X Axis
		double GAHMin=GAHMax-GAWMax; // GameArena Min Co-ordinate on Y Axis
		double EdgesX=(GAWMax*0.03); //X edges are 3% of total Gamearea
		double EdgesY=(GAHMax *0.08); // Y edges are 8% of total Gamearea
	
		// Calculate size of PlayArena
		double PWMax=GAWMax-EdgesX; // Max Play Arena Width
		double PHMax=GAHMax-EdgesY; // Max Play Height
		double PWMid=PWMax/2; // Middle Of Play Width
		double PHMid=PHMax/2; // Middle Of Play Height
		double PWMin=GAWMin+EdgesX; // Min play Area
		double PWHMin=GAHMin+EdgesY; // Max Play Area
		
		
		
		// Draw Boarder	
		Rectangle Sboard= new Rectangle(GAWMid,GAHMax,GAWMax,EdgesY,"#999999",0,0); //Bottom Border
		Rectangle Wboard= new Rectangle(GAWMin,GAHMid,EdgesX,GAHMax,"#999999",0,0); // Right Boarder
		Rectangle Nboard = new Rectangle(GAWMid,GAHMin,GAWMax,EdgesY,"#999999",0,0); // Top Boarder
		Rectangle Eboard = new Rectangle(GAWMax,GAHMid,EdgesX,GAHMax,"#999999",0,0); // Left Boarder
		arena.addRectangle(Nboard);
		arena.addRectangle(Eboard);
		arena.addRectangle(Sboard);
		arena.addRectangle(Wboard);
		
	}

}


