package tui;

import java.awt.*;
import java.util.*;

public class Environment {
	private HashMap<String, Colony> colonyMap = new HashMap<>();

	public Environment() {
		
	}
		
	public Colony getColony(String colonyName) {
		return colonyMap.get(colonyName);
	}
	
	protected void insertColony(String colonyName, Colony colony) {
		colonyMap.put(colonyName, colony);
	}
	
	protected void findTargets() {
		for (String key : colonyMap.keySet()) {
			Colony colony = colonyMap.get(key);
			colony.findTargets();
		}
	}
	
	protected void go() {
		for (String key : colonyMap.keySet()) {
			Colony colony = colonyMap.get(key);
			colony.go();
		}
	}
	
	public HashMap<String, Colony> getColonyMap() {
		return colonyMap;
	}
	
	public HashMap<Color, Integer> getInsectsCounts() {
		HashMap<Color, Integer> insectsCounts = new HashMap<>();
		for (String key : colonyMap.keySet()) {
			Colony colony = colonyMap.get(key);
			colony.setInsectsCounts(insectsCounts);
		}
		return insectsCounts;
	}
	
	public HashMap<Color, ArrayList<Position>> getPositions() {
		HashMap<Color, ArrayList<Position>> insectsPositions = new HashMap<>();
		for (String key : colonyMap.keySet()) {
			Colony colony = colonyMap.get(key);
			colony.setPositions(insectsPositions);
		}
		return insectsPositions;
	}
}
