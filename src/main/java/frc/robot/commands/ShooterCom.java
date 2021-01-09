/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterCom extends CommandBase {
  public ShooterCom() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.shooter);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    Robot.shooter.setShooterMotor(Constants.STOP);
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    double trigger = Robot.m_robotContainer.getDriver2Axis(Constants.RIGHT_TRIGGER, "trigger", Constants.STOP, 1);

    double speed, verticalSpeed, horizontalSpeed;
    if (trigger == 1) {
      speed = Constants.SHOOTER_SPEED;
      verticalSpeed = Constants.INTAKE_SPEED * Robot.m_robotContainer.pulse(Constants.INTAKE_PULSE);
      horizontalSpeed = verticalSpeed;
    } else {
      speed = 0;
      verticalSpeed = 0;
      horizontalSpeed = 0;
    }

    Robot.shooter.setShooterMotor(speed);
    Robot.intake.setVerticalIntake(verticalSpeed);
    Robot.intake.setHorizontalIntake(horizontalSpeed);
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    // stops motor
    Robot.shooter.setShooterMotor(Constants.STOP);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
