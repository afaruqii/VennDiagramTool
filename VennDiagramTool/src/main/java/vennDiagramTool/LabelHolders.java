package vennDiagramTool;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class LabelHolders extends JTextArea{
	private JLabel Target;
	public LabelHolders(JLabel Target) {
		super();
		this.Target = Target;
		setOpaque(false);
		setLineWrap(true);
		setEditable(false);
		setAlignmentX(CENTER_ALIGNMENT);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (getText().length()<=1) {
					setText(Target.getText());
					setFont(Target.getFont());
					setForeground(Target.getForeground());
					}
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			setBorder(new LineBorder(new Color(0, 0, 0), 1));	
			}
			public void mouseExited(MouseEvent e) {
				setBorder(null);
				Target.setText("");
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
					setText(getText());
			
				
				}
		});
		
	}

}
