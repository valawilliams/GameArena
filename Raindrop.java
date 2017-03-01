/**
 * Uses multiple instances of Rectangle to model a Raindrop.
 * This class represents a Raindrop object. When combined with the GameArena class,
 * instances of the Raindrop class can be displayed on the screen.
 */
public class Raindrop
{
	private double xPosition;		// The X coordinate of centre of this Raindrop
	private double yPosition;		// The Y coordinate of centre of this Raindrop
	private double width;			// The widest part of this Raindrop
	private double height;			// The highest part of this Raindrop
	private String colour = "CYAN";		// The colour of this Raindrop
	private double yIncrement;		// The distance for this Raindrop to fall each time

	private int numDrops = 8;

	private MovingRectangle drop[] = new MovingRectangle[numDrops];	// The rectangles making up the raindrop shape
	// The relative width and height of the rectangles making up the raindrop shape
	// the numbers are the ratio of each rectangle compared to the whole (i.e. each array adds up to 1.0)
	private double dropWidth[] =  { 0.02, 0.04, 0.06, 0.12, 0.17, 0.19, 0.23, 0.18 };
	private double dropHeight[] = { 0.025, 0.05, 0.07, 0.12, 0.15, 0.16, 0.265, 0.16 };

	/**
	 * Constructor
	 * @param x middle of raindrop on x-axis
	 * @param y middle of raindrop on y-axis
	 * @param w width of raindrop
	 * @param h height of raindrop
	 * @param yInc distance raindrop will fall
	 * @param arena GameArea object for adding raindrop Rectangles
	 */
	public Raindrop(double x, double y, double w, double h, double yInc, GameArena arena)
	{
		// store the details of the whole Raindrop
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		colour = "CYAN";
		yIncrement = yInc;

		// calculate the top of the raindrop (centre - height/2)
		double thisYPosition = y - h/2;

		// create the Raindrop from its component rectangles
		for (int i = 0; i < numDrops; i++)
		{
			double thisHeight = h*dropHeight[i];
			thisYPosition += thisHeight/2;	// move down to ycentre of this rectangle
			drop[i] = new MovingRectangle(x, thisYPosition, w*dropWidth[i], thisHeight, colour, 0, yInc);
			arena.addRectangle(drop[i]);
			thisYPosition += thisHeight/2;	// move down to ybottom of this rectangle
		}
	}	
 

	/**
	 * Move the Raindrop Down
	 * @param yMax the maximum yPosition
	 * @return false if unable to move
	 */
	public Boolean moveDown(double yMax)
	{
		// increment the position of the whole raindrop
		if (yPosition == yMax)
			return false;
		yPosition += yIncrement;
		if (yPosition > yMax)
			yPosition = yMax;

		// move down all the Raindrop components
		for (int i = 0; i < numDrops; i++)
			drop[i].moveDown(yMax);
		return true;
	}

	/**
	 * Checks whether Raindrop is touching another object
	 * @param x xposition of other object
	 * @param y yposition of other object
	 * @param w width of other object
	 * @param h height of other object
	 * @return true if touching
	 */
	public Boolean touching(double x, double y, double w, double h)
	{
		return (xPosition + width/2 >= x - w/2 &&
			xPosition - width/2 <= x + w/2 &&
			yPosition + height/2 >= y - h/2 &&
			yPosition - height/2 <= y + h/2);
	}

	/**
	 * Destructor
	 * Removes raindrop from arena
	 * @param arena GameArea object for removing raindrop Rectangles
	 */
	public void destroy(GameArena arena)
	{
		for (int i = 0; i < numDrops; i++)
		{
			arena.removeRectangle(drop[i]);
			drop[i] = null;
		}
	}
}
