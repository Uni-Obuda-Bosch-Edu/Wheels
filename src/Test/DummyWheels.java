package Test;

import SharedMemory.IWheels;

public class DummyWheels implements IWheels {

	private double currentTorqueInNewton;
	
	@Override
	public double getCurrentTorqueInNewton() {
		return currentTorqueInNewton;
	}

	@Override
	public double getMaximumTorqueInNewton() {
		return 1700;
	}

	@Override
	public double getMaximumBrakeTorqueInNewton() {
		return 1500;
	}

	@Override
	public double getFrictionalCoefficientOfBrakes() {
		return 0.7;
	}

	private double brakePedalPosition;
	
	@Override
	public double getBrakePedalPosition() {
		return brakePedalPosition;
	}

	@Override
	public double getDiameterOfDriveAxesInMeters() {
		// TODO Auto-generated method stub
		return 0.2;
	}

	@Override
	public double getLengthOfAxesInMeters() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDistanceBetweenAxesInMeters() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public double getDiameterOfWheelsInMeters() {
		return 0.5;
	}

	@Override
	public double getWidthOfWheelsInMeters() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	private double driveWheelStateZeroBasedDegree = 0;
	
	@Override
	public double getDriveWheelStateZeroBasedDegree() {
		return driveWheelStateZeroBasedDegree;
	}

	@Override
	public double getMaximumDriveWheelStateZeroBasedDegree() {
		// TODO Auto-generated method stub
		return 280;
	}

	@Override
	public double getMaximumWheelsTurnDegree() {
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public double getTotalMassInKg() {
		return 100;
	}

	@Override
	public double getInnerFrictionalCoefficientInNewton() {
		return 0.06;
	}

	void setBrakePedalPosition(double brakePedalPosition) {
		this.brakePedalPosition = brakePedalPosition;
	}

	void setCurrentTorqueInNewton(double currentTorqueInNewton) {
		this.currentTorqueInNewton = currentTorqueInNewton;
	}

	void setDriveWheelStateZeroBasedDegree(double driveWheelStateZeroBasedDegree) {
		this.driveWheelStateZeroBasedDegree = driveWheelStateZeroBasedDegree;
	}

}
