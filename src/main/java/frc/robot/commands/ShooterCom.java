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
import frc.robot.commands.auton.autoCmdManual;

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
    boolean x =Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_X);
    boolean y =Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_Y);
    boolean a =Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_A);
    boolean b =Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_B);
    int POV = Robot.m_robotContainer.getDriver2POV();
    double speed = 0;
    double shooterSpeed = 2;
    double Kp = 0.01;
    double tx = Robot.Limelight.getTX();
    double headingError;
    double steerAdjust;
    double min = 0.1;
    double lOut = 0;
    double rOut = 0;


    if (trigger == 1) {
      speed = shooterSpeed;
    }

    if (x){
      headingError = -tx;
      steerAdjust = 0.0;
      if(tx>0.2)
      {
        steerAdjust = Kp*headingError - min;
      }
      else if(tx<0.2)
      {
        steerAdjust = Kp*headingError + min;
      }

      lOut += steerAdjust;
      rOut -= steerAdjust;

      Robot.driveTrain.setRightMotors(rOut);
      Robot.driveTrain.setLeftMotors(lOut);

      speed = 1.1;
    }
    if (y){
      headingError = -tx;
      steerAdjust = 0.0;
      if(tx>0.2)
      {
        steerAdjust = Kp*headingError - min;
      }
      else if(tx<0.2)
      {
        steerAdjust = Kp*headingError + min;
      }

      lOut += steerAdjust;
      rOut -= steerAdjust;

      Robot.driveTrain.setRightMotors(rOut);
      Robot.driveTrain.setLeftMotors(lOut);
      
      speed = 1.1;
    }
    if (a){
      headingError = -tx;
      steerAdjust = 0.0;
      if(tx>0.2)
      {
        steerAdjust = Kp*headingError - min;
      }
      else if(tx<0.2)
      {
        steerAdjust = Kp*headingError + min;
      }

      lOut += steerAdjust;
      rOut -= steerAdjust;

      Robot.driveTrain.setRightMotors(rOut);
      Robot.driveTrain.setLeftMotors(lOut);
      
      speed = .34;
    }
    if (b){
      headingError = -tx;
      steerAdjust = 0.0;
      if(tx>0.2)
      {
        steerAdjust = Kp*headingError - min;
      }
      else if(tx<0.2)
      {
        steerAdjust = Kp*headingError + min;
      }

      lOut += steerAdjust;
      rOut -= steerAdjust;

      Robot.driveTrain.setRightMotors(rOut);
      Robot.driveTrain.setLeftMotors(lOut);
      
      speed = 1.0;
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
    double angleFrom = Robot.Limelight.getTX(); //90 deg turn is 163 deg

    while (Math.abs(angleFrom) > 0.5){
      Robot.driveTrain.setLeftMotors(angleFrom/50);
      Robot.driveTrain.setRightMotors(-angleFrom/50);
      angleFrom = Robot.Limelight.getTX();
      if (Math.abs(angleFrom) <0.1){
        Robot.driveTrain.brakeLeftMotors(0.1);
        Robot.driveTrain.brakeRightMotors(0.1);

      }
    }
      Robot.driveTrain.brakeLeftMotors(0.1);
      Robot.driveTrain.brakeRightMotors(0.1);

    

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
