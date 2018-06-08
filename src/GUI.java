import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GUI implements ActionListener {
	
	private JComboBox<Integer> gradesComboBox, levelsComboBox, mergesComboBox;
	private JComboBox<String> assistsComboBox, banesComboBox, boonsComboBox, heroesComboBox, skillAComboBox, skillBComboBox, skillCComboBox, specialsComboBox, weaponsComboBox;
	private JFrame mainFrame;
	private JPanel formatPanel, headerPanel, mainPanel, unitsPanel;
	private JScrollPane unitsScrollPane;
	
	private ArrayList<JButton> editButtonsArrayList, removeButtonsArrayList;
	private ArrayList<JPanel> unitPanelsArrayList;
	private ArrayList<Unit> unitsArrayList;
	private FileManager fileManager;
	private GridBagConstraints constraints;
	private Unit unit;
	
	public GUI() {		
		mainFrame = new JFrame("Fire Emblem: Heroes Collection");
		mainPanel = new JPanel(new BorderLayout());
		headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
		formatPanel = new JPanel(new BorderLayout());
		unitsScrollPane = new JScrollPane(formatPanel);
		unitsPanel = new JPanel(new GridBagLayout());
		
		editButtonsArrayList = new ArrayList<>();
		removeButtonsArrayList = new ArrayList<>();
		unitPanelsArrayList = new ArrayList<>();
		fileManager = new FileManager();
		constraints = new GridBagConstraints();
	    
	    // Setting up header labels and adding them to "headerPanel", and finally adding "headerPanel" to "unitsPanel".	    
	    JLabel heroHeader = new JLabel("Hero", SwingConstants.CENTER);
		heroHeader.setPreferredSize(new Dimension(150, 40));
		headerPanel.add(heroHeader);
		
		JLabel gradeHeader = new JLabel("Grade", SwingConstants.CENTER);
		gradeHeader.setPreferredSize(new Dimension(50, 40));
		headerPanel.add(gradeHeader);
		
		JLabel levelHeader = new JLabel("Level", SwingConstants.CENTER);
		levelHeader.setPreferredSize(new Dimension(50, 40));
		headerPanel.add(levelHeader);
		
		JLabel mergesHeader = new JLabel("Merges", SwingConstants.CENTER);
		mergesHeader.setPreferredSize(new Dimension(50, 40));
		headerPanel.add(mergesHeader);
		
		JLabel boonHeader = new JLabel("Boon", SwingConstants.CENTER);
		boonHeader.setPreferredSize(new Dimension(55, 40));
		headerPanel.add(boonHeader);
		
		JLabel baneHeader = new JLabel("Bane", SwingConstants.CENTER);
		baneHeader.setPreferredSize(new Dimension(55, 40));
		headerPanel.add(baneHeader);
		
		JLabel weaponHeader = new JLabel("Weapon", SwingConstants.CENTER);
		weaponHeader.setPreferredSize(new Dimension(150, 40));
		headerPanel.add(weaponHeader);
		
		JLabel assistHeader = new JLabel("Assist", SwingConstants.CENTER);
		assistHeader.setPreferredSize(new Dimension(150, 40));
		headerPanel.add(assistHeader);
		
		JLabel specialHeader = new JLabel("Special", SwingConstants.CENTER);
		specialHeader.setPreferredSize(new Dimension(150, 40));
		headerPanel.add(specialHeader);
		
		JLabel skillAHeader = new JLabel("Skill A", SwingConstants.CENTER);
		skillAHeader.setPreferredSize(new Dimension(150, 40));
		headerPanel.add(skillAHeader);
		
		JLabel skillBHeader = new JLabel("Skill B", SwingConstants.CENTER);
		skillBHeader.setPreferredSize(new Dimension(150, 40));
		headerPanel.add(skillBHeader);
		
		JLabel skillCHeader = new JLabel("Skill C", SwingConstants.CENTER);
		skillCHeader.setPreferredSize(new Dimension(150, 40));
		headerPanel.add(skillCHeader);
	
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 0;
		unitsPanel.add(headerPanel, constraints);
	    
		// Retrieving units from the "Units" file.
		try {
			unitsArrayList = (ArrayList<Unit>) fileManager.deserialize("Units");
		} catch (Exception e1) {
			unitsArrayList = new ArrayList<>();
		}
		
		// Displaying the units in the "Units" file.
		for (int i = 0; i <= unitsArrayList.size() - 1; i++) {
			addUnitToGUI(i);
		}
		
		formatPanel.add(unitsPanel, BorderLayout.NORTH);
		mainPanel.add(unitsScrollPane, BorderLayout.CENTER);
		
		// Setting up the "Add New Unit" button. How to make button smaller?
		JButton newUnitButton = new JButton("Add New Unit");
		newUnitButton.setBackground(Color.WHITE);
		newUnitButton.addActionListener(this);
		mainPanel.add(newUnitButton, BorderLayout.SOUTH);
		
		ArrayList<String> strArrayList;
		
		// Setting up the JComboBoxes for adding and editing purposes.
		strArrayList = fileManager.readStringFile("Heroes");
		String[] heroes = strArrayList.toArray(new String[0]);
		heroesComboBox = new JComboBox<>(heroes);
		heroesComboBox.setBackground(Color.WHITE);
		heroesComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) heroesComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		Integer[] grades = {5, 4, 3, 2, 1};
		gradesComboBox = new JComboBox<>(grades);
		gradesComboBox.setBackground(Color.WHITE);
		gradesComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) gradesComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		Integer[] levels = {40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 
				30, 29, 28, 27, 26, 25, 24, 23, 22, 21,
				20, 19, 18, 17, 16, 15, 14, 13, 12, 11,
				10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		levelsComboBox = new JComboBox<>(levels);
		levelsComboBox.setBackground(Color.WHITE);
		levelsComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) levelsComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		Integer[] merges = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		mergesComboBox = new JComboBox<>(merges);
		mergesComboBox.setBackground(Color.WHITE);
		mergesComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) mergesComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		String[] boons = {"Neutral", "Hp", "Atk", "Spd", "Def", "Res"};
		boonsComboBox = new JComboBox<>(boons);
		boonsComboBox.setBackground(Color.WHITE);
		boonsComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) boonsComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		String[] banes = {"Neutral", "Hp", "Atk", "Spd", "Def", "Res"};
		banesComboBox = new JComboBox<>(banes);
		banesComboBox.setBackground(Color.WHITE);
		banesComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) banesComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		strArrayList = fileManager.readStringFile("Weapons");
		String[] weapons = strArrayList.toArray(new String[0]);
		weaponsComboBox = new JComboBox<>(weapons);
		weaponsComboBox.setBackground(Color.WHITE);
		weaponsComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) weaponsComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		strArrayList = fileManager.readStringFile("Assists");
		String[] assists = strArrayList.toArray(new String[0]);
		assistsComboBox = new JComboBox<>(assists);
		assistsComboBox.setBackground(Color.WHITE);
		assistsComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) assistsComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		strArrayList = fileManager.readStringFile("Specials");
		String[] specials = strArrayList.toArray(new String[0]);
		specialsComboBox = new JComboBox<>(specials);
		specialsComboBox.setBackground(Color.WHITE);
		specialsComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) specialsComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		strArrayList = fileManager.readStringFile("A Skills");
		String[] skillAs = strArrayList.toArray(new String[0]);
		skillAComboBox = new JComboBox<>(skillAs);
		skillAComboBox.setBackground(Color.WHITE);
		skillAComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) skillAComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		strArrayList = fileManager.readStringFile("B Skills");
		String[] skillBs = strArrayList.toArray(new String[0]);
		skillBComboBox = new JComboBox<>(skillBs);
		skillBComboBox.setBackground(Color.WHITE);
		skillBComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) skillBComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		strArrayList = fileManager.readStringFile("C Skills");
		String[] skillCs = strArrayList.toArray(new String[0]);
		skillCComboBox = new JComboBox<>(skillCs);
		skillCComboBox.setBackground(Color.WHITE);
		skillCComboBox.setPreferredSize(new Dimension(200, 25));
		((JLabel) skillCComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		// Setting up the mainFrame.
		mainFrame.setContentPane(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setSize(1510, 850);
		mainFrame.setVisible(true);
		
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 2);
	    mainFrame.setLocation(x, 20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		// If "newUnitButton" is pressed, then a JDialog is created,allowing users to add a new unit to their collection.
		if (action.equals("Add New Unit")) {
			JPanel addPanel = new JPanel();
			
			// Adding components related to unit variables to "addPanel".
			JLabel addUnitHeroLabel = new JLabel("Hero:", SwingConstants.CENTER);
			addUnitHeroLabel.setPreferredSize(new Dimension(100, 25));	
			heroesComboBox.setSelectedIndex(0);
			addPanel.add(addUnitHeroLabel);
			addPanel.add(heroesComboBox);
			
			JLabel addUnitGradeLabel = new JLabel("Grade:", SwingConstants.CENTER);
			addUnitGradeLabel.setPreferredSize(new Dimension(100, 25));
			gradesComboBox.setSelectedIndex(0);
			addPanel.add(addUnitGradeLabel);
			addPanel.add(gradesComboBox);
			
			JLabel addUnitLevelLabel = new JLabel("Level:", SwingConstants.CENTER);
			addUnitLevelLabel.setPreferredSize(new Dimension(100, 25));
			levelsComboBox.setSelectedIndex(0);
			addPanel.add(addUnitLevelLabel);
			addPanel.add(levelsComboBox);
			
			JLabel addUnitMergesLabel = new JLabel("Merges:", SwingConstants.CENTER);
			addUnitMergesLabel.setPreferredSize(new Dimension(100, 25));
			mergesComboBox.setSelectedIndex(0);
			addPanel.add(addUnitMergesLabel);
			addPanel.add(mergesComboBox);
			
			JLabel addUnitBoonLabel = new JLabel("Boon:", SwingConstants.CENTER);
			addUnitBoonLabel.setPreferredSize(new Dimension(100, 25));
			boonsComboBox.setSelectedIndex(0);
			addPanel.add(addUnitBoonLabel);
			addPanel.add(boonsComboBox);

			JLabel addUnitBaneLabel = new JLabel("Bane:", SwingConstants.CENTER);
			addUnitBaneLabel.setPreferredSize(new Dimension(100, 25));
			banesComboBox.setSelectedIndex(0);
			addPanel.add(addUnitBaneLabel);
			addPanel.add(banesComboBox);
			
			JLabel addUnitWeaponLabel = new JLabel("Weapon:", SwingConstants.CENTER);
			addUnitWeaponLabel.setPreferredSize(new Dimension(100, 25));
			weaponsComboBox.setSelectedIndex(0);
			addPanel.add(addUnitWeaponLabel);
			addPanel.add(weaponsComboBox);
			
			JLabel addUnitAssistLabel = new JLabel("Assist:", SwingConstants.CENTER);
			addUnitAssistLabel.setPreferredSize(new Dimension(100, 25));
			assistsComboBox.setSelectedIndex(0);
			addPanel.add(addUnitAssistLabel);
			addPanel.add(assistsComboBox);
			
			JLabel addUnitSpecialLabel = new JLabel("Special:", SwingConstants.CENTER);
			addUnitSpecialLabel.setPreferredSize(new Dimension(100, 25));
			specialsComboBox.setSelectedIndex(0);
			addPanel.add(addUnitSpecialLabel);
			addPanel.add(specialsComboBox);
			
			JLabel addUnitSkillALabel = new JLabel("Skill A:", SwingConstants.CENTER);
			addUnitSkillALabel.setPreferredSize(new Dimension(100, 25));
			skillAComboBox.setSelectedIndex(0);
			addPanel.add(addUnitSkillALabel);
			addPanel.add(skillAComboBox);
			
			JLabel addUnitSkillBLabel = new JLabel("Skill B:", SwingConstants.CENTER);
			addUnitSkillBLabel.setPreferredSize(new Dimension(100, 25));
			skillBComboBox.setSelectedIndex(0);
			addPanel.add(addUnitSkillBLabel);
			addPanel.add(skillBComboBox);
			
			JLabel addUnitSkillCLabel = new JLabel("Skill C:", SwingConstants.CENTER);
			addUnitSkillCLabel.setPreferredSize(new Dimension(100, 25));
			skillCComboBox.setSelectedIndex(0);
			addPanel.add(addUnitSkillCLabel);
			addPanel.add(skillCComboBox);
			
			// Setting up and adding "addButton" to "addPanel".
			JButton addButton = new JButton("Add Unit");
			addButton.addActionListener(this);
			addButton.setBackground(Color.WHITE);
			addButton.setPreferredSize(new Dimension(100, 25));
			addPanel.add(addButton);

			// Setting up "addDialog".
			JDialog addDialog = new JDialog(mainFrame, "Add New Unit", Dialog.ModalityType.APPLICATION_MODAL);
			addDialog.setContentPane(addPanel);
			addDialog.setLocation((mainFrame.getWidth() / 2), 250);
			addDialog.setResizable(false);
			addDialog.setSize(350, 435);
			addDialog.setVisible(true);
		/* Pressing "addButton" creates a new unit with variables set to the selected items of the JComboBoxes,
		 * and adds the new unit and its related components into their respective ArrayLists.
		 */
		} else if (action.equals("Add Unit")) {
			// Create new unit and set its properties.
			unit = new Unit();
			unit.setHero(heroesComboBox.getSelectedItem().toString());
			unit.setGrade((Integer) gradesComboBox.getSelectedItem());
			unit.setLevel((Integer) levelsComboBox.getSelectedItem());
			unit.setMerges((Integer) mergesComboBox.getSelectedItem());
			unit.setBoon(boonsComboBox.getSelectedItem().toString());
			unit.setBane(banesComboBox.getSelectedItem().toString());
			unit.setWeapon(weaponsComboBox.getSelectedItem().toString());
			unit.setAssist(assistsComboBox.getSelectedItem().toString());
			unit.setSpecial(specialsComboBox.getSelectedItem().toString());
			unit.setSkillA(skillAComboBox.getSelectedItem().toString());
			unit.setSkillB(skillBComboBox.getSelectedItem().toString());
			unit.setSkillC(skillCComboBox.getSelectedItem().toString());
			
			// Add the new unit to "unitsArrayList" and serialize the updated ArrayList.			
			try {
				unitsArrayList.add(unit);
				fileManager.serialize(unitsArrayList, "Units");
				JOptionPane.showMessageDialog(mainFrame, 
						"Unit was successfully added.",
						"Success",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(mainFrame,
				    "Unit was not successfully added. Please try again.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			}
			
			addUnitToGUI(unitsArrayList.size() - 1);
		} else if (editButtonsArrayList.contains(e.getSource()))  {
			JPanel editMainPanel = new JPanel(new BorderLayout());
					
			// Setting up the "editNorthPanel".
			JPanel editNorthPanel = new JPanel(new BorderLayout());
			
			JPanel editHeaderPanel = new JPanel(new GridLayout(1, 2, 0, 0));	
			editHeaderPanel.setPreferredSize(new Dimension(350, 30));
			
			JLabel currentLabel = new JLabel("Current", SwingConstants.CENTER);
			editHeaderPanel.add(currentLabel);
			
			JLabel newLabel = new JLabel("New", SwingConstants.CENTER);
			editHeaderPanel.add(newLabel);
			
			editNorthPanel.add(editHeaderPanel, BorderLayout.CENTER);
			
			JPanel fillerPanel = new JPanel();
			fillerPanel.setPreferredSize(new Dimension(70, 30));
			editNorthPanel.add(fillerPanel, BorderLayout.WEST);
			
			editMainPanel.add(editNorthPanel, BorderLayout.NORTH);
			
			// Setting up the "editWestPanel".
			JPanel editWestPanel = new JPanel(new GridLayout(12, 1, 0, 0));
			editWestPanel.setPreferredSize(new Dimension(70, 440));
			
			JLabel editUnitHeroLabel = new JLabel("Hero", SwingConstants.CENTER);
			JLabel editUnitGradeLabel = new JLabel("Grade", SwingConstants.CENTER);
			JLabel editUnitLevelLabel = new JLabel("Level", SwingConstants.CENTER);
			JLabel editUnitMergesLabel = new JLabel("Merges", SwingConstants.CENTER);
			JLabel editUnitBoonLabel = new JLabel("Boon", SwingConstants.CENTER);
			JLabel editUnitBaneLabel = new JLabel("Bane", SwingConstants.CENTER);
			JLabel editUnitWeaponLabel = new JLabel("Weapon", SwingConstants.CENTER);
			JLabel editUnitAssistLabel = new JLabel("Assist", SwingConstants.CENTER);
			JLabel editUnitSpecialLabel = new JLabel("Special", SwingConstants.CENTER);
			JLabel editUnitSkillALabel = new JLabel("Skill A", SwingConstants.CENTER);
			JLabel editUnitSkillBLabel = new JLabel("Skill B", SwingConstants.CENTER);
			JLabel editUnitSkillCLabel = new JLabel("Skill C", SwingConstants.CENTER);

			editWestPanel.add(editUnitHeroLabel);
			editWestPanel.add(editUnitGradeLabel);
			editWestPanel.add(editUnitLevelLabel);
			editWestPanel.add(editUnitMergesLabel);
			editWestPanel.add(editUnitBoonLabel);
			editWestPanel.add(editUnitBaneLabel);
			editWestPanel.add(editUnitWeaponLabel);
			editWestPanel.add(editUnitAssistLabel);
			editWestPanel.add(editUnitSpecialLabel);
			editWestPanel.add(editUnitSkillALabel);
			editWestPanel.add(editUnitSkillBLabel);
			editWestPanel.add(editUnitSkillCLabel);
			
			editMainPanel.add(editWestPanel, BorderLayout.WEST);
			
			// Setting up the "editSouthPanel".
			JPanel editSouthPanel = new JPanel();
			editSouthPanel.setPreferredSize(new Dimension(420, 30));
			
			JButton saveButton = new JButton("Save");
			saveButton.addActionListener(this);
			saveButton.setBackground(Color.WHITE);
			editSouthPanel.add(saveButton);
			
			editMainPanel.add(editSouthPanel, BorderLayout.SOUTH);
			
			// Setting up the "editCenterPanel".
			JPanel editCenterPanel = new JPanel(new GridLayout(0, 2, 0, 0));
			editCenterPanel.setPreferredSize(new Dimension(350, 440));

			unit = unitsArrayList.get(editButtonsArrayList.indexOf(e.getSource()));
			
			JLabel currentHero = new JLabel(unit.getHero(), SwingConstants.CENTER);
			heroesComboBox.setSelectedItem(currentHero.getText());
			editCenterPanel.add(currentHero);
			editCenterPanel.add(heroesComboBox);
			
			JLabel currentGrade = new JLabel(Integer.toString(unit.getGrade()), SwingConstants.CENTER);
			gradesComboBox.setSelectedItem(currentGrade.getText());
			editCenterPanel.add(currentGrade);
			editCenterPanel.add(gradesComboBox);
			
			JLabel currentLevel = new JLabel(Integer.toString(unit.getLevel()), SwingConstants.CENTER);
			levelsComboBox.setSelectedItem(currentLevel.getText());
			editCenterPanel.add(currentLevel);
			editCenterPanel.add(levelsComboBox);
			
			JLabel currentMerges = new JLabel(Integer.toString(unit.getMerges()), SwingConstants.CENTER);
			mergesComboBox.setSelectedItem(currentMerges.getText());
			editCenterPanel.add(currentMerges);
			editCenterPanel.add(mergesComboBox);
			
			JLabel currentBoon = new JLabel(unit.getBoon(), SwingConstants.CENTER);
			boonsComboBox.setSelectedItem(currentBoon.getText());
			editCenterPanel.add(currentBoon);
			editCenterPanel.add(boonsComboBox);
			
			JLabel currentBane = new JLabel(unit.getBane(), SwingConstants.CENTER);
			banesComboBox.setSelectedItem(currentBane.getText());
			editCenterPanel.add(currentBane);
			editCenterPanel.add(banesComboBox);
			
			JLabel currentWeapon = new JLabel(unit.getWeapon(), SwingConstants.CENTER);
			weaponsComboBox.setSelectedItem(currentWeapon.getText());
			editCenterPanel.add(currentWeapon);
			editCenterPanel.add(weaponsComboBox);
			
			JLabel currentAssist = new JLabel(unit.getAssist(), SwingConstants.CENTER);
			assistsComboBox.setSelectedItem(currentAssist.getText());
			editCenterPanel.add(currentAssist);
			editCenterPanel.add(assistsComboBox);	
			
			JLabel currentSpecial = new JLabel(unit.getSpecial(), SwingConstants.CENTER);
			specialsComboBox.setSelectedItem(currentSpecial.getText());
			editCenterPanel.add(currentSpecial);
			editCenterPanel.add(specialsComboBox);
			
			JLabel currentSkillA = new JLabel(unit.getSkillA(), SwingConstants.CENTER);
			skillAComboBox.setSelectedItem(currentSkillA.getText());
			editCenterPanel.add(currentSkillA);
			editCenterPanel.add(skillAComboBox);
			
			JLabel currentSkillB = new JLabel(unit.getSkillB(), SwingConstants.CENTER);
			skillBComboBox.setSelectedItem(currentSkillB.getText());
			editCenterPanel.add(currentSkillB);
			editCenterPanel.add(skillBComboBox);
			
			JLabel currentSkillC = new JLabel(unit.getSkillC(), SwingConstants.CENTER);
			skillCComboBox.setSelectedItem(currentSkillC.getText());
			editCenterPanel.add(currentSkillC);
			editCenterPanel.add(skillCComboBox);
			
			editMainPanel.add(editCenterPanel, BorderLayout.CENTER);
			
			// Setting up "editDialog".
			JDialog editDialog = new JDialog(mainFrame, "Edit Unit", Dialog.ModalityType.APPLICATION_MODAL);
			editDialog.setContentPane(editMainPanel);
			editDialog.setLocation((mainFrame.getWidth() / 2), 250);
			editDialog.setResizable(false);
			editDialog.setSize(420, 500);
			editDialog.setVisible(true);
		} else if (action.equals("Save")) {	
			System.out.println(unitsArrayList.indexOf(unit));
			editUnit(unitsArrayList.indexOf(unit));	
		} else if (removeButtonsArrayList.contains(e.getSource())) {
			removeUnit(removeButtonsArrayList.indexOf(e.getSource()));
		}
	}
	
	/*  Adds a new panel for an unit to "unitsPanel".
	 *  The input "i" should represent the i-th element (counting from 0) of "unitsArrayList" AFTER adding the unit. 
	 */
	private void addUnitToGUI(int i) {
		JPanel newUnitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
		unitPanelsArrayList.add(newUnitPanel);
		
		// Setting up and adding the variable labels to "newUnitPanel".
		JLabel newUnitHeroLabel = new JLabel(unitsArrayList.get(i).getHero(), SwingConstants.CENTER);
		newUnitHeroLabel.setPreferredSize(new Dimension(150, 25));
		newUnitPanel.add(newUnitHeroLabel);
		
		JLabel newUnitGradeLabel = new JLabel(Integer.toString(unitsArrayList.get(i).getGrade()), SwingConstants.CENTER);
		newUnitGradeLabel.setPreferredSize(new Dimension(50, 25));
		newUnitPanel.add(newUnitGradeLabel);
		
		JLabel newUnitLevelLabel = new JLabel(Integer.toString(unitsArrayList.get(i).getLevel()), SwingConstants.CENTER);
		newUnitLevelLabel.setPreferredSize(new Dimension(50, 25));
		newUnitPanel.add(newUnitLevelLabel);
		
		JLabel newUnitMergesLabel = new JLabel(Integer.toString(unitsArrayList.get(i).getMerges()), SwingConstants.CENTER);
		newUnitMergesLabel.setPreferredSize(new Dimension(50, 25));
		newUnitPanel.add(newUnitMergesLabel);
		
		JLabel newUnitBoonLabel = new JLabel(unitsArrayList.get(i).getBoon(), SwingConstants.CENTER);
		newUnitBoonLabel.setPreferredSize(new Dimension(55, 25));
		newUnitPanel.add(newUnitBoonLabel);
		
		JLabel newUnitBaneLabel = new JLabel(unitsArrayList.get(i).getBane(), SwingConstants.CENTER);
		newUnitBaneLabel.setPreferredSize(new Dimension(55, 25));
		newUnitPanel.add(newUnitBaneLabel);
		
		JLabel newUnitWeaponLabel = new JLabel(unitsArrayList.get(i).getWeapon(), SwingConstants.CENTER);
		newUnitWeaponLabel.setPreferredSize(new Dimension(150, 25));
		newUnitPanel.add(newUnitWeaponLabel);
		
		JLabel newUnitAssistLabel = new JLabel(unitsArrayList.get(i).getAssist(), SwingConstants.CENTER);
		newUnitAssistLabel.setPreferredSize(new Dimension(150, 25));
		newUnitPanel.add(newUnitAssistLabel);
		
		JLabel newUnitSpecialLabel = new JLabel(unitsArrayList.get(i).getSpecial(), SwingConstants.CENTER);
		newUnitSpecialLabel.setPreferredSize(new Dimension(150, 25));
		newUnitPanel.add(newUnitSpecialLabel);
		
		JLabel newUnitSkillALabel = new JLabel(unitsArrayList.get(i).getSkillA(), SwingConstants.CENTER);
		newUnitSkillALabel.setPreferredSize(new Dimension(150, 25));
		newUnitPanel.add(newUnitSkillALabel);
		
		JLabel newUnitSkillBLabel = new JLabel(unitsArrayList.get(i).getSkillB(), SwingConstants.CENTER);
		newUnitSkillBLabel.setPreferredSize(new Dimension(150, 25));
		newUnitPanel.add(newUnitSkillBLabel);
		
		JLabel newUnitSkillCLabel = new JLabel(unitsArrayList.get(i).getSkillC(), SwingConstants.CENTER);
		newUnitSkillCLabel.setPreferredSize(new Dimension(150, 25));
		newUnitPanel.add(newUnitSkillCLabel);
		
		// Setting up and adding "editButton" to "newUnitPanel".
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(this);
		editButton.setBackground(Color.WHITE);
		editButton.setPreferredSize(new Dimension(55, 25));
		editButtonsArrayList.add(editButton);
		newUnitPanel.add(editButton);	
		
		// Setting up and adding "removeButton" to "newUnitPanel".
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		removeButton.setBackground(Color.WHITE);
		removeButton.setPreferredSize(new Dimension(80, 25));
		removeButtonsArrayList.add(removeButton);
		newUnitPanel.add(removeButton);	
		
		constraints.gridy = i + 1;
		unitsPanel.add(newUnitPanel, constraints);
		unitsPanel.revalidate();
		unitsPanel.repaint();
	}
	
	/* Changes the components/variables of the i-th unit panel/unit (counting from 0)  
	 * to match the selected items in the JComboBoxes.
	 */
	private void editUnit(int i) {
		// Yes = 0 and No = 1
		int editOption = JOptionPane.showConfirmDialog(
			    mainFrame,
			    "Are you sure you want to save the selected changes?",
			    "Confirmation",
			    JOptionPane.YES_NO_OPTION);
		
		if (editOption == 0) {
			/* Sets texts of JLabels of the i-th "newUnitPanel" (see addUnitToGUI method) 
			 * to the selected items of the twelve JComboBoxes.
			 */
			((JLabel) unitPanelsArrayList.get(i).getComponent(0)).setText(heroesComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(1)).setText(gradesComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(2)).setText(levelsComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(3)).setText(mergesComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(4)).setText(boonsComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(5)).setText(banesComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(6)).setText(weaponsComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(7)).setText(assistsComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(8)).setText(specialsComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(9)).setText(skillAComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(10)).setText(skillBComboBox.getSelectedItem().toString());
			((JLabel) unitPanelsArrayList.get(i).getComponent(11)).setText(skillCComboBox.getSelectedItem().toString());
			
			// Sets variables of the i-th unit in "unitsArrayList" to the selected items of the JComboBoxes.
			unitsArrayList.get(i).setHero(heroesComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setGrade((Integer) gradesComboBox.getSelectedItem());
			unitsArrayList.get(i).setLevel((Integer) levelsComboBox.getSelectedItem());
			unitsArrayList.get(i).setMerges((Integer) mergesComboBox.getSelectedItem());
			unitsArrayList.get(i).setBoon(boonsComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setBane(banesComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setWeapon(weaponsComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setAssist(assistsComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setSpecial(specialsComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setSkillA(skillAComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setSkillB(skillBComboBox.getSelectedItem().toString());
			unitsArrayList.get(i).setSkillC(skillCComboBox.getSelectedItem().toString());
			
			// Serialize the updated "unitsArrayList".			
			try {
				fileManager.serialize(unitsArrayList, "Units");
				JOptionPane.showMessageDialog(mainFrame, 
						"Unit was successfully editted.",
						"Success",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(mainFrame,
				    "Unit was not successfully editted. Please try again.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			}
			
			unitsPanel.revalidate();
			unitsPanel.repaint();
		}
	}
	
	/*  Removes an existing unit and its corresponding UI components.
	 *  The input "i" should represent the i-th element (counting from 0) of the "unitsArrayList" ArrayList BEFORE removing the unit. 
	 */
	private void removeUnit(int i) {
		// Yes = 0 and No = 1
		int removeOption = JOptionPane.showConfirmDialog(
			    mainFrame,
			    "Are you sure you want to remove the selected unit?",
			    "Confirmation",
			    JOptionPane.YES_NO_OPTION);
		
		if (removeOption == 0) {
			unitsPanel.remove(unitPanelsArrayList.get(i));
			unitPanelsArrayList.remove(i);
			editButtonsArrayList.remove(i);
			removeButtonsArrayList.remove(i);
			unitsArrayList.remove(i);

			// Changing the constraints on the remaining JPanels in "unitsPanel".
			if (i != removeButtonsArrayList.size()) { // If the removed unit was not the last unit.
				while (i <= removeButtonsArrayList.size() - 1) {
					GridBagLayout layout = (GridBagLayout) unitsPanel.getLayout();
					constraints.gridy = i + 1;
					layout.setConstraints(unitPanelsArrayList.get(i), constraints);
					i++;
				}
			}
			
			// Serializing the updated "unitsArrayList".
			try {
				fileManager.serialize(unitsArrayList, "Units");
				JOptionPane.showMessageDialog(mainFrame, 
						"Unit was successfully removed.",
						"Success",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(mainFrame,
				    "Unit was not successfully removed. Please try again.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			}
			
			unitsPanel.revalidate();
			unitsPanel.repaint();
		}
	}
}