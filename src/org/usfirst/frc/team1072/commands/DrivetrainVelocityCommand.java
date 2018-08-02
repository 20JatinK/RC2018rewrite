package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;
import org.usfirst.frc.team1072.robot.RobotMap.Conversions;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to drive the robot at a velocity using Velocity PID controlled by the left Joystick
 */
public class DrivetrainVelocityCommand extends Command {

	/**
	 * Command to drive the robot at a velocity using Velocity PID controlled by the left Joystick
	 */
    public DrivetrainVelocityCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.getLeft().selectProfileSlot(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
		Robot.drivetrain.getRight().selectProfileSlot(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
    }

    protected void execute() {
    	double leftX = OI.controller.getLeftX();
		double leftY = OI.controller.getLeftY();
		double leftXSquared = Math.pow(leftX, 2) * Math.signum(leftX);
		
		double multiplier = Conversions.ftPerSToTicksPer100Ms(
								RobotMap.Drivetrain.MAX_DRIVE_VELOCITY, 
								RobotMap.Drivetrain.WHEEL_DIAMETER);
		
		double leftTargetVelocity = multiplier * (leftY + leftXSquared);
		double rightTargetVelocity = multiplier * (leftY - leftXSquared);
		
		Robot.drivetrain.setEach(ControlMode.Velocity, leftTargetVelocity, rightTargetVelocity);
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivetrain.setBoth(ControlMode.Disabled, 0);
    }

    protected void interrupted() {
    	Robot.drivetrain.setBoth(ControlMode.Disabled, 0);
    }
}
