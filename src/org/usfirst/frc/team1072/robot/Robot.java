package org.usfirst.frc.team1072.robot;

import org.usfirst.frc.team1072.subsystems.Drivetrain;
import org.usfirst.frc.team1072.subsystems.Elevator;
import org.usfirst.frc.team1072.subsystems.IntakeRollers;
import org.usfirst.frc.team1072.subsystems.IntakePneumatics;
import org.usfirst.frc.team1072.commands.AutonomousCommandGroup;
import org.usfirst.frc.team1072.robot.OI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main class which controls the robot in Autonomous or Tele-operated periods
 */
public class Robot extends TimedRobot {

	/**
	 * Instance of Drivetrain
	 */
	public static final Drivetrain drivetrain = Drivetrain.getInstance();
	
	/**
	 * Instance of Elevator
	 */
	public static final Elevator elevator = Elevator.getInstance();
	
	/**
	 * Instance of IntakePneumatics
	 */
	public static final IntakePneumatics intakePn = IntakePneumatics.getInstance();
	
	/**
	 * Instance of IntakeRollers
	 */
	public static final IntakeRollers intakeRo = IntakeRollers.getInstance();
	
	public void robotInit() {
		OI.initBindings();
	}
	
	public void autonomousInit() {
		defaultInit();
		
		AutonomousCommandGroup autonCommand = new AutonomousCommandGroup();
		autonCommand.start();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		defaultInit();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		int error = Robot.elevator.getTalon().getClosedLoopError(0);
		double current = Robot.elevator.getTalon().getOutputCurrent();
		
		SmartDashboard.putNumber("Error", error);
		SmartDashboard.putNumber("Current", current);
	}
	
	/**
	 * Default configurations for all subsystems to be applied on Robot startup
	 */
	public void defaultInit() {
		drivetrain.configVoltageComp();
		drivetrain.configureEncoders();
		drivetrain.configurePID();
		drivetrain.configNominalOutput();
		drivetrain.configPeakOutput();
		
		elevator.configVictors();
		elevator.configureVoltageComp();
		elevator.configureEncoder();
		elevator.configureSoftLimits();
		elevator.configureCurrentLimits();
		elevator.configurePID();
		
		intakeRo.configVoltageComp();
	}

}
