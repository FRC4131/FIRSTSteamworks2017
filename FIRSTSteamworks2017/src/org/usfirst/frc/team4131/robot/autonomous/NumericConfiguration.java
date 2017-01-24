package org.usfirst.frc.team4131.robot.autonomous;

public class NumericConfiguration extends Configuration<Integer> {
	public NumericConfiguration(String name, String prefix, int min, int max) {
		super(name);
		for (int i = min; i <= max; i++)
			put(prefix + i, i);
	}
}