// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.Timer;

public class autoCmd extends CommandBase {
  private static Timer timer = new Timer();

  /** Creates a new autoCmd. */
  public autoCmd() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(new DriveTrain());
  }

  public void Fwd(double time) {
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED);
    timer.delay(time);

      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
      timer.stop();
  }

  public void Rev() {
  }

  public void RTurn() {
  }

  public void LTurn() {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
