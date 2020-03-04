/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

import java.lang.reflect.Method;
import edu.wpi.first.wpilibj.Timer;

/* Class still in development */
public class STMCom extends CommandBase {
  /* Declares and initializes the colorSensor */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  /* Declares and initializes instanceVariables */
  double[] m_initialColor = new double[3];
  Timer mTimer = new Timer();

  public STMCom() {
    // makes sure that the motor is not moving initially
    Robot.stm.setSTM_Motor(Constants.STOP);

    // gets color values from colorSensor
    Color detectColor = m_colorSensor.getColor();
    m_initialColor[0] = detectColor.red;
    m_initialColor[1] = detectColor.green;
    m_initialColor[2] = detectColor.blue;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.stm);
  }

  /* rotates motor for a set of time before stopping */
  public Method STMRotations() {
    mTimer.start();
    Robot.stm.setSTM_Motor(Constants.STM_SPEED);
    if (mTimer.get() == 1000) {
      mTimer.stop();
      mTimer.reset();
      Robot.stm.setSTM_Motor(0);
      return null;
    }
    return null;
  }

  // * Called when the command is initially scheduled. */
  @Override
  public void initialize() {

  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    // when button X is pressed motor rotates for a set of time
    Robot.m_robotContainer.commandButton(Constants.BUTTON_X, STMRotations());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // stops motor
    Robot.stm.setSTM_Motor(Constants.STOP);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
