package Implementation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

class DrawPanel extends JPanel {

	double phi;
    int barb;
	
    public DrawPanel()
    {
        phi = Math.toRadians(30);
        barb = 10;
    }
    
	private void clearDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        
        g2d.clearRect(0, 0, w, h);
	}
	
	java.util.List<VectorDefinition> vectors;
	
	public void drawVectors(java.util.List<VectorDefinition> vectors) {
		
		this.vectors = vectors;
	}
	
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        clearDrawing(g);
        
        g2d.setColor(Color.blue);
        
        //scale it up

        Color col = Color.blue;
        
        for (VectorDefinition vectorDefinition : vectors) {
        	
        	g2d.drawLine((int)vectorDefinition.getX1(), (int)vectorDefinition.getY1(), (int)vectorDefinition.getX2(), (int)vectorDefinition.getY2());
            drawArrowHead(g2d, new Point((int)vectorDefinition.getX2(), (int)vectorDefinition.getY2()), new Point((int)vectorDefinition.getX1(), (int)vectorDefinition.getY1()), col);
            g2d.setColor(col);
            col = Color.red;
		}
        
        this.repaint();
    }
    
    private void drawArrowHead(Graphics2D g2, Point tip, Point tail, Color color)
    {
        g2.setPaint(color);
        double dy = tip.y - tail.y;
        double dx = tip.x - tail.x;
        double theta = Math.atan2(dy, dx);
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++)
        {
            x = tip.x - barb * Math.cos(rho);
            y = tip.y - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
            rho = theta - phi;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }
}