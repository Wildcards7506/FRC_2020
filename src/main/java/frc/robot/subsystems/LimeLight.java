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
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class LimeLight extends SubsystemBase {
  private final double kDriveTick = 1.0/128*6*Math.PI/12;

  public static final double kDistancePerRevolution = 18.84;  // guestimate from your code
    public static final double kPulsesPerRevolution = 1024;     // for an AS5145B Magnetic Encoder
    public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;

  // Creates a new LimeLight.
  NetworkTable table;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  NetworkTableEntry tv;
  double txDouble;
  NetworkTableEntry ledMode;

  public void updateData() {
    // update table, then update from updated table
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    tv = table.getEntry("tv");
    txDouble = tx.getDouble(0.0);
    ledMode = table.getEntry("ledMode");

    // read values periodically
    double limeV = tv.getDouble(0.0);
    double limeX = tx.getDouble(0.0);
    double limeY = ty.getDouble(0.0);
    double limeArea = ta.getDouble(0.0);

    SmartDashboard.putNumber("Detection", limeV);
    SmartDashboard.putNumber("LimelightX", limeX);
    SmartDashboard.putNumber("LimelightY", limeY);
    SmartDashboard.putNumber("LimelightArea", limeArea);
  }

  public double getTX() {
    return txDouble;
  }
  public double getTA() {
    return ta.getDouble(0.0);
  }

  public double getTV(){
    return tv.getDouble(0.0);
  }

  @Override
  public void periodic() {
    updateData();
    // This method will be called once per scheduler run
  }
}
