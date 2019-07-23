package gui;

import javax.swing.*;

public class SimulationFrame extends JFrame {
	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("Failed to load the system appearance.");
		}
	}
	
	public SimulationFrame() {
		super("War of Insects Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLookAndFeel();
		add(new SimulationPanel());	
		setVisible(true);
	}
}
