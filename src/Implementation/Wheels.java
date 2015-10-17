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
	
	double lastspeed;
	
	
	VectorDefinition currentposvect = new VectorDefinition(100, 100, 101, 100);
	VectorDefinition current = new VectorDefinition(100, 100, 101, 100);
	
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
			
			if(wheelturn != 0)
			{
				double r = sharedMemory.getDistanceBetweenAxesInMeters()/Math.sin(wheelturn);
				double k = 2*r*Math.PI;
				double koriv = distance/k;
				double angle = koriv*2*Math.PI;
				double h = Math.sin(angle/2)*2*r; 
				
				currentposvect.Rotate(angle/2);
				currentposvect.shiftOnArrow(h);
				currentposvect.Rotate(angle/2);
				currentposvect.setLength(1);
				
				current.setX1(currentposvect.getX1());
				current.setY1(currentposvect.getY1());
				current.setX2(currentposvect.getX2());
				current.setY2(currentposvect.getY2());
				
				if(speed != 0)
				{
					current.setLength(speed);
				}
				current.Rotate(angle);
			}
			else
			{
				current.shiftOnArrow(distance);
				if(speed != 0)
				{
					current.setLength(speed);
				}
				else
				{
					current.setLength(1);
				}
				currentposvect.shiftOnArrow(distance);
				currentposvect.setLength(1);
			}
			
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
