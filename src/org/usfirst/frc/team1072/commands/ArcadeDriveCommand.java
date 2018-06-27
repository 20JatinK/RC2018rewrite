package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1072.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode; 

public class ArcadeDriveCommand extends Command {

	public ArcadeDriveCommand() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void isInterrupted() {
		Robot.drivetrain.leftTalon.set(ControlMode.Disabled,0);
		Robot.drivetrain.rightTalon.set(ControlMode.Disabled,0);
	}
	
	protected void end() {
		Robot.drivetrain.leftTalon.set(ControlMode.Disabled,0);
		Robot.drivetrain.rightTalon.set(ControlMode.Disabled,0);
	}

}
