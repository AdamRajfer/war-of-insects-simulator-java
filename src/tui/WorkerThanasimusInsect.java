package tui;

public class WorkerThanasimusInsect extends ThanasimusInsect {
	public static int INSECT_HEALTH = 5000;
	public static int GOING_RADIUS = 8;
	public static int BATTLE_ARRAY_RADIUS = 13;
	public static int CURE = 6;
	
	public WorkerThanasimusInsect(Group familyGroup) {
		super(familyGroup, INSECT_HEALTH, GOING_RADIUS, BATTLE_ARRAY_RADIUS);
	}
	
	public void actTheInsect() {
		Insect targetInsect = getTargetInsect();
		if (targetInsect.getInsectHealth() < targetInsect.getStartInsectHealth()) {
			targetInsect.changeInsectHealth(CURE);
			if (targetInsect.getInsectHealth() > targetInsect.getStartInsectHealth()) {
				int difference = targetInsect.getInsectHealth() - targetInsect.getStartInsectHealth();
				targetInsect.changeInsectHealth(-difference);
			}
		}
		stopActing();
	}
	
	public void setVirtualTargetColony() {
		setTargetColony(getFamilyGroup().getFamilyColony());
	}
	
	public void addGroupsToAct() {
		addGroupToAct("queen");
	    addGroupToAct("drone");
	    addGroupToAct("soldier");
	}
}
