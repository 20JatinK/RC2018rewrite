package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorVelocityCommand extends Command {

	private int upperLimit, lowerLimit;
	
	public ElevatorVelocityCommand() {
		requires(Robot.elevator);
	}
	
	protected void initialize() {
		//limits in encoder units
		upperLimit = 4096 * 5;
		lowerLimit = 0;
	}
	
	protected void execute() {
		double vel = OI.controller.getRightY();
		int encoder = Robot.elevator.getTalon().getSelectedSensorPosition(0);
		
		if (encoder >= lowerLimit && encoder <= upperLimit)
		{
			Robot.elevator.getTalon().set(ControlMode.PercentOutput, vel);
		}
		else
		{
			Robot.elevator.getTalon().set(ControlMode.Position, Math.max(encoder - 250, 0));
		}
		
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void isInterrupted() {
		Robot.elevator.getTalon().set(ControlMode.Position, 0);
		Robot.elevator.getTalon().set(ControlMode.Disabled, 0);
		//May need to change if more commands
	}
	
	protected void end() {
		Robot.elevator.getTalon().set(ControlMode.Position, 0);
		Robot.elevator.getTalon().set(ControlMode.Disabled, 0);
	}

}
