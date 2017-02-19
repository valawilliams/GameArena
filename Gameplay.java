/**
 * This Class launches the Game Arena with a Border
 * @author Daniel Lewis
 *
 */

public class Gameplay {

	int maxArenaWidth = 900;
	int maxArenaHeight = 900;		// decreased from 1000 to fit on screen
	int maxRainDropSize = 50;		// size of rain drop (modified by level)
	int rainMovement = 5;			// distance for rain to fall (modified by level)
	String borderColour = "GREY";		// changed from "#999999"
	String bottomColour = "RED";		// changed from "#CC1100"

	// GameArena sizes/positions
	double GAWMax; 			// arena Max Width - right hand side of arena
	double GAHMax;			// arena Max Height - bottom of arena
	double GAWMid;			// arena Midpoint on X axis - middle of arena on x-axis
	double GAHMid;			// arena Midpoint on Y Axis - middle of arena on y-axis
	double GAWMin;			// arena Min Co-ordinate on X Axis - left hand side of arena
	double GAHMin;			// arena Min Co-ordinate on Y Axis - top of arena
	double EdgesX;			// X edges are 3% of total arena - width of left/right hand border
	double EdgesY;			// Y edges are 8% of total arena - depth of top border
	double missedLine; 		// Red line at Bottom of arena - ?GOD ALONE KNOWS?
	
	// Playable area sizes/positions
	double PWMax;			// Max Play Arena Width - right hand side of playable area
	double PHMax;			// Max Play Height - bottom of playable area
	double PWMin;			// Min play Area - left hand side of playable area
	double PHMin;			// Max Play Area - top of playable area
	double PWMid;			// Middle Of Play Width - middle of playable area on x-axis
	double PHMid;			// Middle Of Play Height - middle of playable area on y-axis

	GameArena arena = new GameArena(maxArenaWidth, maxArenaHeight);
	Raindrop raindrop[] = new Raindrop[100];	// maximum possible number of Raindrops


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
		// GameArena arena = new GameArena(maxArenaWidth, maxArenaHeight);

		GAWMax = arena.getArenaWidth(); 	// arena Max Width
		GAHMax = arena.getArenaHeight();	// arena Max Height
		GAWMid = arena.getArenaWidth()/2;	// arena Midpoint on X axis
		GAHMid = arena.getArenaHeight()/2;	// arena Midpoint on Y Axis
		GAWMin = GAWMax - GAWMax;		// arena Min Co-ordinate on X Axis
		GAHMin = GAHMax - GAHMax;		// arena Min Co-ordinate on Y Axis
		EdgesX = GAWMax*0.03;			// X edges are 3% of total arena
		EdgesY = GAHMax*0.08;			// Y edges are 8% of total arena
		missedLine = GAHMax - 25; 		// Red line at Bottom of arena

		// Calculate size of Playable Area
		PWMax = GAWMax - EdgesX;		// Max Play Area Width
		PHMax = GAHMax - 20;			// Max Play Height
		PWMin = GAWMin + EdgesX;		// Min Play Area
		PHMin = (GAHMin + (EdgesY - 25));	// Max Play Area
		PWMid = PWMax*0.5;			// Middle Of Play Width
		PHMid = PHMax*0.5;			// Middle Of Play Height
		
		
		// Draw Border	
		Rectangle Eborder = new Rectangle(GAWMax, GAHMid, EdgesX, GAHMax, borderColour, 0, 0);	// Left Border
		Rectangle Wborder = new Rectangle(GAWMin, GAHMid, EdgesX, GAHMax, borderColour, 0, 0);	// Right Border
		Rectangle Nborder = new Rectangle(GAWMid, GAHMin, GAWMax, EdgesY, borderColour, 0, 0);	// Top Border
		Rectangle Sborder = new Rectangle(GAWMid, GAHMax, PWMax, 10, bottomColour, 0, 0);	// Bottom Border
		arena.addRectangle(Eborder);
		arena.addRectangle(Wborder);
		arena.addRectangle(Nborder);
		arena.addRectangle(Sborder);

		//Dropped Items Test Size = Ball Diameter 12 which equates to (24,24) Rectangle

	}

	/**
	 * createBucket creates a bucket at the bottom of the game play arena
	 * @param level the current game level (used to vary size of bucket)
	 */
	public void createBucket(int level)
	{
	}

	/**
	 * deleteBucket deletes the current bucket
	 * @param level the current game level
	 */
	public void deleteBucket(int level)
	{
	}

	/**
	 * createRain creates raindrops at the top of the game play arena
	 * @param level the current game level (used to vary the number and size of raindrops)
	 * @param maxLevel the maximum game level (used to calculate the percentage size of raindrops)
	 */
	public void createRain(int level, int maxLevel)
	{
		int numberOfRainDrops = level * 2;
		double sizeOfRainDrops = ((maxLevel + 1 - level)/maxLevel) * maxRainDropSize;	// level determines what percentage of maxsize

		// create raindrops
		// eventually these will be placed randomly along the top
		// for now, just space them equally
		double xMin = GAWMin + EdgesX + sizeOfRainDrops/2;
		double xMax = GAWMax - EdgesX - sizeOfRainDrops/2;
		double xGap = (xMax - xMin) / numberOfRainDrops;
		double xPos = xMin + xGap/2;
		for (int i = 0; i < numberOfRainDrops; i++)
		{
			raindrop[i] = new Raindrop(xPos, GAHMin + EdgesY, 
						   sizeOfRainDrops, sizeOfRainDrops, 
						   (double)(rainMovement + level), arena);
			xPos += xGap;
		}
	}

	/**
	 * deleteRain deletes all the current raindrops
	 * @param level the current game level
	 */
	public void deleteRain(int level)
	{
	}

	/**
	 * play allows the user to play the game, and catch the raindrops
	 * returns when the user has finished the level
	 * @param level the current game level
	 */
	public void play(int level)
	{
		int numberOfRainDrops = level * 2;
		while (true)
		{
			arena.pause();
			for (int i = 0; i < numberOfRainDrops; i++)
				raindrop[i].moveDown(PHMax);
		}
	}
}


