package Implementation;

public class VectorDefinition {

	VectorDefinition(double x1, double y1, double x2, double y2)
	{
		this.setX1(x1);
		this.setY1(y1);
		this.setX2(x2);
		this.setY2(y2);
	}
	
	public double getLength()
	{
		return Math.sqrt(Math.pow(getX2() - getX1(),2) + Math.pow(getY2() - getY1(),2));
	}
	
	private double getBaseX()
	{
		return getX2() - getX1();
	}
	
	private double getBaseY()
	{
		return getY2() - getY1();
	}
	
	public void AppendLength(double value)
	{
		double length = getLength();
		double newLength = length+value;
		double scale = newLength / length;
		Scale(scale);
	}
	
	public void Scale(double value)
	{
		this.setX2(getScaledBaseVectorXInStart(value));
		this.setY2(getScaledBaseVectorYInStart(value));
	}
	
	private double getScaledBaseVectorXInStart(double scaleValue)
	{
		return getBaseX()*scaleValue + getX1();
	}
	private double getScaledBaseVectorYInStart(double scaleValue)
	{
		return getBaseY()*scaleValue + getY1();
	}
	
	public void setLength(double value)
	{
		double scale = value/getLength();
	
		Scale(scale);
	}
	
	public void shiftOrigin()
	{
		setX2(-1*getBaseX()+getX1());
		setY2(-1*getBaseY()+getY1());
	}
	
	public void shiftOnArrow(double value)
	{
		double length =  getLength();
		double newlengthfstart = length - (length - value);
		double multfstart = newlengthfstart/length;
		
		double newlengthfend = length + value;
		double multfend = newlengthfend/length;
		
		double newx1 = getScaledBaseVectorXInStart(multfstart);
		double newy1 = getScaledBaseVectorYInStart(multfstart);
		double newx2 = getScaledBaseVectorXInStart(multfend);
		double newy2 = getScaledBaseVectorYInStart(multfend);
		
		setX1(newx1);
		setY1(newy1);
		setX2(newx2);
		setY2(newy2);
	}
	
	public void Rotate(double angle)
	{
		double vectorX = (getBaseX() * Math.cos(angle) - getBaseY() * Math.sin(angle));
		double vectorY = (getBaseX() * Math.sin(angle) + getBaseY() * Math.cos(angle));
		
		this.setX2(vectorX + getX1());
		this.setY2(vectorY + getY1());
	}
	
	
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	private double x1;
	private double y1;
	
	private double x2;
	private double y2;
	
}
