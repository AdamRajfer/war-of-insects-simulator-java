package tui;

public abstract class AntInsect extends Insect {
	public AntInsect(Group familyGroup, int insectHealth, int goingRadius, int battleArrayRadius) {
		super(familyGroup, insectHealth, goingRadius, battleArrayRadius);
	}
	
	public void moveTheInsect(Position border) {
		changeInsectPosition(border.getX() * 2, border.getY() * 2);
	}
}
