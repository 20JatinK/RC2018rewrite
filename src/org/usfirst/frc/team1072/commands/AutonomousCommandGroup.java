package org.usfirst.frc.team1072.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command to control all actions in Autonomous
 */
public class AutonomousCommandGroup extends CommandGroup {
	
    public AutonomousCommandGroup() {
        //addParallel() or addSequential()
    	
    	System.out.print("AutonomousCommandGroup Started");
    	CommandGroup goToSwitch = new CommandGroup();
 //   		goToSwitch.addSequential(new DrivetrainPositionCommand(3.0));
    		goToSwitch.addSequential(new ElevatorMotionMagicCommand(2.5));
 //   		goToSwitch.addSequential(new RaiseLowerCommand());
		addSequential(goToSwitch);
		
//		CommandGroup outakeCube = new CommandGroup();
//		fullAuton.addSequential(outakeCube);
    }
    
}
