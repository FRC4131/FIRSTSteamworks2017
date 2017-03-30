package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearRamp extends Subsystem{
	private DoubleSolenoid solenoid;
	public GearRamp(){
		solenoid = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.GEAR_RAMP1, RobotMap.GEAR_RAMP2);
	}
	protected void initDefaultCommand(){
		
	}
	public void extend(){
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void retract(){
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
}
