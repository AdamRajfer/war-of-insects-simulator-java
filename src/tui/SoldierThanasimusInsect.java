package tui;

public class SoldierThanasimusInsect extends ThanasimusInsect {
	public static int INSECT_HEALTH = 6000;
	public static int GOING_RADIUS = 7;
	public static int BATTLE_ARRAY_RADIUS = 14;
	public static int ATTACK = 6;
	
	public SoldierThanasimusInsect(Group familyGroup) {
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
