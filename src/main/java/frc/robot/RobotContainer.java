/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
import frc.robot.commands.Move;
import frc.robot.commands.MoveSequence;
import frc.robot.commands.IntakeCom;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...

  private XboxController driverController1 = new XboxController(Constants.DRIVER_CONTROLLER_1);
   JoystickButton xButton = new JoystickButton(driverController1, Constants.BUTTON_X);
   JoystickButton aButton = new JoystickButton(driverController1, Constants.BUTTON_Y);
  //private XboxController xButton = new XboxController(Constants.BUTTON_X);

  public double GetDriverRawAxis(int axis) {
    return driverController1.getRawAxis(axis);
  }

  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
<<<<<<< HEAD
    //xButton.whenPressed(new MoveSequence());
=======
    xButton.whileHeld(new IntakeCom());


>>>>>>> 923f6ac5c0d5d4cb8c47e9cc32184c06d08429ff
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
