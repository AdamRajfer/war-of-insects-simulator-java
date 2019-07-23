package tui;

public class QueenWaspInsect extends WaspInsect {
	public static int INSECT_HEALTH = 6000;
	public static int GOING_RADIUS = 8;
	public static int BATTLE_ARRAY_RADIUS = 20;
	
	public QueenWaspInsect(Group familyGroup) {
		super(familyGroup, INSECT_HEALTH, GOING_RADIUS, BATTLE_ARRAY_RADIUS);
	}
	
	public void actTheInsect() {
		
	}
	
	public void setVirtualTargetColony() {
		setTargetColony(getFamilyGroup().getFamilyColony());
	}
	
	public void addGroupsToAct() {
		addGroupToAct("drone");
	}
}
