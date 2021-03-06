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
          //autoCmd.trackFwd(30); // Go forward from start to D5 Circle
          //System.out.println("Fwd Stopped at: " + Robot.Limelight.getTA());
          //autoCmdManual.slowDown();
          //System.out.println("slow");
          //autoCmdManual.trackRight(4);
          //System.out.println("turn");

          //autoCmd.trackFwd(6.5); // Go forward from start to D5 Circle
          //System.out.println("Fwd" + Robot.Limelight.getTA());
          //autoCmdManual.slowDown();
          //System.out.println("slow");
          //autoCmdManual.trackLeft(1.3);
          //System.out.println("turn");


          //autoCmd.LCircle(); //Complete circle around D5
          //autoCmd.trackFwd(34); //Go forward to B8 Circle
          //autoCmd.RCircle(); //Complete Circle around B8
          //autoCmd.teardrop(); //Loop around D10
          //autoCmd.trackRev(30); //Exit course away from goal 
          
          autoCmdManual.trackFwd(1.9); autoCmdManual.slowDown();
          autoCmdManual.trackRight(3); autoCmdManual.slowDown();
          //autoCmdManual.trackFwd(2.5); autoCmdManual.slowDown();
          //Barrel D5
          //TA between 3 - 3.8

          //Barrel B8
          //TA betweel 8.9 - 10

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
  }
}
