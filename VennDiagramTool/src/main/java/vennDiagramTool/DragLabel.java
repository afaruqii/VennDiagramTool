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

public class DragLabel extends JLabel {
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
				e.getComponent().setLocation(p.x, p.y);
				setGlobal(Target);
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

			}
		});
	}

	public void setGlobal(JLabel Target) {
		Target.setText(getText());
		Target.setFont(getFont());
		Target.setForeground(getForeground());

	}
	

}
