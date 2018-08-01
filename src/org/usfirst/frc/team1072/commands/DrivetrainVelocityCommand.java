package org.usfirst.frc.team1072.commands;

import org.usfirst.frc.team1072.robot.OI;
import org.usfirst.frc.team1072.robot.Robot;
import org.usfirst.frc.team1072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainVelocityCommand extends Command {

    public DrivetrainVelocityCommand() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.getLeft().selectProfileSlot(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
		Robot.drivetrain.getRight().selectProfileSlot(RobotMap.Drivetrain.VELOCITY_PID_SLOT, RobotMap.PRIMARY_PID_LOOP);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftX = OI.controller.getLeftX();
		double leftY = OI.controller.getLeftY();
		double leftXSquared = Math.pow(leftX, 2) * Math.signum(leftX);
		
		double multiplier = RobotMap.Drivetrain.MAX_DRIVE_VELOCITY;
		multiplier *= 0.1; //ft per 100 ms 
		multiplier /= (RobotMap.Drivetrain.WHEEL_DIAMETER / 12.0 * Math.PI); //rotations per 100ms
		multiplier *= 4096; //ticks per 100ms
		
		double leftTargetVelocity = multiplier * (leftY + leftXSquared);
		double rightTargetVelocity = multiplier * (leftY - leftXSquared);
		
		Robot.drivetrain.setEach(ControlMode.Velocity, leftTargetVelocity, rightTargetVelocity);
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
