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
import frc.robot.commands.IntakeCom;

public class Intake extends SubsystemBase {
  /* Declares and initializes motor */
  private final VictorSPX intakeMotor12 = new VictorSPX(Constants.MOTOR_12);
  private final VictorSPX intakeMotor13 = new VictorSPX(Constants.MOTOR_13);
  private final VictorSPX intakeMotor5 = new VictorSPX(Constants.MOTOR_5);

  public void setVerticalIntake(final double speed) {
    intakeMotor5.set(ControlMode.PercentOutput, speed);
  }

  public void setHorizontalIntake(final double speed) {
    intakeMotor12.set(ControlMode.PercentOutput, speed);
  }

  public void setTriggerSpool(final double speed) {
    intakeMotor13.set(ControlMode.PercentOutput, -speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new IntakeCom());
  }
}
