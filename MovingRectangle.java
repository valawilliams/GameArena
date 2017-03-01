/**
 * Models a moving solid rectangle. 
 * This class represents a MovingRectabgle object. When combined with the GameArena class,
 * and the Rectangle class, instances of a MovingRectangle class can be moved about the screen.
 */
public class MovingRectangle extends Rectangle
{
	// The following instance variables define the
	// information needed to represent a MovingRectangle
	// It inherits from Rectangle
	
	private double xIncrement;		// The amount to move this Rectangle on the x-axis
	private double yIncrement;		// The amount to move this Rectangle on the y-axis
	private double xMaximum;		// The maximum X coordinate of this Rectangle
	private double yMaximum;		// The maximum Y coordinate of this Rectangle
 

	/**
	 * Constructor. Creates an instance of MovingRectangle with the given characteristics.
	 * @param x position of Rectangle on x-axis
	 * @param y position of Rectangle on y-axis
	 * @param w width of Rectangle
	 * @param h height of Rectangle
	 * @param col colour of Rectangle
	 * @param xInc movement of Rectangle along x-axis
	 * @param yInc movement of Rectangle along y-axis
	 */
	public MovingRectangle(double x, double y, double w, double h, String col, double xInc, double yInc)
	{
		super(x, y, w, h, col);
		xIncrement = xInc;
		yIncrement = yInc;
	}	

	/**
	 * Set the current x increment for this Rectangle
	 * @param xInc The new X increment of this MovingRectangle
	 */
	public void setXIncrement(int xInc)
	{
		this.xIncrement = xInc;
	}

	/**
	 * Set the current y increment for this Rectangle
	 * @param yInc The new Y increment of this MovingRectangle
	 */
	public void setYIncrement(int yInc)
	{
		this.yIncrement = yInc;
	}

	/**
	 * Move the Rectangle Left
	 * @param xMin the minimum xPosition
	 * @return false if unable to move
	 */
	public Boolean moveLeft(double xMin)
	{
		if (xPosition == xMin)
			return false;
		xPosition -= xIncrement;
		if (xPosition < xMin)
			xPosition = xMin;
		return true;
	}

	/**
	 * Move the Rectangle Right
	 * @param xMax the maximum xPosition
	 * @return false if unable to move
	 */
	public Boolean moveRight(double xMax)
	{
		if (xPosition == xMax)
			return false;
		xPosition += xIncrement;
		if (xPosition > xMax)
			xPosition = xMax;
		return true;
	}

	/**
	 * Move the Rectangle Up
	 * @param yMin the minimum yPosition
	 * @return false if unable to move
	 */
	public Boolean moveUp(double yMin)
	{
		if (yPosition == yMin)
			return false;
		yPosition -= yIncrement;
		if (yPosition < yMin)
			yPosition = yMin;
		return true;
	}

	/**
	 * Move the Rectangle Down
	 * @param yMax the maximum yPosition
	 * @return false if unable to move
	 */
	public Boolean moveDown(double yMax)
	{
		if (yPosition == yMax)
			return false;
		yPosition += yIncrement;
		if (yPosition > yMax)
			yPosition = yMax;
		return true;
	}

	/**
	 * Checks whether Rectangle is touching another object
	 * @param otherX X-position of object that this may be touching
	 * @param otherY Y-position of object that this may be touching
	 * @param otherW Width of object that this may be touching
	 * @param otherH Height of object that this may be touching
	 * @return true if touching
	 */
	public Boolean touching(double otherX, double otherY, double otherW, double otherH)
	{
		return (xPosition + width/2 >= otherX - otherW/2 &&
			xPosition - width/2 <= otherX + otherW/2 &&
			yPosition + height/2 >= otherY - otherH/2 &&
			yPosition - height/2 <= otherY + otherH/2);
	}
}
