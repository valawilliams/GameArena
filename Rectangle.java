/**
 * Models a simple, solid rectangle. 
 * This class represents a Rectabgle object. When combined with the GameArena class,
 * instances of the Rectangle class can be displayed on the screen.
 */
public class Rectangle 
{
	// The following instance variables define the
	// information needed to represent a Rectangle
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;		// The X coordinate of centre of this Rectangle
	private double yPosition;		// The Y coordinate of centre of this Rectangle
	private double width;			// The width of this Rectangle
	private double height;			// The height of this Rectangle
	private String colour = "WHITE";	// The colour of this Rectangle
						// Permissable colours are 8 bit hexadecimal 
	private double xIncrement;		// The X increment for this Rectangle
	private double yIncrement;		// The Y Increment for this Rectangle
 
	/**
	 * Obtains the current position of this Rectangle.
	 * @return the X coordinate of this Rectangle within the GameArena.
	 */
	public double getXPosition()
	{
		return xPosition;
	}

	/**
	 * Obtains the current position of this Rectangle.
	 * @return the Y coordinate of this Rectangle within the GameArena.
	 */
	public double getYPosition()
	{
		return yPosition;
	}

	/**
	 * Moves the current position of this Rectangle to the given X co-ordinate
	 * @param x the new x co-ordinate of this Rectangle
	 */
	public void setXPosition(double x)
	{
		this.xPosition = x;
	}

	/**
	 * Moves the current position of this Rectangle to the given Y co-ordinate
	 * @param y the new y co-ordinate of this Rectangle
	 */
	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

	/**
	 * Obtains the width of this Rectangle.
	 * @return the width of this Rectangle,in pixels.
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * Obtains the height of this Rectangle.
	 * @return the height of this Rectangle,in pixels.
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * Obtains the colour of this Rectangle.
	 * @return a textual description of the colour of this Rectangle.
	 */
	public String getColour()
	{
		return colour;
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
	 * Checks whether Rectangle touching another Rectangle
	 * @param Rectangle otherRect
	 * @return true if touching
	 */
	public Boolean touching(Rectangle other)
	{
		double otherXPos = other.getXPosition();
		double otherYPos = other.getYPosition();
		double otherHalfWidth = other.getWidth() / 2;
		double otherHalfHeight = other.getHeight() / 2;
		return (xPosition + width/2 >= otherXPos - otherHalfWidth &&
			xPosition - width/2 <= otherXPos + otherHalfWidth &&
			yPosition + height/2 >= otherYPos - otherHalfHeight &&
			yPosition - height/2 <= otherYPos + otherHalfHeight);
	}

	/**
	 * Constructor
	 */
	public Rectangle(double x, double y, double w, double h, String col, double xInc, double yInc)
	{
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		colour = col;
		xIncrement = xInc;
		yIncrement = yInc;
	}	
}
