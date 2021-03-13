/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html

/* Class still in development */
public class HomeAuton extends SequentialCommandGroup {
  /**
   * Creates a new MoveSequence.
   */
  public HomeAuton() {
    // Add your commands in the super() call, e.g.
    Barrel();
    //Slalom();

  }

  public void Barrel(){
    autoCmdManual.Forward(1.6,0.46); //Forward out of the gate
    autoCmdManual.Right(0.24); // Box D5
    autoCmdManual.Forward(0.5,0.4);
    autoCmdManual.Right(0.22);
    autoCmdManual.Forward(0.73,0.4);
    autoCmdManual.Right(0.27);
    autoCmdManual.Forward(0.5,0.5);
    autoCmdManual.Right(0.4); 
    
    autoCmdManual.Forward(.97,0.55); //Forward to B8
    
    autoCmdManual.Left(0.3); //Box B8
    autoCmdManual.Forward(0.63,0.4);
    autoCmdManual.Left(0.2);
    autoCmdManual.Forward(.9,0.4);
    autoCmdManual.Left(0.19);
    autoCmdManual.Forward(1.5,0.44);
    
    autoCmdManual.Left(0.5); //Box D10
    autoCmdManual.Forward(0.6,0.4);
    autoCmdManual.Left(0.23);
    autoCmdManual.Forward(5,0.43);
    
    //autoCmdManual.Forward(100); // Leaving Barrel
    }
    
    /*public void Slalom(){
    autoCmdManual.Forward(1); //Forward out of the gate, Start at 45 Degrees
    
    autoCmdManual.Right(45); // Long run 1
    autoCmdManual.Forward(1);
    
    autoCmdManual.Right(90); //Box D10
    autoCmdManual.Forward(1);
    autoCmdManual.Left(90);
    autoCmdManual.Forward(1);
    autoCmdManual.Left(90);
    autoCmdManual.Forward(1);
    autoCmdManual.Left(90);
    autoCmdManual.Forward(1);
    autoCmdManual.Left(90);
    autoCmdManual.Forward(1);
    
    autoCmdManual.Right(90); //Long run 2
    autoCmdManual.Forward(1);
    autoCmdManual.Right(45);
    
    autoCmdManual.Forward(100); // Leaving Slalom
    }
    
    public void Bounce(){
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

