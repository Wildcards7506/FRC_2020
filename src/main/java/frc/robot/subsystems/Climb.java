/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modifidd .
ed and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import frc.robot.commands.ClimbCom;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class Climb extends SubsystemBase {
  /* Declares and initializes motor */
  public static final VictorSPX climbMotorL = new VictorSPX(Constants.climberL);
  public static final VictorSPX climbMotorR = new VictorSPX(Constants.climberR);
 
  public void setLeft(double speed) {
    climbMotorL.set(ControlMode.PercentOutput,speed);
  }

  public void setRight(double speed) {
    climbMotorR.set(ControlMode.PercentOutput,speed);
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
