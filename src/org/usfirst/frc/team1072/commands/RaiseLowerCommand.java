package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command to toggle whether the intake is raised or flat
 */
public class RaiseLowerCommand extends InstantCommand {

	private DoubleSolenoid.Value value;
	
    public RaiseLowerCommand() {
        super();
		requires(Robot.intake);
    }

    protected void initialize() {
    	value = Robot.intake.getRaiseLower().get();
		
		if (value == DoubleSolenoid.Value.kForward) {
			Robot.intake.getRaiseLower().set(DoubleSolenoid.Value.kReverse);
		}
		else {
			Robot.intake.getRaiseLower().set(DoubleSolenoid.Value.kForward);
		}
    }

}
