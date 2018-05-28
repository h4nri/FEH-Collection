import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GUI implements ActionListener {
	
	private JButton addBtn, newUnitBtn;
	private JComboBox<Integer> gradeList, levelList, mergeList;
	private JComboBox<String> assistList, baneList, boonList, charList, skillAList, skillBList, skillCList, specList, weaponList;
	private JFrame frame;
	private JPanel mainWindow, formatPnl, unitsPnl;
	private JScrollPane unitScroll;
	
	private ArrayList<Unit> editList, removeList, unitList;
	private FileManager fileManager;
	private GridBagConstraints c;
	
	public GUI() {		
		frame = new JFrame("Fire Emblem: Heroes Collection");
		mainWindow = new JPanel(new BorderLayout());
		unitsPnl = new JPanel(new GridBagLayout());
		formatPnl = new JPanel(new BorderLayout());
		unitScroll = new JScrollPane(formatPnl);
		
		fileManager = new FileManager();
	    c = new GridBagConstraints();
	    
	    // Setting up header labels (max. total width of components is 1261).
	    c.gridy = 0;
	    
	    JLabel nameHeader = new JLabel("Name", SwingConstants.CENTER);
		c.gridx = 0;
		nameHeader.setPreferredSize(new Dimension(150, 40));
		unitsPnl.add(nameHeader, c);
		
		JLabel gradeHeader = new JLabel("Grade", SwingConstants.CENTER);
		c.gridx = 1;
		gradeHeader.setPreferredSize(new Dimension(50, 40));
		unitsPnl.add(gradeHeader, c);
		
		JLabel levelHeader = new JLabel("Level", SwingConstants.CENTER);
		c.gridx = 2;
		levelHeader.setPreferredSize(new Dimension(50, 40));
		unitsPnl.add(levelHeader, c);
		
		JLabel mergesHeader = new JLabel("Merges", SwingConstants.CENTER);
		c.gridx = 3;
		mergesHeader.setPreferredSize(new Dimension(50, 40));
		unitsPnl.add(mergesHeader, c);
		
		JLabel boonHeader = new JLabel("Boon", SwingConstants.CENTER);
		c.gridx = 4;
		boonHeader.setPreferredSize(new Dimension(55, 40));
		unitsPnl.add(boonHeader, c);
		
		JLabel baneHeader = new JLabel("Bane", SwingConstants.CENTER);
		c.gridx = 5;
		baneHeader.setPreferredSize(new Dimension(55, 40));
		unitsPnl.add(baneHeader, c);
		
		JLabel weaponHeader = new JLabel("Weapon", SwingConstants.CENTER);
		c.gridx = 6;
		weaponHeader.setPreferredSize(new Dimension(150, 40));
		unitsPnl.add(weaponHeader, c);
		
		JLabel assistHeader = new JLabel("Assist", SwingConstants.CENTER);
		c.gridx = 7;
		assistHeader.setPreferredSize(new Dimension(100, 40));
		unitsPnl.add(assistHeader, c);
		
		JLabel specialHeader = new JLabel("Special", SwingConstants.CENTER);
		c.gridx = 8;
		specialHeader.setPreferredSize(new Dimension(150, 40));
		unitsPnl.add(specialHeader, c);
		
		JLabel skillAHeader = new JLabel("Skill A", SwingConstants.CENTER);
		c.gridx = 9;
		skillAHeader.setPreferredSize(new Dimension(150, 40));
		unitsPnl.add(skillAHeader, c);
		
		JLabel skillBHeader = new JLabel("Skill B", SwingConstants.CENTER);
		c.gridx = 10;
		skillBHeader.setPreferredSize(new Dimension(150, 40));
		unitsPnl.add(skillBHeader, c);
		
		JLabel skillCHeader = new JLabel("Skill C", SwingConstants.CENTER);
		c.gridx = 11;
		skillCHeader.setPreferredSize(new Dimension(150, 40));
		unitsPnl.add(skillCHeader, c);
	    
		// Retrieving units from the "Units" file.
		try {
			// How to safe cast?
			unitList = (ArrayList<Unit>) fileManager.deserialize("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Units");
		} catch (Exception e1) {
			unitList = new ArrayList<>();
		}
		
		// Displaying the units in the "Units" file.
		for (int i = 0; i <= unitList.size() - 1; i++) {
			Unit currUnit = unitList.get(i);
			c.gridy = i + 1;
			
			if (i != unitList.size() - 1) {
				c.insets = new Insets(0, 0, 3, 0);
			}
			
			JLabel unitName = new JLabel(currUnit.getName(), SwingConstants.CENTER);
			c.gridx = 0;
			unitsPnl.add(unitName, c);
			
			JLabel unitGrade = new JLabel(Integer.toString(currUnit.getGrade()), SwingConstants.CENTER);
			c.gridx = 1;
			unitsPnl.add(unitGrade, c);
			
			JLabel unitLevel = new JLabel(Integer.toString(currUnit.getLevel()), SwingConstants.CENTER);
			c.gridx = 2;
			unitsPnl.add(unitLevel, c);
			
			JLabel unitMerges = new JLabel(Integer.toString(currUnit.getMerges()), SwingConstants.CENTER);
			c.gridx = 3;
			unitsPnl.add(unitMerges, c);
			
			JLabel unitBoon = new JLabel(currUnit.getBoon(), SwingConstants.CENTER);
			c.gridx = 4;
			unitsPnl.add(unitBoon, c);
			
			JLabel unitBane = new JLabel(currUnit.getBane(), SwingConstants.CENTER);
			c.gridx = 5;
			unitsPnl.add(unitBane, c);
			
			JLabel unitWeapon = new JLabel(currUnit.getWeapon(), SwingConstants.CENTER);
			c.gridx = 6;
			unitsPnl.add(unitWeapon, c);
			
			JLabel unitAssist = new JLabel(currUnit.getAssist(), SwingConstants.CENTER);
			c.gridx = 7;
			unitsPnl.add(unitAssist, c);
			
			JLabel unitSpecial = new JLabel(currUnit.getSpecial(), SwingConstants.CENTER);
			c.gridx = 8;
			unitsPnl.add(unitSpecial, c);
			
			JLabel unitSkillA = new JLabel(currUnit.getSkillA(), SwingConstants.CENTER);
			c.gridx = 9;
			unitsPnl.add(unitSkillA, c);
			
			JLabel unitSkillB = new JLabel(currUnit.getSkillB(), SwingConstants.CENTER);
			c.gridx = 10;
			unitsPnl.add(unitSkillB, c);
			
			JLabel unitSkillC = new JLabel(currUnit.getSkillC(), SwingConstants.CENTER);
			c.gridx = 11;
			unitsPnl.add(unitSkillC, c);		
		}

		formatPnl.add(unitsPnl, BorderLayout.NORTH);		
		mainWindow.add(unitScroll, BorderLayout.CENTER);
		
		// Setting up the "Add New Unit" button.
		newUnitBtn = new JButton("Add New Unit");
		newUnitBtn.setBackground(Color.WHITE);
		newUnitBtn.addActionListener(this);
		mainWindow.add(newUnitBtn, BorderLayout.SOUTH);
		
		// Setting up the main frame.
		frame.setContentPane(mainWindow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(newUnitBtn)) {
			ArrayList<String> strList;
			addBtn = new JButton("Add Unit");
			JFrame addFrame = new JFrame("Add New Unit");
			JPanel addPnl = new JPanel();
			
			// Setting up and adding components related to name. 
			JLabel nameLbl = new JLabel("Name:", SwingConstants.CENTER);
			nameLbl.setPreferredSize(new Dimension(100, 25));
			strList = fileManager.readStringFile("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Heroes");
			String[] heroes = strList.toArray(new String[0]);
			charList = new JComboBox<>(heroes);
			charList.addActionListener(this);
			charList.setBackground(Color.WHITE);
			charList.setPreferredSize(new Dimension(200, 25));
			((JLabel) charList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(nameLbl);
			addPnl.add(charList);
			
			// Setting up and adding components related to grade. 
			JLabel gradeLbl = new JLabel("Grade:", SwingConstants.CENTER);
			gradeLbl.setPreferredSize(new Dimension(100, 25));
			Integer[] grades = {5, 4, 3, 2, 1};
			gradeList = new JComboBox<>(grades);
			gradeList.addActionListener(this);
			gradeList.setBackground(Color.WHITE);
			gradeList.setPreferredSize(new Dimension(200, 25));
			((JLabel) gradeList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(gradeLbl);
			addPnl.add(gradeList);
			
			// Setting up and adding components related to level. 
			JLabel levelLbl = new JLabel("Level:", SwingConstants.CENTER);
			levelLbl.setPreferredSize(new Dimension(100, 25));
			Integer[] levels = {40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 
					30, 29, 28, 27, 26, 25, 24, 23, 22, 21,
					20, 19, 18, 17, 16, 15, 14, 13, 12, 11,
					10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
			levelList = new JComboBox<>(levels);
			levelList.addActionListener(this);
			levelList.setBackground(Color.WHITE);
			levelList.setPreferredSize(new Dimension(200, 25));
			((JLabel) levelList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(levelLbl);
			addPnl.add(levelList);
			
			// Setting up and adding components related to merge. 
			JLabel mergeLbl = new JLabel("Merges:", SwingConstants.CENTER);
			mergeLbl.setPreferredSize(new Dimension(100, 25));
			Integer[] merges = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			mergeList = new JComboBox<>(merges);
			mergeList.addActionListener(this);
			mergeList.setBackground(Color.WHITE);
			mergeList.setPreferredSize(new Dimension(200, 25));
			((JLabel) mergeList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(mergeLbl);
			addPnl.add(mergeList);
			
			// Setting up and adding components related to boon. 
			JLabel boonLbl = new JLabel("Boon:", SwingConstants.CENTER);
			boonLbl.setPreferredSize(new Dimension(100, 25));
			String[] boons = {"Neutral", "Hp", "Atk", "Spd", "Def", "Res"};
			boonList = new JComboBox<>(boons);
			boonList.addActionListener(this);
			boonList.setBackground(Color.WHITE);
			boonList.setPreferredSize(new Dimension(200, 25));
			((JLabel) boonList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(boonLbl);
			addPnl.add(boonList);
			
			// Setting up and adding components related to bane. 
			JLabel baneLbl = new JLabel("Bane:", SwingConstants.CENTER);
			baneLbl.setPreferredSize(new Dimension(100, 25));
			String[] banes = {"Neutral", "Hp", "Atk", "Spd", "Def", "Res"};
			baneList = new JComboBox<>(banes);
			baneList.addActionListener(this);
			baneList.setBackground(Color.WHITE);
			baneList.setPreferredSize(new Dimension(200, 25));
			((JLabel) baneList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(baneLbl);
			addPnl.add(baneList);
			
			// Setting up and adding components related to weapon. 
			JLabel weaponLbl = new JLabel("Weapon:", SwingConstants.CENTER);
			weaponLbl.setPreferredSize(new Dimension(100, 25));
			strList = fileManager.readStringFile("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Weapons");
			String[] weapons = strList.toArray(new String[0]);
			weaponList = new JComboBox<>(weapons);
			weaponList.addActionListener(this);
			weaponList.setBackground(Color.WHITE);
			weaponList.setPreferredSize(new Dimension(200, 25));
			((JLabel) weaponList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(weaponLbl);
			addPnl.add(weaponList);
			
			// Setting up and adding components related to assist. 
			JLabel assistLbl = new JLabel("Assist:", SwingConstants.CENTER);
			assistLbl.setPreferredSize(new Dimension(100, 25));
			strList = fileManager.readStringFile("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Assists");
			String[] assists = strList.toArray(new String[0]);
			assistList = new JComboBox<>(assists);
			assistList.addActionListener(this);
			assistList.setBackground(Color.WHITE);
			assistList.setPreferredSize(new Dimension(200, 25));
			((JLabel) assistList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(assistLbl);
			addPnl.add(assistList);
			
			// Setting up and adding components related to special. 
			JLabel specLbl = new JLabel("Special:", SwingConstants.CENTER);
			specLbl.setPreferredSize(new Dimension(100, 25));
			strList = fileManager.readStringFile("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Specials");
			String[] specials = strList.toArray(new String[0]);
			specList = new JComboBox<>(specials);
			specList.addActionListener(this);
			specList.setBackground(Color.WHITE);
			specList.setPreferredSize(new Dimension(200, 25));
			((JLabel) specList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(specLbl);
			addPnl.add(specList);
			
			// Setting up and adding components related to skill A. 
			JLabel skillALbl = new JLabel("Skill A:", SwingConstants.CENTER);
			skillALbl.setPreferredSize(new Dimension(100, 25));
			strList = fileManager.readStringFile("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\A Skills");
			String[] skillAs = strList.toArray(new String[0]);
			skillAList = new JComboBox<>(skillAs);
			skillAList.addActionListener(this);
			skillAList.setBackground(Color.WHITE);
			skillAList.setPreferredSize(new Dimension(200, 25));
			((JLabel) skillAList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(skillALbl);
			addPnl.add(skillAList);
			
			// Setting up and adding components related to skill B. 
			JLabel skillBLbl = new JLabel("Skill B:", SwingConstants.CENTER);
			skillBLbl.setPreferredSize(new Dimension(100, 25));
			strList = fileManager.readStringFile("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\B Skills");
			String[] skillBs = strList.toArray(new String[0]);
			skillBList = new JComboBox<>(skillBs);
			skillBList.addActionListener(this);
			skillBList.setBackground(Color.WHITE);
			skillBList.setPreferredSize(new Dimension(200, 25));
			((JLabel) skillBList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(skillBLbl);
			addPnl.add(skillBList);
			
			// Setting up and adding components related to skill C. 
			JLabel skillCLbl = new JLabel("Skill C:", SwingConstants.CENTER);
			skillCLbl.setPreferredSize(new Dimension(100, 25));
			strList = fileManager.readStringFile("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\C Skills");
			String[] skillCs = strList.toArray(new String[0]);
			skillCList = new JComboBox<>(skillCs);
			skillCList.addActionListener(this);
			skillCList.setBackground(Color.WHITE);
			skillCList.setPreferredSize(new Dimension(200, 25));
			((JLabel) skillCList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(skillCLbl);
			addPnl.add(skillCList);
			
			addBtn.addActionListener(this);
			addBtn.setBackground(Color.WHITE);
			addBtn.setPreferredSize(new Dimension(100, 25));
			addPnl.add(addBtn);
			
			addFrame.setContentPane(addPnl);
			addFrame.setLocation(450, 220);
			addFrame.setResizable(false);
			addFrame.setSize(350, 435);
			addFrame.setVisible(true);
		} else if (e.getSource().equals(addBtn)) {
			// Create new unit and set its properties.
			Unit unit = new Unit();
			unit.setName(charList.getSelectedItem().toString());
			unit.setGrade((Integer) gradeList.getSelectedItem());
			unit.setLevel((Integer) levelList.getSelectedItem());
			unit.setMerges((Integer) mergeList.getSelectedItem());
			unit.setBoon(boonList.getSelectedItem().toString());
			unit.setBane(baneList.getSelectedItem().toString());
			unit.setWeapon(weaponList.getSelectedItem().toString());
			unit.setAssist(assistList.getSelectedItem().toString());
			unit.setSpecial(specList.getSelectedItem().toString());
			unit.setSkillA(skillAList.getSelectedItem().toString());
			unit.setSkillB(skillBList.getSelectedItem().toString());
			unit.setSkillC(skillCList.getSelectedItem().toString());
			
			// Add the new unit to "unitList" and serialize the updated ArrayList.			
			try {
				unitList.add(unit);
				fileManager.serialize(unitList, "C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Units");
				JOptionPane.showMessageDialog(frame, 
						"Unit was successfully added.",
						"Success",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame,
				    "Unit was not successfully added. Please try again.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			}
			
			// Adding the new unit to "unitsPnl". 
			c.gridy = unitList.size();
			
			JLabel unitName = new JLabel(unit.getName(), SwingConstants.CENTER);
			c.gridx = 0;
			unitsPnl.add(unitName, c);
			
			JLabel unitGrade = new JLabel(Integer.toString(unit.getGrade()), SwingConstants.CENTER);
			c.gridx = 1;
			unitsPnl.add(unitGrade, c);
			
			JLabel unitLevel = new JLabel(Integer.toString(unit.getLevel()), SwingConstants.CENTER);
			c.gridx = 2;
			unitsPnl.add(unitLevel, c);
			
			JLabel unitMerges = new JLabel(Integer.toString(unit.getMerges()), SwingConstants.CENTER);
			c.gridx = 3;
			unitsPnl.add(unitMerges, c);
			
			JLabel unitBoon = new JLabel(unit.getBoon(), SwingConstants.CENTER);
			c.gridx = 4;
			unitsPnl.add(unitBoon, c);
			
			JLabel unitBane = new JLabel(unit.getBane(), SwingConstants.CENTER);
			c.gridx = 5;
			unitsPnl.add(unitBane, c);
			
			JLabel unitWeapon = new JLabel(unit.getWeapon(), SwingConstants.CENTER);
			c.gridx = 6;
			unitsPnl.add(unitWeapon, c);
			
			JLabel unitAssist = new JLabel(unit.getAssist(), SwingConstants.CENTER);
			c.gridx = 7;
			unitsPnl.add(unitAssist, c);
			
			JLabel unitSpecial = new JLabel(unit.getSpecial(), SwingConstants.CENTER);
			c.gridx = 8;
			unitsPnl.add(unitSpecial, c);
			
			JLabel unitSkillA = new JLabel(unit.getSkillA(), SwingConstants.CENTER);
			c.gridx = 9;
			unitsPnl.add(unitSkillA, c);
			
			JLabel unitSkillB = new JLabel(unit.getSkillB(), SwingConstants.CENTER);
			c.gridx = 10;
			unitsPnl.add(unitSkillB, c);
			
			JLabel unitSkillC = new JLabel(unit.getSkillC(), SwingConstants.CENTER);
			c.gridx = 11;
			unitsPnl.add(unitSkillC, c);
			
			mainWindow.updateUI();
		}
	}
}