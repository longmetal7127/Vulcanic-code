// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  //commit test
// start time records the time since the robot is turned on 
private double startTime;
// this declares what motor controllers are on what channel 
  private Spark leftmotor1 = new Spark(0);  
  private Spark leftmotor2 = new Spark(1);  
  private Spark Rightmotor1 = new Spark(2);  
  private Spark Rightmotor2 = new Spark(3);  
  private Joystick joy1 = new Joystick(0);
  public Robot() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() 
  {
    // records time elapsed since robot turned on during auto mode
startTime = Timer.getFPGATimestamp();

  }

  @Override
  public void autonomousPeriodic() {
    // this is basically our entire autonomus routine at the moment , it moves forward at 60% power to the motor for 3 seconds , then stops until teleop is turned on
    double time  =  Timer.getFPGATimestamp();
   if (time - startTime < 3 ) {
leftmotor1.set(0.6);
leftmotor2.set(0.6);
Rightmotor1.set(-0.6);
Rightmotor2.set(-0.6);
   }
   else
   {
leftmotor1.set(0);
leftmotor2.set(0);
Rightmotor1.set(0);
Rightmotor2.set(0);


   }



  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    //=============================================/
    // this code gets the axis value of the power and turning speed of the robot
  double speed = -joy1.getRawAxis(1)*0.6;
  double turn = joy1.getRawAxis(4)* 0.3;  
  //==============================================/


 //=============================================/
 // sets the turning rate (in power delivered to each side ) for each controller input//
double left = speed + turn;
double right=  speed - turn;
 //=============================================/



  //=============================================/
  // sets the motor speed for each side //
leftmotor1.set(left);
leftmotor2.set(left);
Rightmotor1.set(-right);
Rightmotor2.set(-right);
 //=============================================/


  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
