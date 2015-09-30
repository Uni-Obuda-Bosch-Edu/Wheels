package Implementation;

import javax.swing.JFrame;

public class PointsExample extends JFrame {

    public PointsExample() {
        initUI();
    }

    DrawPanel dpnl;
    
    public final void initUI() {

        dpnl = new DrawPanel();
        add(dpnl);

        setSize(250, 200);
        setTitle("Points");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void drawVector(double x, double y, double xl, double yl)
    {
    	dpnl.drawVector(x, y, xl, yl);
    }

    public static void main(String[] args) {

    	 PointsExample ex = new PointsExample();
         ex.setVisible(true);
         ex.drawVector(0,0,50,100);
    }
}
