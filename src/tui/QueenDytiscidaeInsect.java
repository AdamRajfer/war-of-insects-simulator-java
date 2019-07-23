package tui;

public class QueenDytiscidaeInsect extends DytiscidaeInsect {
	public static int INSECT_HEALTH = 3000;
	public static int GOING_RADIUS = 7;
	public static int BATTLE_ARRAY_RADIUS = 25;
	
	public QueenDytiscidaeInsect(Group familyGroup) {
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
