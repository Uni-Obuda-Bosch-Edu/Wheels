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
    
    public void drawVectors(java.util.List<VectorDefinition> vectors)
    {
    	dpnl.drawVectors(vectors);
    }

    public static void main(String[] args) {

    	 PointsExample ex = new PointsExample();
         ex.setVisible(true);
         
    }
}
