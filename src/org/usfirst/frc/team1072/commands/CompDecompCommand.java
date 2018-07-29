package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode; 

public class CompDecompCommand extends Command {
	
	private DoubleSolenoid.Value value;
	private boolean isExecuted;
	
	public CompDecompCommand() {
		requires(Robot.intake);
	}
	
	protected void initialize() {
		isExecuted = false;
		value = Robot.intake.getCompDecomp().get();
		
		if (value == DoubleSolenoid.Value.kForward) {
			Robot.intake.getCompDecomp().set(DoubleSolenoid.Value.kReverse);
		}
		else {
			Robot.intake.getCompDecomp().set(DoubleSolenoid.Value.kForward);
		}
	}
	
	protected void execute() {
		isExecuted = true;
	}
	
	@Override
	protected boolean isFinished() {
		return isExecuted;
	}
	
	protected void isInterrupted() {

	}
	
	protected void end() {

	}

}
