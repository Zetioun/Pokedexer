package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionListener;

import pokemon.Pokemon;
import pokemon.PokemonFactory;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfStartLatitude;
	private JTextField tfStartLongitude;
	private JTextField tfMoveLatitude;
	private JTextField tfMoveLongitude;
	private JTextField tfRegexPokemonName;
	private JTextField tfRegexLatitude;
	private JTextField tfRegexLongitude;
	private JTextField tfURL;
	private JTextField tfStepsLatitude;
	private JTextField tfStepsLongitude;
	private JButton btnScan;
	private JList listPokemon;
	private JList listCoordinate;
	private JTextField coordTextField;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tabbedPane.setBounds(6, 6, 940, 614);
		contentPane.add(tabbedPane);
				
						JPanel panel_1 = new JPanel();
						tabbedPane.addTab("Pokemon", null, panel_1, null);
						panel_1.setLayout(null);
						
								JPanel panel_5 = new JPanel();
								panel_5.setBounds(6, 6, 332, 562);
								panel_1.add(panel_5);
								panel_5.setLayout(null);
								
										btnScan = new JButton("Scan");
										btnScan.setFont(new Font("Tahoma", Font.PLAIN, 21));
										btnScan.setBounds(42, 446, 244, 76);
										panel_5.add(btnScan);
										
												JScrollPane scrollPane = new JScrollPane();
												scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
												scrollPane.setBounds(6, 6, 311, 424);
												panel_5.add(scrollPane);
												
														listPokemon = new JList();
														listPokemon.setFont(new Font("Tahoma", Font.PLAIN, 21));
														scrollPane.setViewportView(listPokemon);
														
																JPanel panel_6 = new JPanel();
																panel_6.setBounds(345, 6, 590, 562);
																panel_1.add(panel_6);
																panel_6.setLayout(null);
																
																		JScrollPane scrollPane_1 = new JScrollPane();
																		scrollPane_1.setBounds(6, 6, 387, 484);
																		panel_6.add(scrollPane_1);
																		
																				listCoordinate = new JList();
																				listCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 25));
																				scrollPane_1.setViewportView(listCoordinate);
																				
																						coordTextField = new JTextField();
																						coordTextField.setFont(new Font("Tahoma", Font.PLAIN, 21));
																						coordTextField.setBounds(6, 495, 387, 56);
																						panel_6.add(coordTextField);
																						coordTextField.setColumns(10);
		
				JPanel panel = new JPanel();
				tabbedPane.addTab("Settings", null, panel, null);
				panel.setLayout(null);
				
						JPanel panel_2 = new JPanel();
						panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
						panel_2.setBounds(6, 6, 418, 227);
						panel.add(panel_2);
						panel_2.setLayout(null);
						
								tfStartLatitude = new JTextField();
								tfStartLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
								tfStartLatitude.setBounds(119, 65, 278, 40);
								panel_2.add(tfStartLatitude);
								tfStartLatitude.setColumns(10);
								
										tfStartLongitude = new JTextField();
										tfStartLongitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
										tfStartLongitude.setBounds(119, 149, 278, 40);
										panel_2.add(tfStartLongitude);
										tfStartLongitude.setColumns(10);
										
												JLabel lblLatitude = new JLabel("Latitude");
												lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
												lblLatitude.setBounds(15, 68, 89, 30);
												panel_2.add(lblLatitude);
												
														JLabel lblLongitude = new JLabel("Longitude");
														lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
														lblLongitude.setBounds(15, 154, 98, 26);
														panel_2.add(lblLongitude);
														
																JLabel lblStartPosition = new JLabel("Start Position");
																lblStartPosition.setFont(new Font("Tahoma", Font.PLAIN, 21));
																lblStartPosition.setBounds(178, 16, 136, 16);
																panel_2.add(lblStartPosition);
																
																		JPanel panel_3 = new JPanel();
																		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
																		panel_3.setBounds(6, 249, 418, 203);
																		panel.add(panel_3);
																		panel_3.setLayout(null);
																		
																				JLabel lblSteps = new JLabel("Movement settings");
																				lblSteps.setFont(new Font("Tahoma", Font.PLAIN, 21));
																				lblSteps.setBounds(84, 6, 196, 32);
																				panel_3.add(lblSteps);
																				
																						tfMoveLatitude = new JTextField();
																						tfMoveLatitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																						tfMoveLatitude.setBounds(209, 69, 188, 40);
																						panel_3.add(tfMoveLatitude);
																						tfMoveLatitude.setColumns(10);
																						
																								tfMoveLongitude = new JTextField();
																								tfMoveLongitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																								tfMoveLongitude.setBounds(209, 147, 188, 40);
																								panel_3.add(tfMoveLongitude);
																								tfMoveLongitude.setColumns(10);
																								
																										JLabel lblMoveInLatitude = new JLabel("Move in Latitude");
																										lblMoveInLatitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																										lblMoveInLatitude.setBounds(15, 74, 165, 26);
																										panel_3.add(lblMoveInLatitude);
																										
																												JLabel lblMoveInLongitude = new JLabel("Move in Longitude");
																												lblMoveInLongitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																												lblMoveInLongitude.setBounds(15, 152, 196, 26);
																												panel_3.add(lblMoveInLongitude);
																												
																														JPanel panel_4 = new JPanel();
																														panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) null));
																														panel_4.setBounds(439, 6, 480, 446);
																														panel.add(panel_4);
																														panel_4.setLayout(null);
																														
																																JLabel lblRegex = new JLabel("Regex");
																																lblRegex.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																lblRegex.setBounds(133, 16, 132, 26);
																																panel_4.add(lblRegex);
																																
																																		JLabel lblPokemonName = new JLabel("Pokemon Name");
																																		lblPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																		lblPokemonName.setBounds(0, 70, 167, 26);
																																		panel_4.add(lblPokemonName);
																																		
																																				tfRegexPokemonName = new JTextField();
																																				tfRegexPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																				tfRegexPokemonName.setBounds(0, 112, 481, 40);
																																				panel_4.add(tfRegexPokemonName);
																																				tfRegexPokemonName.setColumns(10);
																																				
																																						JLabel lblLatitude_1 = new JLabel("Latitude");
																																						lblLatitude_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																						lblLatitude_1.setBounds(0, 186, 83, 26);
																																						panel_4.add(lblLatitude_1);
																																						
																																								tfRegexLatitude = new JTextField();
																																								tfRegexLatitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																								tfRegexLatitude.setBounds(0, 238, 481, 40);
																																								panel_4.add(tfRegexLatitude);
																																								tfRegexLatitude.setColumns(10);
																																								
																																										JLabel lblLongitude_1 = new JLabel("Longitude");
																																										lblLongitude_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																										lblLongitude_1.setBounds(0, 308, 143, 26);
																																										panel_4.add(lblLongitude_1);
																																										
																																												tfRegexLongitude = new JTextField();
																																												tfRegexLongitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																												tfRegexLongitude.setBounds(0, 364, 480, 40);
																																												panel_4.add(tfRegexLongitude);
																																												tfRegexLongitude.setColumns(10);
																																												
																																														tfURL = new JTextField();
																																														tfURL.setText("https://yourUrlHere.com/someMaps.php?map=VAR1,VAR2,VAR3,VAR4");
																																														tfURL.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																														tfURL.setBounds(77, 460, 849, 40);
																																														panel.add(tfURL);
																																														tfURL.setColumns(10);
																																														
																																																JLabel lblUrl = new JLabel("URL: ");
																																																lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																lblUrl.setBounds(6, 468, 70, 16);
																																																panel.add(lblUrl);
																																																
																																																		btnSave = new JButton("Save Settings");
																																																		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																		btnSave.setBounds(6, 516, 177, 40);
																																																		panel.add(btnSave);
																																																		
																																																				tfStepsLatitude = new JTextField();
																																																				tfStepsLatitude.setText("3");
																																																				tfStepsLatitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																				tfStepsLatitude.setBounds(367, 518, 80, 40);
																																																				panel.add(tfStepsLatitude);
																																																				tfStepsLatitude.setColumns(10);
																																																				
																																																						JLabel lblSteps_1 = new JLabel("Steps in Latitude");
																																																						lblSteps_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																						lblSteps_1.setBounds(203, 522, 169, 29);
																																																						panel.add(lblSteps_1);
																																																						
																																																								JLabel lblStepsLon = new JLabel("Steps in Longitude");
																																																								lblStepsLon.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																								lblStepsLon.setBounds(478, 523, 187, 26);
																																																								panel.add(lblStepsLon);
																																																								
																																																										tfStepsLongitude = new JTextField();
																																																										tfStepsLongitude.setText("3");
																																																										tfStepsLongitude.setFont(new Font("Tahoma", Font.PLAIN, 21));
																																																										tfStepsLongitude.setBounds(680, 516, 80, 40);
																																																										panel.add(tfStepsLongitude);
																																																										tfStepsLongitude.setColumns(10);

	}

	public String getCoordTextField() {
		return coordTextField.getText();
	}

	public void setCoordTextField(String t) {
		this.coordTextField.setText(t);
	}

	public void setListCoordinate(JList listCoordinate) {
		this.listCoordinate = listCoordinate;
	}

	public JList getListPokemon() {
		return listPokemon;
	}

	public void setListPokemon(DefaultListModel<PokemonFactory> pokes) {
		this.listPokemon.setModel(pokes);
	}

	public JList getListCoordinate() {
		return listCoordinate;
	}

	public void setListCoordinate(DefaultListModel<String> coords) {
		this.listCoordinate.setModel(coords);
	}

	public String getTfStepsLatitude() {
		return tfStepsLatitude.getText();
	}

	public void setTfStepsLatitude(String stepLatitude) {
		this.tfStepsLatitude.setText(stepLatitude);
	}

	public String getTfStepsLongitude() {
		return tfStepsLongitude.getText();
	}

	public void setTfStepsLongitude(String stepLongitude) {
		this.tfStepsLongitude.setText(stepLongitude);
	}

	public String getTfStartLatitude() {
		return tfStartLatitude.getText();
	}

	public void setTfStartLatitude(String startLatitude) {
		this.tfStartLatitude.setText(startLatitude);;
	}

	public String getTfStartLongitude() {
		return tfStartLongitude.getText();
	}

	public void setTfStartLongitude(String startLatitude) {
		this.tfStartLongitude.setText(startLatitude);
	}

	public String getTfMoveLatitude() {
		return tfMoveLatitude.getText();
	}

	public void setTfMoveLatitude(String moveLatitude) {
		this.tfMoveLatitude.setText(moveLatitude);;
	}

	public String getTfMoveLongitude() {
		return tfMoveLongitude.getText();
	}

	public void setTfMoveLongitude(String moveLongitude) {
		this.tfMoveLongitude.setText(moveLongitude);
	}

	public String getTfRegexPokemonName() {
		return tfRegexPokemonName.getText();
	}

	public void setTfRegexPokemonName(String regexPokemonName) {
		this.tfRegexPokemonName.setText(regexPokemonName);
	}

	public String getTfRegexLatitude() {
		return tfRegexLatitude.getText();
	}

	public void setTfRegexLatitude(String regexLatitude) {
		this.tfRegexLatitude.setText(regexLatitude);
	}

	public String getTfRegexLongitude() {
		return tfRegexLongitude.getText();
	}

	public void setTfRegexLongitude(String regexLongitude) {
		this.tfRegexLongitude.setText(regexLongitude);
	}

	public String getTfURL() {
		return tfURL.getText();
	}

	public void setTfURL(String t) {
		this.tfURL.setText(t);
	}

	public void addActionListenerScan(ActionListener al) {
		btnScan.addActionListener(al);
	}
	public void addActionListenerSave(ActionListener al) {
		btnSave.addActionListener(al);
	}

	public void addActionListenerPokemonNameList(ListSelectionListener al) {
		listPokemon.addListSelectionListener(al);
	}
	public void addActionListenerCoordinateList(ListSelectionListener al) {
		listCoordinate.addListSelectionListener(al);
	}
}
