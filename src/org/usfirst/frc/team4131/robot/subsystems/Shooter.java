package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect both motors to turn at maximum speed in the same direction. Both run1() and run2() should run.
 * Test passed
 * ====================================
 * @author Matthew
 * @since 1/27/2017
 */

public class Shooter extends Subsystem {

	@Override
	protected void initDefaultCommand() {
	}
		private CANTalon flywheel;
		public Shooter(){
			flywheel = new CANTalon(RobotMap.FLYWHEEL);

	}
    public void runFlywheel() {
    	flywheel.set(1);
    }
    public void stopFlywheel() {
    	flywheel.set(0);
    }
   
}
