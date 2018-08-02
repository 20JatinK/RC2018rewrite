package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to drive the robot to a position using Position PID, given a target position
 */
public class DrivetrainPositionCommand extends Command {

	private int targetPos;
	
	/**
	 * Command to drive the robot to a position using Position PID, given a target position
	 *
	 * @param targetPos The position (in encoder units) for the Robot to move straight to
	 */
    public DrivetrainPositionCommand(int targetPos) {
        requires(Robot.drivetrain);
        this.targetPos = targetPos;
    }

    protected void initialize() {
		
		if (targetPos < RobotMap.Drivetrain.MAX_DISTANCE_FOR_POSITION_PID)
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