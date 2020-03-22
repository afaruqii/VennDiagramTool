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
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class VennGUI {
//here we go
	private JFrame frame;
	private JTextField textField;

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
		gbl_A.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_A.rowHeights = new int[]{0, 0};
		gbl_A.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_A.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		A.setLayout(gbl_A);
						
						JPanel panel = new JPanel();
						panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						panel.setBounds(10, 149, 162, 119);
						frame.getContentPane().add(panel);
						panel.setLayout(null);
						
						JButton btnNewButton = new JButton("Create Element");
						
						btnNewButton.setBounds(10, 85, 109, 23);
						panel.add(btnNewButton);				
						JLabel lblNewLabel = new JLabel("Bubble 1");
						lblNewLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
							}
						});
						lblNewLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
						lblNewLabel.setBounds(460, 77, 92, 31);
						frame.getContentPane().add(lblNewLabel);
						
						JLabel lblBubble = new JLabel("Bubble 2");
						lblBubble.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
						lblBubble.setBounds(699, 77, 92, 31);
						frame.getContentPane().add(lblBubble);
						
						JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
						tglbtnNewToggleButton.setBounds(75, 104, 123, 23);
						frame.getContentPane().add(tglbtnNewToggleButton);
						
						
						
						
						
						
						
						
						
						
						
						
						
		
	
	}
}
