package tui;

public class QueenThanasimusInsect extends ThanasimusInsect {
	public static int INSECT_HEALTH = 4000;
	public static int GOING_RADIUS = 6;
	public static int BATTLE_ARRAY_RADIUS = 15;
	
	public QueenThanasimusInsect(Group familyGroup) {
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
