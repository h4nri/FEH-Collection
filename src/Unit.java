import java.io.Serializable;

public class Unit implements Serializable {
	
	private static final long serialVersionUID = -8899424092504638751L;
	private int level, merges, grade;
	private String assist, bane, boon, name, skillA, skillB, skillC, special, weapon;
	
	public int getLevel() {
		return level;
	}
	
	public int getMerges() {
		return merges;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public String getAssist() {
		return assist;
	}
	
	public String getBane() {
		return bane;
	}
	
	public String getBoon() {
		return boon;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSkillA() {
		return skillA;
	}
	
	public String getSkillB() {
		return skillB;
	}
	
	public String getSkillC() {
		return skillC;
	}
	
	public String getSpecial() {
		return special;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	public String getUnit() {
		String s = "Name: " + this.getName() +
				"\nGrade: " + this.getGrade() +
				"\nLevel: " + this.getLevel() +
				"\nMerges: " + this.getMerges() +
				"\nBoon: " + this.getBoon() +
				"\nBane: " + this.getBane() +
				"\nWeapon: " + this.getWeapon() +
				"\nAssist: " + this.getAssist() +
				"\nSpecial: " + this.getSpecial() +
				"\nSkill A: " + this.getSkillA() +
				"\nSkill B: " + this.getSkillB() +
				"\nSkill C: " + this.getSkillC();
		return s;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setMerges(int merges) {
		this.merges = merges;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void setAssist(String assist) {
		this.assist = assist;
	}
	
	public void setBane(String bane) {
		this.bane = bane;
	}
	
	public void setBoon(String boon) {
		this.boon = boon;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSkillA(String skillA) {
		this.skillA = skillA;
	}
	
	public void setSkillB(String skillB) {
		this.skillB = skillB;
	}
	
	public void setSkillC(String skillC) {
		this.skillC = skillC;
	}
	
	public void setSpecial(String special) {
		this.special = special;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
}
