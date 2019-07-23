package tui;

public class DroneThanasimusInsect extends ThanasimusInsect {
	public static int INSECT_HEALTH = 3000;
	public static int GOING_RADIUS = 5;
	public static int BATTLE_ARRAY_RADIUS = 16;
	public static int REGENERATION_TIME = 1000;
	private int passedTime;
	
	public DroneThanasimusInsect(Group familyGroup) {
		super(familyGroup, INSECT_HEALTH, GOING_RADIUS, BATTLE_ARRAY_RADIUS);
		passedTime = REGENERATION_TIME;
	}
	
	public int getPassedTime() {
		return passedTime;
	}
	
	public void actTheInsect() {
		if (passedTime == 0) {
			Group soldierGroup = getFamilyGroup().getFamilyColony().getGroup("soldier");
			soldierGroup.addInsect(new SoldierThanasimusInsect(soldierGroup));
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
