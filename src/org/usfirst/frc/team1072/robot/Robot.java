package org.usfirst.frc.team1072.robot;

import org.usfirst.frc.team1072.subsystems.Drivetrain;
import org.usfirst.frc.team1072.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import org.usfirst.frc.team1072.robot.OI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {

	public static final Drivetrain drivetrain = Drivetrain.getInstance();
	public static final Elevator elevator = Elevator.getInstance();
	
	public void robotInit() {
		OI.initBindings();
	}
	
	public void robotPeriodic() {
		
	}
	
	public void teleopInit() {
		//encoder setup
		elevator.getTalon().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
		//zero the encoder
		elevator.getTalon().setSelectedSensorPosition(0, 0, 10);
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
