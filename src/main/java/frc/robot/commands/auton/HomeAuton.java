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
    Slalom();
    

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
    
    public void Slalom(){

    autoCmdManual.Forward(1.5,false); //Forward out of the gate
    
    autoCmdManual.Left(125,false); // Long run 1
    autoCmdManual.Forward(3,false);
    
    autoCmdManual.Right(80,false); //Box D10
    autoCmdManual.Forward(8,false);
    autoCmdManual.Right(80,false);
    autoCmdManual.Forward(4,false);
    
    autoCmdManual.Left(160,false);
    autoCmdManual.Forward(2,false);
    autoCmdManual.Left(150,false);
    autoCmdManual.Forward(2,false);
    autoCmdManual.Left(175,false);
    autoCmdManual.Forward(6,false);
    
    autoCmdManual.Right(70, false); //Long run 2
    autoCmdManual.Forward(8, false);
    autoCmdManual.Right(80, false);

    autoCmdManual.Forward(3, false);
    autoCmdManual.Left(80, false);
    autoCmdManual.Forward(3, false);

    }
    
    public void Bounce(){
    autoCmdManual.Forward(10,false);
    /*autoCmdManual.Forward(1); //Target A3
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
    autoCmdManual.Backward(1); // Exit Bounce*/
    }
    
    public void SearchA(){ //Red and blue seach patten A
      //Setup centered on 12.5 feet
      autoCmdManual.Forward(22,false);
      autoCmdManual.Right(150,false);

      autoCmdManual.Forward(10,false);
      autoCmdManual.Right(150,false);

      autoCmdManual.Forward(15,false);
      autoCmdManual.Right(150,false);

      autoCmdManual.Forward(7.5,false);
      autoCmdManual.Right(150,false);

      autoCmdManual.Forward(12.5,false);
      autoCmdManual.Right(150,false);
      
      autoCmdManual.Forward(5,false);
      autoCmdManual.Right(150,false);

      autoCmdManual.Forward(15,false);

      autoCmdManual.Forward(25,true);

    }
    public void SearchB(){ //Red and Blue seach patten B
      
    }
}

