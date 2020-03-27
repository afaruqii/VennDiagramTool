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

public class LabelHolders extends JTextArea {
	private JLabel Target = new JLabel();
public JLabel switchA = new JLabel();
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
				setBorder(new LineBorder(new Color(0, 0, 0), 1));
			}
			}
			public void mouseExited(MouseEvent e) {
				setBorder(null);
				Target.setText("");

			}

		});

	}

}
