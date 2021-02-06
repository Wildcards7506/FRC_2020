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
import frc.robot.subsystems.LimeLight;
import edu.wpi.first.wpilibj.Spark;

public class autoCmd extends CommandBase {
  private static Timer timer = new Timer();
  //private static Robot.Limelight Robot.Limelight = new Robot.Limelight();

  /** Creates a new autoCmd. */
  public autoCmd() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(new DriveTrain());
  }

  public static void Fwd(double time) {
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*0.5);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*0.55);
    Timer.delay(time);
    System.out.println("Fwd Complete");
    
    //Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*-.7);
    //Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*-1);
    Timer.delay(.3);
    System.out.println("Stop Complete");

      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
      timer.stop();
  }
  public static void trackFwd(double time)
  {
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.34);
    Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
    Timer.delay(3);
    while(true)
    { 
      Robot.Limelight.updateData();
      if(Math.abs(Robot.Limelight.getTX()) >  1)
      {
        if(Robot.Limelight.getTX() > 1)
        {
          System.out.println("Setting Left to:" + ((1-Robot.Limelight.getTX()/27)*.34));
          Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*((1-Robot.Limelight.getTX()/27)*.34));

        }else if(Robot.Limelight.getTX() < -1)
        {
          System.out.println("Setting Right to:" + ((1+Robot.Limelight.getTX()/27)*.5));
          Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*((1+Robot.Limelight.getTX()/27)*.5));
        }
      }else if(Robot.Limelight.getTV() == 0){
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
      }else
      {
        Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.5);
        Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
      }
    }
    //Robot.driveTrain.setLeftMotors(0);
    //Robot.driveTrain.setRightMotors(0);
    //timer.stop();
  }

  public static void LCircle(double time) {
    timer.reset();
    timer.start();
    //Start Turret
    Robot.Limelight.TurretTurn(1);
    //Start Motors
    Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.34);
    Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
    Timer.delay(3);
    while(true)
    { 
      Robot.Limelight.updateData();
      if(Math.abs(Robot.Limelight.getTX()) >  1)
      {
        if(Robot.Limelight.getTX() > 1)
        {
          System.out.println("Setting Left to:" + ((1-Robot.Limelight.getTX()/27)*.34));
          Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*((1-Robot.Limelight.getTX()/27)*.34));

        }else if(Robot.Limelight.getTX() < -1)
        {
          System.out.println("Setting Right to:" + ((1+Robot.Limelight.getTX()/27)*.5));
          Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*((1+Robot.Limelight.getTX()/27)*.5));
        }
      }else
      {
        Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.5);
        Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
      }
    }
    //Robot.driveTrain.setLeftMotors(0);
    //Robot.driveTrain.setRightMotors(0);
    //timer.stop();
  }

  public static void RCircle(double time) {
    timer.reset();
    timer.start();
    //Start Turret
    Robot.Limelight.TurretTurn(-1);
    //Start Motors
    Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.34);
    Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
    Timer.delay(3);
    while(true)
    { 
      Robot.Limelight.updateData();
      if(Math.abs(Robot.Limelight.getTX()) >  1)
      {
        if(Robot.Limelight.getTX() > 1)
        {
          System.out.println("Setting Left to:" + ((1-Robot.Limelight.getTX()/27)*.34));
          Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*((1-Robot.Limelight.getTX()/27)*.34));

        }else if(Robot.Limelight.getTX() < -1)
        {
          System.out.println("Setting Right to:" + ((1+Robot.Limelight.getTX()/27)*.5));
          Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*((1+Robot.Limelight.getTX()/27)*.5));
        }
      }else
      {
        Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*.5);
        Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED*.5);
      }
    }
    //Robot.driveTrain.setLeftMotors(0);
    //Robot.driveTrain.setRightMotors(0);
    //timer.stop();
  }


  public void Rev(double time) {
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*-1);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*-1);
    Timer.delay(time);

      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
      timer.stop();
  }

  public static void RTurn() {
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

  public static void LTurn() {
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED * -1);
    Timer.delay(.47);

      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
      Timer.delay(1);
      timer.stop();}

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
