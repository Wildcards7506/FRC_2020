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


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html

/* Class still in development */
public class HomeAuton extends SequentialCommandGroup {
  /**
   * Creates a new MoveSequence.
   */
  private static Intake intake = new Intake();
  public HomeAuton() {
    //autoCmd.Forward(12,false);
    // Add your commands in the super() call, e.g.

    Robot.intake.setIntakeLift(-.2);
    Timer.delay(1.2);
    Robot.intake.setIntakeLift(0);
    autoCmd.Forward(2,false);
    Timer.delay(2);
    ShooterCom.limeLightAdjust();
  }

  /*public void Barrel(){
    autoCmd.Forward(8,false); //Forward out of the gate
    autoCmd.Right(163,false); // Box D5
    autoCmd.Forward(2,false);
    autoCmd.Right(163,false);
    autoCmd.Forward(2,false);
    autoCmd.Right(163,false);
    autoCmd.Forward(2.6,false);
    autoCmd.Right(228,false); 
    
    autoCmd.Forward(8.2,false); //Forward to B8
    
    autoCmd.Left(160,false); //Box B8
    autoCmd.Forward(3.8,false);
    autoCmd.Left(163,false);
    autoCmd.Forward(2.5,false);
    autoCmd.Left(100,false);
    autoCmd.Forward(9,false);
    
    autoCmd.Left(90,false); //Box D10
    autoCmd.Forward(4,false);
    autoCmd.Left(150,false);
    Timer.delay(1);
    autoCmd.Forward(10,false);
    autoCmd.Forward(10,false);
    autoCmd.Forward(10,false);
    autoCmd.Forward(10,false);
    
    //autoCmd.Forward(100); // Leaving Barrel
    }
    
    public void Slalom(){

    autoCmd.Forward(.8,false); //Forward out of the gate
    
    autoCmd.Left(160,false); 
    autoCmd.Forward(3,false);
    
    autoCmd.Right(144,false); 
    autoCmd.Forward(8,false); //Long 
    autoCmd.Right(125,false);
    autoCmd.Forward(4.5,false);
    
    autoCmd.Left(135,false);
    autoCmd.Forward(3,false);
    autoCmd.Left(100,false);
    autoCmd.Forward(3,false);
    autoCmd.Left(110,false);
    //autoCmd.Forward(0.3,false);
    //autoCmd.Left(50,false);
    autoCmd.Forward(7,false);
    
    autoCmd.Right(130, false); 
    autoCmd.Forward(8, false); //Long run 2
    autoCmd.Right(140, false);

    autoCmd.Forward(6, false);

    }
    
    public void Bounce(){
    autoCmd.Forward(1.5, false);
    autoCmd.Left(200, false); //Target A3
    autoCmd.Forward(2.5, false); //touch
    autoCmd.Forward(8.1, true);
    autoCmd.Left(170, false);
    autoCmd.Forward(3.5, true);
    autoCmd.Right(270,false);
    autoCmd.Forward(8.5, false);//touch
    autoCmd.Forward(8.5, true); //Target A6
    autoCmd.Left(200, false);
    autoCmd.Forward(6, true);
    autoCmd.Right(250, false);
    autoCmd.Forward(8, false);
    autoCmd.Forward(3.4, true);
    autoCmd.Right(163, false);
    autoCmd.Forward(3, false);
    }
    
    public void SearchA(){ //Red and blue seach patten A
      //Setup centered on 12.5 feet
      intake.setHorizontalIntake(Constants.INTAKE_SPEED);
      Timer.delay(1);
      intake.setHorizontalIntake(Constants.INTAKE_SPEED * .55);
      autoCmd.ForwardSearch(20.5, true);
      autoCmd.Right(260,false);

      autoCmd.ForwardSearch(4.4,true);
      autoCmd.Right(240,false);

      autoCmd.ForwardSearch(13,true);
      autoCmd.Left(250,false);

      autoCmd.ForwardSearch(3,true);
      autoCmd.Left(250,false);

      autoCmd.ForwardSearch(25,true);

    }
    public void Tester(){ //Red and Blue seach patten B
      autoCmd.Forward(10,true);
    }*/
}

