// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Subsystems;

import frc.robot.Constants;

import org.apache.commons.math3.analysis.function.Constant;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  public TalonFX IntakeMotor;
  public double IntakeMotorSpeed;


  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    IntakeMotor = new TalonFX(Constants.Intake.INTAKE_MOTOR_PORT);
  }

  public void setIntakePower(double IntakeMotorSpeed){
    this.IntakeMotorSpeed = IntakeMotorSpeed;
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    IntakeMotor.set(ControlMode.PercentOutput, IntakeMotorSpeed);
  }
}
