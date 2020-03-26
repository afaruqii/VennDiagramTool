package vennDiagramTool;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LabelHolders extends JTextArea{
	private JLabel Target;
	public LabelHolders(JLabel Target) {
		super();
		setOpaque(false);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==127) {
					setText("");
				}
			}
		});
		this.Target = Target;
		setLineWrap(true);
		setEditable(false);
		setAlignmentX(CENTER_ALIGNMENT);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (getText().length()<=1) {
					String str = Target.getText();
					 str = str.replaceAll("\\<.*?\\>", "");
					setText(str);
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
			
		});
		
	}

}
