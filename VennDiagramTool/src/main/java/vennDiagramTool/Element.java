package vennDiagramTool;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Element {
	String content;
	String description;
	int x, y;
	Color textFill, background;
	boolean selected;
	
	public void display(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString(content, x, y);
	}
	
	// Getters and Setters
	// Content
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// Description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// x
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	// y
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	// textFill
	public Color getTextFill() {
		return textFill;
	}
	public void setTextFill(Color textFill) {
		this.textFill = textFill;
	}
	
	// background
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	
	// Selected
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
