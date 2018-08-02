package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode; 

/**
 * Command to control drivetrain using the left Joystick without closed looping
 */
public class ArcadeDriveCommand extends Command {

	private static double Threshold = 0.1;
	
	/**
	 * Command to control drivetrain using the left Joystick without closed looping
	 */
	public ArcadeDriveCommand() {
		requires(Robot.drivetrain);
	}
	
	protected void execute() {
		double leftX = OI.controller.getLeftX();
		double leftY = OI.controller.getLeftY() * -1;
		
		if (Math.abs(leftX) < Threshold && Math.abs(leftY) < Threshold) {
			Robot.drivetrain.setBoth(ControlMode.Disabled,0);
		}
		else {
			Robot.drivetrain.setEach(ControlMode.PercentOutput, 
									leftY + Math.pow(leftX, 2) * Math.signum(leftX), 
									leftY - Math.pow(leftX, 2) * Math.signum(leftX));
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void isInterrupted() {
		Robot.drivetrain.setBoth(ControlMode.Disabled,0);
	}
	
	protected void end() {
		Robot.drivetrain.setBoth(ControlMode.Disabled,0);
	}

}
