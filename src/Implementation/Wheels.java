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
	
	VectorDefinition last = new VectorDefinition(0, 50, 0, 50);
	VectorDefinition current = new VectorDefinition(0, 50, 0, 50);
	
	int xstart = 0;
	int ystart = 50;
	
	class Refresher extends TimerTask
	{
		@Override
		public void run() {
			
			last = current;
			
			double innerForce = calcInnerFrictionalForce();
			double brakingForce = calcBrakingForce(sharedMemory.getBrakePedalPosition());
			double accForce = calcAccelerationForce(sharedMemory.getCurrentTorqueInNewton()); 
		
			
			double resforce = calcResultantForce(innerForce,brakingForce,accForce);
			double accel = calcAccel(resforce);
			
			double lastspeed = speed;
			
			speed = calcSpeed(accel,speed,((double)refreshInterval)/1000);
			
			double distance = speed * (((double)refreshInterval)/1000);
			
			current.setX1(last.getX1()+distance);
			current.setX2(last.getX2()+distance + (speed - lastspeed));
			
		}
	}
	
	double calcAccelerationForce(double TAxes) {
		
		return TAxes * (RAxes / RWheels);
	}
	
	double calcBrakingForce(double brakePedalPosition) {
		
		double retdata = frictionalCoefficientOfBrakes * maxBreakTorque * brakePedalPosition;
		
		if(speed >= 0)
		{
			return -1 * retdata;
		}
		else
		{
			return retdata;
		}
	}

	double calcInnerFrictionalForce() {
		
		double retdata = innerFrictionalForce;
		
		if(speed >= 0)
		{
			return -1 * retdata;
		}
		else
		{
			return retdata;
		}
	}
	
	double calcResultantForce(double innerFrictionalForce,
							  double brakingForce,
							  double accelerationForce) {
		
		return innerFrictionalForce + brakingForce + accelerationForce;
	}
	
	double calcAccel(double sumForces)
	{
		return sumForces/mass;
	}
	

	double calcSpeed(double accel, double lastSpeed, double timeleft)
	{
		return lastSpeed + timeleft*accel;
	}
	
	
	public VectorDefinition getMotionVector() {

		return current;
	}
	
}
