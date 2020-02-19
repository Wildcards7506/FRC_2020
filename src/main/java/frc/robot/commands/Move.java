/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class Move extends CommandBase {
  /**
   * Creates a new Move.
   */

  double m_time, m_lSpeed, m_rSpeed;

  public Move(double time, double lSpeed, double rSpeed) {
    m_time = time;
    m_lSpeed = lSpeed;
    m_rSpeed = rSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //withTimeout(m_time);
    Robot.driveTrain.setLeftMotors(m_lSpeed);
    Robot.driveTrain.setRightMotors(m_rSpeed);
    //setTimeout(m_time);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //withTimeout(m_time);
    Robot.driveTrain.setLeftMotors(m_lSpeed);
    Robot.driveTrain.setRightMotors(m_rSpeed);
    //withTimeout(m_time);
  }

  // Called once the command ends or is interrupted.
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
