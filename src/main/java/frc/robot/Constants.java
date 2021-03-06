/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//ximport com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeSerializer;

import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
	// MotorController Assignments
	//Left Side of board
	public static final int climberL = 1;  //40 AMP FUSE
	public static final int shooterMotor = 2; //40 AMP FUSE
	public static final int driveL1 = 3;  //40 AMP FUSE
	public static final int driveL2 = 4;  //40 AMP FUSE
	public static final int vertIntakeMotor = 5;
	public static final int OPENMOTOR_6 = 6;
	public static final int OPENMOTOR_7 = 7;
	public static final int OPENMOTOR_8 = 8;
	//Right side of board
	public static final int OPENMOTOR_9 = 9;
	public static final int colorWheelMotor = 10;
	public static final int OPENMOTOR_11 = 11;
	public static final int horizIntakeMotor = 12;
	public static final int intakeLiftMotor = 13; //40 AMP FUSE
	public static final int driveR1 = 14;  //40 AMP FUSE
	public static final int driveR2 = 15;  //40 AMP FUSE
	public static final int climberR = 16;  //40 AMP FUSE

	// DriverController Assignments
	public static final int DRIVER_CONTROLLER_1 = 0;
	public static final int DRIVER_CONTROLLER_2 = 1;

	// Control Axis (Joysticks and Triggers)
	public static final int LEFT_STICK_Y = 1;
	public static final int RIGHT_STICK_Y = 5;
	public static final int LEFT_STICK_X = 0;
	public static final int RIGHT_STICK_X = 4;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;

	// Control Buttons
	public static final int PAD_X = 2;
	public static final int PAD_Y = 3;
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int LEFT_BUTTON = 5;
	public static final int RIGHT_BUTTON = 6;
	// Camera Assignment
	public static final int CAMERA_USB = 0;

	// Colors______________________________R____G____B__

	public static final int[][] CYAN = new int[3][11]; // { 0, 255, 255 };
	public static final int[][] MAGENTA = new int[3][11]; // { 255, 0, 0 };
	public static final int[][] YELLOW = new int[3][11]; // { 255, 255, 0 };
	public static final int[][] BLACK = new int[3][11]; // { 0, 0, 0 };

	// Fixed MotorSpeeds
	public static final double INTAKE_SPEED = 1;
	public static final double SPOOL_SPEED = 0.4;
	public static final double DRIVE_MAX_SPEED = 1;
	public static final double TURN_MAX_SPEED = 1.3;
	public static final double STM_SPEED = 0.5;
	public static final double CLIMB_SPEED = 1;
	public static final double STOP = 0;

	// Fixed Variables
	public static final double kDriveTick2Feet = 6.25 / 2560 * Math.PI / 12;
	public static final double kDriveTick2Angle = Math.PI/Math.PI*36/1000;
	public static final double kP = 0.45;
  	public static final double kI = 0.001;
	public static final double kITurn = 0.001;  
  	public static final double kD = 0.15;
	public static final double iLimit = 0.2;

}