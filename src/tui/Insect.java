package tui;

import java.util.*;

public abstract class Insect implements InsectInterface {
	private Group familyGroup;
	private Position insectPosition;
	private Position startInsectPosition;
	private int insectHealth;
	private int startInsectHealth;
	private int goingRadius;
	private int battleArrayRadius;
	private ArrayList<String> groupsToAct = new ArrayList<>();
	private ArrayList<Insect> insectsActing = new ArrayList<>();
	private Insect targetInsect;
	private Colony targetColony;
	
	public Insect(Group familyGroup, int insectHealth, int goingRadius, int battleArrayRadius) {
		this.familyGroup = familyGroup;
		this.insectPosition = (Position) familyGroup.getFamilyColony().getColonyPosition().clone();
		this.startInsectPosition = (Position) familyGroup.getFamilyColony().getColonyPosition().clone();
		this.insectHealth = insectHealth;
		this.startInsectHealth = insectHealth;
		this.goingRadius = goingRadius;
		this.battleArrayRadius = battleArrayRadius;
		setBattleArray();
		addGroupsToAct();
		setVirtualTargetColony();
	}
	
	private void setBattleArray() {
		Random random = new Random();
		int dx = random.nextInt(battleArrayRadius);
		int dy = random.nextInt(battleArrayRadius);
		changeInsectPosition(-battleArrayRadius / 2 + dx, -battleArrayRadius / 2 + dy);
		changeStartInsectPosition(-battleArrayRadius / 2 + dx, -battleArrayRadius / 2 + dy);
	}
	
	private void addInsectActing(Insect insect) {
		insectsActing.add(insect);
	}
	
	private void removeInsectActing(Insect insect) {
		insectsActing.remove(insect);
	}
	
	protected Position findDistance() {
		int dx = getTargetInsect().getInsectPosition().getX() - getInsectPosition().getX();
		int dy = getTargetInsect().getInsectPosition().getY() - getInsectPosition().getY();
		return new Position(dx, dy);
	}
	
	protected Position findBorder() {
		Position distance = findDistance();
		Position border = new Position(0, 0);
		if (distance.getX() > 0) {
			if (distance.getY() > 0) {
				border.setPosition(1, 1);
			} else if (distance.getY() == 0) {
				border.setPosition(1, 0);
			} else if (distance.getY() < 0) {
				border.setPosition(1, -1);
			}
		} else if (distance.getX() == 0) {
			if (distance.getY() > 0) {
				border.setPosition(0, 1);
			} else if (distance.getY() == 0) {
				border.setPosition(0, 0);
			} else if (distance.getY() < 0) {
				border.setPosition(0, -1);
			}
		} else if (distance.getX() < 0) {
			if (distance.getY() > 0) {
				border.setPosition(-1, 1);
			} else if (distance.getY() == 0) {
				border.setPosition(-1, 0);
			} else if (distance.getY() < 0) {
				border.setPosition(-1, -1);
			}
		}
		return border;
	}
	
	protected void addGroupToAct(String groupToAct) {
		groupsToAct.add(groupToAct);
	}
	
	protected void setTargetColony(Colony targetColony) {
		this.targetColony = targetColony;
	}
	
	protected Group getRandomGroup() {
		Random random = new Random();
		int groupNumber = random.nextInt(groupsToAct.size());
		String key = groupsToAct.get(groupNumber);
		Group group = targetColony.getGroup(key);
		return group;
	}
	
	protected void changeInsectPosition(int dx, int dy) {
		insectPosition.addToPosition(dx, dy);
	}
	
	protected void changeStartInsectPosition(int dx, int dy) {
		startInsectPosition.addToPosition(dx, dy);
	}
	
	protected void changeInsectHealth(int dh) {
		insectHealth += dh;
	}
	
	protected void changeStartInsectHealth(int dh) {
		startInsectHealth += dh;
	}
	
	protected void startActing(Insect insect) {
		if (targetInsect == null) {
			targetInsect = insect;
			targetInsect.addInsectActing(this);
		}
	}
	
	protected void stopActing() {
		if (targetInsect != null) {
			targetInsect.removeInsectActing(this);
			targetInsect = null;
		}
	}
	
	protected void stopActed() {
		ArrayList<Insect> insectsToStop = new ArrayList<>();
		for (Insect insect : insectsActing) {
			insectsToStop.add(insect);
		}
		for (Insect insect : insectsToStop) {
			insect.stopActing();
		}
	}
	
	protected void findTarget() {
		if (targetInsect == null) {
			boolean isPassive = true;
			Group randomGroup = getRandomGroup();
			if (randomGroup.getInsectArrayList().size() > 0) {
				Insect targetInsect = randomGroup.getRandomInsect();
				if (targetInsect.getInsectsActing().size() > 0) {
					for (Insect insect : targetInsect.getInsectsActing()) {
						if (insect.familyGroup == familyGroup) {
							isPassive = true;
							break;
						} else {
							isPassive = false;
						}
					}
				} else {
					isPassive = false;
				}
				if (isPassive = false) {
					startActing(targetInsect);
				}
			}
			if (isPassive = true) {
				randomGroup = getRandomGroup();
				if (randomGroup.getInsectArrayList().size() > 0) {
					Insect targetInsect = randomGroup.getRandomInsect();
					startActing(targetInsect);
				}
			}
		}
	}
	
	protected void go() {
		if (targetInsect != null) {
			Position distance = findDistance();
			if (Math.abs(distance.getX()) > goingRadius || Math.abs(distance.getY()) > goingRadius) {
				Position border = findBorder();
				moveTheInsect(border);
			} else {
				actTheInsect();
			}
		}
	}
	
	public Group getFamilyGroup() {
		return familyGroup;
	}
	
	public Position getInsectPosition() {
		return insectPosition;
	}
	
	public Position getStartInsectPosition() {
		return startInsectPosition;
	}
	
	public int getInsectHealth() {
		return insectHealth;
	}
	
	public int getStartInsectHealth() {
		return startInsectHealth;
	}
	
	public int getGoingRadius() {
		return goingRadius;
	}
	
	public int getBattleArrayRadius() {
		return battleArrayRadius;
	}
	
	public ArrayList<String> getGroupsToAct() {
		return groupsToAct;
	}
	
	public ArrayList<Insect> getInsectsActing() {
		return insectsActing;
	}
	
	public Insect getTargetInsect() {
		return targetInsect;
	}
	
	public Colony getTargetColony() {
		return targetColony;
	}
}

