// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends SubsystemBase {
  WPI_TalonSRX leftFront;
  WPI_TalonSRX leftBack;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX rightBack;

  DifferentialDrive drive;

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {

    //intializes each motor to respective port
    leftFront = new WPI_TalonSRX(1);
    leftBack = new WPI_TalonSRX(2);
    rightFront = new WPI_TalonSRX(3);
    rightBack = new WPI_TalonSRX(4);

    leftFront.setInverted(true);

    //respective motor follows its own side motor
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    drive = new DifferentialDrive(leftFront,rightFront);
  }

  //sets the speed of tankdrive 
  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed,rightSpeed);
  }

  //sets the speed of arcade drive 
  public void arcadeDrive(double speed, double rotation){
    drive.arcadeDrive(speed,rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Front Motor: ", leftFront.get());
    SmartDashboard.putNumber("Right Front Motor: ", rightFront.get());
    SmartDashboard.putNumber("Left Back Motor: ", leftBack.get());
    SmartDashboard.putNumber("Right Back Motor: ", rightBack.get());
  }
}
