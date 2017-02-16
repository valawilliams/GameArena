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
	 * @param EdgesX Calculates the space in the GameArena which is used for the boarders at the GAWMin and GAWMax and to Calculate the Play Area
	 * @param EdgesY Calculates the space in the GameArena which is used for the boarders at the GAHMin and GAHMax and to Calculate the Play Area
	 * @param PWMax Calculates the Playable Width Max Coordinate on the X-Axis Minus the Boarder
	 * @param PHMAX Calculates the Playable Width Max Coordinate on the Y-Axis Minus the Boarder
	 * @param PWMid Calculates the Central Coordinate of the Playable Area on the X-Axis
	 * @param PHMid Calculates the Central Coordinate of the Playable Area on the Y-Axis
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
		double GAWMid=arena.getArenaWidth()/2; //GameArena Midpoint on X axis
		double GAHMid=arena.getArenaHeight()/2; //Game Arena Midpoint on Y Axis
		double GAWMin=GAWMax-GAWMax; // GameArena Min Co-ordinate on X Axis
		double GAHMin=GAHMax-GAHMax; // GameArena Min Co-ordinate on Y Axis
		double EdgesX=GAWMax*0.03; //X edges are 3% of total Gamearea
		double EdgesY=GAHMax*0.08; // Y edges are 8% of total Gamearea
		double missedLine = GAHMax -25; //Red line at Bottom of GameArena
	
		// Calculate size of PlayArena
		double PWMax=GAWMax-EdgesX; // Max Play Arena Width
		double PHMax=GAHMax-20; // Max Play Height
		double PWMin=GAWMin+EdgesX; // Min play Area
		double PHMin=(GAHMin+(EdgesY-25)); // Max Play Area
		double PWMid=PWMax*0.5; // Middle Of Play Width
		double PHMid=PHMax*0.5; // Middle Of Play Height
		
		
		// Draw Boarder	
		Rectangle Wboard= new Rectangle(GAWMin,GAHMid,EdgesX,GAHMax,"#999999",0,0); // Right Boarder
		Rectangle Nboard = new Rectangle(GAWMid,GAHMin,GAWMax,EdgesY,"#999999",0,0); // Top Boarder
		Rectangle Eboard = new Rectangle(GAWMax,GAHMid,EdgesX,GAHMax,"#999999",0,0); // Left Boarder
		Rectangle Sboard = new Rectangle(GAWMid,GAHMax,PWMax,10,"#CC1100",0,0); // Bottom Boarder
		arena.addRectangle(Nboard);
		arena.addRectangle(Eboard);
		arena.addRectangle(Sboard);
		arena.addRectangle(Wboard);

		//Dropped Items Test Size = Ball Diameter 12 which equates to (24,24) Rectangle 
		}

}


