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
public class autonSequence extends SequentialCommandGroup {
  /**
   * Creates a new MoveSequence.
   */
  public autonSequence() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    // super(
      //BARREL
          //Loop D5
          autoCmd.Fwd(2.4); autoCmd.RTurn(); autoCmd.Fwd(.97); autoCmd.RTurn(); autoCmd.Fwd(1); autoCmd.RTurn(); autoCmd.Fwd(1);          //Loop B8
          autoCmd.RTurn(); autoCmd.Fwd(1); //autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(1); 
          //Loop D10
          //autoCmd.LTurn(1); autoCmd.Fwd(3); autoCmd.LTurn(1); autoCmd.Fwd(1); autoCmd.LTurn(1); autoCmd.Fwd(6); autoCmd.LTurn(1);
      //SLALOM
          //Long Loop In
          //new Fwd(); new LTurn(); new Fwd(); new RTurn(); new Fwd();
          //Small Box
          //new Rturn(); new Fwd(); new LTurn(); new Fwd(); new LTurn(); new Fwd(); new LTurn(); new Fwd(); new LTurn(); new Fwd();
          //Long Loop Out   
          //new Rturn(); new Fwd(); new RTurn(); new Fwd(); new LTurn(); new Fwd();
      //Bounce Path
          //Spike 1
          //new Fwd(); new RTurn(); new Rev(); new Fwd(); new LTurn(); new Fwd(); new RTurn(); new Fwd(); 
          //Spike 2
          //new RTurn(); new Fwd(); new LTurn(); new Fwd(); new Rev(); new RTurn(); new Fwd();
          //Spike 3
          //new LTurn(); new Fwd(); new Rev(); new RTurn(); new Fwd();
          
          //);
    //super(new Drive(0.5, 0.5));
  }
}
