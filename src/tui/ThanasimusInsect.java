package tui;

public abstract class ThanasimusInsect extends Insect {
	public ThanasimusInsect(Group familyGroup, int insectHealth, int goingRadius, int battleArrayRadius) {
		super(familyGroup, insectHealth, goingRadius, battleArrayRadius);
	}
	
	public void moveTheInsect(Position border) {
		changeInsectPosition(border.getX() * 3, border.getY() * 1);
	}
}
