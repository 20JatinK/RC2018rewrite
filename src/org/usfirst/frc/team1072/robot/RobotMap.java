package org.usfirst.frc.team1072.robot;

public class RobotMap {
	
    public static int PRIMARY_PID_LOOP = 0;
    public static int AUXILIARY_PID_LOOP = 1;
    public static int TIMEOUT = 10;
    public static double VOLT_COMP = 10.0;
	public static class Drivetrain {
		/**
		 * 4 Cim motors, 2 per gearbox run the drivetrain
		 */
		public static final int LEFT_TALON = 5, RIGHT_TALON = 2, LEFT_VICTOR = 4, RIGHT_VICTOR = 3;
		
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
		
		static double velocity_kP_Left = 0.0;
		static double velocity_kP_Right = 0.0;
		
		static double velocity_kI_Left = 0.0;
		static double velocity_kI_Right = 0.0;
		
		static double velocity_kD_Left = 0;
		static double velocity_kD_Right = 0;
		
		static double velocity_kF_Left = 0;
		static double velocity_kF_Right = 0;
		
		public static int position_iZone_Left = 250;
	    public static int position_iZone_Right = 250;
	    
	    public static double NOMINAL_OUTPUT_LEFT = 0.04;
	    public static double NOMINAL_OUTPUT_RIGHT = 0.04;
	    public static double PEAK_OUTPUT_LEFT = 1;
	    public static double PEAK_OUTPUT_RIGHT = 1;
	}
	
	public static class Elevator {
		public static int MAX_LIMIT = 20000;
		public static int MIN_LIMIT = 500;
		public static double ARB_FEED_FORWARD = 0.15;
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
