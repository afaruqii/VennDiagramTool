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
import javax.swing.SwingConstants;

public class VennGUI {
//here we go
	private JFrame frame;
	private JTextField textField;
	private JTextField titleVenn;
	private JTextField bubbleOne;
	private JTextField bubbleTwo;

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
		Toolbar.setBounds(10, 11, 1266, 52);
		frame.getContentPane().add(Toolbar);
		Toolbar.setLayout(null);
		
		titleVenn = new JTextField();
		titleVenn.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		titleVenn.setBackground(SystemColor.menu);
		titleVenn.setBounds(266, 1, 695, 44);
		Toolbar.add(titleVenn);
		titleVenn.setColumns(10);
		titleVenn.setBorder(null);
		titleVenn.setHorizontalAlignment(JTextField.CENTER);
		titleVenn.setText("Venn Diagram Title");
		titleVenn.setToolTipText("Give your Venn Diagram a title");
	//custom colors
		Color transRed = new Color(226, 155, 155, 100);
		Color transBlue = new Color(50, 118, 245, 100);
		RoundedPanel B = new RoundedPanel(1200,transRed);
		B.setSize(455, 455);
		B.setLocation(276, 104);
		frame.getContentPane().add(B);
		B.setLayout(null);
		RoundedPanel A = new RoundedPanel(1200, transBlue);
		A.setBounds(516, 103, 455, 455);
		frame.getContentPane().add(A);
		GridBagLayout gbl_A = new GridBagLayout();
		gbl_A.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_A.rowHeights = new int[] { 0, 0 };
		gbl_A.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_A.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		A.setLayout(gbl_A);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 228, 246, 285);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Bubble Label Font");
		lblNewLabel_2.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 65, 109, 15);
		panel.add(lblNewLabel_2);
		
		JPanel editPanel = new JPanel();
		editPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editPanel.setBounds(1030, 266, 246, 247);
		frame.getContentPane().add(editPanel);
		editPanel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 226, 130);
		editPanel.add(textArea);

		JComboBox fonty = new FontChooser(textArea);
		fonty.setBounds(10, 150, 226, 22);
		editPanel.add(fonty);

		JButton btnNewButton = new JButton("Create Element");
		btnNewButton.setBounds(72, 213, 109, 23);
		editPanel.add(btnNewButton);

		
		bubbleOne = new JTextField();
		bubbleOne.setHorizontalAlignment(SwingConstants.CENTER);
		bubbleOne.setAlignmentY(0);
		bubbleOne.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		bubbleOne.setColumns(10);
		bubbleOne.setBorder(null);
		bubbleOne.setBackground(SystemColor.menu);
		bubbleOne.setBounds(400, 65, 208, 38);
		frame.getContentPane().add(bubbleOne);
		bubbleOne.setText("Bubble 1");
		bubbleOne.setToolTipText("click to give your bubble a title");

		bubbleTwo = new JTextField();
		bubbleTwo.setHorizontalAlignment(SwingConstants.CENTER);
		bubbleTwo.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		bubbleTwo.setColumns(10);
		bubbleTwo.setBorder(null);
		bubbleTwo.setBackground(SystemColor.menu);
		bubbleTwo.setBounds(635, 65, 208, 38);
		frame.getContentPane().add(bubbleTwo);
		bubbleTwo.setText("Bubble 2");
		bubbleTwo.setToolTipText("click to give your bubble a title");

		JLabel lblNewLabel = new JLabel("Element Creator");
		lblNewLabel.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		lblNewLabel.setBounds(1030, 244, 120, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Layout Editor");
		lblNewLabel_1.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 203, 83, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JComboBox fontanya = new FontChooser(bubbleTwo, bubbleOne);
		fontanya.setBounds(10, 76, 215, 22);
		panel.add(fontanya);
		
		JComboBox fontina = new FontChooser(titleVenn);
		fontina.setBounds(10, 24, 215, 22);
		panel.add(fontina);
		
		JLabel lblTitleFont = new JLabel("Title Font");
		lblTitleFont.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		lblTitleFont.setBounds(10, 11, 109, 15);
		panel.add(lblTitleFont);
	}
}
