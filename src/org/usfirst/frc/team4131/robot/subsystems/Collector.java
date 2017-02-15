package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Run on Robot in a Box
 * We will call {@link #collect()} in teleop, and expect the motor to spin at full speed.
 * Tests passed
 * ====================================
 * 
 * @author Patrick
 * @since 1/28/2017
 * 
 */
public class Collector extends Subsystem {

	@Override
	protected void initDefaultCommand() {
	}

	// TODO Auto-generated method stub
	CANTalon motor;

	public Collector() {
		motor = new CANTalon(RobotMap.COLLECTOR_MOTOR);
	}

	public void collect() {
		motor.set(1);
	}

	public void stop() {
		motor.set(0);

	}
	
	public void unload() {
		motor.set(-1);
	}
}
