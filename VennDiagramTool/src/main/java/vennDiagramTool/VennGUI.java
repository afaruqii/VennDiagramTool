package vennDiagramTool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

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
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Insets;

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
		// Get the computer's monitor dimensionss
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(31, -37, 1300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Venn Diagram Tool");
		ImageIcon icon = new ImageIcon(getClass().getResource("AppIcon.png"));
		frame.setIconImage(icon.getImage());
		frame.setLocation(screenWidth/2 - frame.getWidth()/2, screenHeight/2 - frame.getHeight()/2); // centre the JFrame
		

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
		Color transOrange = new Color (255,153,0,100);
		Color transYellow = new Color(252,252,5,100);
		Color transGreen = new Color(5, 230, 95, 100);
		Color transBlue = new Color(50, 118, 245, 100);
		Color transPurp = new Color(110,0,245,100);
		Color transPink = new Color (255,0,179,100);
		Color transGrey = new Color (212,212,212,100);
		
		RoundedPanel panelA = new RoundedPanel(1200,transGrey);
		panelA.setSize(455, 455);
		panelA.setLocation(276, 104);
		frame.getContentPane().add(panelA);
		panelA.setLayout(null);
	
		
		RoundedPanel panelB = new RoundedPanel(1200, transGrey);
		panelB.setBounds(516, 103, 455, 455);
		frame.getContentPane().add(panelB);
		GridBagLayout gbl_A = new GridBagLayout();
		gbl_A.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_A.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_A.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_A.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelB.setLayout(gbl_A);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 228, 246, 285);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel bubbleLabelFont = new JLabel("Bubble Label Font");
		bubbleLabelFont.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		bubbleLabelFont.setBounds(10, 67, 109, 15);
		panel.add(bubbleLabelFont);
		
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
		btnNewButton.setBounds(72, 213, 118, 23);
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

		JLabel elementCreator = new JLabel("Element Creator");
		elementCreator.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		elementCreator.setBounds(1030, 244, 120, 19);
		frame.getContentPane().add(elementCreator);
		
		JLabel layoutEditor = new JLabel("Layout Editor");
		layoutEditor.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		layoutEditor.setBounds(10, 203, 93, 19);
		frame.getContentPane().add(layoutEditor);
		
		
		JComboBox bubbleEditor = new FontChooser(bubbleTwo, bubbleOne);
		bubbleEditor.setBounds(10, 81, 215, 22);
		panel.add(bubbleEditor);
		
		JComboBox titleEditor = new FontChooser(titleVenn);
		titleEditor.setBounds(10, 25, 215, 22);
		panel.add(titleEditor);
		
		JLabel lblTitleFont = new JLabel("Title Font");
		lblTitleFont.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		lblTitleFont.setBounds(10, 11, 109, 15);
		panel.add(lblTitleFont);
		
		JLabel bubbleA = new JLabel("Bubble A Color");
		bubbleA.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		bubbleA.setBounds(10, 122, 81, 14);
		panel.add(bubbleA);
		
		JComboBox bubbleAColor = new JComboBox();
		bubbleAColor.setBounds(10, 136, 81, 22);
		bubbleAColor.addItem("Grey");
		bubbleAColor.addItem("Red");
		bubbleAColor.addItem("Orange");
		bubbleAColor.addItem("Yellow");
		bubbleAColor.addItem("Green");
		bubbleAColor.addItem("Blue");
		bubbleAColor.addItem("Purple");
		bubbleAColor.addItem("Pink");
		bubbleAColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String msg = (String) bubbleAColor.getSelectedItem();
			switch(msg) {
			case "Grey" : panelA.setPanelColor(transGrey);
			panelA.repaint();
			break;
			case "Red" : panelA.setPanelColor(transRed);
			panelA.repaint();
			break;	
			case "Orange" : panelA.setPanelColor(transOrange);
			panelA.repaint();
			break;	
			case "Yellow" : panelA.setPanelColor(transYellow);
			panelA.repaint();
			break;	
			case "Green" : panelA.setPanelColor(transGreen);
			panelA.repaint();
			break;
			case "Blue" : panelA.setPanelColor(transBlue);
			panelA.repaint();
			break;	
			case "Purple" : panelA.setPanelColor(transPurp);
			panelA.repaint();
			break;
			case "Pink" : panelA.setPanelColor(transPink);
			panelA.repaint();
			break;	
			
	}
	}
		});
		panel.add(bubbleAColor);
		
		
		JComboBox bubbleBColor = new JComboBox();
		bubbleBColor.setBounds(10, 191, 81, 22);
		bubbleBColor.addItem("Grey");
		bubbleBColor.addItem("Red");
		bubbleBColor.addItem("Orange");
		bubbleBColor.addItem("Yellow");
		bubbleBColor.addItem("Green");
		bubbleBColor.addItem("Blue");
		bubbleBColor.addItem("Purple");
		bubbleBColor.addItem("Pink");
		
		bubbleBColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String msg = (String) bubbleBColor.getSelectedItem();
			switch(msg) {
			case "Grey" : panelB.setPanelColor(transGrey);
			panelB.repaint();
			break;
			case "Red" : panelB.setPanelColor(transRed);
			panelB.repaint();
			break;	
			case "Orange" : panelB.setPanelColor(transOrange);
			panelB.repaint();
			break;	
			case "Yellow" : panelB.setPanelColor(transYellow);
			panelB.repaint();
			break;	
			case "Green" : panelB.setPanelColor(transGreen);
			panelB.repaint();
			break;
			case "Blue" : panelB.setPanelColor(transBlue);
			panelB.repaint();
			break;	
			case "Purple" : panelB.setPanelColor(transPurp);
			panelB.repaint();
			break;
			case "Pink" : panelB.setPanelColor(transPink);
			panelB.repaint();
			break;	
			
	}
	}
		});
		panel.add(bubbleBColor);
		
		JLabel bubbleB = new JLabel("Bubble B Color");
		bubbleB.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		bubbleB.setBounds(10, 177, 81, 14);
		panel.add(bubbleB);
	}
}
