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
  /**
   * Creates a new TankDrive.
   */
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize(){
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickY = Robot.m_robotContainer.GetDriverRawAxis(Constants.LEFT_STICK_Y);
    double rightStickY = Robot.m_robotContainer.GetDriverRawAxis(Constants.RIGHT_STICK_Y);

    Robot.driveTrain.setLeftMotors(leftStickY * Constants.DRIVE_MAX_SPEED);
    Robot.driveTrain.setRightMotors(rightStickY * Constants.DRIVE_MAX_SPEED);

  }

  // Called once the command ends or is interrupted.
  //david was here  <--- lol  -Alberto
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.setLeftMotors(0);
    Robot.driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
