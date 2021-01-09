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
    Robot.intake.setHorizontalIntake(Constants.STOP);
    Robot.intake.setVerticalIntake(Constants.STOP);
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    boolean LB = Robot.m_robotContainer.getDriver2Button(Constants.LEFT_BUTTON);
    boolean RB = Robot.m_robotContainer.getDriver2Button(Constants.RIGHT_BUTTON);
    double horizontalSpeed, verticalSpeed;
    if (LB) {
      horizontalSpeed = Constants.INTAKE_SPEED;
    } else {
      horizontalSpeed = Robot.m_robotContainer.getDriver2Axis(Constants.LEFT_STICK_Y, "joystick", Constants.STOP,
          Constants.INTAKE_SPEED);
    }
    if (RB) {
      verticalSpeed = Constants.INTAKE_SPEED;
    } else {
      verticalSpeed = Robot.m_robotContainer.getDriver2Axis(Constants.LEFT_STICK_Y, "joystick", Constants.STOP,
          Constants.INTAKE_SPEED);
    }

    Robot.intake.setVerticalIntake(verticalSpeed);
    Robot.intake.setHorizontalIntake(horizontalSpeed);
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    Robot.intake.setHorizontalIntake(Constants.STOP);
    Robot.intake.setVerticalIntake(Constants.STOP);
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
