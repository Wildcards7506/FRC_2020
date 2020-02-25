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
    double rightStickX = Robot.m_robotContainer.getDriver1RawAxis(Constants.RIGHT_STICK_X);
    double rightStickY = Robot.m_robotContainer.getDriver1RawAxis(Constants.RIGHT_STICK_Y);

    Robot.driveTrain.setRightMotors(.5 * ( rightStickY/2 + rightStickX/2) * Constants.DRIVE_MAX_SPEED );
    Robot.driveTrain.setLeftMotors(( rightStickY/2 - rightStickX/2) * Constants.DRIVE_MAX_SPEED );

    //Not really drivetrain but still usefull
    System.out.println(Robot.m_robotContainer.controlValues(
     Constants.RIGHT_STICK_Y,
     Constants.RIGHT_STICK_X,
     Constants.BUTTON_A,
     Constants.BUTTON_B,
     Constants.BUTTON_X,
     Constants.BUTTON_Y,
     Constants.LEFT_BUTTON,
     Constants.RIGHT_BUTTON,
     Constants.RIGHT_STICK_Y)
     );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.setLeftMotors(Constants.STOP);
    Robot.driveTrain.setRightMotors(Constants.STOP);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
