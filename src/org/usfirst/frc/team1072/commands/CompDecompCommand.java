package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Command to toggle whether the intake is compressed or decompressed
 */
public class CompDecompCommand extends InstantCommand {

	private DoubleSolenoid.Value value;
	
    public CompDecompCommand() {
        super();
		requires(Robot.intake);
    }

    protected void initialize() {
    	value = Robot.intake.getCompDecomp().get();
		
		if (value == DoubleSolenoid.Value.kForward) {
			Robot.intake.getCompDecomp().set(DoubleSolenoid.Value.kReverse);
		}
		else {
			Robot.intake.getCompDecomp().set(DoubleSolenoid.Value.kForward);
		}
    }

}
