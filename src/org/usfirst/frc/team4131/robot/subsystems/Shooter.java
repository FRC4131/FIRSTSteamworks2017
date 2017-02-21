package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will call {@link #runFlywheel()} in teleopPeriodic, and expect the motor to turn at maximum speed when teleop is enabled.
 * Tests passed
 * ====================================
 * @author Matthew
 * @since 1/28/2017
 */

public class Shooter extends Subsystem{
	private CANTalon flywheelMotor = new CANTalon(RobotMap.FLYWHEEL_MOTOR);
	protected void initDefaultCommand(){}
	public Shooter(){
		flywheelMotor.changeControlMode(TalonControlMode.Position);
		flywheelMotor.setPID(0.1, 0, 0);
		flywheelMotor.setCloseLoopRampRate(0);
		flywheelMotor.setIZone(100);
	}
	public void runFlywheel(){
		flywheelMotor.set(1);
	}
	public void stopFlywheel(){
		flywheelMotor.set(0);
	}
}
