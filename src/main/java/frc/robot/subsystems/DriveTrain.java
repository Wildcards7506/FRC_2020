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
  private final VictorSPX motorLeft0 = new VictorSPX(Constants.MOTOR_LEFT_0);
  private final VictorSPX motorLeft1 = new VictorSPX(Constants.MOTOR_LEFT_1);
  private final VictorSPX motorLeft2 = new VictorSPX(Constants.MOTOR_LEFT_2);
  private final VictorSPX motorRight3 = new VictorSPX(Constants.MOTOR_RIGHT_3);
  private final VictorSPX motorRight4 = new VictorSPX(Constants.MOTOR_RIGHT_4);
  private final VictorSPX motorRight5 = new VictorSPX(Constants.MOTOR_RIGHT_5);

  public void setLeftMotors(final double speed) {
    motorLeft0.set(ControlMode.PercentOutput, speed);
    motorLeft1.set(ControlMode.PercentOutput,speed);
    motorLeft2.set(ControlMode.PercentOutput,speed);
  }

  public void setRightMotors(final double speed) {
    motorRight3.set(ControlMode.PercentOutput,-speed);
    motorRight4.set(ControlMode.PercentOutput,-speed);
    motorRight5.set(ControlMode.PercentOutput,-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
  }
}
