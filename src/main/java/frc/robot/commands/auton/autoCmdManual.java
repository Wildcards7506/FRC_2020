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

  public static void trackFwd(double runTime) {
      timer.reset();
      timer.start();
      //Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED);
      //Timer.delay(0.1);
      speedUp(-Constants.DRIVE_MAX_SPEED * .33,-Constants.DRIVE_MAX_SPEED * .5);
      // Go forward to pick up target initially
      Timer.delay(runTime);
      
    

  }
  
  public static void trackRight(double runTime) {
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED * .27);
    Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED * .55);
    Timer.delay(runTime);
    //while(Robot.Limelight.getTV() == 0 && Robot.Limelight.getTA() >1)
      //Timer.delay(.1);
    // Go forward to pick up target initially
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED * 0);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED * 0);
    Timer.delay(0.3);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED * .5);
    Timer.delay(0.2);
    Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED * 0);
    Robot.driveTrain.setRightMotors(-Constants.DRIVE_MAX_SPEED * 0);
  
}

public static void trackLeft(double runTime) {
  timer.reset();
  timer.start();
  speedUp(-Constants.DRIVE_MAX_SPEED * .5,-Constants.DRIVE_MAX_SPEED * .23);
  // Go forward to pick up target initially
  Timer.delay(runTime);
  Robot.driveTrain.setLeftMotors(-Constants.DRIVE_MAX_SPEED*0.1);
  Timer.delay(0.2);

}

  public static void slowDown()
  {
    while(motorSpeedLeft < 0 && motorSpeedRight < 0)
    {
        if (motorSpeedLeft < 0)
        {motorSpeedLeft = motorSpeedLeft + 0.01;}
        else {motorSpeedLeft = 0;}
        Robot.driveTrain.setLeftMotors(motorSpeedLeft);
        if (motorSpeedRight < 0)
        {motorSpeedRight = motorSpeedRight + 0.01;}
        else {motorSpeedRight = 0;}
        Robot.driveTrain.setRightMotors(motorSpeedRight);
    }
  }

  public static void speedUp(double left, double right)
  {
    motorSpeedRight = 0;
    motorSpeedLeft = 0;
    while(motorSpeedLeft > left && motorSpeedRight > right)
    {
        if (motorSpeedLeft < 0)
        {motorSpeedLeft = motorSpeedLeft - left * 0.00001;}
        else {motorSpeedLeft = left;}
        Robot.driveTrain.setLeftMotors(motorSpeedLeft);
        if (motorSpeedRight < 0)
        {motorSpeedRight = motorSpeedRight - right * .00001;}
        else {motorSpeedRight = right;}
        Robot.driveTrain.setRightMotors(motorSpeedRight);
    }
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
