package tui;

public class SoldierAntInsect extends AntInsect {
	public static int INSECT_HEALTH = 3000;
	public static int GOING_RADIUS = 8;
	public static int BATTLE_ARRAY_RADIUS = 31;
	public static int ATTACK = 4;

	public SoldierAntInsect(Group familyGroup) {
		super(familyGroup, INSECT_HEALTH, GOING_RADIUS, BATTLE_ARRAY_RADIUS);
	}
	
	public void actTheInsect() {
		getTargetInsect().changeInsectHealth(-ATTACK);
		if (getTargetInsect().getInsectHealth() <= 0) {
			Group targetInsectGroup = getTargetInsect().getFamilyGroup();
			targetInsectGroup.killInsect(getTargetInsect());
		}
	}
	
	public void setVirtualTargetColony() {
		setTargetColony(getFamilyGroup().getFamilyColony().getEnemyColony());
	}
	
	public void addGroupsToAct() {
		addGroupToAct("queen");
	    addGroupToAct("drone");
	    addGroupToAct("soldier");
	    addGroupToAct("worker");
	}
}
