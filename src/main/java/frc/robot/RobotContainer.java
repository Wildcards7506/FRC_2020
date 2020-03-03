/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.lang.reflect.Method;
//import java.util.Set;

//import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.Constants;
//import frc.robot.commands.IntakeCom;
import frc.robot.commands.Move;
//import frc.robot.commands.STMCom;
//import frc.robot.commands.ShooterCom;
//import frc.robot.commands.MoveSequence;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.ConditionalCommand;
//import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...

  private XboxController driverController1 = new XboxController(Constants.DRIVER_CONTROLLER_1);
  private static XboxController driverController2 = new XboxController(Constants.DRIVER_CONTROLLER_2);

  // private AxisCamera camera = new AxisCamera.getInstance();
  // private JoystickButton xButton = JoystickButton(driverController1,
  // Constants.BUTTON_X);
  // private XboxController xButton = new XboxController(Constants.BUTTON_X);

  // This just gives all the controller values
  public String controlValues(int j1, int j2, int b1, int b2, int b3, int b4, int b5, int b6, int j3) {
    return "JY: " + (int) (-getDriver1RawAxis(j1) * 100) + " | JX: " + (int) (getDriver1RawAxis(j2) * 100) + " | A: "
        + driverController2.getRawButton(b1) + " | B: " + driverController2.getRawButton(b2) + " | X: "
        + driverController2.getRawButton(b3) + " | Y: " + driverController2.getRawButton(b4) + " | LB: "
        + driverController2.getRawButton(b5) + " | RB: " + driverController2.getRawButton(b6) + " | Elevator: "
        + (int) (-getDriver2RawAxis(j3) * 100);

  }

  public double getDriver1RawAxis(int axis) {
    return driverController1.getRawAxis(axis);
  }

  public double getDriver2RawAxis(int axis) {
    return driverController2.getRawAxis(axis);
  }

  public double driver2TwoButtonConfig(int button1, int button2, double initialSpeed, double finalSpeed1,
      double finalSpeed2) {
    if (driverController2.getRawButton(button1))
      return finalSpeed1;
    if (driverController2.getRawButton(button2))
      return finalSpeed2;
    return initialSpeed;
  }

  public double driver2OneButtonConfig(int button, double initialSpeed, double finalSpeed) {
    if (!driverController2.getRawButton(button))
      return finalSpeed;
    return initialSpeed;
  }


  public Method commandButton(int button, Method command) {
    if (driverController2.getRawButton(button)) return command;
    return null;
  }

  //public Command STMButton(int button, Command cmd) {
  // if (driverController2.getRawButton(button)) return new Command(){
  //  return null;
  //}
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new Move(5, .2, .2);
  }
}
