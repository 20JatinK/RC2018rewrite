package org.usfirst.frc.team1072.subsystems;

import org.usfirst.frc.team1072.commands.ElevatorVelocityCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private static Elevator instance;
	
	private TalonSRX talon;
	private VictorSPX topLeftVictor, topRightVictor, bottomLeftVictor;
	
	private Elevator() {
		talon = new TalonSRX(RobotMap.Elevator.TALON);
		topLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPLEFT);
		topRightVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPRIGHT);
		bottomLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_BOTTOMLEFT);

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

}
