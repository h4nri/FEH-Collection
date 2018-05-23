import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI implements ActionListener {
	
	private JButton addBtn;
	private JFrame frame;
	private JPanel mainWindow;
	
	public GUI() {
		frame = new JFrame("Fire Emblem: Heroes Collection");
		mainWindow = new JPanel(new BorderLayout());
		
		addBtn = new JButton("Add New Unit");
		addBtn.setBackground(Color.WHITE);
		addBtn.addActionListener(this);
		mainWindow.add(addBtn, BorderLayout.SOUTH);
		
		frame.setContentPane(mainWindow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 720);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addBtn)) {
			JButton addBtn = new JButton("Add Unit");
			JFrame addFrame = new JFrame("Add New Unit");
			JPanel addPnl = new JPanel();
			
			// Setting up and adding components related to name. 
			JLabel nameLbl = new JLabel("Name:", SwingConstants.CENTER);
			nameLbl.setPreferredSize(new Dimension(100, 25));
			String[] characters = {"Anna", "Morgan (F)", "Nino"};
			JComboBox<String> charList = new JComboBox<>(characters);
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
			JComboBox<Integer> gradeList = new JComboBox<>(grades);
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
			JComboBox<Integer> levelList = new JComboBox<>(levels);
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
			JComboBox<Integer> mergeList = new JComboBox<>(merges);
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
			JComboBox<String> boonList = new JComboBox<>(boons);
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
			JComboBox<String> baneList = new JComboBox<>(banes);
			baneList.addActionListener(this);
			baneList.setBackground(Color.WHITE);
			baneList.setPreferredSize(new Dimension(200, 25));
			((JLabel) baneList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(baneLbl);
			addPnl.add(baneList);
			
			// Setting up and adding components related to weapon. 
			JLabel weaponLbl = new JLabel("Weapon:", SwingConstants.CENTER);
			weaponLbl.setPreferredSize(new Dimension(100, 25));
			String[] weapons = {"Falchion", "Gronnblade+"};
			JComboBox<String> weaponList = new JComboBox<>(weapons);
			weaponList.addActionListener(this);
			weaponList.setBackground(Color.WHITE);
			weaponList.setPreferredSize(new Dimension(200, 25));
			((JLabel) weaponList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(weaponLbl);
			addPnl.add(weaponList);
			
			// Setting up and adding components related to assist. 
			JLabel assistLbl = new JLabel("Assist:", SwingConstants.CENTER);
			assistLbl.setPreferredSize(new Dimension(100, 25));
			String[] assists = {"Reposition", "Swap"};
			JComboBox<String> assistList = new JComboBox<>(assists);
			assistList.addActionListener(this);
			assistList.setBackground(Color.WHITE);
			assistList.setPreferredSize(new Dimension(200, 25));
			((JLabel) assistList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(assistLbl);
			addPnl.add(assistList);
			
			// Setting up and adding components related to special. 
			JLabel specLbl = new JLabel("Special:", SwingConstants.CENTER);
			specLbl.setPreferredSize(new Dimension(100, 25));
			String[] specials = {"Aether", "Moonbow"};
			JComboBox<String> specList = new JComboBox<>(specials);
			specList.addActionListener(this);
			specList.setBackground(Color.WHITE);
			specList.setPreferredSize(new Dimension(200, 25));
			((JLabel) specList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(specLbl);
			addPnl.add(specList);
			
			// Setting up and adding components related to skill A. 
			JLabel skillALbl = new JLabel("Skill A:", SwingConstants.CENTER);
			skillALbl.setPreferredSize(new Dimension(100, 25));
			String[] skillAs = {"Distant Counter", "Fury 3"};
			JComboBox<String> skillAList = new JComboBox<>(skillAs);
			skillAList.addActionListener(this);
			skillAList.setBackground(Color.WHITE);
			skillAList.setPreferredSize(new Dimension(200, 25));
			((JLabel) skillAList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(skillALbl);
			addPnl.add(skillAList);
			
			// Setting up and adding components related to skill B. 
			JLabel skillBLbl = new JLabel("Skill B:", SwingConstants.CENTER);
			skillBLbl.setPreferredSize(new Dimension(100, 25));
			String[] skillBs = {"Desperation 3", "Swordbreaker 3"};
			JComboBox<String> skillBList = new JComboBox<>(skillBs);
			skillBList.addActionListener(this);
			skillBList.setBackground(Color.WHITE);
			skillBList.setPreferredSize(new Dimension(200, 25));
			((JLabel) skillBList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(skillBLbl);
			addPnl.add(skillBList);
			
			// Setting up and adding components related to skill C. 
			JLabel skillCLbl = new JLabel("Skill C:", SwingConstants.CENTER);
			skillCLbl.setPreferredSize(new Dimension(100, 25));
			String[] skillCs = {"Hone Spd 3", "Savage Blow 3"};
			JComboBox<String> skillCList = new JComboBox<>(skillCs);
			skillCList.addActionListener(this);
			skillCList.setBackground(Color.WHITE);
			skillCList.setPreferredSize(new Dimension(200, 25));
			((JLabel) skillCList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			addPnl.add(skillCLbl);
			addPnl.add(skillCList);
			
			addBtn.setBackground(Color.WHITE);
			addBtn.setPreferredSize(new Dimension(100, 25));
			addPnl.add(addBtn);
			
			addFrame.setContentPane(addPnl);
			addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addFrame.setResizable(false);
			addFrame.setSize(350, 435);
			addFrame.setVisible(true);
		}
	}
}
