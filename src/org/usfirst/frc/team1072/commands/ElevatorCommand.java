package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to run the elevator at a velocity controlled by the right Joystick without closed looping
 */
public class ElevatorCommand extends Command {

	public ElevatorCommand() {
		requires(Robot.elevator);
	}
	
	protected void execute() {
		double rightY = OI.controller.getRightY();
		
		Robot.elevator.getTalon().set(ControlMode.PercentOutput, rightY, DemandType.ArbitraryFeedForward, RobotMap.Elevator.ARB_FEED_FORWARD);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void isInterrupted() {
		Robot.elevator.getTalon().set(ControlMode.Disabled, 0);
		Robot.elevator.getTalon().set(ControlMode.Disabled, 0);
	}
	
	protected void end() {
		Robot.elevator.getTalon().set(ControlMode.Position, 0);
		Robot.elevator.getTalon().set(ControlMode.Disabled, 0);
	}

}
