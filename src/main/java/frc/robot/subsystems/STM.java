/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.TimerTask;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.STMCom;

/* Class still in development */
public class STM extends SubsystemBase {
  /* Declares and initializes motor and colorSensor */
  private final VictorSPX STM_Motor5 = new VictorSPX(Constants.MOTOR_5);
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  /*
   * This method sets the speed of the motor (returns a double ranging from -1 to
   * 1)
   */
  public TimerTask setSTM_Motor(final double speed) {
    STM_Motor5.set(ControlMode.PercentOutput, speed);
    return null;
  }

  @Override
  public void periodic() {
    Color detectColor = m_colorSensor.getColor();

    // raw value of Infrared Light
    double IR = m_colorSensor.getIR();

    // proximity to object
    int proximity = m_colorSensor.getProximity();

    // Smart Dashboard UI
    SmartDashboard.putNumber("Red", detectColor.red);
    SmartDashboard.putNumber("Green", detectColor.green);
    SmartDashboard.putNumber("Blue", detectColor.blue);
    SmartDashboard.putNumber("IR", IR);
    SmartDashboard.putNumber("Proximity", proximity);
    // This method will be called once per scheduler run
    setDefaultCommand(new STMCom());
  }

  public static double addRequirements(STM stm) {
    return 0;
  }
}
