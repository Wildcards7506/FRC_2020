/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
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

  /* This method is used to print XboxController values */
  public String controlValues(int j1, int j2, int b1, int b2, int b3, int b4, int b5, int b6, int j3) {
    return "JY: " + (int) (-getDriver1RawAxis(j1) * 100) + " | JX: " + (int) (getDriver1RawAxis(j2) * 100) + " | A: "
        + driverController2.getRawButton(b1) + " | B: " + driverController2.getRawButton(b2) + " | X: "
        + driverController2.getRawButton(b3) + " | Y: " + driverController2.getRawButton(b4) + " | LB: "
        + driverController2.getRawButton(b5) + " | RB: " + driverController2.getRawButton(b6) + " | Elevator: "
        + (int) (-getDriver2RawAxis(j3) * 100);

  }

  /*
   * This method is used to get the x or y axis of a joystick in XboxController 1
   * (returns a double ranging from -1 to 1)
   */
  public double getDriver1RawAxis(int axis) {
    return driverController1.getRawAxis(axis);
  }

  /*
   * This method treats a joystick in XboxController 1 as a button (returns one of
   * three doubles depending on the position of the joystick)
   */
  public double getDriver1RawAxis(int axis, double nullSpeed, double speed) {
    // if-statement is used to counteract false positives from the joystick
    if (driverController1.getRawAxis(axis) > 0.1)
      return speed;
    else if (driverController1.getRawAxis(axis) < -0.1)
      return -speed;
    return nullSpeed;
  }

  /*
   * This method treats a trigger in XboxController 1 as a button (returns one of
   * two doubles depending on the position of the trigger)
   */
  public double getDriver1Trigger(Hand trigger, double nullSpeed, double speed) {
    // if-statement is used to counteract false positives from the trigger
    if (driverController1.getTriggerAxis(trigger) > 0.1)
      return speed;
    return nullSpeed;
  }

  /*
   * This method is used to get the value of a trigger in XboxController 1
   * (returns a double ranging from 0.1 to 1)
   */
  public double getDriver1Trigger(Hand trigger) {
    // if-statement is used to counteract false positives from the trigger
    if (driverController1.getTriggerAxis(trigger) > 0.1)
      return driverController1.getTriggerAxis(trigger);
    return 0;
  }

  /*
   * This method is used to get the value of a button in XboxController 1 (returns
   * a boolean)
   */
  public boolean getDriver1ButtonPressed(int button) {
    return driverController1.getRawButtonPressed(button);
  }

  /*
   * The following five methods perform the same tasks as the previous five with
   * the exception that they get the values from XboxController 2
   */
  public double getDriver2RawAxis(int axis) {
    return driverController2.getRawAxis(axis);
  }

  public double getDriver2RawAxis(int axis, double nullSpeed, double speed) {
    if (driverController2.getRawAxis(axis) > 0.1)
      return speed;
    else if (driverController2.getRawAxis(axis) < -0.1)
      return -speed;
    return nullSpeed;
  }

  public double getDriver2Trigger(Hand trigger, double nullSpeed, double speed) {
    if (driverController2.getTriggerAxis(trigger) > -0.9)
      return speed;
    return nullSpeed;
  }

  public double getDriver2Trigger(Hand trigger) {
    if (driverController2.getTriggerAxis(trigger) > -0.9)
      return driverController2.getTriggerAxis(trigger);
    return 0;
  }

  public boolean getDriver2ButtonPressed(int button) {
    return driverController2.getRawButtonPressed(button);
  }

  public Command tCmd(double time, Command command) {
    double startTime = Timer.getFPGATimestamp();

    if (Timer.getFPGATimestamp() - startTime < time) {
      return command;
    }
    // return getClass(command).isFinished();
    return null;
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
