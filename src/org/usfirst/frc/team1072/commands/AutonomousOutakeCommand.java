package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.usfirst.frc.team1072.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode; 

/**
 * Command to autonomously outake cubes
 */
public class AutonomousOutakeCommand extends TimedCommand {
	
	/**
	 * Command to autonomously outake cubes
	 */
	public AutonomousOutakeCommand() {
		super(2.0); //2 seconds
		requires(Robot.intakeRo);
	}
	
	protected void initialize() {
		System.out.println("Outake started");
	}
	
	protected void execute() {
		Robot.intakeRo.getLeftTalon().set(ControlMode.PercentOutput, 0.5);
		Robot.intakeRo.getRightTalon().set(ControlMode.PercentOutput, 0.5);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void isInterrupted() {
		Robot.intakeRo.getLeftTalon().set(ControlMode.Disabled, 0);
		Robot.intakeRo.getRightTalon().set(ControlMode.Disabled, 0);
		System.out.println("Outake Interrupted");
	}
	
	protected void end() {
		Robot.intakeRo.getLeftTalon().set(ControlMode.Disabled, 0);
		Robot.intakeRo.getRightTalon().set(ControlMode.Disabled, 0);
		System.out.println("Outake finished");
	}

}
