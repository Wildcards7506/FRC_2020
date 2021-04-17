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
    // Add your commands in the super() call, e.g.
    Tester();
  }

  public void LeftShoot(){  // Left side, go forwards, shoot -- setup backwards on leftmost side
    intake.setHorizontalIntake(Constants.INTAKE_SPEED);
    Timer.delay(2);
    intake.setHorizontalIntake(Constants.INTAKE_SPEED * .55);
  
    autoCmdManual.Forward(10,true); //go back past AIL
    ShooterCom.limeLightAdjust(); //adjust
    autoCmdManual.Shoot(1,5); //shoot
    autoCmdManual.Right(250, true); //turn around 180
    //drop intake
  }

  public void Tester(){
    //autoCmdManual.Forward(10,false);
    ShooterCom.limeLightAdjust();
    autoCmdManual.Shoot(1.2,3);
  }
}
