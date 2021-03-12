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
import edu.wpi.first.wpilibj.Spark;

public class autoCmdManual extends CommandBase {
  private static Timer timer = new Timer();
  final double kP = 0.5;
  final double kI = 0.5;
  final double kD = 0.5;
  public static double motorSpeedLeft;
  public static double motorSpeedRight;
  // private static Robot.Limelight Robot.Limelight = new Robot.Limelight();

  /** Creates a new autoCmdManual. */
  public autoCmdManual() {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(new DriveTrain());
  }

  public static void Forward(double Distance, double bias){
      timer.reset();
      timer.start();
      Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*bias);
      Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*0.7);
      Timer.delay(Distance);  
  }
  
  public static void Right(double Angle){
      timer.reset();
      timer.start();
      Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*0.34); //Go Right Motors
      Robot.driveTrain.brakeLeftMotors(); //Brake Left Motors
      Timer.delay(Angle);  
      Robot.driveTrain.brakeRightMotors();
      Timer.delay(0.1);
      Robot.driveTrain.setRightMotors(0);
      Robot.driveTrain.setLeftMotors(0);
  }
  
  public static void Left(double Angle){
      timer.reset();
      timer.start();
      Robot.driveTrain.brakeRightMotors();//Brake Right Motors
      Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*0.5);//Go Left Motors
      Timer.delay(Angle);  
      Robot.driveTrain.brakeLeftMotors();
      Timer.delay(0.1);
      Robot.driveTrain.setRightMotors(0);
      Robot.driveTrain.setLeftMotors(0);
  }
  
  public static void bRight(double Angle){
      timer.reset();
      timer.start();
      Robot.driveTrain.brakeRightMotors();//Brake Right Motors
      Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*0.5);//Go Left Motors
      Timer.delay(Angle); 
      Robot.driveTrain.brakeRightMotors();
      Timer.delay(0.1);
      Robot.driveTrain.setRightMotors(0);
      Robot.driveTrain.setLeftMotors(0); 
  }
  
  public static void bLeft(double Angle){
      timer.reset();
      timer.start();
      Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*0.34);//Go Right Motors
      Robot.driveTrain.brakeLeftMotors();//Brake Left Motors
      Timer.delay(Angle);  
      Robot.driveTrain.brakeLeftMotors();
      Timer.delay(0.1);
      Robot.driveTrain.setRightMotors(0);
      Robot.driveTrain.setLeftMotors(0);
  }
  
  public static void Backward(double Distance){
      timer.reset();
      timer.start();
      Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*0.5);
      Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*0.34);
      Timer.delay(Distance);
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
