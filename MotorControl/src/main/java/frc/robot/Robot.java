// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  CANSparkMax wrist = new CANSparkMax(0, MotorType.kBrushless);
  CANSparkMax intake = new CANSparkMax(1, MotorType.kBrushless);
  XboxController controller = new XboxController(0);
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {}

  @Override
  public void teleopPeriodic() {

    //This allows you to manually control the wrist movement using the left joystick.
    double wristSpeed = controller.getLeftY();
    wrist.set(wristSpeed);

    boolean intakeBalls = controller.getRightBumper();
    boolean outtakeBalls = controller.getLeftBumper();

    if(intakeBalls) {
      intake.set(-0.5); // A negative number just tells the motor to go backwards at that speed.
    } else if(outtakeBalls) {
      intake.set(0.5);
    }

  }

}
