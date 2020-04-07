package vennDiagramTool;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;

import vennDiagramTool.LabelHolders;

public class DragLabel extends JLabel implements Serializable {
	Point startingPoint;
	JLabel Target;

	public DragLabel(JLabel Target) {
		super();
		this.Target = Target;
		setOpaque(false);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				Point p = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), getParent());
				p.x = p.x - (getWidth()/2);
				p.y = p.y - (getHeight()/2);
				e.getComponent().setLocation(p.x, p.y);
				setGlobal(Target);
				LabelHolders.labelExists = true;
			}

		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startingPoint = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), getParent());
			}
			public void mouseReleased(MouseEvent e) {
				startingPoint = null;
				setVisible(false);
				LabelHolders.labelExists = false;

			}
		});
	}

	public void setGlobal(JLabel Target) {
		Target.setText(getText());
		Target.setFont(getFont());
		Target.setForeground(getForeground());

	}
	

}
