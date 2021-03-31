/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ShooterCom;

public class Shooter extends SubsystemBase {
  /* Declares and initializes motor */
  private final VictorSPX shooterMotor8 = new VictorSPX(Constants.MOTOR_8);
  //public final Compressor compressor = new Compressor(0);
  //private final DoubleSolenoid pneumatics = new DoubleSolenoid(Constants.PNEUMATIC_1, Constants.PNEUMATIC_2);

  public void setShooterMotor(final double speed) {
    shooterMotor8.set(ControlMode.PercentOutput, -speed);
  }

  public void setPneumatics(final DoubleSolenoid.Value value) {
    //pneumatics.set(value);
  }

  /*
   * public String getShooterMotor() { double busVoltage =
   * shooterMotor8.getBusVoltage(); double outputPercent =
   * shooterMotor8.getMotorOutputPercent(); double outputVoltage =
   * shooterMotor8.getMotorOutputVoltage(); String str = "BusVoltage: " +
   * busVoltage + "\nMotorOutputPercent: " + outputPercent +
   * "\nMotorOutputVoltage: " + outputVoltage; return str; }
   */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new ShooterCom());
  }
}
