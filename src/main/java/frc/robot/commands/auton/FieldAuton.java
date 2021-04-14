/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.ShooterCom;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html

/* Class still in development */
public class FieldAuton extends SequentialCommandGroup {
  /**
   * Creates a new MoveSequence.
   */
  private static Intake intake = new Intake();
  public FieldAuton() {
    //autoCmdManual.Forward(12,false);
    // Add your commands in the super() call, e.g.
    DeReA();
  }

  public void DeReA(){  // Dead Reckoning A
    intake.setHorizontalIntake(Constants.INTAKE_SPEED);
    Timer.delay(1);
    intake.setHorizontalIntake(Constants.INTAKE_SPEED * .55);
    //start at far left wall on AIL
    autoCmdManual.Forward(10,false); //go forward and grab balls, make sure not hit colorwheel
    autoCmdManual.Right(375,false); //turn
    autoCmdManual.Forward(4,false); //go to center of allience half of field
    //ShooterCom.limeLightAdjust(); //use limelight to line up shooter
    //shoot
    autoCmdManual.Left(375,false); //turn around to be ready for teleop
  }

}
