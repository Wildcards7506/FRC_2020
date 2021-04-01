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

public class Climb extends SubsystemBase {
  /* Declares and initializes motor */
  private final VictorSPX climbMotor4 = new VictorSPX(Constants.MOTOR_10);
  //private final VictorSPX climbMotor9 = new VictorSPX(Constants.MOTOR_9);
  private final VictorSPX climbMotor11 = new VictorSPX(Constants.MOTOR_11);
  //private final VictorSPX climbMotor13 = new VictorSPX(Constants.MOTOR_13);

  /*
   * This method sets the speed of the motor (returns a double ranging from -1 to
   * 1)
   */
  public void setClimb(final double speed) {
    climbMotor4.set(ControlMode.PercentOutput, -speed);
    climbMotor11.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() { 
    // This method will be called once per scheduler run
    setDefaultCommand(new ClimbCom());
  }
}
