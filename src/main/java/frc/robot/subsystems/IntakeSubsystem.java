// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  public TalonFX IntakeMotor;
  public double IntakeMotorSpeed;
  public double OutakeMotorPower;
  public boolean Intake = false;

  public boolean isRunning = false;


  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    IntakeMotor = new TalonFX(Constants.Intake.INTAKE_MOTOR_PORT);

  }

  public void setIntakePower(double IntakeMotorSpeed){
    isRunning = true;
    Intake = true;
    this.IntakeMotorSpeed = IntakeMotorSpeed;
    isRunning = false;
  }

  public void setOutakePower(double OutakeMotorPower){
    isRunning = true;
    Intake = false;
    this.OutakeMotorPower = OutakeMotorPower;

  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(!Intake){
      IntakeMotor.set(ControlMode.PercentOutput, IntakeMotorSpeed);
    } else{
      IntakeMotor.set(ControlMode.PercentOutput, OutakeMotorPower);
    }  
    
  }
}
