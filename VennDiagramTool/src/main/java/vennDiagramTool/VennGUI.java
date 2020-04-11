package vennDiagramTool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.checkerframework.common.reflection.qual.GetConstructor;

import javax.swing.JFileChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Panel;
import java.awt.Rectangle;

public class VennGUI {
	int xPos, yPos;
	private JFrame frame;
	private JTextField textField;
	private JTextField titleVenn;
	private JTextField bubbleOne;
	private JTextField bubbleTwo;
	JLabel setterLabel = new JLabel();
	public static JLabel switchA = new JLabel();
	public static boolean mClicked = false;
	public boolean toggleStud = false;
	public File globalSave;
	public static LabelHolders[] lContainer = new LabelHolders[30];
	int reddaz, greenaz, blueaz = 212;
	int reddbz, greenbz, bluebz = 212;
	Checkbox checkbox = new Checkbox("Advanced Mode");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		frame.setResizable(false);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "All unsaved work will be deleted. Exit?",
						"Venn Diagram Tool", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (n == JOptionPane.YES_OPTION) {
					e.getWindow().dispose();
				}
			}
		});
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(31, -37, 1300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Venn Diagram Tool");
		ImageIcon icon = new ImageIcon(getClass().getResource("AppIcon.png"));
		frame.setIconImage(icon.getImage());
		frame.setLocation(screenWidth / 2 - frame.getWidth() / 2, screenHeight / 2 - frame.getHeight() / 2);

		// frame.setLocationRelativeTo(frame.getParent());
		setterLabel.setText(" ");
		JPanel Toolbar = new JPanel();
		Toolbar.setBackground(SystemColor.menu);
		Toolbar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Toolbar.setBounds(349, 11, 538, 52);
		frame.getContentPane().add(Toolbar);
		Toolbar.setLayout(null);

		titleVenn = new JTextField();
		titleVenn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (titleVenn.getText().length() >= 35) // limit to 3 characters
					e.consume();
			}
		});
		titleVenn.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		titleVenn.setBackground(SystemColor.menu);
		titleVenn.setBounds(3, 3, 529, 44);
		Toolbar.add(titleVenn);
		titleVenn.setColumns(10);
		titleVenn.setBorder(null);
		titleVenn.setHorizontalAlignment(JTextField.CENTER);
		titleVenn.setText("Venn Diagram Title");
		titleVenn.setToolTipText("Give your Venn Diagram a title");

		// custom colors
		Color transRed = new Color(255, 99, 71, 100);
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

		LabelHolders lh1 = new LabelHolders(setterLabel);
		lh1.setBounds(75, 57, 211, 41);
		lContainer[0] = lh1;
		panelA.add(lh1);

		LabelHolders lh2 = new LabelHolders(setterLabel);
		lh2.setBounds(36, 100, 226, 41);
		lContainer[1] = lh2;
		panelA.add(lh2);

		LabelHolders lh3 = new LabelHolders(setterLabel);
		lh3.setBounds(10, 143, 238, 41);
		lContainer[2] = lh3;
		panelA.add(lh3);

		LabelHolders lh4 = new LabelHolders(setterLabel);
		lh4.setBounds(16, 272, 226, 41);
		lContainer[3] = lh4;
		panelA.add(lh4);

		LabelHolders lh5 = new LabelHolders(setterLabel);
		lh5.setBounds(2, 229, 238, 41);
		lContainer[4] = lh5;
		panelA.add(lh5);

		LabelHolders lh6 = new LabelHolders(setterLabel);
		lh6.setBounds(3, 186, 234, 41);
		lContainer[5] = lh6;
		panelA.add(lh6);

		LabelHolders lh7 = new LabelHolders(setterLabel);
		lh7.setBounds(33, 315, 215, 41);
		lContainer[6] = lh7;

		panelA.add(lh7);

		LabelHolders lh8 = new LabelHolders(setterLabel);
		lh8.setBounds(69, 358, 221, 41);
		lContainer[7] = lh8;
		panelA.add(lh8);

		LabelHolders lh9 = new LabelHolders(setterLabel);
		lh9.setBounds(131, 401, 191, 41);
		lContainer[8] = lh9;
		panelA.add(lh9);

		LabelHolders lh10 = new LabelHolders(setterLabel);
		lh10.setBounds(290, 63, 111, 45);
		lContainer[9] = lh10;
		panelA.add(lh10);

		LabelHolders lh11 = new LabelHolders(setterLabel);
		lh11.setBounds(264, 109, 161, 43);
		lContainer[10] = lh11;
		panelA.add(lh11);

		LabelHolders lh12 = new LabelHolders(setterLabel);
		lh12.setBounds(250, 154, 198, 41);
		lContainer[11] = lh12;
		panelA.add(lh12);

		LabelHolders lh13 = new LabelHolders(setterLabel);
		lh13.setBounds(241, 197, 211, 44);
		lContainer[12] = lh13;
		panelA.add(lh13);

		LabelHolders lh14 = new LabelHolders(setterLabel);
		lh14.setBounds(244, 242, 205, 42);
		lContainer[13] = lh14;
		panelA.add(lh14);

		LabelHolders lh15 = new LabelHolders(setterLabel);
		lh15.setBounds(249, 285, 194, 51);
		lContainer[14] = lh15;
		panelA.add(lh15);

		LabelHolders lh16 = new LabelHolders(setterLabel);
		lh16.setBounds(294, 337, 105, 61);
		lContainer[15] = lh16;
		panelA.add(lh16);

		LabelHolders lh17 = new LabelHolders(setterLabel);
		lh17.setBounds(126, 14, 196, 42);
		lContainer[16] = lh17;
		panelA.add(lh17);

		RoundedPanel panelB = new RoundedPanel(1200, transGrey);
		panelB.setBounds(517, 105, 455, 455);
		frame.getContentPane().add(panelB);
		panelB.setLayout(null);

		LabelHolders lh18 = new LabelHolders(setterLabel);
		lh18.setBounds(132, 13, 194, 40);
		lContainer[17] = lh18;
		panelB.add(lh18);

		LabelHolders lh19 = new LabelHolders(setterLabel);
		lh19.setBounds(175, 55, 214, 42);
		lContainer[18] = lh19;
		panelB.add(lh19);

		LabelHolders lh20 = new LabelHolders(setterLabel);
		lh20.setBounds(200, 99, 219, 41);
		lContainer[19] = lh20;
		panelB.add(lh20);

		LabelHolders lh21 = new LabelHolders(setterLabel);
		lh21.setBounds(217, 142, 230, 41);
		lContainer[20] = lh21;
		panelB.add(lh21);

		LabelHolders lh22 = new LabelHolders(setterLabel);
		lh22.setBounds(219, 185, 232, 41);
		lContainer[21] = lh22;
		panelB.add(lh22);

		LabelHolders lh23 = new LabelHolders(setterLabel);
		lh23.setBounds(216, 228, 236, 41);
		lContainer[22] = lh23;
		panelB.add(lh23);

		LabelHolders lh24 = new LabelHolders(setterLabel);
		lh24.setBounds(216, 271, 229, 42);
		lContainer[23] = lh24;
		panelB.add(lh24);

		LabelHolders lh25 = new LabelHolders(setterLabel);
		lh25.setBounds(209, 315, 212, 44);
		lContainer[24] = lh25;
		panelB.add(lh25);

		LabelHolders lh26 = new LabelHolders(setterLabel);
		lh26.setBounds(177, 360, 209, 44);
		lContainer[25] = lh26;
		panelB.add(lh26);

		LabelHolders lh27 = new LabelHolders(setterLabel);
		lh27.setBounds(141, 405, 194, 41);
		lContainer[26] = lh27;
		panelB.add(lh27);
		LabelHolders titleV = new LabelHolders(setterLabel);
		lContainer[27] = titleV;
		LabelHolders bubbA = new LabelHolders(setterLabel);
		lContainer[28] = bubbA;
		LabelHolders bubbB = new LabelHolders(setterLabel);
		lContainer[29] = bubbB;
		JPanel layoutPanel = new JPanel();
		layoutPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		layoutPanel.setBounds(10, 228, 246, 214);
		frame.getContentPane().add(layoutPanel);
		layoutPanel.setLayout(null);
		JLabel bubbleLabelFont = new JLabel("Bubble Label Font");
		bubbleLabelFont.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		bubbleLabelFont.setBounds(10, 67, 109, 15);
		layoutPanel.add(bubbleLabelFont);

		JPanel editPanel = new JPanel();
		editPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editPanel.setBounds(1030, 266, 246, 271);
		frame.getContentPane().add(editPanel);
		editPanel.setLayout(null);

		bubbleOne = new JTextField();
		bubbleOne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (bubbleOne.getText().length() >= 15) // limit to 3 characters
					e.consume();
			}
		});
		bubbleOne.setHorizontalAlignment(SwingConstants.CENTER);
		bubbleOne.setAlignmentY(0);
		bubbleOne.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		bubbleOne.setColumns(10);
		bubbleOne.setBorder(null);
		bubbleOne.setBackground(SystemColor.menu);
		bubbleOne.setBounds(354, 66, 270, 35);
		frame.getContentPane().add(bubbleOne);
		bubbleOne.setText("Bubble 1");
		bubbleOne.setToolTipText("click to give bubble A a title");

		bubbleTwo = new JTextField();
		bubbleTwo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (bubbleTwo.getText().length() >= 15) // limit to 3 characters
					e.consume();
			}
		});
		bubbleTwo.setHorizontalAlignment(SwingConstants.CENTER);
		bubbleTwo.setFont(new Font("Myriad Pro", Font.PLAIN, 25));
		bubbleTwo.setColumns(10);
		bubbleTwo.setBorder(null);
		bubbleTwo.setBackground(SystemColor.menu);
		bubbleTwo.setBounds(635, 66, 273, 38);
		frame.getContentPane().add(bubbleTwo);
		bubbleTwo.setText("Bubble 2");
		bubbleTwo.setToolTipText("Click to give Bubble B a title");

		DragLabel draggy = new DragLabel(setterLabel);
		draggy.setBounds(1030, 120, 205, 120);
		draggy.setText("Your elements will appear here");
		draggy.setToolTipText("Click, Hold and Drag into your diagram");

		frame.getContentPane().add(draggy);
		draggy.setVisible(false);
		draggy.setVisible(true);
		draggy.setLocation(1030, 120);

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
		layoutPanel.add(bubbleEditor);

		JComboBox titleEditor = new FontChooser(titleVenn);
		titleEditor.setBounds(10, 29, 215, 22);
		layoutPanel.add(titleEditor);

		JLabel lblTitleFont = new JLabel("Title Font");
		lblTitleFont.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		lblTitleFont.setBounds(10, 15, 109, 15);
		layoutPanel.add(lblTitleFont);

		JLabel bubbleA = new JLabel("Bubble A Color");
		bubbleA.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		bubbleA.setBounds(10, 119, 81, 14);
		layoutPanel.add(bubbleA);
		JLabel bubbleB = new JLabel("Bubble B Color");
		bubbleB.setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		bubbleB.setBounds(10, 163, 81, 14);
		layoutPanel.add(bubbleB);

		JSlider rpanelA = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 212);
		rpanelA.setPaintTicks(true);
		rpanelA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				reddaz = rpanelA.getValue();
				panelA.setPanelColor(new Color(reddaz, greenaz, blueaz, 100));
				panelA.repaint();
			}
		});
		rpanelA.setSnapToTicks(true);
		rpanelA.setMinorTickSpacing(10);
		rpanelA.setMajorTickSpacing(50);
		rpanelA.setBounds(26, 138, 200, 22);

		JSlider gpanelA = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 212);
		gpanelA.setPaintTicks(true);
		gpanelA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				greenaz = gpanelA.getValue();
				panelA.setPanelColor(new Color(reddaz, greenaz, blueaz, 100));
				panelA.repaint();
			}
		});
		gpanelA.setSnapToTicks(true);
		gpanelA.setMinorTickSpacing(10);
		gpanelA.setMajorTickSpacing(50);
		gpanelA.setBounds(26, 162, 200, 22);

		JSlider bpanelA = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 212);
		bpanelA.setPaintTicks(true);
		bpanelA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				blueaz = bpanelA.getValue();
				panelA.setPanelColor(new Color(reddaz, greenaz, blueaz, 100));
				panelA.repaint();
			}
		});
		bpanelA.setSnapToTicks(true);
		bpanelA.setMinorTickSpacing(10);
		bpanelA.setMajorTickSpacing(50);
		bpanelA.setBounds(26, 186, 200, 22);

		JLabel lblR = new JLabel("R:");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblR.setBounds(11, 139, 14, 17);

		JLabel lblG = new JLabel("G:");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblG.setBounds(11, 162, 14, 17);

		JLabel lblB = new JLabel("B:");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblB.setBounds(11, 187, 14, 17);

		JSlider slideB = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 212);
		slideB.setPaintTicks(true);
		slideB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bluebz = slideB.getValue();
				panelB.setPanelColor(new Color(reddbz, greenbz, bluebz, 100));
				panelB.repaint();
			}
		});
		slideB.setSnapToTicks(true);
		slideB.setMinorTickSpacing(10);
		slideB.setMajorTickSpacing(50);
		slideB.setBounds(25, 295, 200, 22);

		JLabel lblB2 = new JLabel("B:");
		lblB2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblB2.setBounds(10, 296, 14, 17);

		JLabel lblG2 = new JLabel("G:");
		lblG2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblG2.setBounds(10, 271, 14, 17);

		JSlider slideG = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 212);
		slideG.setPaintTicks(true);
		slideG.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				greenbz = slideG.getValue();
				panelB.setPanelColor(new Color(reddbz, greenbz, bluebz, 100));
				panelB.repaint();
			}
		});
		slideG.setSnapToTicks(true);
		slideG.setMinorTickSpacing(10);
		slideG.setMajorTickSpacing(50);
		slideG.setBounds(25, 271, 200, 22);

		JSlider slideR = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 212);
		slideR.setPaintTicks(true);
		slideR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				reddbz = slideR.getValue();
				panelB.setPanelColor(new Color(reddbz, greenbz, bluebz, 100));
				panelB.repaint();
			}
		});
		slideR.setSnapToTicks(true);
		slideR.setMinorTickSpacing(10);
		slideR.setMajorTickSpacing(50);
		slideR.setBounds(25, 247, 200, 22);

		JLabel lblR2 = new JLabel("R:");
		lblR2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblR2.setBounds(10, 248, 14, 17);

		JComboBox bubbleBColor = new JComboBox();
		bubbleBColor.setBounds(10, 175, 81, 22);
		layoutPanel.add(bubbleBColor);
		bubbleBColor.addItem("Grey");
		bubbleBColor.addItem("Red");
		bubbleBColor.addItem("Orange");
		bubbleBColor.addItem("Yellow");
		bubbleBColor.addItem("Green");
		bubbleBColor.addItem("Blue");
		bubbleBColor.addItem("Purple");
		bubbleBColor.addItem("Pink");

		JComboBox bubbleAColor = new JComboBox();
		bubbleAColor.setBounds(10, 131, 81, 22);
		layoutPanel.add(bubbleAColor);
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

					panelA.repaint();
					break;
				case "Yellow":
					panelA.setPanelColor(transYellow);

					panelA.repaint();
					break;
				case "Green":
					panelA.setPanelColor(transGreen);

					panelA.repaint();
					break;
				case "Blue":
					panelA.setPanelColor(transBlue);
					panelA.repaint();
					break;
				case "Purple":
					panelA.setPanelColor(transPurp);
					panelA.repaint();
					break;
				case "Pink":
					panelA.setPanelColor(transPink);
					panelA.repaint();
					break;

				}
			}
		});
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

		JTextArea elementBox = new JTextArea();
		elementBox.setBounds(10, 11, 226, 69);
		elementBox.setLineWrap(true);
		elementBox.setWrapStyleWord(true);
		editPanel.add(elementBox);

		JComboBox fonty = new FontChooser(elementBox);
		fonty.setBounds(10, 91, 226, 22);
		editPanel.add(fonty);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draggy.setVisible(true);
				draggy.setLocation(1030, 119);
				String str = "";
				draggy.setText("<html><p>" + elementBox.getText() + " </p></html>");
				draggy.setFont(elementBox.getFont());
				draggy.setForeground(elementBox.getForeground());
				elementBox.setText("");

			}
		});
		btnNewButton.setBounds(65, 229, 118, 23);
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

		// initial frames per second

		JSlider fontSizer = new JSlider(JSlider.HORIZONTAL, 6, 18, 10);
		fontSizer.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				elementBox.setFont(new Font(elementBox.getFont().getName(), elementBox.getFont().getStyle(),
						fontSizer.getValue()));
			}
		});

		fontSizer.setSnapToTicks(true);
		fontSizer.setMajorTickSpacing(2);
		fontSizer.setMinorTickSpacing(1);
		fontSizer.setPaintTicks(true);
		fontSizer.setPaintLabels(true);
		fontSizer.setBounds(10, 184, 211, 44);
		editPanel.add(fontSizer);

		JLabel lblNewLabel = new JLabel("Text Size");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(7, 164, 72, 19);
		editPanel.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(2, 2, 107, 22);
		frame.getContentPane().add(menuBar);

		JMenuItem sF = new JMenuItem("Save");
		sF.setEnabled(false);
		sF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lContainer[27].setText(titleVenn.getText());
					lContainer[27].setFont(titleVenn.getFont());
					lContainer[28].setText(bubbleOne.getText());
					lContainer[28].setFont(bubbleOne.getFont());
					lContainer[28].setForeground(panelA.getBackgroundColor());
					lContainer[29].setText(bubbleTwo.getText());
					lContainer[29].setFont(bubbleTwo.getFont());
					lContainer[29].setForeground(panelB.getBackgroundColor());
					ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream(globalSave.getAbsoluteFile()));
					x.writeObject(lContainer);
					x.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("lets try again shall we?");
				}
			}
		});

		JMenu fileM = new JMenu("File");
		JMenuItem oF = new JMenuItem("Open File");
		oF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File(System.getProperty("user.home")));

				fs.setDialogTitle("Open Venn Diagram");
				fs.setFileFilter(new FileNameExtensionFilter(".venn Files", "venn"));

				if (fs.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					globalSave = fs.getSelectedFile();
					try {
						ObjectInputStream x = new ObjectInputStream(new FileInputStream(globalSave));
						LabelHolders[] l = (LabelHolders[]) x.readObject();
						x.close();
						for (int i = 0; i < 30; i++) {
							lContainer[i].setText(l[i].getText());
							lContainer[i].setFont(l[i].getFont());
							lContainer[i].setForeground(l[i].getForeground());
						}
						titleVenn.setText(l[27].getText());
						titleVenn.setFont(l[27].getFont());
						bubbleOne.setText(l[28].getText());
						bubbleOne.setFont(l[28].getFont());
						panelA.setPanelColor(l[28].getForeground());
						panelA.repaint();
						bubbleTwo.setText(l[29].getText());
						bubbleTwo.setFont(l[29].getFont());
						panelB.repaint();
						panelB.setPanelColor(l[29].getForeground());

					} catch (IOException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sF.setEnabled(true);
				}

			}

		});

		JMenuItem saF = new JMenuItem("Save As");
		saF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lContainer[27].setText(titleVenn.getText());
				lContainer[27].setFont(titleVenn.getFont());
				lContainer[28].setText(bubbleOne.getText());
				lContainer[28].setFont(bubbleOne.getFont());
				lContainer[28].setForeground(panelA.getBackgroundColor());
				lContainer[29].setText(bubbleTwo.getText());
				lContainer[29].setFont(bubbleTwo.getFont());
				lContainer[29].setForeground(panelB.getBackgroundColor());

				JFileChooser fs = new JFileChooser(new File(System.getProperty("user.home")));

				fs.setDialogTitle("Save Venn Diagram");
				fs.setFileFilter(new FileNameExtensionFilter(".venn Files", "venn"));
				if (fs.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						File saveF;
						saveF = new File(fs.getSelectedFile() + ".venn");
						ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream(saveF));
						x.writeObject(lContainer);
						x.close();
						globalSave = saveF;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("lets try again shall we?");

					}

				}
			}
		});

		JMenuItem eF = new JMenuItem("Exit");
		eF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "All unsaved work will be deleted. Exit?",
						"Venn Diagram Tool", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		JMenuItem rF = new JMenuItem("Export");
		rF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File(System.getProperty("user.home")));

				fs.setDialogTitle("Save Venn Diagram");
				fs.setFileFilter(new FileNameExtensionFilter(".jpg", ".jpg"));
				if (fs.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						Color c = frame.getContentPane().getBackground();
						// frame.getContentPane().setBackground(Color.WHITE);
						checkbox.setVisible(false);
						layoutEditor.setVisible(false);
						layoutPanel.setVisible(false);
						elementCreator.setVisible(false);
						editPanel.setVisible(false);
						bubbleOne.setEditable(false);
						bubbleTwo.setEditable(false);
						titleVenn.setEditable(false);
						menuBar.setVisible(false);

						draggy.setVisible(false);
						Toolbar.setBackground(Color.WHITE);
						titleVenn.setBackground(Color.WHITE);
						frame.getContentPane().setBackground(Color.WHITE);
						bubbleOne.setBackground(Color.WHITE);
						bubbleTwo.setBackground(Color.WHITE);

						File screenF;
						screenF = new File(fs.getSelectedFile() + ".jpg");
						BufferedImage img = new BufferedImage(frame.getContentPane().getWidth(),
								frame.getContentPane().getHeight(), BufferedImage.TYPE_INT_RGB);
						frame.getContentPane().paint(img.getGraphics());
						ImageIO.write(img, "jpg", screenF);
						checkbox.setVisible(true);
						layoutEditor.setVisible(true);
						layoutPanel.setVisible(true);
						elementCreator.setVisible(true);
						editPanel.setVisible(true);
						bubbleOne.setEditable(true);
						bubbleTwo.setEditable(true);
						titleVenn.setEditable(true);
						menuBar.setVisible(true);
						draggy.setVisible(true);

						Toolbar.setBackground(c);
						titleVenn.setBackground(c);
						frame.getContentPane().setBackground(c);
						bubbleOne.setBackground(c);
						bubbleTwo.setBackground(c);

						// frame.getContentPane().setBackground(c);
					} catch (IOException ex) {
						System.err.println(ex);
					}

				}
			}

		});

		fileM.add(oF);
		fileM.add(sF);
		fileM.add(saF);
		fileM.add(rF);
		fileM.add(eF);

		menuBar.add(fileM);

		JMenu helpM = new JMenu("Help");
		JMenuItem abt = new JMenuItem("About");
		abt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "A simple but Powerful Venn Diagram Tool. Use wisely...",
						"Venn Diagram Tool", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem gs = new JMenuItem("Getting started");
		JMenuItem gr = new JMenuItem("Github Repo");
		gr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop()
							.browse(java.net.URI.create("https://github.com/chutneyslurpee/VennDiagramTool"));
				} catch (java.io.IOException f) {
					System.out.println(f.getMessage());
				}
			}
		});
		helpM.add(abt);
		helpM.add(gs);
		helpM.add(gr);
		
		JMenu editM = new JMenu("Edit");
		JMenuItem cl = new JMenuItem("Clear All");
		JMenuItem tD = new JMenuItem("Enable/Disable Design Studio");
		tD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!toggleStud) {
					checkbox.setVisible(false);
					layoutEditor.setVisible(false);
					layoutPanel.setVisible(false);
					elementCreator.setVisible(false);
					editPanel.setVisible(false);
					bubbleOne.setEditable(false);
					bubbleTwo.setEditable(false);
					titleVenn.setEditable(false);
					toggleStud = true;

				} else {
					checkbox.setVisible(true);
					layoutEditor.setVisible(true);
					layoutPanel.setVisible(true);
					elementCreator.setVisible(true);
					editPanel.setVisible(true);
					titleVenn.setEditable(true);
					bubbleOne.setEditable(true);
					bubbleTwo.setEditable(true);
					toggleStud = false;
				}

			}
		});

		cl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 27; i++) {
					lContainer[i].setText("");
				}
			}
		});
		editM.add(tD);
		editM.add(cl);
		menuBar.add(editM);
		menuBar.add(helpM);
		checkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					layoutPanel.setSize(246, 214);
					bubbleB.setLocation(10, 159);
					layoutPanel.remove(rpanelA);
					layoutPanel.remove(gpanelA);
					layoutPanel.remove(bpanelA);
					layoutPanel.remove(lblR);
					layoutPanel.remove(lblG);
					layoutPanel.remove(lblB);
					layoutPanel.remove(slideB);
					layoutPanel.remove(lblB2);
					layoutPanel.remove(lblG2);
					layoutPanel.remove(slideG);
					layoutPanel.remove(slideR);
					layoutPanel.remove(lblR2);
					layoutPanel.add(bubbleAColor);
					layoutPanel.add(bubbleBColor);
					layoutPanel.repaint();

				}
				if (e.getStateChange() == ItemEvent.SELECTED) {
					layoutPanel.setSize(246, 323);
					bubbleB.setLocation(10, 229);
					layoutPanel.add(rpanelA);
					layoutPanel.add(gpanelA);
					layoutPanel.add(bpanelA);
					layoutPanel.add(lblR);
					layoutPanel.add(lblG);
					layoutPanel.add(lblB);
					layoutPanel.add(slideB);
					layoutPanel.add(lblB2);
					layoutPanel.add(lblG2);
					layoutPanel.add(slideG);
					layoutPanel.add(slideR);
					layoutPanel.add(lblR2);
					layoutPanel.remove(bubbleAColor);
					layoutPanel.remove(bubbleBColor);
					layoutPanel.repaint();
				}
			}
		});

		checkbox.setBounds(101, 198, 120, 21);
		frame.getContentPane().add(checkbox);

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

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});

	}
}
