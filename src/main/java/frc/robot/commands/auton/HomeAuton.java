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
    //autoCmdManual.Forward(12,false);
    // Add your commands in the super() call, e.g.
    Barrel();
    

  }

  public void Barrel(){
    autoCmdManual.Forward(8,false); //Forward out of the gate
    autoCmdManual.Right(163,false); // Box D5
    autoCmdManual.Forward(2,false);
    autoCmdManual.Right(163,false);
    autoCmdManual.Forward(2,false);
    autoCmdManual.Right(163,false);
    autoCmdManual.Forward(2.6,false);
    autoCmdManual.Right(228,false); 
    
    autoCmdManual.Forward(8.2,false); //Forward to B8
    
    autoCmdManual.Left(160,false); //Box B8
    autoCmdManual.Forward(3.8,false);
    autoCmdManual.Left(163,false);
    autoCmdManual.Forward(2.5,false);
    autoCmdManual.Left(100,false);
    autoCmdManual.Forward(9,false);
    
    autoCmdManual.Left(90,false); //Box D10
    autoCmdManual.Forward(4,false);
    autoCmdManual.Left(150,false);
    Timer.delay(1);
    autoCmdManual.Forward(10,false);
    autoCmdManual.Forward(10,false);
    autoCmdManual.Forward(10,false);
    autoCmdManual.Forward(10,false);
    
    //autoCmdManual.Forward(100); // Leaving Barrel
    }
    
    public void Slalom(){

    autoCmdManual.Forward(.8,false); //Forward out of the gate
    
    autoCmdManual.Left(160,false); 
    autoCmdManual.Forward(3,false);
    
    autoCmdManual.Right(144,false); 
    autoCmdManual.Forward(8,false); //Long 
    autoCmdManual.Right(125,false);
    autoCmdManual.Forward(4.5,false);
    
    autoCmdManual.Left(135,false);
    autoCmdManual.Forward(3,false);
    autoCmdManual.Left(100,false);
    autoCmdManual.Forward(3,false);
    autoCmdManual.Left(110,false);
    //autoCmdManual.Forward(0.3,false);
    //autoCmdManual.Left(50,false);
    autoCmdManual.Forward(7,false);
    
    autoCmdManual.Right(130, false); 
    autoCmdManual.Forward(8, false); //Long run 2
    autoCmdManual.Right(140, false);

    autoCmdManual.Forward(6, false);

    }
    
    public void Bounce(){
    autoCmdManual.Forward(1.5, false);
    autoCmdManual.Left(200, false); //Target A3
    autoCmdManual.Forward(2.5, false); //touch
    autoCmdManual.Forward(8.1, true);
    autoCmdManual.Left(170, false);
    autoCmdManual.Forward(3.5, true);
    autoCmdManual.Right(270,false);
    autoCmdManual.Forward(8.5, false);//touch
    autoCmdManual.Forward(8.5, true); //Target A6
    autoCmdManual.Left(200, false);
    autoCmdManual.Forward(6, true);
    autoCmdManual.Right(250, false);
    autoCmdManual.Forward(8, false);
    autoCmdManual.Forward(3.4, true);
    autoCmdManual.Right(163, false);
    autoCmdManual.Forward(3, false);
    }
    
    public void SearchA(){ //Red and blue seach patten A
      //Setup centered on 12.5 feet
      intake.setHorizontalIntake(Constants.INTAKE_SPEED);
      Timer.delay(1);
      intake.setHorizontalIntake(Constants.INTAKE_SPEED * .55);
      autoCmdManual.ForwardSearch(20.5, true);
      autoCmdManual.Right(260,false);

      autoCmdManual.ForwardSearch(4.4,true);
      autoCmdManual.Right(240,false);

      autoCmdManual.ForwardSearch(13,true);
      autoCmdManual.Left(250,false);

      autoCmdManual.ForwardSearch(3,true);
      autoCmdManual.Left(250,false);

      autoCmdManual.ForwardSearch(25,true);

    }
    public void Tester(){ //Red and Blue seach patten B
      autoCmdManual.Forward(10,true);
    }
}

