package vennDiagramTool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;


import javax.swing.JPanel;

class RoundedPanel extends JPanel
{
    private Color backgroundColor;
    public Color getBackgroundColor() {
		return backgroundColor;
	}
	private int cornerRadius = 15;
    //layout and radius constructor
    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
        setOpaque(false);
    }
    //layout, radius and Background Color constructor
    public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
        setOpaque(false);
    }
    //radius constructor
    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
        setOpaque(false);
        
    }
    //radius and color constructor
    public RoundedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
        graphics.setColor(getForeground());
//        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//        
    }
    public void setPanelColor(Color c) {
    	this.backgroundColor = c;
    }
   
}