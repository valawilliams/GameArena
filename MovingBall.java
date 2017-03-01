/**
 * Models a simple solid sphere. 
 * This class represents a Ball object. When combined with the GameArena class,
 * and the Ball class, instances of the MovingBall class can be moved about the screen.
 */
public class MovingBall extends Ball
{
	// The following instance variables define the
	// information needed to represent a MovingBall
	// It inherits from Ball
	
	private double xIncrement;		// The amount to move this Ball on the x-axis
	private double yIncrement;		// The amount to move this Ball on the y-axis
	private double xMaximum;		// The maximum X coordinate of this Ball
	private double yMaximum;		// The maximum Y coordinate of this Ball

 
	/**
	 * Constructor. Creates an instance of MovingBall with the given chatacteristics.
	 * @param x The initial location of the centre of the Ball on the screen, in the X dimension.
	 * @param y The initial location of the centre of the Ball on the screen, in the Y dimension.
	 * @param diameter The diameter of the Ball, in pixels.
	 * @param col The colour of the Ball, see Ball constructor
	 * @param xInc The initial x-increment of the Ball
	 * @param yInc The initial y-increment of the Ball
	 * @param xMax The maximum x-position of the Ball in this Arena
	 * @param yMax The maximum y-position of the Ball in this Arena
	 */
	public MovingBall(double x, double y, double diameter, String col, 
			  double xInc, double yInc, double xMax, double yMax)
	{
		super(x, y, diameter, col);
		xIncrement = xInc;
		yIncrement = yInc;
                xMaximum = xMax;
		yMaximum = yMax;
	}

	
	/**
	 * Set the current x increment for this Ball
	 * @param xInc The new X increment of this MovingBall
	 */
	public void setXIncrement(int xInc)
	{
		this.xIncrement = xInc;
	}

	/**
	 * Set the current y increment for this Ball
	 * @param yInc The new Y increment of this MovingBall
	 */
	public void setYIncrement(int yInc)
	{
		this.yIncrement = yInc;
	}

	/**
	 * Move this Ball by the x and y increments, 
	 * reversing at the edge of the arena
	 */
	public void move()
	{
		double oldXPosition = xPosition;
		double oldYPosition = yPosition;

		xPosition += xIncrement;		// move xPosition on by xIncrement
		if (xPosition >= xMaximum)
		{
			xPosition = xMaximum;		// if reached 1st edge
			xIncrement = 0 - xIncrement;	// start going back towards 2nd edge
		}
		else if (xPosition <= 0)
		{
			xPosition = 0;			// if reached 2nd edge
			xIncrement = 0 - xIncrement;	// start going back towards 1st edge
		}

		yPosition += yIncrement;		// move yPosition on by yIncrement
		if (yPosition >= yMaximum)
		{
			yPosition = yMaximum;		// if at bottom
			yIncrement = 0 - yIncrement;	// go back towards top
		}
		else if (yPosition <= 0)
		{
			yPosition = 0;			// if at top
			yIncrement = 0 - yIncrement;	// go back towards bottom
		}
	}
}
