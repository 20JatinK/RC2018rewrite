package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to run the elevator at a velocity controlled by the right Joystick using Motion Magic
 */
public class ElevatorMotionMagicCommand extends Command {

    public ElevatorMotionMagicCommand() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.getTalon().selectProfileSlot(RobotMap.Elevator.MOTION_MAGIC_SLOT, RobotMap.PRIMARY_PID_LOOP);
    	
    	Robot.elevator.getTalon().configMotionCruiseVelocity(RobotMap.Elevator.MOTION_MAGIC_CRUISE_VEL, RobotMap.TIMEOUT);
    	Robot.elevator.getTalon().configMotionAcceleration(RobotMap.Elevator.MOTION_MAGIC_ACCEL, RobotMap.TIMEOUT);
    }

    protected void execute() {
    	double rightY = OI.controller.getRightY();
		
		double targetPosition = rightY * (RobotMap.Elevator.MAX_HEIGHT - RobotMap.Elevator.MIN_HEIGHT) + RobotMap.Elevator.MIN_HEIGHT;
    	
    	Robot.elevator.getTalon().set(ControlMode.MotionMagic, targetPosition, DemandType.ArbitraryFeedForward, RobotMap.Elevator.ARB_FEED_FORWARD);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
