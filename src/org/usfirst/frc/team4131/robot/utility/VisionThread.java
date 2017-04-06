package org.usfirst.frc.team4131.robot.utility;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionThread extends Thread{
	public static final int IMAGE_WIDTH = 640, IMAGE_HEIGHT = 480;
	@SuppressWarnings("unused")
	private static final double FOV_X = 72, FOV_Y = 57.6;
	private static final double FOCAL_LENGTH = IMAGE_WIDTH/2 / Math.tan(Math.toRadians(FOV_X / 2));
	public static final Object LOCK = new Object();
	private static VisionThread instance;
	private boolean hasData = false, hasTarget = false;
	private double turn = 0;
	private NetworkTable table = NetworkTable.getTable("VisionThread");
	private VisionThread(){super("4131-Vision");}
	@Override
	public void run(){
		table.putNumber("StartedAt", System.currentTimeMillis() % 10000);
		table.putString("Pi", "Not Found");
		try(DatagramSocket socket = new DatagramSocket(5800)){
			byte[] b = new byte[1024];
			DatagramPacket packet = new DatagramPacket(b, b.length);
			while(true){
				socket.receive(packet);
				String msg = new String(b, 0, packet.getLength());
				packet.setLength(b.length);
				
				synchronized(LOCK){
					int i1 = msg.indexOf(' '), i2 = msg.indexOf(' ', i1+1);
					hasTarget = Boolean.parseBoolean(msg.substring(0, i1));
					float targetX = Float.parseFloat(msg.substring(i1+1, i2));
					turn = Math.toDegrees(Math.atan2(targetX - IMAGE_WIDTH/2, FOCAL_LENGTH));
					hasData = true;
				}
				table.putBoolean("HasTarget", hasTarget);
				table.putNumber("Turn", turn);
				table.putNumber("Time", System.currentTimeMillis() % 10000);
				table.putString("Pi", packet.getAddress().getHostAddress());
			}
		}catch(Throwable ex){
			DriverStation.reportError("Error in vision\n" + ex, true);
		}
	}
	public boolean hasData(){return hasData;}
	public boolean hasTarget(){return hasTarget;}
	public double getError(){
		hasData = false;
		return turn;
	}
	public static VisionThread instance(){
		if(instance == null) (instance = new VisionThread()).start();
		return instance;
	}
}