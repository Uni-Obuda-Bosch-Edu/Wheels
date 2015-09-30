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
	
	public void SetBrakePedalPos(double percent)
	{
		dummy.setBrakePedalPosition(percent);
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
		drive.SetTorque(3000);
		drive.SetBrakePedalPos(1);
		drive.StartDrawing();
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		drive.SetBrakePedalPos(0);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		drive.SetTorque(0);
		drive.SetBrakePedalPos(1);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drive.SetBrakePedalPos(0);
		drive.SetTorque(-1000);
	}

}
