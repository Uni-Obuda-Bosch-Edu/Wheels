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
    
    public void drawVector(int x, int y, int xl, int yl)
    {
    	dpnl.drawVecotr(0, 0, 100, 100);
    }

    public static void main(String[] args) {

    	 PointsExample ex = new PointsExample();
         ex.setVisible(true);
         ex.drawVector(0,0,100,100);
    }
}
