// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  WPI_TalonRX leftFront;
  WPI_TalonRX leftBack;
  WPI_TalonRX rightFront;
  WPI_TalonRX rightBack;

  DifferentialDrive drive;

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {

    //intializes each motor to respective port
    leftFront = new WPI_TalonRX(1);
    leftBack = new WPI_TalonRX(2);
    rightFront = new WPI_TalonRX(3);
    rightBack = new WPI_TalonRX(4);

    leftFront.setInverted(true);

    //respective motor follows its own side motor
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    drive = new DifferentialDrive(leftFront,rightFront);
  }

  //sets the speed of tankdrive (foward?)
  public void setSpeedTank(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed,rightSpeed);
  }

  //sets the speed of arcade drive (turning?)
  public void setSpeedArcade(double speed, double rotation){
    drive.arcadeDrive(speed,rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
