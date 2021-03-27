// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.graalvm.compiler.core.common.alloc.Trace;

import edu.wpi.first.wpilibj.Timer;

public class autoCmdManual extends CommandBase {
  private static Timer timer = new Timer();
  public static double motorSpeedLeft;
  public static double motorSpeedRight;
  private static double sensorPosition;
  private static double errorSum = 0;
  private static double lastTimestamp = 0;
  private static double lastError = 0;
  private static double error;
  private static double errorRate;
  private static double outputSpeed;
  private static double dt;
  // private static Robot.Limelight Robot.Limelight = new Robot.Limelight();

  /** Creates a new autoCmdManual. */
  public autoCmdManual() {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(new DriveTrain());
  }

  public static void Forward(double distance, boolean backwards){
    error = distance;
    errorSum = 0;
    lastError = 0;
    sensorPosition = 0;
    lastTimestamp = Timer.getFPGATimestamp();
    System.out.println(distance);
    Robot.driveTrain.encoderL.reset();
    Robot.driveTrain.encoderR.reset();
      while (distance > sensorPosition){
        SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.encoderL.getDistance());
        SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.encoderR.getDistance());
        SmartDashboard.putNumber("Set Point", sensorPosition);
        SmartDashboard.putNumber("Error Rate", errorRate);
        SmartDashboard.putNumber("Output Speed", outputSpeed);
        //System.out.println(sensorPosition);
        // get sensor position
        //System.out.println(Constants.kDriveTick2Feet);
        sensorPosition = Robot.driveTrain.encoderL.getDistance()*Constants.kDriveTick2Feet;
        
        // calculations
        lastError = error;
        error = (distance - sensorPosition)/distance;
        dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        errorRate = (error - lastError) / dt;

        outputSpeed = Constants.kP * error + Constants.kI * errorSum + Constants.kD * errorRate;
        while (Math.abs(errorRate)<0.1){
          outputSpeed = outputSpeed - 0.001;
          Robot.driveTrain.setLeftMotors(outputSpeed);
        Robot.driveTrain.setRightMotors(outputSpeed);
        }
        // output to motors
        if (backwards=true){
          outputSpeed = outputSpeed * -1;
      }
      Robot.driveTrain.setLeftMotors(outputSpeed);
      Robot.driveTrain.setRightMotors(outputSpeed);
    }
  }
  
  public static void Right(double angle,boolean backwards){
    error = angle;
    errorSum = 0;
    lastError = 0;
    sensorPosition = 0;
    lastTimestamp = Timer.getFPGATimestamp();
      Robot.driveTrain.encoderL.reset();
      Robot.driveTrain.encoderR.reset();
      while (angle-0.1 > sensorPosition){
        // get sensor position
        SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.encoderL.getDistance());
        SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.encoderR.getDistance());
        SmartDashboard.putNumber("Set Point", sensorPosition);
        SmartDashboard.putNumber("Constant", Math.PI);
        sensorPosition = Robot.driveTrain.encoderR.get() * Constants.kDriveTick2Angle;

        // calculations
        lastError = error;
        error = (angle - sensorPosition)/angle;
        dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        errorRate = (error - lastError) / dt;

        outputSpeed = Constants.kP * error + Constants.kI * errorSum + Constants.kD * errorRate;
        if (backwards=true){
            outputSpeed = outputSpeed * -1;
        }
        // output to motors
      Robot.driveTrain.brakeLeftMotors(0.1);
      Robot.driveTrain.setRightMotors(outputSpeed);
    }
  }
  
  public static void Left(double angle, boolean backwards){
    error = angle;
    errorSum = 0;
    lastError = 0;
    sensorPosition = 0;
    lastTimestamp = Timer.getFPGATimestamp();
      Robot.driveTrain.encoderL.reset();
      Robot.driveTrain.encoderR.reset();
      while (angle-0.1 > sensorPosition){
        // get sensor position
        SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.encoderL.getDistance());
        SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.encoderR.getDistance());
        SmartDashboard.putNumber("Set Point", sensorPosition);
        SmartDashboard.putNumber("Constant", Math.PI);
        sensorPosition = Robot.driveTrain.encoderL.get() * Constants.kDriveTick2Angle;

        // calculations
        lastError = error;
        error = (angle - sensorPosition)/angle;
        dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        errorRate = (error - lastError) / dt;
        
        outputSpeed = Constants.kP * error + Constants.kI * errorSum + Constants.kD * errorRate;
        
        if (backwards=true){
            outputSpeed = outputSpeed * -1;
        }
        // output to motors
      Robot.driveTrain.setLeftMotors(outputSpeed);
      Robot.driveTrain.brakeRightMotors(0.1);
    }
  }

  public static void motorTest() {
    DriveTrain.motorLeft1.set(ControlMode.PercentOutput, 0.5);
    Timer.delay(2);
    DriveTrain.motorLeft1.set(ControlMode.PercentOutput, 0);
    DriveTrain.motorLeft2.set(ControlMode.PercentOutput, 0.5);
    Timer.delay(2);
    DriveTrain.motorLeft2.set(ControlMode.PercentOutput, 0);
    DriveTrain.motorLeft3.set(ControlMode.PercentOutput, 0.5);
    Timer.delay(2);
    DriveTrain.motorLeft3.set(ControlMode.PercentOutput, 0);
    DriveTrain.motorRight14.set(ControlMode.PercentOutput, 0.5);
    Timer.delay(2);
    DriveTrain.motorRight14.set(ControlMode.PercentOutput, 0);
    DriveTrain.motorRight15.set(ControlMode.PercentOutput, 0.5);
    Timer.delay(2);
    DriveTrain.motorRight15.set(ControlMode.PercentOutput, 0);
    DriveTrain.motorRight16.set(ControlMode.PercentOutput, 0.5);
    Timer.delay(2);
    DriveTrain.motorRight16.set(ControlMode.PercentOutput, 0);
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
