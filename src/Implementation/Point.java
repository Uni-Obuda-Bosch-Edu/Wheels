package Implementation;

import Common.I2DPoint;

public class Point implements I2DPoint{
	
	double x;
	double y;
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}
}
