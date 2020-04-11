package vennDiagramTool;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ToolTipManager;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LabelHolders extends JTextArea implements Serializable {
	private JLabel Target = new JLabel();
public static boolean labelExists = false;

	public LabelHolders(JLabel Target) {
		super(2, 30);
		setOpaque(false);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int kC = e.getKeyCode();
				switch (kC) {
				case (127):
					setText("");
					break;
				case(77): VennGUI.switchA.setText(getText());
						  VennGUI.switchA.setFont(getFont());
						  VennGUI.switchA.setForeground(getForeground());
						  setText("");
						  labelExists = true;
					break;
			}

			}
		});
		this.Target = Target;
		setLineWrap(true);
		setWrapStyleWord(true);
		setEditable(false);
		setAlignmentX(CENTER_ALIGNMENT);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (getText().length() <= 1) {
					String str = Target.getText();
					str = str.replaceAll("\\<.*?\\>", "");
					setText(str);//
					setFont(Target.getFont());
					setForeground(Target.getForeground());
				}
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (labelExists) {
				setBorder(new LineBorder(new Color(0, 0, 0, 125), 1));
				 setToolTipText(VennGUI.switchA.getText());
				 ToolTipManager.sharedInstance().setInitialDelay(5);
				
			}
			}
			public void mouseExited(MouseEvent e) {
				setBorder(null);
				Target.setText("");
				setToolTipText(null);
				ToolTipManager.sharedInstance().setInitialDelay(2000);
				

			}
			public void mouseReleased(MouseEvent e) {
				if(getText().length()<=1) {
				setText(VennGUI.switchA.getText());
				setFont(VennGUI.switchA.getFont());
				setForeground(VennGUI.switchA.getForeground());
				labelExists = false;
				VennGUI.switchA.setText("");
				setToolTipText(null);
				}
			}

		});

	}

}
