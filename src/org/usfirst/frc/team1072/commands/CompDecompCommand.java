package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command to toggle whether the intake is compressed or decompressed
 */
public class CompDecompCommand extends InstantCommand {

	private DoubleSolenoid.Value value;
	
	/**
	 * Command to toggle whether the intake is compressed or decompressed
	 */
    public CompDecompCommand() {
        super();
		requires(Robot.intakePn);
    }

    protected void initialize() {
    	value = Robot.intakePn.getCompDecomp().get();
		
		if (value == DoubleSolenoid.Value.kForward) {
			Robot.intakePn.getCompDecomp().set(DoubleSolenoid.Value.kReverse);
		}
		else {
			Robot.intakePn.getCompDecomp().set(DoubleSolenoid.Value.kForward);
		}
    }

}
