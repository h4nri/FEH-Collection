import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GUI implements ActionListener {
	
	private JButton addBtn, editBtn, newUnitBtn, removeBtn;
	private JComboBox<Integer> gradeList, levelList, mergeList;
	private JComboBox<String> assistList, baneList, boonList, charList, skillAList, skillBList, skillCList, specList, weaponList;
	private JFrame frame;
	private JPanel formatPnl, headerPnl, mainWindow, unitsPnl;
	private JScrollPane unitScroll;
	
	private ArrayList<JButton> editList, removeList;
	private ArrayList<JPanel> pnlList;
	private ArrayList<Unit> unitList;
	private FileManager fileManager;
	private GridBagConstraints c;
	
	public GUI() {		
		frame = new JFrame("Fire Emblem: Heroes Collection");
		mainWindow = new JPanel(new BorderLayout());
		headerPnl = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
		unitsPnl = new JPanel(new GridBagLayout());
		formatPnl = new JPanel(new BorderLayout());
		unitScroll = new JScrollPane(formatPnl);
		
		c = new GridBagConstraints();
		editList = new ArrayList<>();
		pnlList = new ArrayList<>();
		removeList = new ArrayList<>();
		fileManager = new FileManager();
	    
	    // Setting up header labels.	    
	    JLabel nameHeader = new JLabel("Name", SwingConstants.CENTER);
		nameHeader.setPreferredSize(new Dimension(150, 40));
		headerPnl.add(nameHeader);
		
		JLabel gradeHeader = new JLabel("Grade", SwingConstants.CENTER);
		gradeHeader.setPreferredSize(new Dimension(50, 40));
		headerPnl.add(gradeHeader);
		
		JLabel levelHeader = new JLabel("Level", SwingConstants.CENTER);
		levelHeader.setPreferredSize(new Dimension(50, 40));
		headerPnl.add(levelHeader);
		
		JLabel mergesHeader = new JLabel("Merges", SwingConstants.CENTER);
		mergesHeader.setPreferredSize(new Dimension(50, 40));
		headerPnl.add(mergesHeader);
		
		JLabel boonHeader = new JLabel("Boon", SwingConstants.CENTER);
		boonHeader.setPreferredSize(new Dimension(55, 40));
		headerPnl.add(boonHeader);
		
		JLabel baneHeader = new JLabel("Bane", SwingConstants.CENTER);
		baneHeader.setPreferredSize(new Dimension(55, 40));
		headerPnl.add(baneHeader);
		
		JLabel weaponHeader = new JLabel("Weapon", SwingConstants.CENTER);
		weaponHeader.setPreferredSize(new Dimension(150, 40));
		headerPnl.add(weaponHeader);
		
		JLabel assistHeader = new JLabel("Assist", SwingConstants.CENTER);
		assistHeader.setPreferredSize(new Dimension(150, 40));
		headerPnl.add(assistHeader);
		
		JLabel specialHeader = new JLabel("Special", SwingConstants.CENTER);
		specialHeader.setPreferredSize(new Dimension(150, 40));
		headerPnl.add(specialHeader);
		
		JLabel skillAHeader = new JLabel("Skill A", SwingConstants.CENTER);
		skillAHeader.setPreferredSize(new Dimension(150, 40));
		headerPnl.add(skillAHeader);
		
		JLabel skillBHeader = new JLabel("Skill B", SwingConstants.CENTER);
		skillBHeader.setPreferredSize(new Dimension(150, 40));
		headerPnl.add(skillBHeader);
		
		JLabel skillCHeader = new JLabel("Skill C", SwingConstants.CENTER);
		skillCHeader.setPreferredSize(new Dimension(150, 40));
		headerPnl.add(skillCHeader);
	
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridx = 0;
		c.gridy = 0;
		unitsPnl.add(headerPnl, c);
	    
		// Retrieving units from the "Units" file.
		try {
			// How to safe cast?
			unitList = (ArrayList<Unit>) fileManager.deserialize("C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Units");
		} catch (Exception e1) {
			unitList = new ArrayList<>();
		}
		
		// Displaying the units in the "Units" file.
		for (int i = 0; i <= unitList.size() - 1; i++) {
			addUnit(i + 1);
		}
		
		formatPnl.add(unitsPnl, BorderLayout.NORTH);
		mainWindow.add(unitScroll, BorderLayout.CENTER);
		
		// Setting up the "Add New Unit" button. How to make button smaller?
		newUnitBtn = new JButton("Add New Unit");
		newUnitBtn.setBackground(Color.WHITE);
		newUnitBtn.addActionListener(this);
		mainWindow.add(newUnitBtn, BorderLayout.SOUTH);
		
		// Setting up the frame.
		frame.setContentPane(mainWindow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1510, 850);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newUnitBtn) {
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
		} else if (e.getSource() == addBtn) {
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
			
			addUnit(unitList.size());
		} else if (removeList.contains(e.getSource())) {
			int index = removeList.indexOf(e.getSource());		
			removeUnit(index);
		}
	}
	
	/*  Adds a new unit to the "unitsPnl" panel.
	 *  The input "i" should represent the i-th element (counting from 1)
	 *  of the "unitList" ArrayList AFTER adding the unit. 
	 */
	private void addUnit(int i) {
		JPanel unitPnl = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
		pnlList.add(unitPnl);
		
		JLabel unitName = new JLabel(unitList.get(i - 1).getName(), SwingConstants.CENTER);
		unitName.setPreferredSize(new Dimension(150, 25));
		unitPnl.add(unitName);
		
		JLabel unitGrade = new JLabel(Integer.toString(unitList.get(i - 1).getGrade()), SwingConstants.CENTER);
		unitGrade.setPreferredSize(new Dimension(50, 25));
		unitPnl.add(unitGrade);
		
		JLabel unitLevel = new JLabel(Integer.toString(unitList.get(i - 1).getLevel()), SwingConstants.CENTER);
		unitLevel.setPreferredSize(new Dimension(50, 25));
		unitPnl.add(unitLevel);
		
		JLabel unitMerges = new JLabel(Integer.toString(unitList.get(i - 1).getMerges()), SwingConstants.CENTER);
		unitMerges.setPreferredSize(new Dimension(50, 25));
		unitPnl.add(unitMerges);
		
		JLabel unitBoon = new JLabel(unitList.get(i - 1).getBoon(), SwingConstants.CENTER);
		unitBoon.setPreferredSize(new Dimension(55, 25));
		unitPnl.add(unitBoon);
		
		JLabel unitBane = new JLabel(unitList.get(i - 1).getBane(), SwingConstants.CENTER);
		unitBane.setPreferredSize(new Dimension(55, 25));
		unitPnl.add(unitBane);
		
		JLabel unitWeapon = new JLabel(unitList.get(i - 1).getWeapon(), SwingConstants.CENTER);
		unitWeapon.setPreferredSize(new Dimension(150, 25));
		unitPnl.add(unitWeapon);
		
		JLabel unitAssist = new JLabel(unitList.get(i - 1).getAssist(), SwingConstants.CENTER);
		unitAssist.setPreferredSize(new Dimension(150, 25));
		unitPnl.add(unitAssist);
		
		JLabel unitSpecial = new JLabel(unitList.get(i - 1).getSpecial(), SwingConstants.CENTER);
		unitSpecial.setPreferredSize(new Dimension(150, 25));
		unitPnl.add(unitSpecial);
		
		JLabel unitSkillA = new JLabel(unitList.get(i - 1).getSkillA(), SwingConstants.CENTER);
		unitSkillA.setPreferredSize(new Dimension(150, 25));
		unitPnl.add(unitSkillA);
		
		JLabel unitSkillB = new JLabel(unitList.get(i - 1).getSkillB(), SwingConstants.CENTER);
		unitSkillB.setPreferredSize(new Dimension(150, 25));
		unitPnl.add(unitSkillB);
		
		JLabel unitSkillC = new JLabel(unitList.get(i - 1).getSkillC(), SwingConstants.CENTER);
		unitSkillC.setPreferredSize(new Dimension(150, 25));
		unitPnl.add(unitSkillC);
		
		editBtn = new JButton("Edit");
		editBtn.addActionListener(this);
		editBtn.setBackground(Color.WHITE);
		editBtn.setPreferredSize(new Dimension(55, 25));
		editList.add(editBtn);
		unitPnl.add(editBtn);	
		
		removeBtn = new JButton("Remove");
		removeBtn.addActionListener(this);
		removeBtn.setBackground(Color.WHITE);
		removeBtn.setPreferredSize(new Dimension(80, 25));
		removeList.add(removeBtn);
		unitPnl.add(removeBtn);	
		
		c.gridy = i;
		unitsPnl.add(unitPnl, c);
		mainWindow.updateUI();
	}
	
	/*  Removes an existing unit and its corresponding UI components.
	 *  The input "i" should represent the i-th element (counting from 0)
	 *  of the "unitList" ArrayList BEFORE removing the unit. 
	 */
	private void removeUnit(int i) {
		// Yes = 0 and No = 1
		int option = JOptionPane.showConfirmDialog(
			    frame,
			    "Are you sure you want to remove the selected hero?",
			    "Confirmation",
			    JOptionPane.YES_NO_OPTION);
		
		if (option == 0) {
			unitsPnl.remove(pnlList.get(i));
			pnlList.remove(i);
			editList.remove(i);
			removeList.remove(i);
			unitList.remove(i);

			// Changing the constraints on the remaining JPanels in "unitsPnl".
			if (i != removeList.size()) { // If the removed unit was not the last unit.
				while (i <= removeList.size() - 1) {
					GridBagLayout layout = (GridBagLayout) unitsPnl.getLayout();
					c.gridy = i + 1;
					layout.setConstraints(pnlList.get(i), c);
					i++;
				}
			}
			
			// Serializing the updated "unitList".
			try {
				fileManager.serialize(unitList, "C:\\Users\\zheng\\Documents\\workspace\\FEH Collection\\src\\Units");
				JOptionPane.showMessageDialog(frame, 
						"Unit was successfully removed.",
						"Success",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame,
				    "Unit was not successfully removed. Please try again.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			}
			
			mainWindow.updateUI();
		}
	}
}