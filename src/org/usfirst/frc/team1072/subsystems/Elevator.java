package org.usfirst.frc.team1072.subsystems;

import org.usfirst.frc.team1072.commands.ElevatorVelocityCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private static Elevator instance;
	
	private TalonSRX talon;
	private VictorSPX topLeftVictor, topRightVictor, bottomLeftVictor;
	
	private Elevator() {
		talon = new TalonSRX(RobotMap.Elevator.TALON_ID);
		topLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPLEFT_ID);
		topRightVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPRIGHT_ID);
		bottomLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_BOTTOMLEFT_ID);

		bottomLeftVictor.follow(talon);
		topLeftVictor.follow(talon);
		topRightVictor.follow(talon);
		
		bottomLeftVictor.setInverted(true);
		topLeftVictor.setInverted(false);
		topRightVictor.setInverted(false);
	}
	
	public TalonSRX getTalon() {
		return talon;
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ElevatorVelocityCommand());

	}
	
	public static Elevator getInstance() {
		if (instance == null) {
			instance = new Elevator();
		}
		return instance;
	}
	
	public void configureVoltageComp() {
		getTalon().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getTalon().enableVoltageCompensation(true); 
	}
	
	public void configureEncoder() {
		getTalon().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 
			RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
		
		getTalon().setSelectedSensorPosition(0, RobotMap.PRIMARY_PID_LOOP, RobotMap.TIMEOUT);
	}
	
	public void configureSoftLimits() {
		getTalon().configForwardSoftLimitEnable(true, RobotMap.TIMEOUT);
		getTalon().configReverseSoftLimitEnable(true, RobotMap.TIMEOUT);
		getTalon().configForwardSoftLimitThreshold(RobotMap.Elevator.MAX_HEIGHT, RobotMap.TIMEOUT);
		getTalon().configReverseSoftLimitThreshold(RobotMap.Elevator.MIN_HEIGHT, RobotMap.TIMEOUT);
	}
}
