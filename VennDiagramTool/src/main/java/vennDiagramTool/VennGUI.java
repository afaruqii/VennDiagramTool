package vennDiagramTool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;

public class VennGUI {
//here we go
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VennGUI window = new VennGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VennGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	// add
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(31, -37, 1300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel Toolbar = new JPanel();
		Toolbar.setBackground(SystemColor.menu);
		Toolbar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Toolbar.setBounds(10, 11, 1266, 59);
		frame.getContentPane().add(Toolbar);
		Toolbar.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Venn Diagram Tool");
		lblNewLabel_1.setFont(new Font("Myriad Pro", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(482, 11, 279, 43);
		Toolbar.add(lblNewLabel_1);
	//custom colors
		Color transRed = new Color(226, 155, 155, 100);
		Color transBlue = new Color(50, 118, 245, 100);
		RoundedPanel B = new RoundedPanel(1200,transRed);
		B.setSize(455, 455);
		B.setLocation(276, 104);
		frame.getContentPane().add(B);
		B.setLayout(null);
		
		
		RoundedPanel A = new RoundedPanel(1200,transBlue);
		A.setBounds(516, 103, 455, 455);
		frame.getContentPane().add(A);
		GridBagLayout gbl_A = new GridBagLayout();
		gbl_A.columnWidths = new int[]{0};
		gbl_A.rowHeights = new int[]{0};
		gbl_A.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_A.rowWeights = new double[]{Double.MIN_VALUE};
		A.setLayout(gbl_A);
						
						JPanel panel = new JPanel();
						panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						panel.setBounds(10, 149, 162, 119);
						frame.getContentPane().add(panel);
						
						JLabel lblNewLabel = new JLabel("Bubble 1");
						lblNewLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
						lblNewLabel.setBounds(465, 77, 92, 31);
						frame.getContentPane().add(lblNewLabel);
						
						JLabel lblBubble = new JLabel("Bubble 2");
						lblBubble.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
						lblBubble.setBounds(687, 77, 92, 31);
						frame.getContentPane().add(lblBubble);
		
	
	}
}
