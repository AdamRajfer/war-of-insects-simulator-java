package tui;

import java.awt.*;

public class Simulation {
	public static final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int screenX = screenDimension.width;
	public static final int screenY = screenDimension.height;
	public static final int COLONIES_DISTANCE = (int) (screenX * 0.3);
	public static final int topX = (int) (screenX * 0.2);
	public static final int topY = (int) (screenY * 0.2);
	private Environment environment;

	public Simulation() {
		environment = new Environment();
		
		Colony antColony = new Colony(environment, topX, topY, Color.red);
		Colony waspColony = new Colony(environment, topX + COLONIES_DISTANCE, topY, Color.blue);
		Colony dytiscidaeColony = new Colony(environment, topX + COLONIES_DISTANCE, topY + COLONIES_DISTANCE, Color.white);
		Colony thanasimusColony = new Colony(environment, topX, topY + COLONIES_DISTANCE, Color.green);

		antColony.setEnemyColony(waspColony);
		waspColony.setEnemyColony(dytiscidaeColony);
		dytiscidaeColony.setEnemyColony(thanasimusColony);
		thanasimusColony.setEnemyColony(antColony);
		
		Group queenAntGroup = new Group(antColony);
		Group droneAntGroup = new Group(antColony);
		Group soldierAntGroup = new Group(antColony);
		Group workerAntGroup = new Group(antColony);
		
		Group queenWaspGroup = new Group(waspColony);
		Group droneWaspGroup = new Group(waspColony);
		Group soldierWaspGroup = new Group(waspColony);
		Group workerWaspGroup = new Group(waspColony);
		
		Group queenDytiscidaeGroup = new Group(dytiscidaeColony);
		Group droneDytiscidaeGroup = new Group(dytiscidaeColony);
		Group soldierDytiscidaeGroup = new Group(dytiscidaeColony);
		Group workerDytiscidaeGroup = new Group(dytiscidaeColony);
		
		Group queenThanasimusGroup = new Group(thanasimusColony);
		Group droneThanasimusGroup = new Group(thanasimusColony);
		Group soldierThanasimusGroup = new Group(thanasimusColony);
		Group workerThanasimusGroup = new Group(thanasimusColony);
		
		antColony.insertGroup("queen", queenAntGroup);
		antColony.insertGroup("drone", droneAntGroup);
		antColony.insertGroup("soldier", soldierAntGroup);
		antColony.insertGroup("worker", workerAntGroup);
		
		waspColony.insertGroup("queen", queenWaspGroup);
		waspColony.insertGroup("drone", droneWaspGroup);
		waspColony.insertGroup("soldier", soldierWaspGroup);
		waspColony.insertGroup("worker", workerWaspGroup);
		
		dytiscidaeColony.insertGroup("queen", queenDytiscidaeGroup);
		dytiscidaeColony.insertGroup("drone", droneDytiscidaeGroup);
		dytiscidaeColony.insertGroup("soldier", soldierDytiscidaeGroup);
		dytiscidaeColony.insertGroup("worker", workerDytiscidaeGroup);
		
		thanasimusColony.insertGroup("queen", queenThanasimusGroup);
		thanasimusColony.insertGroup("drone", droneThanasimusGroup);
		thanasimusColony.insertGroup("soldier", soldierThanasimusGroup);
		thanasimusColony.insertGroup("worker", workerThanasimusGroup);
		
		environment.insertColony("ant", antColony);
		environment.insertColony("wasp", waspColony);
		environment.insertColony("dytiscidae", dytiscidaeColony);
		environment.insertColony("thanasimus", thanasimusColony);

		
		for (int i = 0; i < 20; ++i) {
			queenAntGroup.addInsect(new QueenAntInsect(queenAntGroup));
		}
		
		for (int i = 0; i < 30; ++i) {
			droneAntGroup.addInsect(new DroneAntInsect(droneAntGroup));
		}
		
		for (int i = 0; i < 40; ++i) {
			soldierAntGroup.addInsect(new SoldierAntInsect(soldierAntGroup));
		}
		
		for (int i = 0; i < 50; ++i) {
			workerAntGroup.addInsect(new WorkerAntInsect(workerAntGroup));
		}
		
		
		for (int i = 0; i < 40; ++i) {
			queenWaspGroup.addInsect(new QueenWaspInsect(queenWaspGroup));
		}
		
		for (int i = 0; i < 50; ++i) {
			droneWaspGroup.addInsect(new DroneWaspInsect(droneWaspGroup));
		}
		
		for (int i = 0; i < 20; ++i) {
			soldierWaspGroup.addInsect(new SoldierWaspInsect(soldierWaspGroup));
		}
		
		for (int i = 0; i < 30; ++i) {
			workerWaspGroup.addInsect(new WorkerWaspInsect(workerWaspGroup));
		}
		
		
		for (int i = 0; i < 30; ++i) {
			queenDytiscidaeGroup.addInsect(new QueenDytiscidaeInsect(queenDytiscidaeGroup));
		}
		
		for (int i = 0; i < 20; ++i) {
			droneDytiscidaeGroup.addInsect(new DroneDytiscidaeInsect(droneDytiscidaeGroup));
		}
		
		for (int i = 0; i < 50; ++i) {
			soldierDytiscidaeGroup.addInsect(new SoldierDytiscidaeInsect(soldierDytiscidaeGroup));
		}
		
		for (int i = 0; i < 40; ++i) {
			workerDytiscidaeGroup.addInsect(new WorkerDytiscidaeInsect(workerDytiscidaeGroup));
		}
		
		
		for (int i = 0; i < 50; ++i) {
			queenThanasimusGroup.addInsect(new QueenThanasimusInsect(queenThanasimusGroup));
		}
		
		for (int i = 0; i < 40; ++i) {
			droneThanasimusGroup.addInsect(new DroneThanasimusInsect(droneThanasimusGroup));
		}
		
		for (int i = 0; i < 30; ++i) {
			soldierThanasimusGroup.addInsect(new SoldierThanasimusInsect(soldierThanasimusGroup));
		}
		
		for (int i = 0; i < 20; ++i) {
			workerThanasimusGroup.addInsect(new WorkerThanasimusInsect(workerThanasimusGroup));
		}
	}
		
	public Environment getEnvironment() {
		return environment;
	}
	
	public void startTour() {
		environment.findTargets();
		environment.go();
	}
}
