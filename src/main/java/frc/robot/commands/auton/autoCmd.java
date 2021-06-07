// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
public class autoCmd extends CommandBase {
  public static double encSpeedLeft;
  public static double encSpeedRight;
  private static double sensorPosition;
  private static double errorSum = 0;
  private static double lastTimestamp = 0;
  private static double lastError = 0;
  private static double error;
  private static double errorRate;
  private static double outputSpeed;
  private static double dt;
  private static double encoderDiff;

  /** Creates a new autoCmd. */
  public autoCmd() {
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
      while (distance > Math.abs(sensorPosition)){
        sensorPosition = Robot.driveTrain.encoderL.getDistance()*Constants.kDriveTick2Feet;
        encSpeedLeft = Robot.driveTrain.encoderL.getDistance();
        encSpeedRight = Robot.driveTrain.encoderR.getDistance();
        encoderDiff = (encSpeedLeft-encSpeedRight)/encSpeedLeft;
        // calculations
        lastError = error;
        error = (distance - sensorPosition)/distance;
        dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        errorRate = (error - lastError) / dt;
        
        outputSpeed = Constants.kP * error + Constants.kI * errorSum + Constants.kD * errorRate;
        // output to motors
        if (backwards==true){
          outputSpeed = outputSpeed * -.4;
      }
      Robot.driveTrain.setLeftMotors(-outputSpeed);
      Robot.driveTrain.setRightMotors(-outputSpeed);
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
        sensorPosition = Robot.driveTrain.encoderR.get() * Constants.kDriveTick2Angle;

        // calculations
        lastError = error;
        error = (angle - sensorPosition)/angle;
        dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }

        errorRate = (error - lastError) / dt;

        outputSpeed = Constants.kP * error + Constants.kITurn * errorSum + Constants.kD * errorRate;
        if (backwards=true){
            outputSpeed = outputSpeed * -1;
        }
        // output to motors
      Robot.driveTrain.brakeLeftMotors(0.1);
      Robot.driveTrain.setRightMotors(outputSpeed*1.5);
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
        sensorPosition = Robot.driveTrain.encoderL.get() * Constants.kDriveTick2Angle;
        
        // calculations
        lastError = error;
        error = (angle - sensorPosition)/angle;
        dt = Timer.getFPGATimestamp() - lastTimestamp;

        if (Math.abs(error) < Constants.iLimit) {
            errorSum += error * dt;
        }


        errorRate = (error - lastError) / dt;
        
        outputSpeed = Constants.kP * error + Constants.kITurn * errorSum + Constants.kD * errorRate;
        
        if (backwards=true){
            outputSpeed = outputSpeed * -1;
        }
        // output to motors
      Robot.driveTrain.setLeftMotors(outputSpeed*1.5);
      Robot.driveTrain.brakeRightMotors(0.1);
    }
  }

  public static void Shoot(int shots){
    boolean b = Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_B);
    while (shots > 0){
      if (b) {break;}
      Robot.intake.setVerticalIntake(-1); //turn on intake
      Timer.delay(.78); //intake time
      shots--;
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
