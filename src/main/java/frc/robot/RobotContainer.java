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
   * This method is used to get the x or y axis of a joystick in XboxController 2
   * (returns a double ranging from -1 to 1)
   */
  public double getDriver2RawAxis(int axis) {
    return driverController2.getRawAxis(axis);
  }

  /*
   * This method is used to set the speed on a motor or set of motors depending on
   * what assigned button in XboxController2 is being pressed (doubles nullSpeed,
   * speed1, and speed2 can be assigned a value between -1 and 1)
   */
  public double driver2ButtontrigggerConfig(int button, Hand trigger, double nullSpeed, double speed1, double speed2) {
    // if button1 is pressed
    if (driverController2.getRawButton(button))
      return speed1;

    // if button2 is pressed
    if (driverController2.getTriggerAxis(trigger) > 0.5)
      return speed2;
    // if no button is pressed
    return nullSpeed;
  }

  /*
   * Same thing as driver2TowButtonConfig but just with one button in
   * XboxController2 (doubles nullSpeed and speed can be assigned a value between
   * -1 and 1)
   */
  public double driver2OneButtonConfig(int button, double nullSpeed, double speed) {
    // if button is pressed
    if (driverController2.getRawButton(button))
      return speed;
    // if button is not pressed
    return nullSpeed;
  }

  /* Same thing as driver2OneButtonConfig but for XboxController1 */
  public double driver1OneButtonConfig(int button, double nullSpeed, double speed) {
    // if button is pressed
    if (driverController1.getRawButton(button))
      return speed;
    // if button is not pressed
    return nullSpeed;
  }

  public Command tCmd(double time, Command command) {
    double startTime = Timer.getFPGATimestamp();

    if (Timer.getFPGATimestamp() - startTime < time) {
      return command;
    }
    // return getClass(command).isFinished();
    return null;
  }

  public double driver2OneImmediateButtonConfig(double nullSpeed, double speed) {
    if (driverController2.getBButtonPressed()) {
      Robot.stm.setSTM_Motor(speed);
      long i = 0;
      long j = 0;
      while (j < 40) {
        while (i < 3500000)
          i++;
        while (i != 0)
          i--;
        j++;
      }
      Robot.stm.setSTM_Motor(nullSpeed);
    }
    return nullSpeed;
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
