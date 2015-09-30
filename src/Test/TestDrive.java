package Test;

import java.util.Timer;
import java.util.TimerTask;

import Implementation.PointsExample;
import Implementation.VectorDefinition;
import Implementation.Wheels;
import SharedMemory.IWheels;

public class TestDrive {

	PointsExample ex;
	DummyWheels dummy;
	Wheels wheels;
	Timer timer = new Timer();
	RefreshScreenTask task = new RefreshScreenTask();
	
	public TestDrive()
	{
		dummy = new DummyWheels();
		wheels = new Wheels(100,dummy);
		ex = new PointsExample();
	}
	
	public void StartDrawing()
	{
		ex.setVisible(true);
		timer.scheduleAtFixedRate(task, 0, 100);
	}
	
	public void StopDrawing()
	{
		timer.cancel();
		ex.setVisible(false);
	}
	
	public void StartWheels()
	{
		wheels.StartRefreshing();
	}
	
	public void StopWheels()
	{
		wheels.StopRefreshing();
	}
	
	public void SetTorque(double torque)
	{
		dummy.setCurrentTorqueInNewton(torque);
	}
	
	class RefreshScreenTask extends TimerTask
	{
		@Override
		public void run() {
			VectorDefinition vect = wheels.getMotionVector();
	        ex.drawVector(vect.getX1(), vect.getY1(), vect.getX2(), vect.getY2()); 
		}
	}
	
	public static void main(String[] args) {
		
		TestDrive drive = new TestDrive();
		drive.StartWheels();
		drive.SetTorque(10000);
		drive.StartDrawing();
	}

}
