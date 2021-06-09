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
import frc.robot.commands.auton.autoCmd;
import edu.wpi.first.wpilibj.Timer;

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
    boolean x = Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_X);
    boolean y = Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_Y);
    boolean a = Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_A);
    boolean b = Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_B);
    double speed = 0;

    if (a) {
      speed = -1;
    } else if(b) {
      speed = -0.8;
    } else if(x) {
      speed = -0.6;
    } else if(y){
      speed = -0.5;
    }

    Robot.shooter.setShooterMotor(speed);
  }

  public static void limeLightAdjust(){
    
    boolean bstop = Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_B);
    double angleFrom = Robot.Limelight.getTX();
    double lastAngle = 0;
    double errorSum = 0;
    double lastTimestamp = 0;
    double dt;
    double kP = 0.03;
    double kI = 0.07;
    double output;
    double errorRate;

    //Start shooter spool up
    Robot.shooter.setShooterMotor(-1);

    //While the bot is aiming >2 degrees away from target, correct
    while (Math.abs(angleFrom) > 2){
      bstop = Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_B);
      Robot.Limelight.updateData();

      lastAngle = angleFrom;
      angleFrom = Robot.Limelight.getTX();
      lastTimestamp = Timer.getFPGATimestamp();
      dt = Timer.getFPGATimestamp() - lastTimestamp;

      if (Math.abs(angleFrom) < 5) {
        errorSum += angleFrom * dt;
      }

      output = kP*angleFrom + kI*errorSum;
      
      Robot.driveTrain.setLeftMotors(output);
      Robot.driveTrain.setRightMotors(-output);

      if (bstop){break;}
    }
      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);

      //if the autotarget has not been stopped, fire.
      if (!bstop){autoCmd.Shoot(3);}
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
