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
    boolean x =Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_X);
    boolean y =Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_Y);
    boolean a =Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_A);
    boolean b =Robot.m_robotContainer.getDriver2Button(Constants.BUTTON_B);
    
    int POV = Robot.m_robotContainer.getDriver2POV();
    double speed = 0;
    double shooterSpeed = 5;
    double Kp = 0.01;
    double tx = Robot.Limelight.getTX();
    double headingError;
    double steerAdjust;
    double min = 0.1;
    double lOut = 0;
    double rOut = 0;


    if (a) {
      ShooterCom.limeLightAdjust();

    } else if(b) {
      speed = shooterSpeed;
    }
    else if(x) {
      speed = 0;
    }


    
    Robot.shooter.setShooterMotor(speed);

    switch (POV) {
    case 270:
      //Robot.shooter.setPneumatics(Value.kForward);
      break;
    case 90:
      //Robot.shooter.setPneumatics(Value.kReverse);
      break;
    }

    // makes sure compressor maintains pressure
    //if (Robot.shooter.compressor.getPressureSwitchValue()) {
      //Robot.shooter.compressor.start();
    //} else {
      //Robot.shooter.compressor.stop();
    //}
  }

  public static void limeLightAdjust(){
    boolean bstop =Robot.m_robotContainer.getDriver1Button(Constants.BUTTON_B);
    double angleFrom = Robot.Limelight.getTX(); //90 deg turn is 163 deg
    while (angleFrom > 0.5 || angleFrom < -0.5){
      Robot.Limelight.updateData();
      angleFrom = Robot.Limelight.getTX();
      Robot.driveTrain.setLeftMotors(angleFrom/60);
      Robot.driveTrain.setRightMotors(-angleFrom/60);
      if (bstop){break;}
    }
      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);

      autoCmdManual.Shoot(1,3);  // 1.2 / 2.075 = Speed / getTA
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
