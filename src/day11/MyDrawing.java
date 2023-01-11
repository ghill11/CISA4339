package day11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawing extends JPanel {
	private int height;
	private int width;
	
	public MyDrawing(int height, int width) {
		this.height = height;
		this.width = width;
	} // end ctor
	
    @Override
    protected void paintComponent(Graphics g) { // What is going on in here?
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(5, 5, 100, 100);
        g.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
        g.setColor(Color.decode("#4F2D7F"));
        g.drawString("Hello, World!", this.width-150, this.height-50);
    } // end paintComponent
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    } // end getPreferredSize
} // end MyDrawing