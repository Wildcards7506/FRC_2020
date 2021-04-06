/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auton;

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
    Bounce();
    

  }

  public void Barrel(){
    autoCmdManual.Forward(8,false); //Forward out of the gate
    autoCmdManual.Right(163,false); // Box D5
    autoCmdManual.Forward(2,false);
    autoCmdManual.Right(163,false);
    autoCmdManual.Forward(2,false);
    autoCmdManual.Right(163,false);
    autoCmdManual.Forward(2,false);
    autoCmdManual.Right(163,false); 
    
    autoCmdManual.Forward(8.2,false); //Forward to B8
    
    autoCmdManual.Left(160,false); //Box B8
    autoCmdManual.Forward(2.7,false);
    autoCmdManual.Left(163,false);
    autoCmdManual.Forward(2,false);
    autoCmdManual.Left(120,false);
    autoCmdManual.Forward(7,false);
    
    autoCmdManual.Left(90,false); //Box D10
    autoCmdManual.Forward(3,false);
    autoCmdManual.Left(180,false);
    autoCmdManual.Forward(60,false);
    
    //autoCmdManual.Forward(100); // Leaving Barrel
    }
    
    public void Slalom(){

    autoCmdManual.Forward(1.5,false); //Forward out of the gate
    
    autoCmdManual.Left(125,false); 
    autoCmdManual.Forward(3,false);
    
    autoCmdManual.Right(125,false); 
    autoCmdManual.Forward(8,false); //Long 
    autoCmdManual.Right(115,false);
    autoCmdManual.Forward(5.4,false);
    
    autoCmdManual.Left(135,false);
    autoCmdManual.Forward(3,false);
    autoCmdManual.Left(140,false);
    autoCmdManual.Forward(3,false);
    autoCmdManual.Left(140,false);
    autoCmdManual.Forward(4,false);
    
    autoCmdManual.Right(130, false); 
    autoCmdManual.Forward(9, false); //Long run 2
    autoCmdManual.Right(140, false);

    autoCmdManual.Forward(6, false);

    }
    
    public void Bounce(){
    autoCmdManual.Forward(2, false);
    autoCmdManual.Left(200, false); //Target A3
    autoCmdManual.Forward(2.5, false); //touch
    autoCmdManual.Forward(8.1, true);
    autoCmdManual.Left(130, false);
    autoCmdManual.Forward(3.2, true);
    autoCmdManual.Left(183,true);
    autoCmdManual.Forward(8.5, false);//touch
    autoCmdManual.Forward(8.2, true); //Target A6
    autoCmdManual.Left(140, false);
    autoCmdManual.Forward(6, true);
    autoCmdManual.Right(160, false);
    autoCmdManual.Forward(8, false);
    autoCmdManual.Forward(3.4, true);
    autoCmdManual.Right(163, false);
    autoCmdManual.Forward(3, false);
    }
    
    public void SearchA(){ //Red and blue seach patten A
      //Setup centered on 12.5 feet
      intake.setHorizontalIntake(Constants.INTAKE_SPEED);
      autoCmdManual.ForwardSearch(5, true);
      autoCmdManual.Forward(5, true);
      autoCmdManual.ForwardSearch(9,true);
      autoCmdManual.Right(210,false);

      autoCmdManual.ForwardSearch(7.5,true);
      autoCmdManual.Right(200,false);

      autoCmdManual.ForwardSearch(12,true);
      autoCmdManual.Right(195,false);
/*
      autoCmdManual.ForwardSearch(7.5,true);
      autoCmdManual.Right(163,false);

      autoCmdManual.ForwardSearch(12.5,false);
      autoCmdManual.Right(163,false);
      
      autoCmdManual.ForwardSearch(5,false);
      autoCmdManual.RightSearch(163),false);

      autoCmdManual.ForwardSearch(15,false);

      autoCmdManual.ForwardSearch(25,true);*/

    }
    public void Tester(){ //Red and Blue seach patten B
      autoCmdManual.Forward(10,true);
    }
}

