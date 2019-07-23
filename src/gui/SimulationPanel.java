package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

import tui.*;

public class SimulationPanel extends JPanel implements Runnable {
	public static final Font FONT_1 = new Font("Tahoma", Font.PLAIN, 40);
	public static final Font FONT_2 = new Font("Tahoma", Font.PLAIN, 20);
	public static final Font FONT_3 = new Font("Tahoma", Font.BOLD, 20);
	public static final int SIMULATION_TIME = 15000;
	private Simulation simulation = new Simulation();
	private PropertiesPanel propertiesPanel = new PropertiesPanel();;
	private HashMap<Color, ArrayList<Position>> positions;
	private HashMap<Color, Integer> counts;
	private JPanel gamePanel = new JPanel() {
		public void paintComponent(Graphics comp) {
			Graphics2D comp2D = (Graphics2D) comp;
			comp2D.setColor(Color.black);
			Rectangle2D.Float rectangle = new Rectangle2D.Float(0F, 0F, getSize().width, getSize().height);
			comp2D.fill(rectangle);
			if (positions != null && counts != null) {
				for (Color key : positions.keySet()) {
					ArrayList<Position> arrayList = positions.get(key);
					for (int i = 0; i < arrayList.size(); i++) {
						comp2D.setColor(key);
						comp2D.fillOval(arrayList.get(i).getX(), arrayList.get(i).getY(), 6, 6);
					}
				}
				int x = 100;
				for (Color key : counts.keySet()) {
					int count = counts.get(key);
					comp2D.setColor(key);
					comp2D.setFont(FONT_1);
					comp2D.drawString(String.valueOf(count), 100, x);
					x += 100;
				}
			}
		}
	};
	
	public SimulationPanel() {
		super();
		setLayout(new BorderLayout());
		add(gamePanel, BorderLayout.CENTER);
		add(propertiesPanel, BorderLayout.EAST);
	}
	
	public void run() {
		propertiesPanel.beginButton.setEnabled(false);
		propertiesPanel.setDefaultPropertiesButton.setEnabled(false);
		for (int i = 0; i < SIMULATION_TIME; ++i) {
			simulation.startTour();
			positions = simulation.getEnvironment().getPositions();
			counts = simulation.getEnvironment().getInsectsCounts();
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println("Failed to sleep.");
			}
		}
		propertiesPanel.beginButton.setEnabled(true);
		propertiesPanel.setDefaultPropertiesButton.setEnabled(true);
		simulation = new Simulation();
	}
	
	private class PropertiesPanel extends JPanel {
		private JButton beginButton = new JButton("start the simulation");
		private JButton setDefaultPropertiesButton = new JButton("set default properties");
		private JButton exitButton = new JButton("leave the program");
		private InsectPanel antPanel;
		private InsectPanel waspPanel;
		private InsectPanel dytiscidaePanel;
		private InsectPanel thanasimusPanel;

		public PropertiesPanel() {
			super();
			beginButton.setFont(FONT_3);
			setDefaultPropertiesButton.setFont(FONT_3);
			exitButton.setFont(FONT_3);
			setLayout(new BorderLayout());
			JPanel insectsPanel = new JPanel();
			JPanel buttonPanel = new JPanel();
			insectsPanel.setLayout(new GridLayout(4, 1));
			buttonPanel.setLayout(new GridLayout(3, 1));
			antPanel = new InsectPanel("ANTS", simulation.getEnvironment().getColony("ant").getColor());
			waspPanel = new InsectPanel("WASPS", simulation.getEnvironment().getColony("wasp").getColor());
			dytiscidaePanel = new InsectPanel("DYTISCIDAES", simulation.getEnvironment().getColony("dytiscidae").getColor());
			thanasimusPanel = new InsectPanel("THANASIMUSES", simulation.getEnvironment().getColony("thanasimus").getColor());
			insectsPanel.add(antPanel);
			insectsPanel.add(waspPanel);
			insectsPanel.add(dytiscidaePanel);
			insectsPanel.add(thanasimusPanel);
			buttonPanel.add(beginButton);
			buttonPanel.add(setDefaultPropertiesButton);
			buttonPanel.add(exitButton);
			add(insectsPanel, BorderLayout.CENTER);
			add(buttonPanel, BorderLayout.NORTH);
			addAllProperties();
			addListeners();
		}
		
		private void addListeners() {
			ActionListener beginButtonListener = (event) -> {
				getProperties();
				new Thread(SimulationPanel.this).start();
			};
			beginButton.addActionListener(beginButtonListener);
			
			ActionListener setDefaultPropertiesButtonListener = (event) -> {
				addAllProperties();
			};
			setDefaultPropertiesButton.addActionListener(setDefaultPropertiesButtonListener);
			
			ActionListener exitButtonListener = (event) -> {
				System.exit(0);
			};
			exitButton.addActionListener(exitButtonListener);
		}
		
		private void addDefaultProperties(InsectPanel insectPanel, int attack, int cure, int regenerationPanel) {
			insectPanel.field1.field.setText("" + attack);
			insectPanel.field2.field.setText("" + cure);
			insectPanel.field3.field.setText("" + regenerationPanel);
		}
		
		private void getProperties() {
			SoldierAntInsect.ATTACK = Integer.parseInt(antPanel.field1.field.getText());
			WorkerAntInsect.CURE = Integer.parseInt(antPanel.field2.field.getText());
			DroneAntInsect.REGENERATION_TIME = Integer.parseInt(antPanel.field3.field.getText());
			
			SoldierWaspInsect.ATTACK = Integer.parseInt(waspPanel.field1.field.getText());
			WorkerWaspInsect.CURE = Integer.parseInt(waspPanel.field2.field.getText());
			DroneWaspInsect.REGENERATION_TIME = Integer.parseInt(waspPanel.field3.field.getText());
			
			SoldierDytiscidaeInsect.ATTACK = Integer.parseInt(dytiscidaePanel.field1.field.getText());
			WorkerDytiscidaeInsect.CURE = Integer.parseInt(dytiscidaePanel.field2.field.getText());
			DroneDytiscidaeInsect.REGENERATION_TIME = Integer.parseInt(dytiscidaePanel.field3.field.getText());
			
			SoldierThanasimusInsect.ATTACK = Integer.parseInt(thanasimusPanel.field1.field.getText());
			WorkerThanasimusInsect.CURE = Integer.parseInt(thanasimusPanel.field2.field.getText());
			DroneThanasimusInsect.REGENERATION_TIME = Integer.parseInt(thanasimusPanel.field3.field.getText());
		}
		
		private void addAllProperties() {
			addDefaultProperties(antPanel, SoldierAntInsect.ATTACK, WorkerAntInsect.CURE, DroneAntInsect.REGENERATION_TIME);
			addDefaultProperties(waspPanel, SoldierWaspInsect.ATTACK, WorkerWaspInsect.CURE, DroneWaspInsect.REGENERATION_TIME);
			addDefaultProperties(dytiscidaePanel, SoldierDytiscidaeInsect.ATTACK, WorkerDytiscidaeInsect.CURE, DroneDytiscidaeInsect.REGENERATION_TIME);
			addDefaultProperties(thanasimusPanel, SoldierThanasimusInsect.ATTACK, WorkerThanasimusInsect.CURE, DroneThanasimusInsect.REGENERATION_TIME);
		}
		
		private class InsectPanel extends JPanel {
			FieldPanel field1;
			FieldPanel field2;
			FieldPanel field3;
			
			public InsectPanel(String insectName, Color color) {
				super();
				setLayout(new BorderLayout());
				JPanel fieldsPanel = new JPanel();
				JPanel upPanel = new JPanel() {
					public void paintComponent(Graphics comp) {
						Graphics2D comp2D = (Graphics2D) comp;
						comp2D.setColor(color);
						Rectangle2D.Float rect = new Rectangle2D.Float(0F, 0F, getSize().width, getSize().height);
						comp2D.fill(rect);
					}
				};
				upPanel.setLayout(new BorderLayout());
				JLabel insectNameLabel = new JLabel(insectName + ": ");
				insectNameLabel.setFont(FONT_2);
				upPanel.add(insectNameLabel, BorderLayout.EAST);	
				fieldsPanel.setLayout(new GridLayout(3, 1));
				field1 = new FieldPanel("attack:");
				field2 = new FieldPanel("cure:");
				field3 = new FieldPanel("regeneration time:");
				fieldsPanel.add(field1);
				fieldsPanel.add(field2);
				fieldsPanel.add(field3);
				add(fieldsPanel, BorderLayout.CENTER);
				add(upPanel, BorderLayout.NORTH);
			}

			private class FieldPanel extends JPanel {
				private JTextField field = new JTextField(5);

				public FieldPanel(String power) {
					super();
					field.setFont(FONT_3);
					setLayout(new GridLayout(1, 2));
					JLabel powerLabel = new JLabel(power);
					powerLabel.setFont(FONT_2);
					JPanel labelPanel = new JPanel();
					labelPanel.setOpaque(false);
					powerLabel.setOpaque(false);
					field.setOpaque(false);
					labelPanel.setLayout(new BorderLayout());
					labelPanel.add(powerLabel, BorderLayout.EAST);
					add(labelPanel);
					add(field);
				}
			}
		}
	}
}
