package org.usfirst.frc.team1072.robot;

public class RobotMap {
	
    public static final int PRIMARY_PID_LOOP = 0;
    public static final int TIMEOUT = 10;
    public static final double VOLT_COMP = 11.0;
	public static class Drivetrain {
		
		/**
		 * 4 Cim motors, 2 per gearbox run the drivetrain
		 */
		public static final int LEFT_TALON_ID = 5, RIGHT_TALON_ID = 2, LEFT_VICTOR_ID = 4, RIGHT_VICTOR_ID = 3;
		
		public static final boolean INVERTED_ENCODERS = false;
		
		public static final int MAX_DRIVE_VELOCITY = 6; //ft per s
		
		public static final double WHEEL_DIAMETER = 3.95; //in
		
		public static final int POSITION_PID_SLOT = 0;
		public static final int VELOCITY_PID_SLOT = 1;
		
		
		public static final double POSITION_KP_LEFT = 0.20;
		public static final double POSITION_KP_RIGHT = 0.19;
		
		public static final double POSITION_KI_LEFT = 0.001;
		public static final double POSITION_KI_RIGHT = 0.001;
		
		public static final double POSITION_KD_LEFT = 30;
		public static final double POSITION_KD_RIGHT = 30;
		
		public static final double POSITION_KF_LEFT = 0;
		public static final double POSITION_KF_RIGHT = 0;
		
		public static final int POSITION_iZone_LEFT = 250;
	    public static final int POSITION_iZone_RIGHT = 250;
		
	    
		public static final double VELOCITY_KP_LEFT = 0.6;
		public static final double VELOCITY_KP_RIGHT = 0.6;
		
		public static final double VELOCITY_KI_LEFT = 0.0;
		public static final double VELOCITY_KI_RIGHT = 0.0;
		
		public static final double VELOCITY_KD_LEFT = 0;
		public static final double VELOCITY_KD_RIGHT = 0;
		
		public static final double VELOCITY_KF_LEFT = 0.23; 
		public static final double VELOCITY_KF_RIGHT = 0.23; 
		
	    
	    public static final double NOMINAL_OUTPUT_LEFT = 0.04;
	    public static final double NOMINAL_OUTPUT_RIGHT = 0.04;
	    public static final double PEAK_OUTPUT_LEFT = 1;
	    public static final double PEAK_OUTPUT_RIGHT = 1;
	    
	    public static final int MAX_DISTANCE_FOR_POSITION_PID = 10000; //in encoder units
	}
	
	public static class Elevator {
		/**
		 * Talon is bottom right
		 */
		public static final int TALON_ID = 9, VICTOR_TOPLEFT_ID = 7, VICTOR_BOTTOMLEFT_ID = 8, VICTOR_TOPRIGHT_ID = 10;
		
		public static final int VELOCITY_PID_SLOT = 0;
		public static final int MOTION_MAGIC_SLOT = 1;
		
		
		public static final double VELOCITY_KF = 0.54;
		
		public static final double MOTION_MAGIC_KF = 0.54;
		public static final double MOTION_MAGIC_KP = 0.1;
		public static final double MOTION_MAGIC_KI = 0.0001;
		public static final double MOTION_MAGIC_KD = 18;
		
		public static final double VOLTAGE_RAMP_RATE = 0.75; //seconds
		
		public static final int MAX_HEIGHT = 20000;
		public static final int MIN_HEIGHT = 2000;
		
		public static final double ARB_FEED_FORWARD = 0.15;
		
		public static final int MAX_VELOCITY = 1; //ft per s, maximum is 2.5
		public static final double SPROCKET_DIAMETER = 1.433; //in

		public static final int CURRENT_PEAK_LIMIT = 10;
		public static final int CURRENT_PEAK_DURATION = 40; //ms
		public static final int CURRENT_CONTINUOUS_LIMIT = 5;

		public static final int MOTION_MAGIC_CRUISE_VEL = 650;

		public static final int MOTION_MAGIC_ACCEL = 2250;
	}
	
	public static class Intake {
		public static final int LEFT_TALON_ID = 6, RIGHT_TALON_ID = 1;
		
		public static final int LOWER_CHANNEL = 1, RAISE_CHANNEL = 3, COMP_CHANNEL = 0, DECOMP_CHANNEL = 2;
		public static final int COMPRESSOR_CHANNEL = 0;
	}
}
