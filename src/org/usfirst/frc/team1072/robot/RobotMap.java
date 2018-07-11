package org.usfirst.frc.team1072.robot;

public class RobotMap {
	
	public static class Drivetrain {
		/**
		 * 4 Cim motors, 2 per gearbox run the drivetrain
		 */
		public static final int LEFT_TALON = 5, RIGHT_TALON = 2, LEFT_VICTOR = 4, RIGHT_VICTOR = 3;
		
		int timeout = 10;
		
		static boolean invertedEncoders = true;
		
		int positionPIDSlot = 0;
		int velocityPIDSlot = 1;
		
		static double position_kP_Left = 0.11;
		static double position_kP_Right = 0.11;
		
		static double position_kI_Left = 0;
		static double position_kI_Right = 0;
		
		static double position_kD_Left = 0;
		static double position_kD_Right = 0;
		
		static double position_kF_Left = 0;
		static double position_kF_Right = 0;
	}
	
	public static class Elevator {
		/**
		 * Talon is bottom right
		 */
		public static int TALON = 9, VICTOR_TOPLEFT = 7, VICTOR_BOTTOMLEFT = 8, VICTOR_TOPRIGHT = 10;
		
	}
}
