package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command to toggle whether the intake is raised or flat
 */
public class RaiseLowerCommand extends InstantCommand {

	private DoubleSolenoid.Value value;
	
	/**
	 * Command to toggle whether the intake is raised or flat
	 */
    public RaiseLowerCommand() {
        super();
		requires(Robot.intakePn);
    }

    protected void initialize() {
    	System.out.println("Raise/Lower started");
    	value = Robot.intakePn.getRaiseLower().get();
		
		if (value == DoubleSolenoid.Value.kForward) {
			Robot.intakePn.getRaiseLower().set(DoubleSolenoid.Value.kReverse);
		}
		else {
			Robot.intakePn.getRaiseLower().set(DoubleSolenoid.Value.kForward);
		}
		System.out.println("Raise/Lower finished");
    }

}
