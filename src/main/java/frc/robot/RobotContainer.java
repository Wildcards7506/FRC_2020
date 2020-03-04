/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.lang.reflect.Method;
// import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Move;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /* This initializes XboxControllers */
  private XboxController driverController1 = new XboxController(Constants.DRIVER_CONTROLLER_1);
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
  public double driver2TwoButtonConfig(int button1, int button2, double nullSpeed, double speed1, double speed2) {
    // if button1 is pressed
    if (driverController2.getRawButton(button1))
      return speed1;
    // if button2 is pressed
    if (driverController2.getRawButton(button2))
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

  /*
   * This method is used to run a command when an assigned button in
   * XboxController2 is pressed
   */
  public Method commandButton(int button, Method command) {
    // if button is pressed
    if (driverController2.getRawButton(button))
      return command;
    // if no button is pressed
    return null;
  }

  /*
   * public Command STMButton(int button, Command cmd) { if
   * (driverController2.getRawButton(button)) return new Command(){ return null; }
   * // The container for the robot. Contains subsystems, OI devices, and
   * commands.
   * 
   * public RobotContainer() { // Configure the button bindings
   * configureButtonBindings(); }
   * 
   * // * Use this method to define your button->command mappings. Buttons can be
   * // * created by instantiating a {@link GenericHID} or one of its subclasses
   * // * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and
   * then // * passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * 
   * private void configureButtonBindings() { }
   */

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new Move(2, .5, .5);
  }
}
