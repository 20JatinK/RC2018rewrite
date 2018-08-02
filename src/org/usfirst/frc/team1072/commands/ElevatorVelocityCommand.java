package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;
import org.usfirst.frc.team1072.robot.RobotMap.Conversions;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to run the elevator at a velocity controlled by the right Joystick using Velocity PID
 */
public class ElevatorVelocityCommand extends Command {

	/**
	 * Command to run the elevator at a velocity controlled by the right Joystick using Velocity PID
	 */
    public ElevatorVelocityCommand() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.getTalon().selectProfileSlot(RobotMap.Elevator.VELOCITY_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double rightY = OI.controller.getRightY();
		
		double multiplier = Conversions.ftPerSToTicksPer100Ms(
								RobotMap.Elevator.MAX_VELOCITY, 
								RobotMap.Elevator.SPROCKET_DIAMETER);
		
		double targetVelocity = multiplier * rightY;
		
		if (Robot.elevator.getTalon().getSelectedSensorPosition(0) < RobotMap.Elevator.MIN_HEIGHT)
		{
			if (targetVelocity < 0)
			{
				targetVelocity = 0;
			}
		}
		
		Robot.elevator.getTalon().set(ControlMode.Velocity, targetVelocity, DemandType.ArbitraryFeedForward, RobotMap.Elevator.ARB_FEED_FORWARD);
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
