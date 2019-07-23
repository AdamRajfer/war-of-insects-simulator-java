package tui;

public class DroneDytiscidaeInsect extends DytiscidaeInsect {
	public static int INSECT_HEALTH = 4000;
	public static int GOING_RADIUS = 8;
	public static int BATTLE_ARRAY_RADIUS = 24;
	public static int REGENERATION_TIME = 1100;
	private int passedTime;
	
	public DroneDytiscidaeInsect(Group familyGroup) {
		super(familyGroup, INSECT_HEALTH, GOING_RADIUS, BATTLE_ARRAY_RADIUS);
		passedTime = REGENERATION_TIME;
	}
	
	public int getPassedTime() {
		return passedTime;
	}
	
	public void actTheInsect() {
		if (passedTime == 0) {
			Group soldierGroup = getFamilyGroup().getFamilyColony().getGroup("soldier");
			soldierGroup.addInsect(new SoldierDytiscidaeInsect(soldierGroup));
			passedTime = REGENERATION_TIME;
			stopActing();
		} else {
			passedTime--;
		}
	}
	
	public void setVirtualTargetColony() {
		setTargetColony(getFamilyGroup().getFamilyColony());
	}
	
	public void addGroupsToAct() {
		addGroupToAct("queen");
	}
}
