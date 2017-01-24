
package org.usfirst.frc.team4131.robot;

//import org.usfirst.frc.team4131.robot.commands.CameraToggle;
//import org.usfirst.frc.team4131.robot.commands.EmergencyStop;
//import org.usfirst.frc.team4131.robot.commands.LittleMove;
import org.usfirst.frc.team4131.robot.commands.ToggleDirection;
//import org.usfirst.frc.team4131.robot.commands.ToggleLight;
//import org.usfirst.frc.team4131.robot.commands.VisionSeek;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
//	private boolean emergencyState = false;
	public Joystick leftStick;
	public Joystick rightStick;

//	private Button emergencyStop;
//	private Button inverseDrive;
//	private Button toggleLight;
//	private Button cameraAssist;
	private Button cameraToggle;
	public POVTrigger POV;

	public OI() {
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);

		POV = new POVTrigger(rightStick);

//		cameraToggle = new JoystickButton(rightStick, RobotMap.CAMERA_TOGGLE);
//		cameraToggle.whenPressed(new CameraToggle());
		
//		emergencyStop = new JoystickButton(launchpad, RobotMap.EMERGENCY_STOP);
//		emergencyStop.whenPressed(new EmergencyStop(emergencyState = !emergencyState));

//		deployArms.whenPressed(new DeployArms(-795)); //Ma-gic ma-gic ooh-ooh! Ma-gic ma-gic ooh-ooh! Ma-gic ma-gic ma-gic ma-gic ... ooh-ooh!

//		inverseDrive = new JoystickButton(rightStick, RobotMap.INVERSE);
//		inverseDrive.whenPressed(new ToggleDirection());
		
//		toggleLight = new JoystickButton(leftStick, RobotMap.TOGGLE_LIGHT);
//		toggleLight.whenPressed(new ToggleLight());
		
//		cameraAssist = new JoystickButton(leftStick, RobotMap.VISION_SEEK_TOGGLE);
//		cameraAssist.whenPressed(new VisionSeek());
	}
	
//	public boolean getCameraAssist(){
//		return cameraAssist.get();
//	}
	
	public boolean getCameraToggle(){
		return cameraToggle.get();
	}
	
	public double getLeftSpeed() {
		return Math.pow(leftStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}

	public double getRightSpeed() {
		return Math.pow(rightStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}
	
	public class POVTrigger extends Trigger {
		private final Joystick joystick;

		public POVTrigger(Joystick joystick) {
			this.joystick = joystick;
		}

		public boolean get() {
			return joystick.getPOV() != -1;
		}
	}
}
