package org.usfirst.frc.team4131.robot.utilities;

public class Point {
	public double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return String.format("[%d,%d]", x, y);
	}
}