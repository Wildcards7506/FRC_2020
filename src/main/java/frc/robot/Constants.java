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
	public static final int MOTOR_LEFT_0 = 0; 
	public static final int MOTOR_LEFT_1 = 1;
	public static final int MOTOR_LEFT_2 = 2;
	public static final int MOTOR_RIGHT_3 = 3;
	public static final int MOTOR_RIGHT_4 = 4;
	public static final int MOTOR_RIGHT_5 = 5;
	public static final int MOTOR_INTAKE_6 = 6;//Intake
	public static final int MOTOR_INTAKE_7 = 7;
	
    //Driver Controller 1 declarations
	public static final int DRIVER_CONTROLLER_1 = 0;
	public static final int LEFT_STICK_Y = 1;
	public static final int RIGHT_STICK_Y = 5;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 0;//need to reassign to an axis
	
    //Driver Controller 2 declarations
	public static final int DRIVER_CONTROLLER_2 = 1;


	public static final double MAX_SPEED = 1;
	public static final double MIN_SPEED = 0;
	
	

	
}
