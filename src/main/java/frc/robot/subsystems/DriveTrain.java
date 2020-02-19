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
import frc.robot.commands.TankDrive;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private final VictorSPX motorLeft9 = new VictorSPX(Constants.MOTOR_9);
  private final VictorSPX motorLeft10 = new VictorSPX(Constants.MOTOR_10);
  private final VictorSPX motorLeft11 = new VictorSPX(Constants.MOTOR_11);
  private final VictorSPX motorRight1 = new VictorSPX(Constants.MOTOR_1);
  private final VictorSPX motorRight2 = new VictorSPX(Constants.MOTOR_2);
  private final VictorSPX motorRight3 = new VictorSPX(Constants.MOTOR_3);

  public void setLeftMotors(final double speed) {
    motorLeft9.set(ControlMode.PercentOutput, -speed);
    motorLeft10.set(ControlMode.PercentOutput, -speed);
    motorLeft11.set(ControlMode.PercentOutput, -speed);
  }

  public void setRightMotors(final double speed) {
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
    motorRight3.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
  }
}
