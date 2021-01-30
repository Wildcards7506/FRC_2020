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
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.Robot;

/* Class still in development */
public class STMCom extends CommandBase {
  /* Declares and initializes the colorSensor */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private static Timer timer = new Timer();

  Color color = m_colorSensor.getColor();
  int rotations = 0;
  char button = 'n';
  /* Declares and initializes instanceVariables */
  double[] m_initialColor = new double[3];

  public void STM_Spin(Color colour) {
    rotations = 0;
    Robot.stm.setSTM_Motor(Constants.STM_SPEED);
    if (color == colour)
      rotations += 1;
    Timer.delay(0.5); // prevent robot from detecting the color we are looking for immmediately after
                      // already detecting it
    if (rotations > 3) {
      Robot.stm.setSTM_Motor(Constants.STOP);
      rotations = 0;
      button = 'n';
    }
  }

  // * Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    // makes sure motor does not move when robot starts
    Robot.stm.setSTM_Motor(Constants.STOP);
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    // color = m_colorSensor.getColor();
    // if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_A))
    //   button = 'a';
    // if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_B))
    //   button = 'b';
    // if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_X))
    //   button = 'x';
    // if (Robot.m_robotContainer.getDriver2ButtonPressed(Constants.BUTTON_Y))
    //   button = 'y';

    // switch (button) {
    //   case 'a':
    //     STM_Spin(Color.kGreen);
    //     break;
    //   case 'b':
    //     STM_Spin(Color.kRed);
    //     break;
    //   case 'x':
    //     STM_Spin(Color.kCyan);
    //     break;
    //   case 'y':
    //     STM_Spin(Color.kYellow);
    //     break;
    // }
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
