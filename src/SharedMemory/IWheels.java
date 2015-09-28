package SharedMemory;

public interface IWheels {

	double getCurrentTorqueInNewton();
	double getMaximumTorqueInNewton();
	//double getFrictionalCoefficientWithRoad();
	
	double getMaximumBrakeTorqueInNewton();
	double getFrictionalCoefficientOfBrakes();
	double getBrakePedalPosition();
	
	double getDiameterOfDriveAxesInMeters();
	double getLengthOfAxesInMeters();
	double getDistanceBetweenAxesInMeters();
	
	double getDiameterOfWheelsInMeters();
	double getWidthOfWheelsInMeters();
	
	double getDriveWheelStateZeroBasedDegree();
	double getMaximumDriveWheelStateZeroBasedDegree();
	double getMaximumWheelsTurnDegree();

	double getTotalMassInKg();
	double getInnerFrictionalCoefficientInNewton();

}