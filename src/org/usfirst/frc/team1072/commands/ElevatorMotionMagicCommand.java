package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMotionMagicCommand extends Command {

    public ElevatorMotionMagicCommand() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.getTalon().selectProfileSlot(RobotMap.Elevator.MOTION_MAGIC_SLOT, RobotMap.PRIMARY_PID_LOOP);
    	
    	Robot.elevator.getTalon().configMotionCruiseVelocity(RobotMap.Elevator.MOTION_MAGIC_CRUISE_VEL, RobotMap.TIMEOUT);
    	Robot.elevator.getTalon().configMotionAcceleration(RobotMap.Elevator.MOTION_MAGIC_ACCEL, RobotMap.TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rightY = OI.controller.getRightY();
		
		double targetPosition = rightY * (RobotMap.Elevator.MAX_HEIGHT - RobotMap.Elevator.MIN_HEIGHT) + RobotMap.Elevator.MIN_HEIGHT;
    	
    	Robot.elevator.getTalon().set(ControlMode.MotionMagic, targetPosition, DemandType.ArbitraryFeedForward, RobotMap.Elevator.ARB_FEED_FORWARD);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
