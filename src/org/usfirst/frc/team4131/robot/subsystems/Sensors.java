package org.usfirst.frc.team4131.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	private AHRS imu;
	public Sensors() {
		// TODO Instantiate IMU and add appropriate variables
		imu = new AHRS(SPI.Port.kMXP);
	}
	
	public double getAngle() {
		return (imu.getYaw() % 360) + (imu.getYaw() < 0 ? 360 : 0);
	}

	public double getContinuousAngle() {
		return imu.getYaw();
	}
	
	public void resetGyro() {
		imu.zeroYaw();
	}
	
	protected void initDefaultCommand() {
	}
}