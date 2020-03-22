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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(266, 1, 695, 44);
		Toolbar.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setText("Venn Diagram Title");
		textField_1.setToolTipText("Give your Venn Diagram a title");
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
						
						JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
						tglbtnNewToggleButton.setBounds(75, 104, 123, 23);
						frame.getContentPane().add(tglbtnNewToggleButton);
						
						textField_2 = new JTextField();
						textField_2.setHorizontalAlignment(SwingConstants.CENTER);
						textField_2.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
						textField_2.setColumns(10);
						textField_2.setBorder(null);
						textField_2.setBackground(SystemColor.menu);
						textField_2.setBounds(400, 73, 208, 27);
						frame.getContentPane().add(textField_2);
						textField_2.setText("Bubble 1");
						textField_2.setToolTipText("click to give your bubble a title");
						
						textField_3 = new JTextField();
						textField_3.setHorizontalAlignment(SwingConstants.CENTER);
						textField_3.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
						textField_3.setColumns(10);
						textField_3.setBorder(null);
						textField_3.setBackground(SystemColor.menu);
						textField_3.setBounds(635, 71, 208, 27);
						frame.getContentPane().add(textField_3);
						textField_3.setText("Bubble 2");
						textField_3.setToolTipText("click to give your bubble a title");
	}
}
