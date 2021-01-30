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
    // super(new FooCommand(), new BarCommand());
    // super(
      //BARREL
          autoCmd.trackFwd();

          //new autoCmd;
          //Loop D5
          //autoCmd.Fwd(2.8); autoCmd.RTurn(); autoCmd.Fwd(1.03); autoCmd.RTurn(); autoCmd.Fwd(1); autoCmd.RTurn(); autoCmd.Fwd(8);          
          //Loop B8
          //autoCmd.RTurn(); autoCmd.LFwd(2.8); autoCmd.LTurn(); autoCmd.Fwd(1.1); autoCmd.LTurn(); autoCmd.Fwd(1); autoCmd.LTurn(); autoCmd.Fwd(2);
          //Loop D10
          //autoCmd.LTurn(1); autoCmd.Fwd(3); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(6); autoCmd.LTurn(1);
      //SLALOM
          //Long Loop In
          //autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.RTurn(1); autoCmd.Fwd(1);
          //Small Box
          //autoCmd.Rturn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1);
          //Long Loop Out   
          //autoCmd.Rturn(1); autoCmd.Fwd(1); autoCmd.RTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1);
      //BOUNCE
          //Spike 1
          //autoCmd.Fwd(1); autoCmd.RTurn(1); autoCmd.Rev(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.RTurn(1); autoCmd.Fwd(1); 
          //Spike 2
          //autoCmd.RTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.Rev(1); autoCmd.RTurn(1); autoCmd.Fwd(1);
          //Spike 3
          //autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.Rev(1); autoCmd.RTurn(1); autoCmd.Fwd(1);
          
          //);
    //super(new Drive(0.5, 0.5));
  }
}
