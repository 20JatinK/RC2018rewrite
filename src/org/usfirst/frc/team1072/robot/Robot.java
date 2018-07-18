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
		drivetrain.getLeft().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		drivetrain.getRight().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		elevator.getTalon().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
		//zero the encoder
		drivetrain.getLeft().setSelectedSensorPosition(0, 0, 10);
		drivetrain.getRight().setSelectedSensorPosition(0, 0, 10);
		elevator.getTalon().setSelectedSensorPosition(0, 0, 10);
		
		drivetrain.getLeft().setSensorPhase(RobotMap.Drivetrain.invertedEncoders);
		drivetrain.getRight().setSensorPhase(RobotMap.Drivetrain.invertedEncoders);
		
		drivetrain.getLeft().config_kP(0, RobotMap.Drivetrain.position_kP_Left, 10);
		drivetrain.getRight().config_kP(0, RobotMap.Drivetrain.position_kP_Right, 10);
		
		drivetrain.getLeft().config_kI(0, RobotMap.Drivetrain.position_kI_Left, 10);
		drivetrain.getRight().config_kI(0, RobotMap.Drivetrain.position_kI_Right, 10);
		
		drivetrain.getLeft().config_kD(0, RobotMap.Drivetrain.position_kD_Left, 10);
		drivetrain.getRight().config_kD(0, RobotMap.Drivetrain.position_kD_Right, 10);
		
		drivetrain.getLeft().config_kF(0, RobotMap.Drivetrain.position_kF_Left, 10);
		drivetrain.getRight().config_kF(0, RobotMap.Drivetrain.position_kF_Right, 10);
		
		drivetrain.getLeft().configNominalOutputForward(0.04, 10);
		drivetrain.getRight().configNominalOutputForward(0.04, 10);
		
		drivetrain.getLeft().configNominalOutputReverse(-0.04, 10);
		drivetrain.getRight().configNominalOutputReverse(-0.04, 10);
		
		drivetrain.getLeft().configPeakOutputForward(1, 10);
		drivetrain.getRight().configPeakOutputForward(1, 10);
		
		drivetrain.getLeft().configPeakOutputReverse(-1, 10);
		drivetrain.getRight().configPeakOutputReverse(-1, 10);
		
		drivetrain.getLeft().config_IntegralZone(RobotMap.Drivetrain.positionPIDSlot, 250, 10);
		drivetrain.getRight().config_IntegralZone(RobotMap.Drivetrain.positionPIDSlot, 250, 10);
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
