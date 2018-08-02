package org.usfirst.frc.team1072.subsystems;

import org.usfirst.frc.team1072.commands.ElevatorMotionMagicCommand;
import org.usfirst.frc.team1072.commands.ElevatorCommand;
import org.usfirst.frc.team1072.commands.ElevatorVelocityPIDCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to control the Victors, Talons, and Encoders in the Elevator
 */
public class Elevator extends Subsystem {

	private static Elevator instance;
	
	private TalonSRX talon;
	private VictorSPX topLeftVictor, topRightVictor, bottomLeftVictor;
	
	private Elevator() {
		talon = new TalonSRX(RobotMap.Elevator.TALON_ID);
		topLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPLEFT_ID);
		topRightVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPRIGHT_ID);
		bottomLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_BOTTOMLEFT_ID);
	}
	
	/**
	 * Returns the Talon in the Elevator (On the Bottom Right of the Elevator)
	 * 
	 * @return The Elevator Talon
	 */
	public TalonSRX getTalon() {
		return talon;
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ElevatorVelocityPIDCommand());
	}
	
	/**
	 * Configures Current Limits for Elevator
	 */
	public void configureCurrentLimits() {
		getTalon().configPeakCurrentLimit(RobotMap.Elevator.CURRENT_PEAK_LIMIT, 10);
		getTalon().configPeakCurrentDuration(RobotMap.Elevator.CURRENT_PEAK_DURATION, 10); 
		getTalon().configContinuousCurrentLimit(RobotMap.Elevator.CURRENT_CONTINUOUS_LIMIT, 10);
		getTalon().enableCurrentLimit(true);
	}
	
	/**
	 * Configures Voltage Compensation for Elevator
	 */
	public void configureVoltageComp() {
		getTalon().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getTalon().enableVoltageCompensation(true); 
	}
	
	/**
	 * Configures Encoder for Elevator
	 */
	public void configureEncoder() {
		getTalon().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
			RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		
		getTalon().setSelectedSensorPosition(0, RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
	}
	
	/**
	 * Configures Soft Limits for Elevator
	 */
	public void configureSoftLimits() {
		getTalon().configForwardSoftLimitEnable(true, RobotMap.TIMEOUT);
		getTalon().configReverseSoftLimitEnable(true, RobotMap.TIMEOUT);
		getTalon().configForwardSoftLimitThreshold(RobotMap.Elevator.MAX_HEIGHT, RobotMap.TIMEOUT);
		getTalon().configReverseSoftLimitThreshold(RobotMap.Elevator.MIN_HEIGHT, RobotMap.TIMEOUT);
	}
	/**
	 * Configures PID constants and Closed Loop Ramping for Elevator
	 */
	public void configurePID() {
		getTalon().config_kF(RobotMap.Elevator.VELOCITY_PID_SLOT, RobotMap.Elevator.VELOCITY_KF, RobotMap.TIMEOUT);
		
		getTalon().config_kF(RobotMap.Elevator.MOTION_MAGIC_SLOT, RobotMap.Elevator.MOTION_MAGIC_KF, RobotMap.TIMEOUT);
		getTalon().config_kP(RobotMap.Elevator.MOTION_MAGIC_SLOT, RobotMap.Elevator.MOTION_MAGIC_KP, RobotMap.TIMEOUT);
		getTalon().config_kI(RobotMap.Elevator.MOTION_MAGIC_SLOT, RobotMap.Elevator.MOTION_MAGIC_KI, RobotMap.TIMEOUT);
		getTalon().config_kD(RobotMap.Elevator.MOTION_MAGIC_SLOT, RobotMap.Elevator.MOTION_MAGIC_KD, RobotMap.TIMEOUT);
		
		getTalon().configClosedloopRamp(RobotMap.Elevator.VOLTAGE_RAMP_RATE, RobotMap.TIMEOUT);
	}
	
	/**
	 * Configures Victors in the Elevator
	 */
	public void configVictors() {
		bottomLeftVictor.follow(talon);
		topLeftVictor.follow(talon);
		topRightVictor.follow(talon);
		
		bottomLeftVictor.setInverted(true);
		topLeftVictor.setInverted(false);
		topRightVictor.setInverted(false);
	}
	
	/**
	 * Gets the instance of Elevator if it already exists, otherwise instantiates one
	 * 
	 * @return an instance of Elevator
	 */
	public static Elevator getInstance() {
		if (instance == null) {
			instance = new Elevator();
		}
		return instance;
	}
}
