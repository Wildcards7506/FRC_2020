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
  private final VictorSPX motorLeft1 = new VictorSPX(Constants.MOTOR_1);
  private final VictorSPX motorLeft2 = new VictorSPX(Constants.MOTOR_2);
  private final VictorSPX motorLeft3 = new VictorSPX(Constants.MOTOR_3);
  private final VictorSPX motorRight14 = new VictorSPX(Constants.MOTOR_14);
  private final VictorSPX motorRight15 = new VictorSPX(Constants.MOTOR_15);
  private final VictorSPX motorRight16 = new VictorSPX(Constants.MOTOR_16);
  public Encoder encoderL = new Encoder(0, 1, false,EncodingType.k4X);
  public Encoder encoderR = new Encoder(2, 3, false,EncodingType.k4X);



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
    motorLeft1.set(ControlMode.PercentOutput, -speed);
    motorLeft2.set(ControlMode.PercentOutput, -speed);
    motorLeft3.set(ControlMode.PercentOutput, -speed);
  }

  /*
   * This method sets the speed of the left motors (returns a double ranging from
   * -1 to 1)
   */
  public void setRightMotors(final double speed) {
    motorRight14.set(ControlMode.PercentOutput, speed);
    motorRight15.set(ControlMode.PercentOutput, speed);
    motorRight16.set(ControlMode.PercentOutput, speed);
  }

  public void brakeLeftMotors() {
    motorLeft1.set(ControlMode.PercentOutput, 0.2);
    motorLeft2.set(ControlMode.PercentOutput, -0.2);
    motorLeft3.set(ControlMode.PercentOutput, 0);
  }

  public void brakeRightMotors() {
    motorRight14.set(ControlMode.PercentOutput, 0.2);
    motorRight15.set(ControlMode.PercentOutput, -0.2);
    motorRight16.set(ControlMode.PercentOutput, 0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
  }
}
 