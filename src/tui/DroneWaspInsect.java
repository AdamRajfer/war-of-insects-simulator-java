package tui;

public class DroneWaspInsect extends WaspInsect {
	public static int INSECT_HEALTH = 3000;
	public static int GOING_RADIUS = 9;
	public static int BATTLE_ARRAY_RADIUS = 19;
	public static int REGENERATION_TIME = 900;
	private int passedTime;
	
	public DroneWaspInsect(Group familyGroup) {
		super(familyGroup, INSECT_HEALTH, GOING_RADIUS, BATTLE_ARRAY_RADIUS);
		passedTime = REGENERATION_TIME;
	}
	
	public int getPassedTime() {
		return passedTime;
	}
	
	public void actTheInsect() {
		if (passedTime == 0) {
			Group soldierGroup = getFamilyGroup().getFamilyColony().getGroup("soldier");
			soldierGroup.addInsect(new SoldierWaspInsect(soldierGroup));
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
