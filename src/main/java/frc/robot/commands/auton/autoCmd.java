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

public class autoCmd extends CommandBase {
  private static Timer timer = new Timer();
  private static LimeLight limelight = new LimeLight();

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

  public static void trackFwd()
  {
    timer.reset();
    timer.start();
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*.1);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*.1);
    while(true)
    {
      if(Math.abs(limelight.getTX()) >= 5)
      {
        if(limelight.getTX() > 5)
        {
          Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*.05);
        } else if(limelight.getTX() < -5)
        {
          Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED * .05);
        }
      }
      //Timer.delay(.01);
    }
    //timer.stop();
  }

  public static void LFwd(double time) {
    timer.reset();
    timer.start();
    
    
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*0.54);
    Timer.delay(0.2);
    
    Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*0.5);
    Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*0.5);
    Timer.delay(time);
    System.out.println("Fwd Complete");
    
    //Robot.driveTrain.setLeftMotors(Constants.DRIVE_MAX_SPEED*-.7);
    //Robot.driveTrain.setRightMotors(Constants.DRIVE_MAX_SPEED*-1);
    Timer.delay(.3);
    System.out.println("Stop Complete");

      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);
      Timer.delay(1);
      timer.stop();
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
