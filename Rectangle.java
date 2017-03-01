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
	
	protected double xPosition;		// The X coordinate of centre of this Rectangle
	protected double yPosition;		// The Y coordinate of centre of this Rectangle
	protected double width;			// The width of this Rectangle
	protected double height;			// The height of this Rectangle
	protected String colour = "WHITE";	// The colour of this Rectangle
						// Permissable colours are 8 bit hexadecimal 
 
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
	 * Sets the colour of this Rectangle.
	 * @param newColour a textual description of the colour of this Rectangle.
	 */
	public void setColour(String newColour)
	{
		colour = newColour;
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
	 * Constructor
	 * @param x position of Rectangle on x-axis
	 * @param y position of Rectangle on y-axis
	 * @param w width of Rectangle
	 * @param h height of Rectangle
	 * @param col colour of Rectangle
	 * @param xInc movement of Rectangle along x-axis
	 * @param yInc movement of Rectangle along y-axis
	 */
	public Rectangle(double x, double y, double w, double h, String col)
	{
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		colour = col;
	}	
}
