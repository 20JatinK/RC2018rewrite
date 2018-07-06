package org.usfirst.frc.team1072.subsystems;

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
		
		topLeftVictor.setInverted(true);
		topRightVictor.setInverted(true);
		//Ask how elevator talons are setup (do I need to invert some of them or not?)
	}
	
	public TalonSRX getTalon() {
		return talon;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public static Elevator getInstance() {
		if (instance == null) {
			instance = new Elevator();
		}
		return instance;
	}

}
