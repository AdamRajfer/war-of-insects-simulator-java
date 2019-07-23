package tui;

import java.awt.*;
import java.util.*;

public class Colony {
	private Environment familyEnvironment;
	private Position colonyPosition;
	private HashMap<String, Group> groupMap = new HashMap<>();
	private Colony enemyColony;
	private Color color;
	
	public Colony(Environment familyEnvironment, int x, int y, Color  color) {
		this.familyEnvironment = familyEnvironment;
		this.colonyPosition = new Position(x, y);
		this.color = color;
	}
	
	protected Group getGroup(String groupName) {
		return groupMap.get(groupName);
	}
	
	protected void insertGroup(String groupName, Group group) {
		groupMap.put(groupName, group);
	}
	
	protected void setEnemyColony(Colony enemyColony) {
		this.enemyColony = enemyColony;
	}
	
	protected void setInsectsCounts(HashMap<Color, Integer> counts) {
		int insectsCount = 0;
		for (String key : groupMap.keySet()) {
			Group group = groupMap.get(key);
			insectsCount += group.getInsectArrayList().size();
		}
		counts.put(color, insectsCount);
	}
	
	protected void setPositions(HashMap<Color, ArrayList<Position>> positions) {
		ArrayList<Position> pos = new ArrayList<>();
		for (String key : groupMap.keySet()) {
			Group group = groupMap.get(key);
			for (Insect insect : group.getInsectArrayList()) {
				pos.add((Position) insect.getInsectPosition().clone());
			}
		}
		positions.put(color, pos);
	}
	
	protected void findTargets() {
		for (String key : groupMap.keySet()) {
			Group group = groupMap.get(key);
			group.findTargets();
		}
	}
	
	protected void go() {
		for (String key : groupMap.keySet()) {
			Group group = groupMap.get(key);
			group.go();
		}
	}
	
	public Environment getFamilyEnvironment() {
		return familyEnvironment;
	}
	
	public Position getColonyPosition() {
		return colonyPosition;
	}
	
	public HashMap<String, Group> getGroupMap() {
		return groupMap;
	}
	
	public Colony getEnemyColony() {
		return enemyColony;
	}
	
	public Color getColor() {
		return color;
	}
}
