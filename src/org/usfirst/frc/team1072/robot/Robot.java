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

	public static final Drivetrain drivetrain = Drivetrain.getInstance();
	public static final Elevator elevator = Elevator.getInstance();
	public static final Intake intake = Intake.getInstance();
	
	public void robotInit() {
		OI.initBindings();
	}
	
	public void robotPeriodic() {
		
	}
	
	public void teleopInit() {
		//encoder setup
		drivetrain.getLeft().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
		        RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		drivetrain.getRight().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
		        RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		elevator.getTalon().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
		        RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		
		//zero the encoder
		drivetrain.getLeft().setSelectedSensorPosition(0, RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		drivetrain.getRight().setSelectedSensorPosition(0, RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		elevator.getTalon().setSelectedSensorPosition(0, RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().setSensorPhase(RobotMap.Drivetrain.invertedEncoders);
		drivetrain.getRight().setSensorPhase(RobotMap.Drivetrain.invertedEncoders);
		
		drivetrain.getLeft().config_kP(RobotMap.Drivetrain.positionPIDSlot, 
		        RobotMap.Drivetrain.position_kP_Left, RobotMap.TIMEOUT);
		drivetrain.getRight().config_kP(RobotMap.Drivetrain.positionPIDSlot, 
		        RobotMap.Drivetrain.position_kP_Right, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().config_kI(RobotMap.Drivetrain.positionPIDSlot, 
		        RobotMap.Drivetrain.position_kI_Left, RobotMap.TIMEOUT);
		drivetrain.getRight().config_kI(RobotMap.Drivetrain.positionPIDSlot, 
		        RobotMap.Drivetrain.position_kI_Right, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().config_kD(RobotMap.Drivetrain.positionPIDSlot, RobotMap.Drivetrain.position_kD_Left, RobotMap.TIMEOUT);
		drivetrain.getRight().config_kD(RobotMap.Drivetrain.positionPIDSlot, RobotMap.Drivetrain.position_kD_Right, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().config_kF(RobotMap.Drivetrain.positionPIDSlot, RobotMap.Drivetrain.position_kF_Left, RobotMap.TIMEOUT);
		drivetrain.getRight().config_kF(RobotMap.Drivetrain.positionPIDSlot, RobotMap.Drivetrain.position_kF_Right, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().configNominalOutputForward(RobotMap.Drivetrain.NOMINAL_OUTPUT_LEFT, RobotMap.TIMEOUT);
		drivetrain.getRight().configNominalOutputForward(RobotMap.Drivetrain.NOMINAL_OUTPUT_RIGHT, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().configNominalOutputReverse(-RobotMap.Drivetrain.NOMINAL_OUTPUT_LEFT, RobotMap.TIMEOUT);
		drivetrain.getRight().configNominalOutputReverse(-RobotMap.Drivetrain.NOMINAL_OUTPUT_RIGHT, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().configPeakOutputForward(RobotMap.Drivetrain.PEAK_OUTPUT_LEFT, RobotMap.TIMEOUT);
		drivetrain.getRight().configPeakOutputForward(RobotMap.Drivetrain.PEAK_OUTPUT_RIGHT, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().configPeakOutputReverse(-RobotMap.Drivetrain.PEAK_OUTPUT_LEFT, RobotMap.TIMEOUT);
		drivetrain.getRight().configPeakOutputReverse(-RobotMap.Drivetrain.NOMINAL_OUTPUT_RIGHT, RobotMap.TIMEOUT);
		
		drivetrain.getLeft().config_IntegralZone(RobotMap.Drivetrain.positionPIDSlot, RobotMap.Drivetrain.position_iZone_Left, RobotMap.TIMEOUT);
		drivetrain.getRight().config_IntegralZone(RobotMap.Drivetrain.positionPIDSlot, RobotMap.Drivetrain.position_iZone_Right, RobotMap.TIMEOUT);
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		int dtLeftEncoder = Robot.drivetrain.getLeft().getSelectedSensorPosition(0);
		int dtRightEncoder = Robot.drivetrain.getRight().getSelectedSensorPosition(0);
		int errorLeft = Robot.drivetrain.getLeft().getClosedLoopError(0);
		int errorRight = Robot.drivetrain.getRight().getClosedLoopError(0);
		
		SmartDashboard.putNumber("Left", dtLeftEncoder);
		SmartDashboard.putNumber("Right", dtRightEncoder);
		SmartDashboard.putNumber("Left error", errorLeft);
		SmartDashboard.putNumber("Right error", errorRight);
		
//		drivetrain.driveToPosition(15000);
	}
}
