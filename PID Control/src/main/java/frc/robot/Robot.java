// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
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
  
  double WRIST_POSITION_1 = 1.0/6.0 * 128; //These numbers is arbitrary.
  double WRIST_POSITION_2 = 1.0/9.0 * 128;

  CANSparkMax wrist = new CANSparkMax(16, MotorType.kBrushless);
  SparkMaxPIDController wristPID;
  XboxController controller = new XboxController(0);
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    wristPID = wrist.getPIDController();
    wristPID.setP(0.3);
    wristPID.setI(0.0);
    wristPID.setD(0.0);
    wristPID.setIZone(0.0);
    wristPID.setOutputRange(-0.4, 0.4);
  }

  @Override
  public void teleopPeriodic() {
    if(controller.getAButton()){
      wristPID.setReference(WRIST_POSITION_1, ControlType.kPosition);
    }else if(controller.getBButton()) {
      wristPID.setReference(WRIST_POSITION_2, ControlType.kPosition);
    }
  }

}
