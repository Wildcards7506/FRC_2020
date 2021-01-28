/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.STMCom;

/* Class still in development */
public class STM extends SubsystemBase {
  /* Declares and initializes the motor */
  private final VictorSPX STM_Motor10 = new VictorSPX(Constants.MOTOR_10);

  /*
   * This method sets the speed of the motor (returns a double ranging from -1 to
   * 1)
   */
  public void setSTM_Motor(final double speed) {
    STM_Motor10.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new STMCom());
  }
}
