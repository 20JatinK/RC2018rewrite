package org.usfirst.frc.team1072.robot;

/**
 * Class to hold all general and subsystem related constants
 */
public class RobotMap {
	
    public static final int PRIMARY_PID_LOOP = 0;
    public static final int TIMEOUT = 10;
    public static final double VOLT_COMP = 11.0;
    
    /**
     * Class to hold Drivetrain-specific constants
     */
	public static class Drivetrain {
		
		public static final int LEFT_TALON_ID = 5, RIGHT_TALON_ID = 2, LEFT_VICTOR_ID = 4, RIGHT_VICTOR_ID = 3;
		
		public static final boolean INVERTED_ENCODERS = false;
		
		/**
		 * Max velocity in ft/s
		 */
		public static final int MAX_DRIVE_VELOCITY = 6;
		
		/**
		 * Wheel Diameter in inches
		 */
		public static final double WHEEL_DIAMETER = 3.95;
		
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
		
		/**
		 * Range around target position acceptable to end Position PID
		 */
		public static final double POSITION_PID_TOLERANCE = 300;
		
	    /**
	     * Nominal output in percent output
	     */
	    public static final double NOMINAL_OUTPUT_LEFT = 0.04;
	    
	    /**
	     * Nominal output in percent output
	     */
	    public static final double NOMINAL_OUTPUT_RIGHT = 0.04;
	    
	    /**
	     * Peak output in percent output
	     */
	    public static final double PEAK_OUTPUT_LEFT = 1;
	    
	    /**
	     * Peak output in percent output
	     */
	    public static final double PEAK_OUTPUT_RIGHT = 1;
	    
	    /**
	     * Maximum distance (in feet) robot can drive away from starting point
	     */
	    public static final double MAX_DISTANCE_FOR_POSITION_PID = 4.0;
	}
	
	/**
     * Class to hold ELevator-specific constants
     */
	public static class Elevator {
		/**
		 * Talon is bottom right
		 */
		public static final int TALON_ID = 9, VICTOR_TOPLEFT_ID = 7, VICTOR_BOTTOMLEFT_ID = 8, VICTOR_TOPRIGHT_ID = 10;
		
		public static final int VELOCITY_PID_SLOT = 0;
		public static final int MOTION_MAGIC_SLOT = 1;
		
		
		public static final double VELOCITY_KF = 0.54;
		
		public static final double MOTION_MAGIC_KF = 0.45;
		public static final double MOTION_MAGIC_KP = 0.3; //0.1
		public static final double MOTION_MAGIC_KI = 0.0001; //0.0001
		public static final double MOTION_MAGIC_KD = 0.0; //18
		
		/**
		 * Range around target position acceptable to end Motion Magic
		 */
		public static final double MOTION_MAGIC_TOLERANCE = 300;
		
		/**
		 * Voltage Ramp Rate in seconds between neutral and full
		 */
		public static final double VOLTAGE_RAMP_RATE = 0.75;
		
		/**
		 * Max Height in encoder units
		 */
		public static final int MAX_HEIGHT = 25000;
		
		/**
		 * Min Height in encoder units
		 */
		public static final int MIN_HEIGHT = 1500;
		
		/**
		 * Feed Forward in percent output
		 */
		public static final double ARB_FEED_FORWARD = 0.15;
		
		/**
		 * Max Velocity in ft/s 
		 */
		public static final int MAX_VELOCITY = 1; //should never be higher than 2.5
		
		/**
		 * Sprocket Diameter in inches, multiplied by 2 to compensate for difference between actual position and encoder reading
		 */
		public static final double SPROCKET_DIAMETER = 1.433 * 2;

		/**
		 * Current Peak Limit in Amps
		 */
		public static final int CURRENT_PEAK_LIMIT = 10;
		
		/**
		 * Current Peak Duration in ms
		 */
		public static final int CURRENT_PEAK_DURATION = 40;
		
		/**
		 * Current continuous Limit in Amps
		 */
		public static final int DEFAULT_CURRENT_CONTINUOUS_LIMIT = 5;
		
		/**
		 * Current continuous Limit in Amps for Motion Magic
		 */
		public static final int MOTION_MAGIC_CURRENT_CONTINUOUS_LIMIT = 10;

		/**
		 * Motion Magic Cruise Velocity in sensor units per 100 ms
		 */
		public static final int MOTION_MAGIC_CRUISE_VEL = 500;

		/**
		 * Motion Magic Acceleration in sensor units per 100 ms
		 */
		public static final int MOTION_MAGIC_ACCEL = 1000;
	}
	
	/**
     * Class to hold Intake-specific constants
     */
	public static class Intake {
		public static final int LEFT_TALON_ID = 6, RIGHT_TALON_ID = 1;
		
		public static final int LOWER_CHANNEL = 1, RAISE_CHANNEL = 3, COMP_CHANNEL = 0, DECOMP_CHANNEL = 2;
		public static final int COMPRESSOR_CHANNEL = 0;
	}
	
	/**
	 * Class with methods of conversions
	 */
	public static class Conversions {
		
		/**
		 * Method to convert feet to encoder units
		 * 
		 * @param feet The distance in feet to be converted to encoder units
		 * @param wheelDiameter The diameter in inches of the wheels which the encoder corresponds to
		 * @param isElevator True if for elevator
		 * @return The number of encoder units in the given amount of feet
		 */
		public static double feetToTicks(double feet, double wheelDiameter) {
			double ticks = feet;
			ticks /= wheelDiameter / 12.0 * Math.PI; //feet to rotations
			ticks *= 4096; //rotations to ticks
			return ticks;
		}
		
		public static double ticksToFeet(double ticks, double wheelDiameter) {
			double feet = ticks;
			feet *= wheelDiameter / 12.0 * Math.PI; //feet to rotations
			feet /= 4096; //rotations to ticks
			return feet;
		}
		
		/**
		 * Method to convert ft/s into ticks/100ms
		 * 
		 * @param ftPerS
		 * @param wheelDiameter The diameter in inches of the wheels which the encoder corresponds to 
		 * @return
		 */
		public static double ftPerSToTicksPer100Ms(double ftPerS, double wheelDiameter) {
			double ticksPer100Ms = feetToTicks(ftPerS, wheelDiameter); //ft/s to ticks/s
			ticksPer100Ms *= 0.1; //ticks/s to ticks/100ms
			return ticksPer100Ms;
		}
	}
}
