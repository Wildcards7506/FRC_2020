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

import java.text.DecimalFormat;

import edu.wpi.first.wpilibj.Spark;

public class autoCmd extends CommandBase {
  private static Timer timer = new Timer();
  final double kP = 0.5;
  final double kI = 0.5;
  final double kD = 0.5;
  //private static Robot.Limelight Robot.Limelight = new Robot.Limelight();

  /** Creates a new autoCmd. */
  public autoCmd() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(new DriveTrain());
  }

  public static void trackFwd(double runTime)
  {
    timer.reset();
    timer.start();
    //Robot.Limelight.resetEncoder();
    Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.34);
    Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.7);
    System.out.println("Pause");
    //Timer.delay(2);
    //System.out.println("Start");
    //DecimalFormat df = new DecimalFormat("###.##");
    //double Distance = Double.parseDouble(df.format(Robot.Limelight.getTA()));
    //System.out.println(Distance);
    //Go forward to pick up target initially

    //System.out.println(Distance + " " + Target);
    //While the robot is not in its target position, drive to the target
    System.out.println(timer.getFPGATimestamp());
    while(timer.getFPGATimestamp() < runTime)
    { 
      Robot.Limelight.updateData();
      //Distance = Double.parseDouble(df.format(Robot.Limelight.getTA()));
      if(Math.abs(Robot.Limelight.getTX()) >  1){
        if(Robot.Limelight.getTX() > 0){
          Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*((1-Robot.Limelight.getTX()/27)));
        }else if(Robot.Limelight.getTX() < 0){
          Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*((1+Robot.Limelight.getTX()/27)));
        }
      }else if(Robot.Limelight.getTV() == 0){
        //Stop Motors if target lost
        Robot.driveTrain.setLeftMotors(0);
        Robot.driveTrain.setRightMotors(0);
        timer.stop();
      }else{
        //Target is centered. Go forward.
        Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.5);
        Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
      }
    }
    System.out.println("Time's Up!");
  }

  public static void LCircle() {
    
  }

  public static void RCircle() {
    timer.reset();
    timer.start();
    //Start Turret
    //Robot.Limelight.resetEncoder();
    Robot.Limelight.turretTurn(0);//0.17);
    //Start Motors
    //while(Robot.Limelight.getEncoderDistance() > -90)
    { 
      //System.out.println(Robot.Limelight.getEncoderDistance());
      Robot.Limelight.updateData();
      if(Math.abs(Robot.Limelight.getTX()) >  1)
      {
        if(Robot.Limelight.getTX() > 1)
        {
          //System.out.println("Setting Left to:" + ((1-Robot.Limelight.getTX()/27)*.34));
          Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*((1-Robot.Limelight.getTX()/27)*.34));

        }else if(Robot.Limelight.getTX() < -1)
        {
          //System.out.println("Setting Right to:" + ((1+Robot.Limelight.getTX()/27)*.5));
          Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*((1+Robot.Limelight.getTX()/27)*.5));
        }
      }else
      {
        Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.5);
        Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
      }
    }
    //timer.stop();
  }


  public static void trackRev(double Distance) { // THIS IS INCOMPLETE
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.34);
    Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
    //Go forward to pick up target initially
    Timer.delay(3);

    //While the robot is not in its target position, drive to the target
    while(Distance>Robot.Limelight.getDist())
    { 
      Robot.Limelight.updateData();
      //If the robot is off course, Use PID Control to correct
      if(Math.abs(Robot.Limelight.getTX()) >  1)
      {
        if(Robot.Limelight.getTX() > 0)
        {
          Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*((1-Robot.Limelight.getTX()/27)*.34));

        }else if(Robot.Limelight.getTX() < 0)
        {
          Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*((1+Robot.Limelight.getTX()/27)*.5));
        }
      }else if(Robot.Limelight.getTV() == 0){
        //Stop Motors if target lost
        Robot.driveTrain.setLeftMotors(0);
        Robot.driveTrain.setRightMotors(0);
        timer.stop();
        while(Robot.Limelight.getTV() == 0)
        {
          //spark.set(1);
        }
        Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*.2);
        Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*.2);
        timer.start();
      }else{
        //Target is centered. Go forward.
        Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.5);
        Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
      }
    }
  }

  public static void teardrop() { // THIS IS INCOMPLETE. Method should be to turn the turret at a variable speed to achieve a teardrop shape
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED * -1);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED);
    Timer.delay(.25);

      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
      Timer.delay(1);
      timer.stop();
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
