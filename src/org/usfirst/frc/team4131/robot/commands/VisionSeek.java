package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.utility.VisionThread;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionSeek extends Command{
	private static final double TOLERANCE = 5;
	private double lastKnownError;
	private double distance;
	private double speed;
	private PIDController controller = new PIDController(0.05, 0, 0, Robot.drive.getAngleSource(), steer -> Robot.drive.move(speed - steer, speed + steer));
	private NetworkTable debugTable = NetworkTable.getTable("VisionSeek");
	public VisionSeek(double distance, double speed){
		requires(Robot.drive);
		speed = Math.abs(speed);
		controller.setInputRange(0, 360);
		controller.setContinuous();
		controller.setOutputRange(-speed/2, speed/2);
		controller.setSetpoint(0);
		
		this.speed = Math.copySign(speed, distance);
		this.distance = distance;
	}
	protected void initialize(){
		Robot.drive.shiftDown();
		Robot.drive.resetDistance();
		controller.reset();
		controller.enable();
		lastKnownError = 2 * TOLERANCE;//Not done before we've begun
		debugTable.putString("State", "Initialized");
	}
	@Override
	protected void execute(){
		if(controller.onTarget() && VisionThread.instance().hasData() && VisionThread.instance().hasTarget()) synchronized(VisionThread.LOCK){
			lastKnownError = VisionThread.instance().getError();
			controller.setSetpoint(Robot.drive.getAngle() + lastKnownError);
		}
		debugTable.putNumber("Setpoint", controller.getSetpoint());
		debugTable.putNumber("Error", controller.getError());
		debugTable.putNumber("LastKnownError", lastKnownError);
		debugTable.putNumber("Tolerance", TOLERANCE);
		debugTable.putString("State", "Running");
		debugTable.putNumber("Time", System.currentTimeMillis() % 10000);
	}
	protected boolean isFinished(){
		return Math.abs(Robot.drive.getDistance()) > Math.abs(distance);
	}
	protected void end(){
		controller.disable();
		Robot.drive.move(0, 0);
		debugTable.putString("State", "Ended");
	}
	protected void interrupted(){
		controller.disable();
		Robot.drive.move(0, 0);
		debugTable.putString("State", "Interrupted");
	}
}
