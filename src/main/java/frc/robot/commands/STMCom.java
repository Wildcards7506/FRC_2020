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
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
import frc.robot.Robot;

/* Class still in development */
public class STMCom extends CommandBase {
  /* Declares and initializes the colorSensor */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  private static XboxController driverController2 = new XboxController(Constants.DRIVER_CONTROLLER_2);
  
  /* Declares and initializes instanceVariables */
  double[] m_initialColor = new double[3];
  Timer mTimer = new Timer();

  double m_time, m_speed;

  public STMCom(int time, double speed) {
    // makes sure that the motor is not moving initially

    // gets color values from colorSensor
    Color detectColor = m_colorSensor.getColor();
    m_initialColor[0] = detectColor.red;
    m_initialColor[1] = detectColor.green;
    m_initialColor[2] = detectColor.blue;

    
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.stm);
  }


  // * Called when the command is initially scheduled. */
  @Override
  public void initialize() {
    mTimer.start();
    
    Robot.stm.setSTM_Motor(m_speed);
  }

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    //m_speed = Robot.m_robotContainer.driver2OneImmediateButtonConfig(0, 0.5);
      Robot.stm.setSTM_Motor(m_speed);
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
