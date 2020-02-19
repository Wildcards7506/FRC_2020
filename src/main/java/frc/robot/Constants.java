/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //MotorController Assignments
	public static final int MOTOR_1 = 1;
	public static final int MOTOR_2 = 2;
	public static final int MOTOR_3 = 3;
	public static final int MOTOR_4 = 4;
	public static final int MOTOR_5 = 5;
	public static final int MOTOR_6 = 6;
	public static final int MOTOR_7 = 7;
	public static final int MOTOR_8 = 8;
	public static final int MOTOR_9 = 9;
	public static final int MOTOR_10 = 10;
	public static final int MOTOR_11 = 11;
	
    //DriverController Assignments
	public static final int DRIVER_CONTROLLER_1 = 0;
	public static final int DRIVER_CONTROLLER_2 = 1;

	/*JBT Assignments -- These might loose thier purpose in future updates of this program with 
	"DriverController Assignments" being the only ones needed to control the robot. */
	public static final int LEFT_STICK_Y = 1;
	public static final int RIGHT_STICK_Y = 5;
	public static final int LEFT_STICK_X = 0;
	public static final int RIGHT_STICK_X = 0;
	public static final int BUTTON_A = 0;
	public static final int BUTTON_B = 0;
	public static final int BUTTON_X = 0;
	public static final int BUTTON_Y = 0;
	public static final int RIGHT_BUTTON = 0;
	public static final int LEFT_BUTTON = 0;
	public static final int RIGHT_TRIGGER = 0;
	public static final int LEFT_TRIGGER = 0;//need to reassign to an axis

	//Fixed MotorSpeeds
	public static final double MAX_SPEED = 1;
	public static final double STOP = 0;
	public static final double DRIVE_MAX_SPEED = 0.8;

}