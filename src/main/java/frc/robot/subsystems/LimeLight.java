/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* LimeLight specific Imports*/
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Spark;

public class LimeLight extends SubsystemBase {
  /**
   * Creates a new LimeLight.
   */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  NetworkTableEntry tv;
  NetworkTableEntry ledMode;

  //private final Spark spark = new Spark(0);

  public double Detecto() {
    if (tv.getDouble(0.0) == 1) {
      ledMode.setNumber(2);
      return tx.getDouble(0.0);
    }
    return 0.0;
  }

  public double getTX()
  {
    return tx.getDouble(0.0);
  }
  @Override
  public void periodic() {
    //update from table
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    tv = table.getEntry("tv");
    ledMode = table.getEntry("ledMode");
    // This method will be called once per scheduler run
    ledMode.setNumber(0);
    // read values periodically
    double limeV = tv.getDouble(0.0);
    double limeX = tx.getDouble(0.0);
    double limeY = ty.getDouble(0.0);
    double limeArea = ta.getDouble(0.0);

    // post to smart dashboard periodically
    SmartDashboard.putNumber("Detection", limeV);
    SmartDashboard.putNumber("LimelightX", limeX);
    SmartDashboard.putNumber("LimelightY", limeY);
    SmartDashboard.putNumber("LimelightArea", limeArea);
    // pwm.setRaw(255);
    // pwm.setSpeed(50);
    //spark.set(1);

    
    
  }
}
