package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPocket extends Subsystem{
	private Solenoid solenoid1;
	private Solenoid solenoid2;
	public GearPocket(){
		solenoid1 = new Solenoid(RobotMap.PCM_ID, RobotMap.GEAR_POCKET1);
		solenoid2 = new Solenoid(RobotMap.PCM_ID, RobotMap.GEAR_POCKET2);
	}
	protected void initDefaultCommand(){
	}
	public void extend(){
		solenoid1.set(true);
		solenoid2.set(false);
	}
	public void retract(){
		solenoid1.set(false);
		solenoid2.set(true);
	}
}
