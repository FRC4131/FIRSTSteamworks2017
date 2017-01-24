package org.usfirst.frc.team4131.robot.autonomous;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Configuration<E> {
	protected String name;
	protected List<String> keys = new ArrayList<>();
	protected List<E> values = new ArrayList<E>();
	protected SendableChooser chooser = new SendableChooser();

	public Configuration(String name) {
		this.name = name;
	}

	public Configuration<E> put(String key, E b) {
		keys.add(key);
		values.add(b);
		return this;
	}

	public void init() {
		chooser.addDefault(keys.get(0), 0);
		for (int i = 1; i < keys.size(); i++)
			chooser.addObject(keys.get(i), i);
		SmartDashboard.putData(name, chooser);
	}

	public int key() {
		return (int) chooser.getSelected();
	}

	public E value() {
		return values.get(key());
	}
}
