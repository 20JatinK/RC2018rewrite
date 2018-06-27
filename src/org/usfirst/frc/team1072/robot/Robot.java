package org.usfirst.frc.team1072.robot;

import org.usfirst.frc.team1072.subsystems.Drivetrain;
import org.usfirst.frc.team1072.robot.OI;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

	public static final Drivetrain drivetrain = Drivetrain.getInstance();
	
	public void robotInit() {
		OI.initBindings();
	}
	
	public void robotPeriodic() {
		
	}
}
