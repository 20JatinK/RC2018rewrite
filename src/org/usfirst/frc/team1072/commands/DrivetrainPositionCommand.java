package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;
import org.usfirst.frc.team1072.robot.RobotMap.Conversions;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to drive the robot to a position using Position PID, given a target position in feet
 */
public class DrivetrainPositionCommand extends Command {

	private double targetPos;
	private double wheelDiameter;
	
	/**
	 * Command to drive the robot to a position using Position PID, given a target position in feet
	 *
	 * @param targetPos The position (in feet) for the Robot to move straight to
	 */
    public DrivetrainPositionCommand(double targetPos) {
        requires(Robot.drivetrain);
        wheelDiameter = RobotMap.Drivetrain.WHEEL_DIAMETER;
        this.targetPos = Conversions.feetToTicks(targetPos, wheelDiameter);
    }

    protected void initialize() {
		double maxDistanceInTicks = Conversions.feetToTicks(
										RobotMap.Drivetrain.MAX_DISTANCE_FOR_POSITION_PID,
										wheelDiameter);
		
		if (targetPos < maxDistanceInTicks)
    	{
			Robot.drivetrain.getLeft().selectProfileSlot(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
			Robot.drivetrain.getRight().selectProfileSlot(RobotMap.Drivetrain.POSITION_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
			
    		Robot.drivetrain.setBoth(ControlMode.Position, targetPos);
    	}
    	else 
    	{
    		System.out.println("The target position exceeds the maximum distance allowed for Position PID");
    	}
    }

	@Override
	protected boolean isFinished() {
		return false;
	}
}