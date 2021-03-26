/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html

/* Class still in development */
public class HomeAuton extends SequentialCommandGroup {
  /**
   * Creates a new MoveSequence.
   */
  public HomeAuton() {
    //autoCmdManual.Forward(12,false);
    // Add your commands in the super() call, e.g.
    //Barrel();
    //Slalom();

  }

  public void Barrel(){
    autoCmdManual.Forward(1.6,false); //Forward out of the gate
    autoCmdManual.Right(0.24,false); // Box D5
    autoCmdManual.Forward(0.5,false);
    autoCmdManual.Right(0.22,false);
    autoCmdManual.Forward(0.73,false);
    autoCmdManual.Right(0.27,false);
    autoCmdManual.Forward(0.5,false);
    autoCmdManual.Right(0.4,false); 
    
    autoCmdManual.Forward(.97,false); //Forward to B8
    
    autoCmdManual.Left(0.3,false); //Box B8
    autoCmdManual.Forward(0.63,false);
    autoCmdManual.Left(0.2,false);
    autoCmdManual.Forward(.9,false);
    autoCmdManual.Left(0.19,false);
    autoCmdManual.Forward(1.5,false);
    
    autoCmdManual.Left(0.5,false); //Box D10
    autoCmdManual.Forward(0.6,false);
    autoCmdManual.Left(0.23,false);
    autoCmdManual.Forward(5,false);
    
    //autoCmdManual.Forward(100); // Leaving Barrel
    }
    
    //Do we need to have Distance be return 6.25*Math.PI*encoderL.getDistance()/2048; like inches is?

    public void Slalom(){
    autoCmdManual.Forward(90,false); //Forward out of the gate, Start at 45 Degrees
    
    autoCmdManual.Left(45,false); // Long run 1
    autoCmdManual.Forward(84.85,false);
    /*
    autoCmdManual.Right(45); //Box D10
    autoCmdManual.Forward(120,false);
    autoCmdManual.Right(45);
    autoCmdManual.Forward(.35,false);
    autoCmdManual.Left(.5);
    autoCmdManual.Forward(.9,false);
    autoCmdManual.Left(.3);
    autoCmdManual.Forward(.8,false);
    autoCmdManual.Left(.34);
    autoCmdManual.Forward(.82,false);
    
    autoCmdManual.Right(.45); //Long run 2
    autoCmdManual.Forward(1,1);*/
    /*autoCmdManual.Right(.24);
    autoCmdManual.Forward(.8,.4);
    autoCmdManual.Left(.3);

    autoCmdManual.Forward(100,.4);*/ // Leaving Slalom
    }
    
    /*public void Bounce(){
    autoCmdManual.Forward(1); //Target A3
    autoCmdManual.Left(90);
    autoCmdManual.Forward(1); //touch
    autoCmdManual.Backward(1);
    autoCmdManual.bLeft(45);
    autoCmdManual.Backward(1);
    autoCmdManual.bRight(45);
    autoCmdManual.Backward(1);
    
    autoCmdManual.bLeft(90); //Target A6
    autoCmdManual.Backward(1);
    autoCmdManual.bLeft(90); 
    autoCmdManual.Backward(1); //touch
    autoCmdManual.Forward(1);
    
    autoCmdManual.Left(90); //Target A9
    autoCmdManual.Forward(1);
    autoCmdManual.Left(90); 
    autoCmdManual.Forward(1); //touch
    autoCmdManual.Backward(1);
    autoCmdManual.bLeft(90); 
    autoCmdManual.Backward(1); // Exit Bounce
    
    }*/
}

