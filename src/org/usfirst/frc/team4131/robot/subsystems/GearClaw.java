
package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearClaw extends Subsystem{
	private Solenoid solenoid1, solenoid2;
	public GearClaw(){
		solenoid1 = new Solenoid(RobotMap.PCM_ID, RobotMap.GEAR_CLAW1);
		solenoid2 = new Solenoid(RobotMap.PCM_ID, RobotMap.GEAR_CLAW2);
	}
	protected void initDefaultCommand(){
	}
	public void open(){
		solenoid1.set(false);
		solenoid2.set(true);
	}
	public void close(){
		solenoid1.set(true);		
		solenoid2.set(false);
	}
}
