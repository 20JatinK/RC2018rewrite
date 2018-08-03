package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TestCommand extends InstantCommand {

    public TestCommand() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	System.out.println("Command Initialized");
    }

}
