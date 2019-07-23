package tui;

public abstract class DytiscidaeInsect extends Insect {
	public DytiscidaeInsect(Group familyGroup, int insectHealth, int goingRadius, int battleArrayRadius) {
		super(familyGroup, insectHealth, goingRadius, battleArrayRadius);
	}
	
	public void moveTheInsect(Position border) {
		if (getInsectPosition().getY() == getStartInsectPosition().getY()) {
			changeInsectPosition(border.getX() * 1, findDistance().getY());
		} else {
			changeInsectPosition(border.getX() * 1, getStartInsectPosition().getY() - getInsectPosition().getY());
		}
	}
}
