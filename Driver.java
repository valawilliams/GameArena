
public class Driver 
{
	public static void main (String[] args)
	{
		boolean gameResult;
		int maxLevel = 10;		// there are 10 levels in total (1 to 10)
					// NOTE: if you increase maxLevel, you must 
					// extend bucketFillRate[] and scaling[] in Gameplay.java
		int level = 1;			// start at the lowest level

		//create the game
		Gameplay game = new Gameplay();

		while (level <= maxLevel)
		{
			game.createBucket(level);
			game.createRain(level, maxLevel);
			gameResult = game.play(level, maxLevel);
			game.deleteRain(level);
			game.deleteBucket();
			if (gameResult)		// if we filled the bucket
				level++;	// go up one level
			else if (level > 1)	// if the ground was saturated
				level--;	// go down one level, to the lowest
		}
	}
}
	
