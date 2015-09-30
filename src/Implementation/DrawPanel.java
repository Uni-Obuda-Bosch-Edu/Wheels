package Implementation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;

class DrawPanel extends JPanel {

	private void clearDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        
        g2d.clearRect(0, 0, w, h);
	}
	
	public void drawVecotr(int x, int y, int xl, int yl) {
		
		vector_x1 = x;
		vector_y1 = y;
		vector_x2 = xl;
		vector_y2 = yl;
	}
	
	int vector_x1 = 0;
	int vector_y1 = 0;
	int vector_x2 = 0;
	int vector_y2 = 0;
	
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        clearDrawing(g);
        
        g2d.setColor(Color.blue);
        
        g2d.drawLine(vector_x1, vector_y1, vector_x2, vector_y2);

        //draw arrow
        if(vector_x2 > vector_x1)
        {
        	g2d.drawLine(vector_x2, vector_y2, vector_x2-10, vector_y2);
        }
        else
        {
        	g2d.drawLine(vector_x2, vector_y2, vector_x2+10, vector_y2);
        }
        
        if(vector_y2 > vector_x1)
        {
        	g2d.drawLine(vector_x2, vector_y2, vector_x2, vector_y2-10);
        }
        else
        {
        	g2d.drawLine(vector_x2, vector_y2, vector_x2, vector_y2+10);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }
}