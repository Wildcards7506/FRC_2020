/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private final PWMVictorSPX motorLeft0 = new PWMVictorSPX(Constants.MOTOR_LEFT_0);
  private final PWMVictorSPX motorLeft1 = new PWMVictorSPX(Constants.MOTOR_LEFT_1);
  private final PWMVictorSPX motorLeft2 = new PWMVictorSPX(Constants.MOTOR_LEFT_2);
  private final PWMVictorSPX motorRight3 = new PWMVictorSPX(Constants.MOTOR_RIGHT_3);
  private final PWMVictorSPX motorRight4 = new PWMVictorSPX(Constants.MOTOR_RIGHT_4);
  private final PWMVictorSPX motorRight5 = new PWMVictorSPX(Constants.MOTOR_RIGHT_5);

  public void setLeftMotors(final double speed) {
    motorLeft0.set(speed);
    motorLeft1.set(speed);
    motorLeft2.set(speed);
  }

  public void setRightMotors(final double speed) {
    motorRight3.set(-speed);
    motorRight4.set(-speed);
    motorRight5.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
  }
}
