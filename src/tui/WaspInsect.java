package tui;

public abstract class WaspInsect extends Insect {
	public WaspInsect(Group familyGroup, int insectHealth, int goingRadius, int battleArrayRadius) {
		super(familyGroup, insectHealth, goingRadius, battleArrayRadius);
	}
	
	public void moveTheInsect(Position border) {
		changeInsectPosition(border.getX() * 1, border.getY() * 3);
	}
}
