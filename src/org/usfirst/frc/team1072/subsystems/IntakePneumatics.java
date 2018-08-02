package org.usfirst.frc.team1072.subsystems;

import org.usfirst.frc.team1072.commands.IntakeOutakeCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to control all solenoids in the Intake
 */
public class IntakePneumatics extends Subsystem {

	private static IntakePneumatics instance;
	
	private DoubleSolenoid raiseAndLower, compAndDecomp;
	private Compressor compressor;
	
	private IntakePneumatics() {
		compressor = new Compressor(RobotMap.Intake.COMPRESSOR_CHANNEL);
		
		raiseAndLower = new DoubleSolenoid(RobotMap.Intake.RAISE_CHANNEL, RobotMap.Intake.LOWER_CHANNEL);
		compAndDecomp = new DoubleSolenoid(RobotMap.Intake.COMP_CHANNEL, RobotMap.Intake.DECOMP_CHANNEL);
		
		raiseAndLower.set(DoubleSolenoid.Value.kForward);
	}
	
	/**
	 * Returns the DoubleSolenoid used for raising or lowering the intake
	 * 
	 * @return The Raise/Lower DoubleSolenoid
	 */
	public DoubleSolenoid getRaiseLower() {
		return raiseAndLower;
	}
	
	/**
	 * Returns the DoubleSolenoid used for compressing or decompressing the intake
	 * 
	 * @return The Compress/Decompress DoubleSolenoid
	 */
	public DoubleSolenoid getCompDecomp() {
		return compAndDecomp;
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	/**
	 * Gets the instance of IntakePneumatics if it already exists, otherwise instantiates one
	 * 
	 * @return an instance of IntakePneumatics
	 */
	public static IntakePneumatics getInstance() {
		if (instance == null) {
			instance = new IntakePneumatics();
		}
		return instance;
	}
}
