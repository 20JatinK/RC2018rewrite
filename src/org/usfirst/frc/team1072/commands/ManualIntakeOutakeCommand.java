package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode; 

/**
 * Command to control the Intake's rollers with the triggers
 * 
 * The left trigger is for in-taking and the right trigger is for out-taking
 */
public class ManualIntakeOutakeCommand extends Command {
	
	/**
	 * Command to control the Intake's rollers with the triggers
	 * 
	 * The left trigger is for in-taking and the right trigger is for out-taking
	 */
	public ManualIntakeOutakeCommand() {
		requires(Robot.intakeRo);
	}
	
	protected void execute() {
		if (OI.controller.getRightTriggerPressed()) {
			Robot.intakeRo.getLeftTalon().set(ControlMode.PercentOutput, OI.controller.getRightTrigger());
			Robot.intakeRo.getRightTalon().set(ControlMode.PercentOutput, OI.controller.getRightTrigger());
		}
		else if (OI.controller.getLeftTriggerPressed()) {
			Robot.intakeRo.getLeftTalon().set(ControlMode.PercentOutput, -1 * OI.controller.getLeftTrigger());
			Robot.intakeRo.getRightTalon().set(ControlMode.PercentOutput, -1 * OI.controller.getLeftTrigger());
		}
		else {
			Robot.intakeRo.getLeftTalon().set(ControlMode.Disabled, 0);
			Robot.intakeRo.getRightTalon().set(ControlMode.Disabled, 0);
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void isInterrupted() {
		Robot.intakeRo.getLeftTalon().set(ControlMode.Disabled, 0);
		Robot.intakeRo.getRightTalon().set(ControlMode.Disabled, 0);
	}
	
	protected void end() {
		Robot.intakeRo.getLeftTalon().set(ControlMode.Disabled, 0);
		Robot.intakeRo.getRightTalon().set(ControlMode.Disabled, 0);
	}

}
