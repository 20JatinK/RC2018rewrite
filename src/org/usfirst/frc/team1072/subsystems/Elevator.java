package org.usfirst.frc.team1072.subsystems;

import org.usfirst.frc.team1072.commands.ArcadeDriveCommand;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private TalonSRX talon;
	private VictorSPX topLeftVictor, topRightVictor, bottomLeftVictor;
	
	@Override
	protected void initDefaultCommand() {
		talon = new TalonSRX(RobotMap.Elevator.TALON);
		topLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPLEFT);
		topRightVictor = new VictorSPX(RobotMap.Elevator.VICTOR_TOPRIGHT);
		bottomLeftVictor = new VictorSPX(RobotMap.Elevator.VICTOR_BOTTOMLEFT);
	}

}
