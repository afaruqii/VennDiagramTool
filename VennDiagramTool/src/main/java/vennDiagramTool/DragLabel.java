package vennDiagramTool;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragLabel extends JLabel {
Point startingPoint;


	public DragLabel(String s) {
		super(s);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point location = new Point(getX(),getY());
				Point newLocation = e.getLocationOnScreen();
				if(getParent().getBounds().contains(location)) {
				newLocation.translate(location.x-startingPoint.x, location.y - startingPoint.y);
				newLocation.x = Math.max(newLocation.x, 10);
				newLocation.y = Math.max(newLocation.y, 10);
				newLocation.x = Math.min(newLocation.x, getParent().getWidth()-getWidth());
				newLocation.y = Math.min(newLocation.y, getParent().getHeight()-getHeight());			
				setLocation(newLocation);
			startingPoint = location;
				}
				}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
startingPoint = SwingUtilities.convertPoint((Component)e.getSource(), e.getPoint(), getParent());

			}
			public void mouseReleased(MouseEvent e) {
				startingPoint = null;

							}
		});
	}

}
