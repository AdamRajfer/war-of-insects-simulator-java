package tui;

import java.util.*;

public class Group {
	private Colony familyColony;
	private ArrayList<Insect> insectArrayList = new ArrayList<>();
	
	public Group(Colony familyColony) {
		this.familyColony = familyColony;
	}
	
	protected Insect getInsect(int i) {
		return insectArrayList.get(i);
	}
	
	protected Insect getRandomInsect() {
		Random random = new Random();
		int i = random.nextInt(insectArrayList.size());
		return insectArrayList.get(i);
	}
	
	protected void addInsect(Insect insect) {
		insectArrayList.add(insect);
	}
	
	protected void removeInsect(Insect insect) {
		insectArrayList.remove(insect);
	}
	
	protected void killInsect(Insect insect) {
		if (insectArrayList.size() > 0) {
			removeInsect(insect);
			insect.stopActing();
			insect.stopActed();
		}
	}
	
	protected void findTargets() {
		for (Insect insect : insectArrayList) {
			insect.findTarget();
		}
	}
	
	protected void go() {
		for (Insect insect : insectArrayList) {
			insect.go();
		}
	}
	
	public Colony getFamilyColony() {
		return familyColony;
	}
	
	public ArrayList<Insect> getInsectArrayList() {
		return insectArrayList;
	}
}
