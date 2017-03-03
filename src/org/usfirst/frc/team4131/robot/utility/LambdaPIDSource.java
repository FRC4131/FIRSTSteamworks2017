package org.usfirst.frc.team4131.robot.utility;

import java.util.function.DoubleSupplier;

public class LambdaPIDSource extends AbstractPIDSource{
	private DoubleSupplier displacement, rate;
	public LambdaPIDSource(DoubleSupplier displacement, DoubleSupplier rate){this.displacement = displacement; this.rate = rate;}
	protected double pidGetDisplacement(){return displacement.getAsDouble();}
	protected double pidGetRate(){return rate.getAsDouble();}
}
