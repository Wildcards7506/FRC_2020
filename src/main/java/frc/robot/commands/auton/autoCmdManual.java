// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

//import org.graalvm.compiler.core.common.alloc.Trace;

import edu.wpi.first.wpilibj.Timer;

public class autoCmdManual extends CommandBase {
  private static Timer timer = new Timer();
  public static double motorSpeedLeft;
  public static double motorSpeedRight;
  private static double sensorPosition;
  private static double setpoint = 0;
  private static double errorSum = 0;
  private static double lastTimestamp = 0;
  private static double lastError = 0;
  // private static Robot.Limelight Robot.Limelight = new Robot.Limelight();

  /** Creates a new autoCmdManual. */
  public autoCmdManual() {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(new DriveTrain());
  }

  public static void Forward(double distance, boolean backwards){
    Robot.driveTrain.encoderL.reset();
    if (backwards=true){
        distance = distance *-1;
    }
    errorSum = 0;
    lastError = 0;
    lastTimestamp = Timer.getFPGATimestamp();
      Robot.driveTrain.encoderL.reset();
      Robot.driveTrain.encoderR.reset();
      while (distance < sensorPosition){
        // get sensor position
        double sensorPosition = Robot.driveTrain.encoderL.get() * Constants.kDriveTick2Feet;

        // calculations
        double error = setpoint - sensorPosition;
        double dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        double errorRate = (error - lastError) / dt;

        double outputSpeed = Constants.kP * error + Constants.kI * errorSum + Constants.kD * errorRate;
        if (backwards=true){
            outputSpeed = outputSpeed * -1;
        }
        // output to motors
      Robot.driveTrain.setLeftMotors(-outputSpeed);
      Robot.driveTrain.setRightMotors(-outputSpeed);
    }
  }
  
  public static void Right(double angle,boolean backwards){
    Robot.driveTrain.encoderL.reset();
    if (backwards=true){
        angle = angle *-1;
    }
    errorSum = 0;
    lastError = 0;
    lastTimestamp = Timer.getFPGATimestamp();
      Robot.driveTrain.encoderL.reset();
      Robot.driveTrain.encoderR.reset();
      while (angle < sensorPosition){
        // get sensor position
        double sensorPosition = Robot.driveTrain.encoderL.get() * Constants.kDriveTick2Feet;

        // calculations
        double error = setpoint - sensorPosition;
        double dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        double errorRate = (error - lastError) / dt;

        double outputSpeed = Constants.kP * error + Constants.kI * errorSum + Constants.kD * errorRate;
        if (backwards=true){
            outputSpeed = outputSpeed * -1;
        }
        // output to motors
      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(-outputSpeed);
    }
  }
  
  public static void Left(double angle, boolean backwards){
    Robot.driveTrain.encoderL.reset();
    if (backwards=true){
        angle = angle *-1;
    }
    errorSum = 0;
    lastError = 0;
    lastTimestamp = Timer.getFPGATimestamp();
      Robot.driveTrain.encoderL.reset();
      Robot.driveTrain.encoderR.reset();
      while (angle < sensorPosition){
        // get sensor position
        double sensorPosition = Robot.driveTrain.encoderL.get() * Constants.kDriveTick2Feet;

        // calculations
        double error = setpoint - sensorPosition;
        double dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        double errorRate = (error - lastError) / dt;

        double outputSpeed = Constants.kP * error + Constants.kI * errorSum + Constants.kD * errorRate;
        if (backwards=true){
            outputSpeed = outputSpeed * -1;
        }
        // output to motors
      Robot.driveTrain.setLeftMotors(-outputSpeed);
      Robot.driveTrain.setRightMotors(0);
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

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
