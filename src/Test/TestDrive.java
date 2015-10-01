package Test;

import java.util.ArrayList;
import java.util.List;
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
	
	public void SetDriveWheelState(double value)
	{
	    dummy.setDriveWheelStateZeroBasedDegree(value);
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
			
			List<VectorDefinition> vectors = new ArrayList<VectorDefinition>();
			vectors.add(wheels.getMotionVector());
			vectors.add(wheels.getPositionVector());
			ex.drawVectors(vectors); 
		}
	}
	
	private static void Sleep(long sleepage)
	{
		try {
			Thread.sleep(sleepage);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		TestDrive drive = new TestDrive();
		drive.StartWheels();
		drive.StartDrawing();
		drive.SetTorque(4000);
		
		Sleep(3000);
		drive.SetTorque(0);
		drive.SetBrakePedalPos(1);
		Sleep(2000);
		drive.SetBrakePedalPos(0);
		drive.SetTorque(500);
		double end = 0.09;
		double current = 0;
		
		for(int i =0;i<100;i++)
		{
			current += end / 100;
			drive.SetDriveWheelState(current);
			Sleep(10);
		}
		
		Sleep(3000);
		drive.SetDriveWheelState(0);
		drive.SetTorque(0);
		drive.SetBrakePedalPos(1);
		drive.SetBrakePedalPos(0);
		Sleep(1000);
		drive.SetTorque(-1000);
		Sleep(4000);
		drive.SetDriveWheelState(-0.03);
		Sleep(12000);
		drive.SetDriveWheelState(+0.03);
		Sleep(10000);
		drive.SetBrakePedalPos(1);

	}

}
