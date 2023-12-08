// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Intake;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class IntakeSubsystem extends SubsystemBase {
  private double intakeMotorPower;
  private TalonFX intake_motor;
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intake_motor = new TalonFX(Intake.MOTOR_PORT);
    intakeMotorPower = 0;
    
  }

  public void setIntakePower(double intakeMotorPower) {
    this.intakeMotorPower = intakeMotorPower;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    intake_motor.set(TalonFXControlMode.PercentOutput, intakeMotorPower);
  }
}
