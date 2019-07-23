package tui;

public class DroneAntInsect extends AntInsect {
	public static int INSECT_HEALTH = 5000;
	public static int GOING_RADIUS = 10;
	public static int BATTLE_ARRAY_RADIUS = 29;
	public static int REGENERATION_TIME = 800;
	private int passedTime;
	
	public DroneAntInsect(Group familyGroup) {
		super(familyGroup, INSECT_HEALTH, GOING_RADIUS, BATTLE_ARRAY_RADIUS);
		passedTime = REGENERATION_TIME;
	}
	
	public int getPassedTime() {
		return passedTime;
	}
	
	public void actTheInsect() {
		if (passedTime == 0) {
			Group soldierGroup = getFamilyGroup().getFamilyColony().getGroup("soldier");
			soldierGroup.addInsect(new SoldierAntInsect(soldierGroup));
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
