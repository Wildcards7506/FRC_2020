/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Drive extends CommandBase {
  double m_lSpeed, m_rSpeed;

  public Drive(double lSpeed, double rSpeed) {

    m_lSpeed = lSpeed;
    m_rSpeed = rSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    Robot.driveTrain.setLeftMotors(m_lSpeed);
    Robot.driveTrain.setRightMotors(m_rSpeed);
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    Robot.driveTrain.setLeftMotors(m_lSpeed);
    Robot.driveTrain.setRightMotors(m_rSpeed);
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.setLeftMotors(Constants.STOP);
    Robot.driveTrain.setRightMotors(Constants.STOP);
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
