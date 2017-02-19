/**
 * This Class launches the Game Arena with a Border
 * @author Daniel Lewis
 *
 */


public class Gameplay {

	/** Constructor
	 * @param GAWMax Gets the Max Width Coordinate of the GameArena on the X-Axis
	 * @param GAHMax Gets the Max Height Coordinate of the GameArena on the Y-Axis
	 * @param GAWMid Calculates the Central Coordinate of the GameArena on the X-Axis
	 * @param GAHMid Calculates the Central Coordinate of the GameArena on the Y-Axis
	 * @param GAWMin Calculates the Minimum Coordinate of the GameArena on the X-Axis
	 * @param GAHMin Calculates the Minimum Coordinate of the GameArena on the Y-Axis
	 * @param EdgesX Calculates the space in the GameArena which is used for the borders at the GAWMin and GAWMax and to Calculate the Play Area
	 * @param EdgesY Calculates the space in the GameArena which is used for the borders at the GAHMin and GAHMax and to Calculate the Play Area
	 * @param PWMax Calculates the Playable Width Max Coordinate on the X-Axis Minus the Border
	 * @param PHMAX Calculates the Playable Width Max Coordinate on the Y-Axis Minus the Border
	 * @param PWMid Calculates the Central Coordinate of the Playable Area on the X-Axis
	 * @param PHMid Calculates the Central Coordinate of the Playable Area on the Y-Axis
	 * @param PWMin Calculates the Minimum Coordinate of the Playable Area on the X-Axis
	 * @param PHMin Calculates the Minimum Coordinate of the Playable Area on the Y-Axis
	 * @param Nboard Creates a Rectangle to form a Border at the TOP of the GameArena
	 * @param Eboard Creates a Rectangle to form a Border at the RIGHT of the GameArena
	 * @param Sboard Creates a Rectangle to form a Border at the BOTTOM of the GameArena
	 * @param Wboard Creates a Rectangle to form a Border at the LEFT of the GameArena
	 */
	
	public Gameplay() 
	{
		// create the game arena
		GameArena arena = new GameArena(900,900);	// decreased from 1000 to fit on screen

		double GAWMax = arena.getArenaWidth(); 		// arena Max Width
		double GAHMax = arena.getArenaHeight();		// arena Max Height
		double GAWMid = arena.getArenaWidth()/2;	// arena Midpoint on X axis
		double GAHMid = arena.getArenaHeight()/2;	// arena Midpoint on Y Axis
		double GAWMin = GAWMax - GAWMax;		// arena Min Co-ordinate on X Axis
		double GAHMin = GAHMax - GAHMax;		// arena Min Co-ordinate on Y Axis
		double EdgesX = GAWMax*0.03;			// X edges are 3% of total arena
		double EdgesY = GAHMax*0.08;			// Y edges are 8% of total arena
		double missedLine = GAHMax - 25; 		// Red line at Bottom of arena
	
		// Calculate size of PlayArena
		double PWMax = GAWMax - EdgesX;			// Max Play Arena Width
		double PHMax = GAHMax - 20;			// Max Play Height
		double PWMin = GAWMin + EdgesX;			// Min play Area
		double PHMin = (GAHMin + (EdgesY - 25));	// Max Play Area
		double PWMid = PWMax*0.5;			// Middle Of Play Width
		double PHMid = PHMax*0.5;			// Middle Of Play Height
		
		
		// Draw Border	
		Rectangle Wborder = new Rectangle(GAWMin,GAHMid,EdgesX,GAHMax,"#999999",0,0);	// Right Border
		Rectangle Nborder = new Rectangle(GAWMid,GAHMin,GAWMax,EdgesY,"#999999",0,0);	// Top Border
		Rectangle Eborder = new Rectangle(GAWMax,GAHMid,EdgesX,GAHMax,"#999999",0,0);	// Left Border
		Rectangle Sborder = new Rectangle(GAWMid,GAHMax,PWMax,10,"#CC1100",0,0);	// Bottom Border
		arena.addRectangle(Nborder);
		arena.addRectangle(Eborder);
		arena.addRectangle(Sborder);
		arena.addRectangle(Wborder);

		//Dropped Items Test Size = Ball Diameter 12 which equates to (24,24) Rectangle

		// create a raindrop in th centre of the arena for test purposes
		Raindrop raindrop = new Raindrop(PWMid, PHMid, 50, 20, 10, arena);
	}
}


