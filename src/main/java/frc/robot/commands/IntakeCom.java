/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class IntakeCom extends CommandBase {
  public IntakeCom() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.intake);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    Robot.intake.setHorizontalIntake(Constants.STOP);
    Robot.intake.setVerticalIntake(Constants.STOP);
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    double leftTrigger1 = Robot.m_robotContainer.getDriver1Axis(Constants.LEFT_TRIGGER, "trigger", 0,1);
    boolean leftButton1 = Robot.m_robotContainer.getDriver1Button(Constants.LEFT_BUTTON);

    double RightTrigger = Robot.m_robotContainer.getDriver2Axis(Constants.RIGHT_TRIGGER, "trigger", 0, 1);
    double LeftTrigger = Robot.m_robotContainer.getDriver2Axis(Constants.LEFT_TRIGGER, "trigger", 0, 1);
    
    boolean RightButton = Robot.m_robotContainer.getDriver2Button(Constants.RIGHT_BUTTON);
    boolean LeftButton = Robot.m_robotContainer.getDriver2Button(Constants.LEFT_BUTTON);

    if (leftTrigger1 == 1) {
      Robot.intake.setIntakeLift(-Constants.INTAKE_SPEED*.5);
    } else if(leftButton1){
      Robot.intake.setIntakeLift(Constants.INTAKE_SPEED*.5);
    } else {
      Robot.intake.setIntakeLift(0);
    }

    double horizontalSpeed, verticalSpeed;
    if (RightButton) {
      horizontalSpeed = -Constants.INTAKE_SPEED*0.5;
    } else if(RightTrigger == 1){
      horizontalSpeed = Constants.INTAKE_SPEED*0.5;
    } else {
      horizontalSpeed = 0;//Robot.m_robotContainer.getDriver2Axis(Constants.LEFT_STICK_Y, "joystick", Constants.STOP,Constants.INTAKE_SPEED);
    }

    if (LeftButton) {
      verticalSpeed = Constants.INTAKE_SPEED;
    } else if(LeftTrigger == 1) {
      verticalSpeed = -Constants.INTAKE_SPEED;
    } else {
      verticalSpeed = 0;//Robot.m_robotContainer.getDriver2Axis(Constants.LEFT_STICK_Y, "joystick", Constants.STOP, Constants.INTAKE_SPEED);
    }

    Robot.intake.setVerticalIntake(verticalSpeed);
    Robot.intake.setHorizontalIntake(horizontalSpeed);
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    Robot.intake.setHorizontalIntake(Constants.STOP);
    Robot.intake.setVerticalIntake(Constants.STOP);
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
