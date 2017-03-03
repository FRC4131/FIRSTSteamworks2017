package org.usfirst.frc.team4131.robot.utility;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public abstract class AbstractPIDSource implements PIDSource{
	private PIDSourceType type;
	public AbstractPIDSource(){this(PIDSourceType.kDisplacement);}
	public AbstractPIDSource(PIDSourceType defaultType){type = defaultType;}
	public void setPIDSourceType(PIDSourceType type){this.type = type;}
	public PIDSourceType getPIDSourceType(){return type;}
	public double pidGet(){
		switch(type){
			case kDisplacement: return pidGetDisplacement();
			case kRate: return pidGetRate();
			default: return 0;
		}
	}
	protected abstract double pidGetDisplacement();
	protected abstract double pidGetRate();
}
