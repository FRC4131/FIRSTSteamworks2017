package org.usfirst.frc.team4131.robot.commands;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class VisionGearSeek extends Command{
	@SuppressWarnings("unused")
	private static final int IMAGE_WIDTH = 800, IMAGE_HEIGHT = 600;
	@SuppressWarnings("unused")
	private static final double FOV_X = 72, FOV_Y = 57.6;
	private static final double FOCAL_LENGTH = IMAGE_WIDTH/2 / Math.tan(Math.toRadians(FOV_X / 2));
	
	private PIDController controller = new PIDController(0.05, 0, 0.5, Robot.drive.getAngleSource(), speed -> Robot.drive.move(-speed, speed));
	private VisionThread thread;
	private final Object lock = new Object();
	private boolean hasTarget, hasData;
	private double turn;
	public VisionGearSeek(){
		requires(Robot.drive);
		controller.setAbsoluteTolerance(0.5);
		controller.setInputRange(0, 360);
		controller.setContinuous();
		controller.setOutputRange(-1, 1);
		controller.setSetpoint(0);
		thread = new VisionThread();
	}
	protected void initialize(){
		Robot.drive.shiftDown();
		controller.enable();
		thread.start();
	}
	@Override
	protected void execute(){
		if(!hasData) return;
		synchronized(lock){
			if(hasTarget) controller.setSetpoint(Robot.drive.getAngle() + turn);
			hasData = false;
		}
	}
	protected boolean isFinished(){
		return hasTarget && controller.onTarget() && Math.abs(controller.get()) < 0.5;
	}
	protected void end(){
		controller.disable();
		Robot.drive.move(0, 0);
		thread.running = false;
	}
	protected void interrupted(){
		controller.disable();
		Robot.drive.move(0, 0);
		thread.running = false;
	}
	private class VisionThread extends Thread{
		private boolean running = true;
		@Override
		public void run(){
			running = true;
			try(DatagramSocket socket = new DatagramSocket(5800)){
				byte[] b = new byte[1024];
				DatagramPacket packet = new DatagramPacket(b, b.length);
				while(running){
					socket.receive(packet);
					String msg = new String(b, 0, packet.getLength());
					packet.setLength(b.length);
					
					synchronized(lock){
						int i1 = msg.indexOf(' '), i2 = msg.indexOf(' ', i1+1);
						hasTarget = Boolean.parseBoolean(msg.substring(0, i1));
						float targetX = Float.parseFloat(msg.substring(i1+1, i2));
						turn = Math.toDegrees(Math.atan2(targetX - IMAGE_WIDTH/2, FOCAL_LENGTH));
						hasData = true;
					}
				}
			}catch(IOException ex){
				DriverStation.reportError("Error in vision\n" + ex, true);
			}
		}
	}
}
