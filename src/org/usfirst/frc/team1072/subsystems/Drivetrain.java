package org.usfirst.frc.team1072.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.usfirst.frc.team1072.commands.ArcadeDriveCommand;
import org.usfirst.frc.team1072.commands.DrivetrainVelocityCommand;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem{

	private static Drivetrain instance;
	
	private TalonSRX leftTalon, rightTalon;
	private VictorSPX leftVictor, rightVictor;
	
	private Drivetrain() {
		leftTalon = new TalonSRX(RobotMap.Drivetrain.LEFT_TALON_ID);
		rightTalon = new TalonSRX(RobotMap.Drivetrain.RIGHT_TALON_ID);
		leftVictor = new VictorSPX(RobotMap.Drivetrain.LEFT_VICTOR_ID);
		rightVictor = new VictorSPX(RobotMap.Drivetrain.RIGHT_VICTOR_ID);
		
		leftVictor.follow(leftTalon);
		rightVictor.follow(rightTalon);
		
		leftTalon.setInverted(true);
		leftVictor.setInverted(true);
		
		rightTalon.setInverted(false);
		rightVictor.setInverted(false);

	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveCommand());
//		setDefaultCommand(new DrivetrainVelocityCommand());
	}
	
	public void setBoth(ControlMode mode, double value) {
		Robot.drivetrain.getLeft().set(mode, value);
		Robot.drivetrain.getRight().set(mode, value);
	}
	
	public void setEach(ControlMode mode, double valueLeft, double valueRight) {
		Robot.drivetrain.getLeft().set(mode, valueLeft);
		Robot.drivetrain.getRight().set(mode, valueRight);
	}

	public static Drivetrain getInstance() {
		if (instance == null) {
			instance = new Drivetrain();
		}
		return instance;
	}
	
	public TalonSRX getLeft() {
		return Robot.drivetrain.leftTalon;
	}
	
	public TalonSRX getRight() {
		return Robot.drivetrain.rightTalon;
	}
	
	public void driveToPosition(int position) {
		getLeft().set(ControlMode.Position, position);
		getRight().set(ControlMode.Position, position);
	}
	
	public void configVoltageComp() {
		getLeft().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getRight().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getLeft().enableVoltageCompensation(true); 
		getRight().enableVoltageCompensation(true);
	}
	
	public void configureEncoders() {
		getLeft().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
				RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		getRight().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
				RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		
		getLeft().setSelectedSensorPosition(0, RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		getRight().setSelectedSensorPosition(0, RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		
		getLeft().setSensorPhase(RobotMap.Drivetrain.INVERTED_ENCODERS);
		getRight().setSensorPhase(RobotMap.Drivetrain.INVERTED_ENCODERS);
	}
	
	public void configurePID() {
		getLeft().selectProfileSlot(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
		getRight().selectProfileSlot(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
		
		
		getLeft().config_kP(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KP_LEFT, RobotMap.TIMEOUT);
		getRight().config_kP(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KP_RIGHT, RobotMap.TIMEOUT);
		
		getLeft().config_kI(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KI_LEFT, RobotMap.TIMEOUT);
		getRight().config_kI(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KI_RIGHT, RobotMap.TIMEOUT);
		
		getLeft().config_kD(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KD_LEFT, RobotMap.TIMEOUT);
		getRight().config_kD(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KD_RIGHT, RobotMap.TIMEOUT);
		
		getLeft().config_kF(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KF_LEFT, RobotMap.TIMEOUT);
		getRight().config_kF(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.Drivetrain.VELOCITY_KF_RIGHT, RobotMap.TIMEOUT);
		
		
		getLeft().config_kP(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KP_LEFT, RobotMap.TIMEOUT);
		getRight().config_kP(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KP_RIGHT, RobotMap.TIMEOUT);
		
		getLeft().config_kI(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KI_LEFT, RobotMap.TIMEOUT);
		getRight().config_kI(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KI_RIGHT, RobotMap.TIMEOUT);
		
		getLeft().config_kD(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KD_LEFT, RobotMap.TIMEOUT);
		getRight().config_kD(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KD_RIGHT, RobotMap.TIMEOUT);
		
		getLeft().config_kF(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KF_LEFT, RobotMap.TIMEOUT);
		getRight().config_kF(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_KF_RIGHT, RobotMap.TIMEOUT);
		
		getLeft().config_IntegralZone(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_iZone_LEFT, RobotMap.TIMEOUT);
		getRight().config_IntegralZone(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.Drivetrain.POSITION_iZone_RIGHT, RobotMap.TIMEOUT);
	}
	
	public void configNominalOutput() {
		getLeft().configNominalOutputForward(RobotMap.Drivetrain.NOMINAL_OUTPUT_LEFT, RobotMap.TIMEOUT);
		getRight().configNominalOutputForward(RobotMap.Drivetrain.NOMINAL_OUTPUT_RIGHT, RobotMap.TIMEOUT);
		getLeft().configNominalOutputReverse(-RobotMap.Drivetrain.NOMINAL_OUTPUT_LEFT, RobotMap.TIMEOUT);
		getRight().configNominalOutputReverse(-RobotMap.Drivetrain.NOMINAL_OUTPUT_RIGHT, RobotMap.TIMEOUT);
	}
	
	public void configPeakOutput() {
		getLeft().configPeakOutputForward(RobotMap.Drivetrain.PEAK_OUTPUT_LEFT, RobotMap.TIMEOUT);
		getRight().configPeakOutputForward(RobotMap.Drivetrain.PEAK_OUTPUT_RIGHT, RobotMap.TIMEOUT);
		getLeft().configPeakOutputReverse(-RobotMap.Drivetrain.PEAK_OUTPUT_LEFT, RobotMap.TIMEOUT);
		getRight().configPeakOutputReverse(-RobotMap.Drivetrain.PEAK_OUTPUT_RIGHT, RobotMap.TIMEOUT);
	}
}
