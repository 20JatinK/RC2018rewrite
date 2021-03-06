/*----------------------------------------------------------------------------*/
/*
 * Copyright (c) 2017-2018 FIRST. All Rights Reserved. Open Source Software -
 * may be modified and shared by FRC teams. The code must be accompanied by the
 * FIRST BSD license file in the root directory of the project.
 */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1072.robot;

import org.usfirst.frc.team1072.commands.CompDecompCommand;
import org.usfirst.frc.team1072.commands.ElevatorMotionMagicCommand;
import org.usfirst.frc.team1072.commands.RaiseLowerCommand;
import org.usfirst.frc.team1072.commands.TestCommand;
import org.usfirst.frc.team1072.harkerrobolib.wrappers.DPadButtonWrapper;
import org.usfirst.frc.team1072.harkerrobolib.wrappers.GamepadWrapper;
import org.usfirst.frc.team1072.robot.RobotMap.Conversions;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:
	
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());
	
	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	/**
	 * Xbox Controller
	 */
	public static GamepadWrapper controller = new GamepadWrapper(0);
	
	public static DPadButtonWrapper dPadUp = new DPadButtonWrapper(controller, 0);
	public static DPadButtonWrapper dPadRight = new DPadButtonWrapper(controller, 90);
	public static DPadButtonWrapper dPadDown = new DPadButtonWrapper(controller, 180);
	public static DPadButtonWrapper dPadLeft = new DPadButtonWrapper(controller, 270);
	
	/**
	 * Assigns Commands to Buttons
	 */
	public static void initBindings() {
		controller.getButtonY().whenPressed(new RaiseLowerCommand());
		controller.getButtonX().whenPressed(new CompDecompCommand());
		
		dPadUp.whenPressed(new ElevatorMotionMagicCommand(1.5));
		dPadDown.whenPressed(new ElevatorMotionMagicCommand(Conversions.ticksToFeet(
																RobotMap.Elevator.MIN_HEIGHT,
																RobotMap.Elevator.SPROCKET_DIAMETER)));
	}
}