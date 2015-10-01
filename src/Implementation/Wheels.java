package Implementation;

import java.util.Timer;
import java.util.TimerTask;

import SharedMemory.IWheels;

public class Wheels {

	double mass;
	double RAxes;
	double RWheels;
	double maxBreakTorque;
	double maxAxesTorque;
	double frictionalCoefficientOfBrakes;
	double innerFrictionalForce;
	double speed = 0;
	
	Timer timer;
	IWheels sharedMemory;
	Refresher task = new Refresher();
	
	long refreshInterval;
	
	public Wheels(long refreshInterval,
		   IWheels sharedMemory)
	{
		this.sharedMemory = sharedMemory;
		
		this.mass = sharedMemory.getTotalMassInKg();
		this.RAxes = sharedMemory.getDiameterOfDriveAxesInMeters()/2;
		this.RWheels = sharedMemory.getDiameterOfWheelsInMeters()/2;
		this.maxAxesTorque = sharedMemory.getMaximumTorqueInNewton();
		this.maxBreakTorque = sharedMemory.getMaximumBrakeTorqueInNewton();
		this.frictionalCoefficientOfBrakes = sharedMemory.getFrictionalCoefficientOfBrakes();
		this.innerFrictionalForce = sharedMemory.getInnerFrictionalCoefficientInNewton() * 10 * mass;
		timer = new Timer();
		
		this.refreshInterval = refreshInterval;
	}
	
	public void StartRefreshing()
	{
		timer.scheduleAtFixedRate(task, 0, refreshInterval);
	}
	
	public void StopRefreshing()
	{
		timer.cancel();
	}
	
	VectorDefinition current = new VectorDefinition(100, 100, 101, 100);
	
	
	double lastspeed;
	
	
	VectorDefinition currentposvect = new VectorDefinition(100, 100, 101, 100);
	
	public VectorDefinition getPositionVector()
	{
		return currentposvect;
	}
	
	boolean inreverse = false;
	
	class Refresher extends TimerTask
	{
		@Override
		public void run() {
			
			
			
			double innerForce = calcInnerFrictionalForce();
			double brakingForce = calcBrakingForce(sharedMemory.getBrakePedalPosition());
			double accTorque = sharedMemory.getCurrentTorqueInNewton();
			double accForce = calcAccelerationForce(accTorque); 
		
			
			double resforce = calcResultantForce(innerForce,brakingForce,accForce);
			double accel = calcAccel(resforce);
			
			speed = calcSpeed(accel,speed,((double)refreshInterval)/1000);
			
			double distance = speed * (((double)refreshInterval)/1000);
			
			double maxdrivewheelstate = sharedMemory.getMaximumDriveWheelStateZeroBasedDegree();
			
			double wheelpercent = (sharedMemory.getDriveWheelStateZeroBasedDegree() / maxdrivewheelstate); 
			
			double maxturndegree = sharedMemory.getMaximumWheelsTurnDegree();
			
			double wheelturn = wheelpercent*maxturndegree; 
			//calculate turn of the car
			//turning component of the speed
			double turnspeed = speed * Math.sin(wheelturn);
			double turned = turnspeed * ((double)refreshInterval)/1000;
			
			double angle = turned / (2*sharedMemory.getDistanceBetweenAxesInMeters()*Math.PI) * 360;
			
			currentposvect.setLength(10);
			currentposvect.shiftOnArrow(distance);
			currentposvect.Rotate(angle);
			
			current.setX1(currentposvect.getX1());
			current.setY1(currentposvect.getY1());
			current.setX2(currentposvect.getX2());
			current.setY2(currentposvect.getY2());
			
			current.setLength(1+Math.abs(speed));
			
			if(speed < 0)
			{
				current.shiftOrigin();
			}

			current.Rotate(angle);
			
	
			
			
			/*double baseVectorX = last.getX2() - last.getX1();
			double baseVectorY = last.getY2() - last.getY1();
			
			double currentlength = Math.sqrt(Math.pow(baseVectorX,2)+Math.pow(baseVectorY, 2));
			double newlength = Math.abs(speed)+distance;
			double multiplier = newlength/currentlength;
			
			double scaledbaseVectorXForEnd = baseVectorX*multiplier + last.getX1();
			double scaledbaseVectorYForEnd = baseVectorY*multiplier + last.getY1();
			
			double newlengthfstart = currentlength - (currentlength - distance);
			double multfstart = newlengthfstart/currentlength;
			
			double scaledbaseVectorXForStart = baseVectorX*multfstart + last.getX1();
			double scaledbaseVectorYForStart = baseVectorY*multfstart + last.getY1();
			
			double newLength = Math.sqrt(Math.pow(scaledbaseVectorXForStart - scaledbaseVectorXForEnd,2)+Math.pow(scaledbaseVectorYForStart - scaledbaseVectorYForEnd , 2));
			
			double newBaseVectorX = scaledbaseVectorXForEnd - scaledbaseVectorXForStart;
			double newBaseVectorY = scaledbaseVectorYForEnd - scaledbaseVectorYForStart;
			
			double vectorX = (newBaseVectorX * Math.cos(angle) - newBaseVectorY * Math.sin(angle));
			double vectorY = (newBaseVectorX * Math.sin(angle) + newBaseVectorY * Math.cos(angle)) ;

			double newLength2 = Math.sqrt(Math.pow(vectorX,2)+Math.pow(vectorY , 2));
			
			VectorDefinition def = new VectorDefinition(scaledbaseVectorXForStart, scaledbaseVectorYForStart, scaledbaseVectorXForStart+vectorX, scaledbaseVectorYForStart+vectorY);
			
			current = def;*/
			lastspeed = speed;
		}
	}
	
	double calcAccelerationForce(double TAxes) {
		
		return TAxes * (RAxes / RWheels);
	}
	
	double calcBrakingForce(double brakePedalPosition) {
		
		double retdata = frictionalCoefficientOfBrakes * maxBreakTorque * brakePedalPosition;
		
		if(speed != 0)
		{
			return retdata;
		}
		else 
		{
			return 0;
		}
	}

	double calcInnerFrictionalForce() {
		
		double retdata = innerFrictionalForce;
		
		if(speed != 0)
		{
			return retdata;
		}
		else
		{
			return 0;
		}
	}
	
	double calcResultantForce(double innerFrictionalForce,
							  double brakingForce,
							  double accelerationForce) {
		
			double ret = accelerationForce;
			
			if(speed < 0)
			{
				ret += brakingForce;
				ret += innerFrictionalForce;
			}

			if(speed > 0)
			{
				ret -= brakingForce;
				ret -= innerFrictionalForce;
			}
			
			return ret;
			
	}
	
	double calcAccel(double sumForces)
	{
		return sumForces/mass;
	}
	

	double calcSpeed(double accel, double lastSpeed, double timeleft)
	{
		double retval = lastSpeed + timeleft*accel;
		
		int signlastSpeed = (int) Math.signum(lastSpeed);
		int signAccel = (int) Math.signum(accel);
		
		if(signlastSpeed != 0 && signlastSpeed != signAccel && Math.abs(accel)*timeleft >= Math.abs(lastSpeed))
		{
			return 0;
		}
		else
		{
			return retval;
		}
	}
	
	
	public VectorDefinition getMotionVector() {

		return current;
	}
	
}
