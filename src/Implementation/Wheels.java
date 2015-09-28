package Implementation;

public class Wheels {

	double calcAccelerationForce(double torqueInNewton, 
								 double AxesDiameterInMeters, 
								 double WheelsDiamaterInMeters) {
		return 0;
	}

	double calcBrakingForce(double maximumBrakeTorqueInNewton, 
							double frictionalCoefficientOfBrakes, 
							double brakePedalPosition) {
		return 0;
	}
	
	double calcMomentum(double mass, 
						double speed) {
		return 0;
	}

	double calcInnerFrictionalForce(double coefficient, 
									double mass) {
		return 0;
	}
	
	double calcResultantForce(double innerFrictionalForce,
							  double brakingForce,
							  double torque) {
		return 0;
	}
	
	double calcMotionVector(
			double driveWheelStateZeroBasedDegree,
			double maximumDriveWheelStateZeroBasedDegree,
			double maximumWheelsTurnDegree,
			double speed,
			double momentum,
			double resultantForce) {
		return 0;
	}
	
}
