/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modifidd .
ed and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import frc.robot.commands.ClimbCom;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.EncoderType;
public class Climb extends SubsystemBase {
  /* Declares and initializes motor */
  private final CANSparkMax climbMotorL = new CANSparkMax(Constants.climberL, MotorType.kBrushless);
  private final CANSparkMax climbMotorR = new CANSparkMax(Constants.climberR, MotorType.kBrushless);
  public final CANEncoder encoderLC = climbMotorL.getEncoder(EncoderType.kHallSensor, 42);
  public final CANEncoder encoderRC = climbMotorR.getEncoder(EncoderType.kHallSensor, 42);
  public final Spark Arduino = new Spark(0);
 
  public void setLeft(double speed) {
    climbMotorL.set(speed);
  }

  public void setRight(double speed) {
    climbMotorR.set(speed);
  }

  public void setPWM(int PWM) {
    Arduino.setRaw(PWM);
  }

  @Override
  public void periodic() { 
    // This method will be called once per scheduler run
    setDefaultCommand(new ClimbCom());
  }
}
