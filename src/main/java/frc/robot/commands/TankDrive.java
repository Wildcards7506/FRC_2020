/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class TankDrive extends CommandBase {
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    // initializes and declares joystick values from XboxController1
    double rightStickX = Robot.m_robotContainer.getDriver1Axis(Constants.RIGHT_STICK_X, "joystick");
    double leftStickY = Robot.m_robotContainer.getDriver1Axis(Constants.LEFT_STICK_Y, "joystick");
    double rightTrigger = Robot.m_robotContainer.getDriver1Axis(Constants.RIGHT_TRIGGER, "trigger", 0, 1);
    // changes direction of drive when LB in XboxController is pressed
    boolean LB = Robot.m_robotContainer.getDriver1Button(Constants.LEFT_BUTTON);
    boolean RB = Robot.m_robotContainer.getDriver1Button(Constants.RIGHT_BUTTON);
    double TurnL;
    double TurnR;

    if (LB) { 
      TurnL = 0.25;
    } else {
      TurnL = 1;
    }

    if (RB) {
      TurnR = 0.25;
    } else {
      TurnR = 1;
    }

    // forward and reverse
    double rightSpeed = ((leftStickY-(0.5*rightStickX)) * Constants.DRIVE_MAX_SPEED * TurnL);
    double leftSpeed = ((leftStickY+(0.5*rightStickX)) * Constants.DRIVE_MAX_SPEED * TurnR);
    // turning right joystick

    if(rightTrigger == 1){
      Robot.driveTrain.setRightMotors(rightSpeed*.5);
      Robot.driveTrain.setLeftMotors(leftSpeed*.5);
    }else{
      Robot.driveTrain.setRightMotors(rightSpeed);
      Robot.driveTrain.setLeftMotors(leftSpeed);
    }
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    // stops motors
    Robot.driveTrain.setLeftMotors(Constants.STOP);
    Robot.driveTrain.setRightMotors(Constants.STOP);
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
