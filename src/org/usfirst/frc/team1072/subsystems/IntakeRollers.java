package org.usfirst.frc.team1072.subsystems;

import org.usfirst.frc.team1072.commands.ManualIntakeOutakeCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem to control rollers in the Intake
 */
public class IntakeRollers extends Subsystem {
	
	private static IntakeRollers instance;
	private TalonSRX left, right;

	private IntakeRollers () {
		left = new TalonSRX(RobotMap.Intake.LEFT_TALON_ID);
		right = new TalonSRX(RobotMap.Intake.RIGHT_TALON_ID);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ManualIntakeOutakeCommand());
    }
    
    /**
     * Returns the left roller
     * 
     * @return Left Roller on Intake
     */
    public TalonSRX getLeftTalon() {
		return left;
	}
	
    /**
     * Returns the right roller
     * 
     * @return Right Roller on Intake
     */
	public TalonSRX getRightTalon() {
		return right;
	}
	
	/**
	 * Configures Voltage Compensation for the rollers
	 */
	public void configVoltageComp() {
		getLeftTalon().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getRightTalon().configVoltageCompSaturation(RobotMap.VOLT_COMP, RobotMap.TIMEOUT);
		getLeftTalon().enableVoltageCompensation(true); 
		getRightTalon().enableVoltageCompensation(true);
	}
	
	/**
	 * Gets the instance of IntakeRollers if it already exists, otherwise instantiates one
	 * 
	 * @return an instance of IntakeRollers
	 */
	public static IntakeRollers getInstance() {
		if (instance == null) {
			instance = new IntakeRollers();
		}
		return instance;
	}
}

