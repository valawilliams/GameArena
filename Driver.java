
public class Driver 
{
	public static void main (String[] args)
	{
		int maxLevel = 10;		// there are 10 levels in total (1 to 10)
		int level = 1;			// start at the lowest level

		//create the game
		Gameplay game = new Gameplay();

		while (level <= maxLevel)
		{
			game.createBucket(level);
			game.createRain(level, maxLevel);
			game.play(level, maxLevel);
			game.deleteRain(level);
			game.deleteBucket(level);
			level++;
		}
	}
}
	
