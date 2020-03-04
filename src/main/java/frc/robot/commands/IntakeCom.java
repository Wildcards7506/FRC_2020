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

public class IntakeCom extends CommandBase {
  public IntakeCom() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.intake);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    // initializes and declares motor speed basedXboxController2's LB and RB button
    // values
    double motorSpeed = Robot.m_robotContainer.driver2TwoButtonConfig(Constants.LEFT_BUTTON, Constants.RIGHT_BUTTON,
        Constants.STOP, -Constants.INTAKE_SPEED, Constants.INTAKE_SPEED);
        
    // set the speed of the motor
    Robot.intake.setIntakeMotors(motorSpeed);
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    // stops the motor
    Robot.intake.setIntakeMotors(Constants.STOP);
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
