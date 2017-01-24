package org.usfirst.frc.team4131.robot.utilities;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

/*
 * The first version had a setpoint, but this version only has an error; that way, error can be
 * customized. Also, the controller can be created in the constructor. Make sure to call start()
 * in the command's initialize method.
 * 
 * update() has its own timer; therefore, update should be called only once for each command's execute
 * 
 * If the setpoint changes, call start() again
 */

public class ChrisPIDController {
	private double Kp;
	private double Ki;
	private double Kd;
	private double previousError;
	private double accumulatedError;
	private double previousTime;
	private double processMin;
	private double processMax;
	private Timer timer;

	/*
	 * @param Kp Proportional constant; error is multiplied by this
	 * 
	 * @param Ki Integral constant; the integral of past errors (weighted by
	 * time) is multiplied by this
	 * 
	 * @param Kd Differential constant; the discrete differential (differential
	 * of previous error and this error) is multiplied by this
	 */
	public ChrisPIDController(double Kp, double Ki, double Kd, double processMin, double processMax) {
		this.Kp = Kp;
		this.Ki = Ki;
		this.Kd = Kd;
		this.processMin = processMin;
		this.processMax = processMax;

		previousError = 0.0;
		accumulatedError = 0.0;

		timer = new Timer();
	}

	public void start(double error) {
		timer.reset();
		timer.start();
		accumulatedError = 0.0;
		previousTime = timer.get();
		previousError = error;
	}

	public double update(double error) {
		double process;

		double dt;
		double proportional;
		double integral;
		double differential;
		double currentTime;

		currentTime = timer.get();
		dt = currentTime - previousTime;

		//proportional Error
		proportional = error * Kp * dt;

		//differential Error
		differential = Kd * (error - previousError) * dt;

		//integral Error
		// Trapezoidal Riemann sum
		integral = Ki * dt * (previousError + error) / 2;

		process = proportional + differential + integral + accumulatedError;
		//if the process is outside the process range, don't update the accumulated error
		if (process < processMin || process > processMax) {
			process -= integral;
		} else {
			accumulatedError += integral;
		}

		previousError = error;
		previousTime = currentTime;
		return Robot.constrain(process, processMin, processMax);
	}
}