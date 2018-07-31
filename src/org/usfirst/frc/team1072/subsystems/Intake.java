package org.usfirst.frc.team1072.subsystems;

import org.usfirst.frc.team1072.commands.IntakeOutakeCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private static Intake instance;
	
	private TalonSRX left, right;
	private DoubleSolenoid raiseAndLower, compAndDecomp;
	private Compressor compressor;
	
	private Intake() {
		left = new TalonSRX(RobotMap.Intake.LEFT_TALON_ID);
		right = new TalonSRX(RobotMap.Intake.RIGHT_TALON_ID);
		compressor = new Compressor(RobotMap.Intake.COMPRESSOR_CHANNEL);
		
		raiseAndLower = new DoubleSolenoid(RobotMap.Intake.RAISE_CHANNEL, RobotMap.Intake.LOWER_CHANNEL);
		compAndDecomp = new DoubleSolenoid(RobotMap.Intake.COMP_CHANNEL, RobotMap.Intake.DECOMP_CHANNEL);
		
		raiseAndLower.set(DoubleSolenoid.Value.kForward);
	}
	
	public TalonSRX getLeftTalon() {
		return left;
	}
	
	public TalonSRX getRightTalon() {
		return right;
	}
	
	public DoubleSolenoid getRaiseLower() {
		return raiseAndLower;
	}
	
	public DoubleSolenoid getCompDecomp() {
		return compAndDecomp;
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IntakeOutakeCommand());
	}
	
	public static Intake getInstance() {
		if (instance == null) {
			instance = new Intake();
		}
		return instance;
	}

	public void configVoltageComp() {
		getLeftTalon().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getRightTalon().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getLeftTalon().enableVoltageCompensation(true); 
		getRightTalon().enableVoltageCompensation(true);
	}
}
