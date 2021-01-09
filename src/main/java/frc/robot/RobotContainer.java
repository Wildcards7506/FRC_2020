/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.auton.Drive;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /* This initializes XboxControllers */
  private static XboxController driverController1 = new XboxController(Constants.DRIVER_CONTROLLER_1);
  private static XboxController driverController2 = new XboxController(Constants.DRIVER_CONTROLLER_2);

  /*
   * This method is used to get an axis of XboxController 1 (returns a double
   * ranging from -1 to 1) **YOU MUST SPECIFY WHETHER IT IS A JOYSTICK OR A
   * TRIGGER**
   */
  public double getDriver1Axis(int axis, String type) {
    double axisValue = driverController1.getRawAxis(axis);
    if (type.contains("joystick")) {
      // if-statement is used to counteract false positives from the axis
      if (Math.abs(axisValue) > 0.1)
        return axisValue;
      return 0;
    } else if (type.contains("trigger")) {
      if (axisValue > -0.9)
        return axisValue;
      return 0;
    }
    return 0;
  }

  /*
   * This method treats an axis of XboxController 1 as a button (returns one of
   * three doubles depending on the position of the joystick)
   */
  public double getDriver1Axis(int axis, String type, double nullSpeed, double speed) {
    double axisValue = driverController1.getRawAxis(axis);
    if (type.contains("joystick")) {
      // if-statement is used to counteract false positives from the axis
      if (axisValue > 0.1)
        return speed;
      else if (axisValue < -0.1)
        return -speed;
      return nullSpeed;
    } else if (type.contains("trigger")) {
      if (axisValue > -0.9)
        return axisValue;
      return 0;
    }
    return 0;
  }

  /*
   * This method is used to get the value of a button in XboxController 1 (returns
   * a boolean)
   */
  public boolean getDriver1Button(int button) {
    return driverController1.getRawButton(button);
  }

  public int getDriver1POV() {
    return driverController1.getPOV();
  }

  /*
   * The following five methods perform the same tasks as the previous five with
   * the exception that they get the values from XboxController 2
   */
  public double getDriver2Axis(int axis, String type) {
    double axisValue = driverController2.getRawAxis(axis);
    if (type.contains("joystick")) {
      // if-statement is used to counteract false positives from the axis
      if (Math.abs(axisValue) > 0.1)
        return axisValue;
      return 0;
    } else if (type.contains("trigger")) {
      if (axisValue > -0.9)
        return axisValue;
      return 0;
    }
    return 0;
  }

  public double getDriver2Axis(int axis, String type, double nullSpeed, double speed) {
    double axisValue = driverController2.getRawAxis(axis);
    if (type.contains("joystick")) {
      // if-statement is used to counteract false positives from the axis
      if (axisValue > 0.1)
        return speed;
      else if (axisValue < -0.1)
        return -speed;
      return nullSpeed;
    } else if (type.contains("trigger")) {
      if (axisValue > -0.9)
        return axisValue;
      return 0;
    }
    return 0;
  }

  public boolean getDriver2Button(int button) {
    return driverController2.getRawButton(button);
  }

  public int getDriver2POV() {
    return driverController2.getPOV();
  }

  public double pulse(double pulseLength) {
    double seconds = Timer.getFPGATimestamp();
    int a = (int)(seconds % pulseLength);

    double flip = 0;
    if (a == 0 && flip == 0) {
      flip = 1;
    } else if (a == 0 && flip == 1) {
      flip = 0;
    }
    System.out.println("flip : " + flip);
    //System.out.println("a : " + a);
    return flip;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Start Motors

    Robot.driveTrain.setLeftMotors(Constants.LD * -0.7);
    Robot.driveTrain.setRightMotors(Constants.RD * -0.7);
    // Loop to turn
    long l = 0;
    long p = 0;
    while (l < 5) {
      while (p < 3500000)
        p++;
      while (p != 0)
        p--;
      l++;
    }
    // Set Drive to zero
    Robot.driveTrain.setLeftMotors(0);
    Robot.driveTrain.setRightMotors(0);
    /*
     * Robot.driveTrain.setLeftMotors(Constants.LD * -0.5);
     * Robot.driveTrain.setRightMotors(Constants.RD * 0.5); // Loop to turn /* long
     * i = 0; long j = 0; while (j < 3) { while (i < 3500000) i++; while (i != 0)
     * i--; j++; } // Set Drive to zero Robot.driveTrain.setLeftMotors(0);
     * Robot.driveTrain.setRightMotors(0);
     */
    // Adjust To aim
    // Start Motors
    /*
     * Robot.driveTrain.setLeftMotors(.95 * 0.5); Robot.driveTrain.setRightMotors(.7
     * * 0.5); //Loop to drive (ADJUST THIS TIME)
     * 
     * long i = 0; long j = 0; while (j < 3) { while (i < 3500000) i++; while (i !=
     * 0) i--; j++; } //Set Drive to zero Robot.driveTrain.setLeftMotors(0);
     * Robot.driveTrain.setRightMotors(0);
     */

    // Shoot
    /*
     * Robot.shooter.setShooterMotor(Constants.SHOOTER_SPEED); long x = 0; long y =
     * 0; while (x < 2) { while (y < 3500000) y++; while (y != 0) y--; x++; }
     * Robot.intake.setIntakeMotorDown(Constants.INTAKE_SPEED);
     * Robot.intake.setIntakeMotorUp(-Constants.INTAKE_SPEED); long a = 0; long b =
     * 0; while (a < 6) { while (b < 3500000) b++; while (b != 0) b--; a++; }
     * Robot.shooter.setShooterMotor(0); Robot.intake.setIntakeMotorDown(0);
     * Robot.intake.setIntakeMotorUp(0);
     */
    return new Drive(0, 0);
  }
}
