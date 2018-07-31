package org.usfirst.frc.team1072.robot;

import org.usfirst.frc.team1072.subsystems.Drivetrain;
import org.usfirst.frc.team1072.subsystems.Elevator;
import org.usfirst.frc.team1072.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import org.usfirst.frc.team1072.robot.OI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	// Declare/Instantiate subsystems
	public static final Drivetrain drivetrain = Drivetrain.getInstance();
	public static final Elevator elevator = Elevator.getInstance();
	public static final Intake intake = Intake.getInstance();
	
	public void robotInit() {
		OI.initBindings(); // Initialize command bindings
	}
	
	public void autonInit() {
		defaultInit();
	}
	
	public void teleopInit() {
		defaultInit();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		double dtLeftVelocity = Robot.drivetrain.getLeft().getSelectedSensorPosition(0)/System.currentTimeMillis() * 100;
		double dtRightVelocity = Robot.drivetrain.getRight().getSelectedSensorPosition(0)/System.currentTimeMillis()  * 100;
		int errorLeft = Robot.drivetrain.getLeft().getClosedLoopError(0);
		int errorRight = Robot.drivetrain.getRight().getClosedLoopError(0);
		
		SmartDashboard.putNumber("Left", dtLeftVelocity);
		SmartDashboard.putNumber("Right", dtRightVelocity);
		SmartDashboard.putNumber("Left error", errorLeft);
		SmartDashboard.putNumber("Right error", errorRight);
	}
	
	public void defaultInit() {
		drivetrain.configVoltageComp();
		drivetrain.configureEncoders();
		drivetrain.configurePID();
		drivetrain.configNominalOutput();
		drivetrain.configPeakOutput();
		
		elevator.configureVoltageComp();
		elevator.configureEncoder();
		elevator.configureSoftLimits();
		
		intake.configVoltageComp();
	}

}
