package VennDiagramTool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Toolbar = new JPanel();
		Toolbar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Toolbar.setBounds(10, 11, 1266, 103);
		frame.getContentPane().add(Toolbar);
		Toolbar.setLayout(null);
		
		JComboBox numberOfVenns = new JComboBox();
		numberOfVenns.setBounds(16, 35, 39, 23);
		Toolbar.add(numberOfVenns);
		numberOfVenns.addItem("2");
		numberOfVenns.addItem("3");
		numberOfVenns.addItem("4");
		
		
		JLabel lblNewLabel = new JLabel("Number Of Venns");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(4, 4, 157, 25);
		Toolbar.add(lblNewLabel);
	}
}
