/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

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
    double trigger = Robot.m_robotContainer.getDriver2Axis(Constants.RIGHT_TRIGGER, "trigger", 0, 1);
    boolean trigger1 = Robot.m_robotContainer.getDriver2Button(Constants.RIGHT_BUTTON);
    int POV = Robot.m_robotContainer.getDriver2POV();
    double speed;
    double angleFrom;
    double shooterSpeed = 1;


    if (trigger == 1) {
      speed = shooterSpeed;
    } else {
      speed = 0;
    }

    if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_A)){
      shooterSpeed = .2;
      limeLightAdjust();
    }
    if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_B)){
      shooterSpeed = 1;
      limeLightAdjust();
    }
    if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_Y)){
      shooterSpeed = 1;
      limeLightAdjust();
    }
    if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_X)){
      shooterSpeed = 1;
      limeLightAdjust();
    }


    
    Robot.shooter.setShooterMotor(speed);

    switch (POV) {
    case 270:
      Robot.shooter.setPneumatics(Value.kForward);
      break;
    case 90:
      Robot.shooter.setPneumatics(Value.kReverse);
      break;
    }

    // makes sure compressor maintains pressure
    //if (Robot.shooter.compressor.getPressureSwitchValue()) {
      //Robot.shooter.compressor.start();
    //} else {
      //Robot.shooter.compressor.stop();
    //}
  }

  public void limeLightAdjust(){
    angleFrom = Robot.Limelight.gettX() * (90 / 163); //90 deg turn is 163 deg

    if(angleFrom > 0){
      Robot.autoCmdManual.Left(angleFrom * -1);
    }
    else if (angleFrom < 0){
      Robot.autoCmdManual.right(angleFrom);
    }
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    // stops motor
    Robot.shooter.setShooterMotor(Constants.STOP);
    //Robot.shooter.compressor.stop();
    Robot.shooter.setPneumatics(Value.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
