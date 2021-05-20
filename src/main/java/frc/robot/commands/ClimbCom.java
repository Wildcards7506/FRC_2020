/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.PWM;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Spark;
import com.revrobotics.CANSparkMax;

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
    int pov = Robot.m_robotContainer.getDriver2POV();

    // sets the speed pf climb
    switch(pov){
      case 0 : 
        leftSpeed = Constants.CLIMB_SPEED;
        rightSpeed = Constants.CLIMB_SPEED * .9;
        break;
      case 180 :
        leftSpeed = -Constants.CLIMB_SPEED;
        rightSpeed = -Constants.CLIMB_SPEED * .9;
        break;
      default :
        leftSpeed = -leftJoyStick;
        rightSpeed = -rightJoyStick;
        break;
    }
    Robot.climb.setLeft(leftSpeed);
    Robot.climb.setRight(rightSpeed);
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
