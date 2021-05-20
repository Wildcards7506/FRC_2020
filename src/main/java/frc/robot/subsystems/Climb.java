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
import frc.robot.Constants;
import frc.robot.commands.ClimbCom;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Climb extends SubsystemBase {
  /* Declares and initializes motor */
  private final CANSparkMax climbMotor1 = new CANSparkMax(Constants.MOTOR_1, MotorType.kBrushless);
  //private final VictorSPX climbMotor9 = new VictorSPX(Constants.MOTOR_9);
  private final CANSparkMax climbMotor16 = new CANSparkMax(Constants.MOTOR_16, MotorType.kBrushless);
  //private final VictorSPX climbMotor13 = new VictorSPX(Constants.MOTOR_13);

  /*
   * This method sets the speed of the motor (returns a double ranging from -1 to
   * 1)
   */
  public void setLeft(final double speed) {
    climbMotor1.set(speed);
  }

  public void setRight(final double speed) {
    climbMotor16.set(speed);
  }



  @Override
  public void periodic() { 
    // This method will be called once per scheduler run
    setDefaultCommand(new ClimbCom());
  }
}
