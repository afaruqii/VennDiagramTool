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
		frame.setBounds(100, 100, 1300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel Toolbar = new JPanel();
		Toolbar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Toolbar.setBounds(10, 11, 1266, 119);
		frame.getContentPane().add(Toolbar);
		Toolbar.setLayout(null);

		JComboBox numberOfVenns = new JComboBox();
		numberOfVenns.setForeground(Color.BLUE);
		numberOfVenns.setBounds(16, 35, 39, 23);
		Toolbar.add(numberOfVenns);
		numberOfVenns.addItem("2");
		numberOfVenns.addItem("3");
		numberOfVenns.addItem("4");

		JLabel lblNewLabel = new JLabel("Number Of Venns");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(4, 4, 157, 25);
		Toolbar.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(817, 34, 439, 74);
		Toolbar.add(textArea);

		JLabel lblTextEntry = new JLabel("Text Entry");
		lblTextEntry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTextEntry.setBounds(966, 4, 157, 25);
		Toolbar.add(lblTextEntry);

		JButton btnNewButton = new JButton("Create Element");
		btnNewButton.setBounds(701, 56, 109, 23);
		Toolbar.add(btnNewButton);
	
		RoundedPanel B = new RoundedPanel(1200,Color.blue);
		B.setSize(400, 400);
		B.setLocation(161, 141);
		frame.getContentPane().add(B);
		B.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("test");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 69));
		lblNewLabel_1.setBounds(101, 71, 138, 79);
		B.add(lblNewLabel_1);
		
		RoundedPanel A = new RoundedPanel(1200,Color.RED);
		A.setBounds(470, 141, 400, 400);
		frame.getContentPane().add(A);
		A.setLayout(null);
	}
}
