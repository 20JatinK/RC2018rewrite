package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode; 

public class ArcadeDriveCommand extends Command {

	private static double Threshold = 0.1;
	
	public ArcadeDriveCommand() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		double leftX = OI.controller.getLeftX();
		double leftY = OI.controller.getLeftY();
		
		//The rest of this is my attempt at making a solution to arcade drive, Joel's is probably better
		if (Math.abs(leftX) < Threshold && Math.abs(leftY) < Threshold) {
			Robot.drivetrain.setBoth(ControlMode.Disabled,0);
		}
		else {
			if (Math.abs(leftX) > Threshold && Math.abs(leftY) > Threshold) {
				if (leftX < 0) {
					Robot.drivetrain.setEach(ControlMode.PercentOutput, leftY*0.5, leftY);
				}
				else {
					Robot.drivetrain.setEach(ControlMode.PercentOutput, leftY, leftY*0.5);
				}
			}
			else if (Math.abs(leftX) > Threshold) {
				Robot.drivetrain.setEach(ControlMode.PercentOutput,leftY,leftY);
			}
			else {
				Robot.drivetrain.setEach(ControlMode.PercentOutput,leftX,-1*leftX);
			}
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void isInterrupted() {
		Robot.drivetrain.setBoth(ControlMode.Disabled,0);
	}
	
	protected void end() {
		Robot.drivetrain.setBoth(ControlMode.Disabled,0);
	}

}
