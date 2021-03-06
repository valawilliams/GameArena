/**
 * Uses multiple instances of MovingRectangle to model a Bucket.
 * This class represents a Bucket object. When combined with the GameArena class,
 * instances of the Bucket class can be displayed on the screen.
 */
public class Bucket
{
	private double xPosition;			// The X coordinate of centre of this Bucket
	private double yPosition;			// The Y coordinate of centre of this Bucket
	private double width;				// The widest part of this Bucket
	private double height;				// The highest part of this Bucket
	private String outlineColour = "YELLOW";	// The colour of the Bucket outline
	private String insideColour = "BLACK";		// The initial colour of the inside of the Bucket
	private double xIncrement;			// The distance for this Bucket to slide each time

	// The relative width and height of the rectangles making up the Bucket shape
	// The numbers are the ratio of each rectangle compared to the whole (i.e. each array adds up to 1.0)
	// The bucket has a base and two sides, followed by a middle.
	// The middle is made of 20 narrow strips, initially coloured black, which can be coloured as the bucket fills
	private double outlineWidth =  4;
	private double outlineHeight = 4;
	private int numOutlines = 3;			// number of rectangles in outline of bucket
	private int numInsides = 20;			// number of rectangles inside bucket
	private int numFilled = 0;			// count of rectangles inside bucket that are full

	private MovingRectangle outline[] = new MovingRectangle[numOutlines];	// The rectangles making up the bucket outline
	private MovingRectangle inside[] = new MovingRectangle[numInsides];	// The rectangles making up the bucket insides

	/**
	 * Constructor
	 * @param x middle of Bucket on x-axis
	 * @param y middle of Bucket on y-axis
	 * @param w width of Bucket
	 * @param h height of Bucket
	 * @param xInc distance Bucket will slide
	 * @param arena GameArea object for adding Bucket rectangles
	 */
	public Bucket(double x, double y, double w, double h, double xInc, GameArena arena)
	{
		// store the details of the whole Bucket
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		xIncrement = xInc;

		// calculate the bottom of the Bucket (centre + height/2)
		double thisYPosition = y + (h/2);

		// create the Bucket outline from its component rectangles
		outline[0] = new MovingRectangle((x - (w/2) + (outlineWidth/2)), y, 
						     outlineWidth, h, outlineColour, xInc, 0);
		outline[1] = new MovingRectangle((x + (w/2) - (outlineWidth/2)), y, 
						     outlineWidth, h, outlineColour, xInc, 0);
		outline[2] = new MovingRectangle(x, (thisYPosition - (outlineHeight/2)), 
						     w, outlineHeight, outlineColour, xInc, 0);
		arena.addRectangle(outline[0]);
		arena.addRectangle(outline[1]);
		arena.addRectangle(outline[2]);

		// create the Bucket insides from its component rectangles
		thisYPosition = thisYPosition - outlineHeight;
		double insideHeight = (h - outlineHeight) / numInsides;
		for (int i = 0; i < numInsides; i++)
		{
			thisYPosition = thisYPosition - insideHeight/2;
			inside[i] = new MovingRectangle(x, thisYPosition, 
						  (w - (2*outlineWidth)), insideHeight, insideColour, xInc, 0);
			arena.addRectangle(inside[i]);
			thisYPosition = thisYPosition - insideHeight/2;
		}
		numFilled = 0;
	}	
 
	/**
	 * destroy: remove each bucket Rectangle from the arena and dereference it
	 * @param arena from which to remove bucket Rectangles
	 */
	public void destroy(GameArena arena)
	{
		// destroy the insides
		for (int i = 0; i < numInsides; i++)
		{
			arena.removeRectangle(inside[i]);	// remove it from the arena
			inside[i] = null;			// dereference it
		}
		// destroy the outline
		for (int i = 0; i < outline.length; i++)
		{
			arena.removeRectangle(outline[i]);	// remove it from the arena
			outline[i] = null;			// dereference it
		}
	}

	/**
	 * Move the Bucket Right, stopping when it reaches xMax
	 * @param xMax the maximum xPosition
	 * @return false if unable to move
	 */
	public Boolean moveRight(double xMax)
	{
		int i;
		// increment the position of the whole Bucket
		if (xPosition == xMax)
			return false;
		xPosition += xIncrement;
		if (xPosition > xMax)
			xPosition = xMax;

		// move along all the Bucket components
		// first move the bucket outlines
		outline[0].moveRight(xMax - (width/2) + (outlineWidth/2));
		outline[1].moveRight(xMax + (width/2) - (outlineWidth/2));
		outline[2].moveRight(xMax);
		// now move the bucket insides
		for (i = 0; i < numInsides; i++)
			inside[i].moveRight(xMax);
		return true;
	}

	/**
	 * Move the Bucket Left, stopping when it reaches xMin
	 * @param xMin the minimum xPosition
	 * @return false if unable to move
	 */
	public Boolean moveLeft(double xMin)
	{
		int i;
		// decrement the position of the whole Bucket
		if (xPosition == xMin)
			return false;
		xPosition -= xIncrement;
		if (xPosition < xMin)
			xPosition = xMin;

		// move along all the Bucket components
		// first move the bucket outlines
		outline[0].moveLeft(xMin - (width/2) + (outlineWidth/2));
		outline[1].moveLeft(xMin + (width/2) - (outlineWidth/2));
		outline[2].moveLeft(xMin);
		// now move the bucket insides
		for (i = 0; i < numInsides; i++)
			inside[i].moveLeft(xMin);
		return true;
	}

	/**
	 * Fill the bucket - change the colour of the specified number of inside elements
	 * @param numberToFill number of inside elements to fill
	 * @return true if bucket is full
	 **/
	public Boolean fill(int numberToFill)
	{
		int i;
		numFilled += numberToFill;
		if (numFilled > numInsides)
			numFilled = numInsides;
		for (i = 0; i < numInsides; i++)
			if (i < numFilled)
				inside[i].setColour("CYAN");
			else
				inside[i].setColour("BLACK");
		if (numFilled == numInsides)
			return true;
		return false;
	}
 
	/**
	 * Obtain the current position of this bucket on the x-axis
	 * @return the X coordinate of this Bucket within the GameArena.
	 */
	public double getXPosition()
	{
		return xPosition;
	}

	/**
	 * Obtain the current position of this bucket on the y-axis
	 * @return the Y coordinate of this Bucket within the GameArena.
	 */
	public double getYPosition()
	{
		return yPosition;
	}

	/**
	 * Obtain the width of this Bucket
	 * @return the width of this Bucket, in pixels.
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * Obtain the height of this Bucket
	 * @return the height of this Bucket, in pixels.
	 */
	public double getHeight()
	{
		return height;
	}
}
