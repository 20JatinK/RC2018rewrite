package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorVelocityCommand extends Command {

	private double upperLimit, lowerLimit;
	
	public ElevatorVelocityCommand() {
		requires(Robot.elevator);
	}
	
	protected void initialize() {
		//limits in encoder units
		upperLimit = 10000;
		lowerLimit = 0;
		
		//zero the encoder
		Robot.elevator.getTalon().getSensorCollection().setPulseWidthPosition(0,10);
	}
	
	protected void execute() {
		double vel = OI.controller.getRightY();
		int encoder = Robot.elevator.getTalon().getSensorCollection().getPulseWidthPosition();
		
		if (encoder > lowerLimit && encoder < upperLimit)
		{
			Robot.elevator.getTalon().set(ControlMode.PercentOutput, vel);
		}
		
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void isInterrupted() {
		Robot.elevator.getTalon().set(ControlMode.Position, 0);
		Robot.elevator.getTalon().set(ControlMode.Disabled, 0);
	}
	
	protected void end() {
		Robot.elevator.getTalon().set(ControlMode.Position, 0);
		Robot.elevator.getTalon().set(ControlMode.Disabled, 0);
	}

}
