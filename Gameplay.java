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
	String bottomColour[] = {"RED",		// changed from "#CC1100"
				 "#E0FFFF", "#D0FFFF", "#C0FFFF", "#B0FFFF", "#A0FFFF", "#90FFFF", 
				 "#80FFFF", "#70FFFF", "#60FFFF", "#50FFFF", "#40FFFF", "#30FFFF", 
				 "#20FFFF", "#10FFFF", "#0FFFFF", "#0EFFFF", "#0DFFFF", "#0CFFFF",
				 "#0BFFFF", "#0AFFFF", "#09FFFF", "#08FFFF", "#07FFFF", "#06FFFF",
				 "#05FFFF", "#04FFFF", "#03FFFF", "#02FFFF", "#01FFFF", "#00FFFF"};
	int bucketSize = 100;			// size of bucket
	int bucketMovement = 10;		// distance for bucket to slide
	int maxRainDrops = 100;			// maximum number of raindrops

	// GameArena sizes/positions
	double GAWMax; 			// arena Max Width - right hand side of arena
	double GAHMax;			// arena Max Height - bottom of arena
	double GAWMid;			// arena Midpoint on X axis - middle of arena on x-axis
	double GAHMid;			// arena Midpoint on Y Axis - middle of arena on y-axis
	double GAWMin;			// arena Min Co-ordinate on X Axis - left hand side of arena
	double GAHMin;			// arena Min Co-ordinate on Y Axis - top of arena
	double EdgesX;			// X edges are 3% of total arena - width of left/right hand border
	double EdgesY;			// Y edges are 8% of total arena - depth of top border
	double redLineDepth; 		// Red line at Bottom of arena
	double bottomEdgeY;
	
	// Playable area sizes/positions
	double PWMax;			// Max Play Arena Width - right hand side of playable area
	double PHMax;			// Max Play Height - bottom of playable area
	double PWMin;			// Min play Area - left hand side of playable area
	double PHMin;			// Max Play Area - top of playable area
	double PWMid;			// Middle Of Play Width - middle of playable area on x-axis
	double PHMid;			// Middle Of Play Height - middle of playable area on y-axis

	Rectangle Eborder, Wborder, Nborder, Sborder;		

	GameArena arena = new GameArena(maxArenaWidth, maxArenaHeight);
	Raindrop raindrop[] = new Raindrop[maxRainDrops];	// maximum possible number of Raindrops
	Bucket bucket;


	/** Constructor creates the game arena, with borders
	 */
	public Gameplay()
	{
		// create the game arena
		// GameArena arena = new GameArena(maxArenaWidth, maxArenaHeight);

		GAWMax = arena.getArenaWidth(); 	// Max Width Coordinate of the GameArena on the X-axis
		GAHMax = arena.getArenaHeight();	// Max Height Coordinate of the GameArena on the Y-axis
		GAWMid = arena.getArenaWidth()/2;	// Midpoint Coordinate of the GameArena on the X-axis
		GAHMid = arena.getArenaHeight()/2;	// Midpoint Coordinate of the GameArena on the on Y-axis
		GAWMin = GAWMax - GAWMax;		// Minimum Coordinate of the GameArena on the X-axis
		GAHMin = GAHMax - GAHMax;		// Minimum Coordinate of the GameArena on the Y-axis
		EdgesX = GAWMax*0.03;			// X edges are 3% of total arena
		EdgesY = GAHMax*0.08;			// Y edges are 8% of total arena
		redLineDepth = 10; 			// Red line at Bottom of arena
		bottomEdgeY = GAHMax - redLineDepth;

		// Calculate size of Playable Area
		PWMax = GAWMax - EdgesX;		// Max Width Coordinate of the Playable Area on the X-axis (GameArena minus border)
		PHMax = GAHMax - redLineDepth;		// Max Height Coordinate of the Playable Area on the Y-axis (GameArena minus border)
		PWMin = GAWMin + EdgesX;		// Min Width Coordinate of the Playable Area (GameArena plus border)
		PHMin = (GAHMin + (EdgesY - 25));	// Min Height Coordinate of the Playable Area (GameArea plus top border)
					// WHY DOES PHMin USE THIS NUMBER, RATHER THAN GAHMin + EdgesY ??????
		PWMid = PWMax*0.5;			// Midpoint Coordinate of the Playable Area on the X-axis
		PHMid = PHMax*0.5;			// Midpoint Coordinate of the Playable Area on the Y-axis
		
		
		// Draw Border	
		Eborder = new Rectangle(GAWMax, GAHMid, EdgesX, GAHMax, borderColour, 0, 0);	// Left Border
		Wborder = new Rectangle(GAWMin, GAHMid, EdgesX, GAHMax, borderColour, 0, 0);	// Right Border
		Nborder = new Rectangle(GAWMid, GAHMin, GAWMax, EdgesY, borderColour, 0, 0);	// Top Border
		Sborder = new Rectangle(GAWMid, GAHMax-redLineDepth/2, PWMax, redLineDepth, bottomColour[0], 0, 0);	// Bottom Border
		arena.addRectangle(Eborder);		// show border rectangle at right of GameArena
		arena.addRectangle(Wborder);		// show border rectangle at left of GameArena
		arena.addRectangle(Nborder);		// show border rectangle at top of GameArena
		arena.addRectangle(Sborder);		// show border rectangle at bottom of GameArena

		//Dropped Items Test Size = Ball Diameter 12 which equates to (24,24) Rectangle

		for (int i = 0; i < maxRainDrops; i++)
			raindrop[i] = null;
	}

	/**
	 * createBucket creates a bucket at the bottom of the game play arena
	 * @param level the current game level (used to vary size of bucket)
	 */
	public void createBucket(int level)
	{
		bucket = new Bucket(GAWMid, bottomEdgeY-(bucketSize/2), 
					bucketSize, bucketSize, 
					(double)bucketMovement, arena);
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
			if (raindrop[i] == null)
				raindrop[i] = new Raindrop(xPos, PHMin, 
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
	public void play(int level, int maxLevel)
	{
		int i, c;
		int numberOfRainDrops = level * 2;
		double sizeOfRainDrops = ((maxLevel + 1 - level)/maxLevel) * maxRainDropSize;	// level determines what percentage of maxsize

		while (true)
		{
			arena.pause();
			for (i = 0; i < numberOfRainDrops; i++)
			{
				if (raindrop[i] != null)
				{
					raindrop[i].moveDown(bottomEdgeY-sizeOfRainDrops/2);
					if (raindrop[i].touching(bucket.getXPosition(), bucket.getYPosition(), 
								 bucket.getWidth(), bucket.getHeight()))
					{
						bucket.fill(1);	// change the fill amount depending on level
						raindrop[i].destroy(arena);	// destroy raindrop
						raindrop[i] = null;
						createRain(level, maxLevel);
					}
					else if (raindrop[i].touching(Sborder.getXPosition(), Sborder.getYPosition(), 
									Sborder.getWidth(), Sborder.getHeight()))
					{
						String col;
						col = Sborder.getColour();
						for (c = 0; c < bottomColour.length && col != bottomColour[c]; i++)
							;
						Sborder.setColour(bottomColour[c]);
						raindrop[i].destroy(arena);	// destroy raindrop
						raindrop[i] = null;
						createRain(level, maxLevel);
					}
				}
			}
			if (arena.leftPressed())
				bucket.moveLeft(PWMin + bucketSize/2);
			else if (arena.rightPressed())
				bucket.moveRight(PWMax - bucketSize/2);		
		}
	}
}


