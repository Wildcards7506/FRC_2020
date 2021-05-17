/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;

public class DriveTrain extends SubsystemBase {
  /* Declares and initializes motors */
  public static final VictorSPX motorLeft4 = new VictorSPX(Constants.MOTOR_4);
  public static final VictorSPX motorLeft3 = new VictorSPX(Constants.MOTOR_3);
  public static final VictorSPX motorRight14 = new VictorSPX(Constants.MOTOR_14);
  public static final VictorSPX motorRight15 = new VictorSPX(Constants.MOTOR_15);
  public final Encoder encoderL = new Encoder(1, 2, false,EncodingType.k4X);
  public final Encoder encoderR = new Encoder(5, 6, true,EncodingType.k4X);



  /*
   * This method sets the speed of the left motors (returns a double ranging from
   * -1 to 1)
   */

   public double getEncoderInchesL()
   {
     return 6.25*Math.PI*encoderL.getDistance()/2048;
   }
   public double getEncoderInchesR()
   {
     return 6.25*Math.PI*encoderR.getDistance()/2048;
   }
   
   public double getEncoderDegreesL()
   {
     return encoderL.getDistance()/2048;
   }
   public double getEncoderDegreesR()
   {
     return encoderR.getDistance()/2048;
   }

  public void setLeftMotors(final double speed) {
    //motorLeft1.set(ControlMode.PercentOutput, -speed);
    motorLeft4.set(ControlMode.PercentOutput, -speed);
    motorLeft3.set(ControlMode.PercentOutput, -speed);
  }

  /*
   * This method sets the speed of the left motors (returns a double ranging from
   * -1 to 1)
   */
  public void setRightMotors(final double speed) {
    motorRight14.set(ControlMode.PercentOutput, speed);
    motorRight15.set(ControlMode.PercentOutput, speed);
    //motorRight16.set(ControlMode.PercentOutput, speed);
  }


public void brakeLeftMotors(final double speed) {
    //motorLeft1.set(ControlMode.PercentOutput, -speed);
    motorLeft3.set(ControlMode.PercentOutput, speed);
    motorLeft4.set(ControlMode.PercentOutput, -speed);
  }

  public void brakeRightMotors(final double speed) {
    motorRight14.set(ControlMode.PercentOutput, -speed);
    motorRight15.set(ControlMode.PercentOutput, speed);
    //motorRight16.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
  }
}
 