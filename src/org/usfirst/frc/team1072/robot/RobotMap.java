package org.usfirst.frc.team1072.robot;

public class RobotMap {
	
	public static class Drivetrain {
		/**
		 * 4 Cim motors, 2 per gearbox run the drivetrain
		 */
		public static final int LEFT_TALON = 5, RIGHT_TALON = 2, LEFT_VICTOR = 4, RIGHT_VICTOR = 3;
		
		int timeout = 10;
		
		static boolean invertedEncoders = false;
		
		static int positionPIDSlot = 0;
		static int velocityPIDSlot = 1;
		
		static double position_kP_Left = 0.20;
		static double position_kP_Right = 0.19;
		
		static double position_kI_Left = 0.001;
		static double position_kI_Right = 0.001;
		
		static double position_kD_Left = 30;
		static double position_kD_Right = 30;
		
		static double position_kF_Left = 0;
		static double position_kF_Right = 0;
	}
	
	public static class Elevator {
		/**
		 * Talon is bottom right
		 */
		public static int TALON = 9, VICTOR_TOPLEFT = 7, VICTOR_BOTTOMLEFT = 8, VICTOR_TOPRIGHT = 10;
		
	}
	
	public static class Intake {
		public static int LEFT_TALON = 6, RIGHT_TALON = 1;
		public static final int lowerChannel = 1, raiseChannel = 3, compChannel = 0, decompChannel = 2;
		public static final int compressorChannel = 0;
	}
}
