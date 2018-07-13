package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode; 

public class RaiseLowerCommand extends Command {
	
	private DoubleSolenoid.Value value;
	private boolean isExecuted;
	
	public RaiseLowerCommand() {
		requires(Robot.intake);
	}
	
	protected void initialize() {
		isExecuted = false;
		value = Robot.intake.getRaiseLower().get();
		
		if (value == DoubleSolenoid.Value.kForward) {
			Robot.intake.getRaiseLower().set(DoubleSolenoid.Value.kReverse);
		}
		else {
			Robot.intake.getRaiseLower().set(DoubleSolenoid.Value.kForward);
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
		Robot.intake.getRaiseLower().set(DoubleSolenoid.Value.kOff);
	}
	
	protected void end() {
		Robot.intake.getRaiseLower().set(DoubleSolenoid.Value.kOff);
	}

}
