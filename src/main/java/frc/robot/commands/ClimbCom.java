/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;

public class ClimbCom extends CommandBase {
  public ClimbCom() {
    /* Use addRequirements() here to declare subsystem dependencies. */
    addRequirements(Robot.climb);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    Robot.climb.setLeft(Constants.STOP);
    Robot.climb.setRight(Constants.STOP);
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    // initializes and declares the speed for climbing
    double leftJoyStick = Robot.m_robotContainer.getDriver2Axis(Constants.LEFT_STICK_Y, "joystick");
    double rightJoyStick = Robot.m_robotContainer.getDriver2Axis(Constants.RIGHT_STICK_Y, "joystick");
    double leftSpeed = 0;
    double rightSpeed = 0;
    boolean buttonConfirm = Robot.m_robotContainer.getDriver1ButtonPressed(Constants.BUTTON_B);
    int buttonMult = (buttonConfirm) ? 1 : 0;
    int PWM;
    int pov = Robot.m_robotContainer.getDriver2POV();
    
    // sets climber direction
    switch(pov){
      case 0 : 
        leftSpeed = Constants.CLIMB_SPEED;
        rightSpeed = Constants.CLIMB_SPEED;
        PWM = 100;
        break;
      case 180 :
        leftSpeed = -Constants.CLIMB_SPEED;
        rightSpeed = -Constants.CLIMB_SPEED;
        PWM = 100;
        break;
      default :
        leftSpeed = -leftJoyStick;
        rightSpeed = -rightJoyStick;
        PWM = 0;
        break;
    }
    
    Robot.climb.setLeft(leftSpeed * buttonMult);
    Robot.climb.setRight(rightSpeed * buttonMult);
    Robot.climb.setPWM(PWM);
    
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    // stops the motor
    Robot.climb.setLeft(Constants.STOP);
    Robot.climb.setRight(Constants.STOP);
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
