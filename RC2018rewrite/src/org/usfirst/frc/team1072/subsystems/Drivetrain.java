package org.usfirst.frc.team1072.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.usfirst.frc.team1072.commands.ArcadeDriveCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem{

	private static Drivetrain instance;
	
	public TalonSRX leftTalon, rightTalon;
	private VictorSPX leftVictor, rightVictor;
	
	private Drivetrain() {
		leftTalon = new TalonSRX(RobotMap.Drivetrain.LEFT_TALON);
		rightTalon = new TalonSRX(RobotMap.Drivetrain.RIGHT_TALON);
		leftVictor = new VictorSPX(RobotMap.Drivetrain.LEFT_VICTOR);
		rightVictor = new VictorSPX(RobotMap.Drivetrain.RIGHT_VICTOR);
		
		leftVictor.follow(leftTalon);
		rightVictor.follow(rightTalon);
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveCommand());
	}

	public static Drivetrain getInstance() {
		if (instance == null) {
			instance = new Drivetrain();
		}
		return instance;
	}
	
}
