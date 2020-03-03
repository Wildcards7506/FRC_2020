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
//import frc.robot.subsystems.STM;

import java.lang.reflect.Method;
//import java.util.Timer;
import edu.wpi.first.wpilibj.Timer;

public class STMCom extends CommandBase {
  /**
   * Creates a new STM.
   */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  double m_motorSpeed;
  double[] m_initialColor = new double[3];

  Timer mTimer = new Timer();

  public STMCom() {
    // Use addRequirements() here to declare subsystem dependencies.
    m_motorSpeed = Constants.STOP;

    Color detectColor = m_colorSensor.getColor();

    m_initialColor[0] = detectColor.red;
    m_initialColor[1] = detectColor.green;
    m_initialColor[2] = detectColor.blue;

    addRequirements(Robot.stm);
  }

  public Method STMRotations() {
     //Timer m_timer = new Timer();
    //m_timer.schedule(Robot.stm.setSTM_Motor(0), 15000);
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

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    //int rotations = -1;
    //for (int i = 0; ) {}

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_robotContainer.commandButton(Constants.BUTTON_X, STMRotations());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.stm.setSTM_Motor(Constants.STOP);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
