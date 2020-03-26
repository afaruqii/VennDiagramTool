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
import java.awt.TextArea;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VennGUI {

	int xPos, yPos;
	private JFrame frame;
	private JTextField textField;
	private JTextField titleVenn;
	private JTextField bubbleOne;
	private JTextField bubbleTwo;
	JLabel glooba = new JLabel();

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
		// Get the computer's monitor dimensions
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
		frame.setLocation(screenWidth / 2 - frame.getWidth() / 2, screenHeight / 2 - frame.getHeight() / 2);
																												
		glooba.setText(" ");
		JPanel Toolbar = new JPanel();
		Toolbar.setBackground(SystemColor.menu);
		Toolbar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Toolbar.setBounds(10, 11, 1266, 52);
		frame.getContentPane().add(Toolbar);
		Toolbar.setLayout(null);

		titleVenn = new JTextField();
		titleVenn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (titleVenn.getText().length() >= 35 ) // limit to 3 characters
	                e.consume();
			}
		});
		titleVenn.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		titleVenn.setBackground(SystemColor.menu);
		titleVenn.setBounds(277, 1, 638, 44);
		Toolbar.add(titleVenn);
		titleVenn.setColumns(10);
		titleVenn.setBorder(null);
		titleVenn.setHorizontalAlignment(JTextField.CENTER);
		titleVenn.setText("Venn Diagram Title");
		titleVenn.setToolTipText("Give your Venn Diagram a title");
		// custom colors
		Color transRed = new Color(226, 155, 155, 100);
		Color transOrange = new Color(255, 153, 0, 100);
		Color transYellow = new Color(252, 252, 5, 100);
		Color transGreen = new Color(5, 230, 95, 100);
		Color transBlue = new Color(50, 118, 245, 100);
		Color transPurp = new Color(110, 0, 245, 100);
		Color transPink = new Color(255, 0, 179, 100);
		Color transGrey = new Color(212, 212, 212, 100);

		RoundedPanel panelA = new RoundedPanel(1200, transGrey);
		panelA.setSize(455, 455);
		panelA.setLocation(282, 105);
		frame.getContentPane().add(panelA);
		panelA.setLayout(null);
		
		LabelHolders labelHolders = new LabelHolders(glooba);
		labelHolders.setBounds(75, 57, 211, 41);
		panelA.add(labelHolders);
		
		LabelHolders labelHolders_1 = new LabelHolders(glooba);
		labelHolders_1.setBounds(36, 100, 226, 41);
		panelA.add(labelHolders_1);
		
		LabelHolders labelHolders_2 = new LabelHolders(glooba);
		labelHolders_2.setBounds(10, 143, 238, 41);
		panelA.add(labelHolders_2);
		
		LabelHolders labelHolders_3 = new LabelHolders(glooba);
		labelHolders_3.setBounds(16, 272, 226, 41);
		panelA.add(labelHolders_3);
		
		LabelHolders labelHolders_4 = new LabelHolders(glooba);
		labelHolders_4.setBounds(2, 229, 238, 41);
		panelA.add(labelHolders_4);
		
		LabelHolders labelHolders_5 = new LabelHolders(glooba);
		labelHolders_5.setBounds(3, 186, 234, 41);
		panelA.add(labelHolders_5);
		
		LabelHolders labelHolders_6 = new LabelHolders(glooba);
		labelHolders_6.setBounds(33, 315, 217, 41);
		panelA.add(labelHolders_6);
		
		LabelHolders labelHolders_7 = new LabelHolders(glooba);
		labelHolders_7.setBounds(69, 358, 221, 41);
		panelA.add(labelHolders_7);
		
		LabelHolders labelHolders_8 = new LabelHolders(glooba);
		labelHolders_8.setBounds(131, 401, 191, 41);
		panelA.add(labelHolders_8);
		
		LabelHolders labelHolders_19 = new LabelHolders(glooba);
		labelHolders_19.setBounds(290, 67, 111, 41);
		panelA.add(labelHolders_19);
		
		LabelHolders labelHolders_20 = new LabelHolders(glooba);
		labelHolders_20.setBounds(264, 111, 161, 41);
		panelA.add(labelHolders_20);
		
		LabelHolders labelHolders_21 = new LabelHolders(glooba);
		labelHolders_21.setBounds(250, 154, 198, 41);
		panelA.add(labelHolders_21);
		
		LabelHolders labelHolders_22 = new LabelHolders(glooba);
		labelHolders_22.setBounds(241, 197, 211, 41);
		panelA.add(labelHolders_22);
		
		LabelHolders labelHolders_23 = new LabelHolders(glooba);
		labelHolders_23.setBounds(244, 241, 205, 41);
		panelA.add(labelHolders_23);
		
		LabelHolders labelHolders_24 = new LabelHolders(glooba);
		labelHolders_24.setBounds(248, 284, 202, 41);
		panelA.add(labelHolders_24);
		
		LabelHolders labelHolders_25 = new LabelHolders(glooba);
		labelHolders_25.setBounds(288, 345, 114, 44);
		panelA.add(labelHolders_25);
		
				LabelHolders textArea = new LabelHolders(glooba);
				textArea.setBounds(112, 19, 206, 35);
				panelA.add(textArea);
				
				

		RoundedPanel panelB = new RoundedPanel(1200, transGrey);
		panelB.setBounds(517, 105, 455, 455);
		frame.getContentPane().add(panelB);
		panelB.setLayout(null);
		
		LabelHolders labelHolders_9 = new LabelHolders(glooba);
		labelHolders_9.setBounds(136, 15, 192, 40);
		panelB.add(labelHolders_9);
		
		LabelHolders labelHolders_10 = new LabelHolders(glooba);
		labelHolders_10.setBounds(176, 57, 204, 40);
		panelB.add(labelHolders_10);
		
		LabelHolders labelHolders_11 = new LabelHolders(glooba);
		labelHolders_11.setBounds(200, 99, 219, 41);
		panelB.add(labelHolders_11);
		
		LabelHolders labelHolders_12 = new LabelHolders(glooba);
		labelHolders_12.setBounds(217, 142, 230, 41);
		panelB.add(labelHolders_12);
		
		LabelHolders labelHolders_13 = new LabelHolders(glooba);
		labelHolders_13.setBounds(219, 185, 232, 41);
		panelB.add(labelHolders_13);
		
		LabelHolders labelHolders_14 = new LabelHolders(glooba);
		labelHolders_14.setBounds(216, 228, 236, 41);
		panelB.add(labelHolders_14);
		
		LabelHolders labelHolders_15 = new LabelHolders(glooba);
		labelHolders_15.setBounds(216, 271, 229, 41);
		panelB.add(labelHolders_15);
		
		LabelHolders labelHolders_16 = new LabelHolders(glooba);
		labelHolders_16.setBounds(206, 315, 215, 41);
		panelB.add(labelHolders_16);
		
		LabelHolders labelHolders_17 = new LabelHolders(glooba);
		labelHolders_17.setBounds(177, 359, 209, 41);
		panelB.add(labelHolders_17);
		
		LabelHolders labelHolders_18 = new LabelHolders(glooba);
		labelHolders_18.setBounds(140, 405, 199, 41);
		panelB.add(labelHolders_18);
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

		bubbleOne = new JTextField();
		bubbleOne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (bubbleOne.getText().length() >= 15 ) // limit to 3 characters
	                e.consume();
			}
		});
		bubbleOne.setHorizontalAlignment(SwingConstants.CENTER);
		bubbleOne.setAlignmentY(0);
		bubbleOne.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		bubbleOne.setColumns(10);
		bubbleOne.setBorder(null);
		bubbleOne.setBackground(SystemColor.menu);
		bubbleOne.setBounds(385, 66, 223, 35);
		frame.getContentPane().add(bubbleOne);
		bubbleOne.setText("Bubble 1");
		bubbleOne.setToolTipText("click to give your bubble a title");

		bubbleTwo = new JTextField();
		bubbleTwo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (bubbleTwo.getText().length() >= 15 ) // limit to 3 characters
	                e.consume();
			}
		});
		bubbleTwo.setHorizontalAlignment(SwingConstants.CENTER);
		bubbleTwo.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		bubbleTwo.setColumns(10);
		bubbleTwo.setBorder(null);
		bubbleTwo.setBackground(SystemColor.menu);
		bubbleTwo.setBounds(635, 66, 237, 38);
		frame.getContentPane().add(bubbleTwo);
		bubbleTwo.setText("Bubble 2");
		bubbleTwo.setToolTipText("click to give your bubble a title");
		
		
		
		DragLabel lblNewLabel = new DragLabel(glooba);
		lblNewLabel.setBounds(1031, 120, 198, 104);	 
		lblNewLabel.setText("Your elements will appear here");
		
		
		
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		lblNewLabel.setVisible(true);
		lblNewLabel.setLocation(1030, 120);

		JLabel elementCreator = new JLabel("Element Tray");
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
		panel.add(bubbleAColor);
		bubbleAColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = (String) bubbleAColor.getSelectedItem();
				switch (msg) {
				case "Grey":
					panelA.setPanelColor(transGrey);
					panelA.revalidate();
					panelA.repaint();

					break;
				case "Red":
					panelA.setPanelColor(transRed);
					panelA.revalidate();
					panelA.repaint();
					break;
				case "Orange":
					panelA.setPanelColor(transOrange);
					panelA.revalidate();
					panelA.repaint();
					break;
				case "Yellow":
					panelA.setPanelColor(transYellow);
					panelA.revalidate();
					panelA.repaint();
					break;
				case "Green":
					panelA.setPanelColor(transGreen);
					panelA.revalidate();
					panelA.repaint();
					break;
				case "Blue":
					panelA.setPanelColor(transBlue);
					panelA.revalidate();
					panelA.repaint();
					break;
				case "Purple":
					panelA.setPanelColor(transPurp);
					panelA.revalidate();
					panelA.repaint();
					break;
				case "Pink":
					panelA.setPanelColor(transPink);
					panelA.revalidate();
					panelA.repaint();
					break;

				}
			}
		});

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
		panel.add(bubbleBColor);
		bubbleBColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = (String) bubbleBColor.getSelectedItem();
				switch (msg) {
				case "Grey":
					panelB.setPanelColor(transGrey);
					panelB.repaint();
					break;
				case "Red":
					panelB.setPanelColor(transRed);
					panelB.repaint();
					break;
				case "Orange":
					panelB.setPanelColor(transOrange);
					panelB.repaint();
					break;
				case "Yellow":
					panelB.setPanelColor(transYellow);
					panelB.repaint();
					break;
				case "Green":
					panelB.setPanelColor(transGreen);
					panelB.repaint();
					break;
				case "Blue":
					panelB.setPanelColor(transBlue);
					panelB.repaint();
					break;
				case "Purple":
					panelB.setPanelColor(transPurp);
					panelB.repaint();
					break;
				case "Pink":
					panelB.setPanelColor(transPink);
					panelB.repaint();
					break;

				}
			}
		});

		JLabel bubbleB = new JLabel("Bubble B Color");
		bubbleB.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		bubbleB.setBounds(10, 177, 81, 14);
		panel.add(bubbleB);

		

		JTextArea elementBox = new JTextArea();
		elementBox.setBounds(10, 11, 226, 69);
		elementBox.setLineWrap(true);
		editPanel.add(elementBox);
		
		JComboBox fonty = new FontChooser(elementBox);
		fonty.setBounds(10, 91, 226, 22);
		editPanel.add(fonty);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				lblNewLabel.setLocation(1030, 119);
				String str = "";
				lblNewLabel.setText("<html><p>" + elementBox.getText()+ "</p></html>");
				lblNewLabel.setFont(elementBox.getFont());
				lblNewLabel.setForeground(elementBox.getForeground());
				elementBox.setText(""); 
				
			}
		});
		btnNewButton.setBounds(72, 213, 118, 23);
		editPanel.add(btnNewButton);
		JComboBox ElementColor = new JComboBox();
		ElementColor.setBounds(10, 124, 81, 22);
		editPanel.add(ElementColor);
		ElementColor.addItem("Black");
		ElementColor.addItem("Red");
		ElementColor.addItem("Orange");
		ElementColor.addItem("Yellow");
		ElementColor.addItem("Green");
		ElementColor.addItem("Blue");
		ElementColor.addItem("Purple");
		ElementColor.addItem("Pink");

		ElementColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = (String) ElementColor.getSelectedItem();
				switch (msg) {
				case "Black":
					elementBox.setForeground(Color.BLACK);
					break;
				case "Red":
					elementBox.setForeground(Color.RED);

					break;
				case "Orange":
					elementBox.setForeground(Color.ORANGE);

					break;
				case "Yellow":
					elementBox.setForeground(Color.YELLOW);

					break;
				case "Green":
					elementBox.setForeground(Color.GREEN);

					break;
				case "Blue":
					elementBox.setForeground(Color.BLUE);
					break;
				case "Purple":
					elementBox.setForeground(transPurp);
					break;
				case "Pink":
					elementBox.setForeground(Color.MAGENTA);
					break;

				}
			}
		});

	}
}
