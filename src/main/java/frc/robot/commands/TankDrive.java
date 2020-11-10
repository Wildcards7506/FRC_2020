/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */  
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class TankDrive extends CommandBase {
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    // initializes and declares joystick values from XboxController1
    double rightStickX = Robot.m_robotContainer.getDriver1RawAxis(Constants.RIGHT_STICK_X);
    double leftStickY = Robot.m_robotContainer.getDriver1RawAxis(Constants.LEFT_STICK_Y);
    // changes direction of drive when LB in XboxController is pressed
    double driveThrottle = Robot.m_robotContainer.driver1OneButtonConfig(Constants.LEFT_BUTTON, 1, 0.25);
    

    // set the speed of the motors
    double slowDown = Robot.m_robotContainer.driver1OneButtonConfig(Constants.RIGHT_BUTTON, 1, 0.9);
    // forward and reverse
    double rightSpeed = (Constants.RD * (leftStickY - rightStickX)) * Constants.DRIVE_MAX_SPEED * driveThrottle * retardmode;
    double leftSpeed = (Constants.LD * (leftStickY + rightStickX)) * Constants.DRIVE_MAX_SPEED * driveThrottle * slowDown;
    // turning right joystick

    Robot.driveTrain.setRightMotors(rightSpeed);
    Robot.driveTrain.setLeftMotors(leftSpeed);

    // Prints XboxController values on dashboard
    System.out.println(Robot.m_robotContainer.controlValues(Constants.RIGHT_STICK_Y, Constants.RIGHT_STICK_X,
        Constants.BUTTON_A, Constants.BUTTON_B, Constants.BUTTON_X, Constants.BUTTON_Y, Constants.LEFT_BUTTON,
        Constants.RIGHT_BUTTON, Constants.RIGHT_STICK_Y));
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    // stops motors
    Robot.driveTrain.setLeftMotors(Constants.STOP);
    Robot.driveTrain.setRightMotors(Constants.STOP);
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
