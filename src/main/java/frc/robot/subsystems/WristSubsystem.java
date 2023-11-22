// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Wrist;

public class WristSubsystem extends SubsystemBase {
  /** Creates a new WristSubsystem. */
  private double targetAngle;

  private double currentAngle;
  private TalonFX wrist_motor;
  private PIDController pidController;
  private double motorPower;

  public WristSubsystem() {}

  public void setTargetAngle(double targetAngle) {
    this.targetAngle = targetAngle;
    wrist_motor = new TalonFX(Constants.Wrist.WRIST_MOTOR_DEVICE_NUMBER);
    wrist_motor.configFactoryDefault();
    wrist_motor.clearStickyFaults();
    wrist_motor.configReverseSoftLimitEnable(true, 0);
    wrist_motor.setNeutralMode(NeutralMode.Coast);
    wrist_motor.setSelectedSensorPosition(0);
    wrist_motor.configOpenloopRamp(.5); // can't go from 0 to 1 instantly

    pidController = new PIDController(0.1, 0, 0);
  }

  public static double degreesToTicks(double angle) {
    return angle * ((Wrist.GEAR_RATIO * Wrist.TICKS));
  }

  public static double ticksToDegrees(double ticks) {
    return (ticks / (Wrist.TICKS * Wrist.GEAR_RATIO));
  }

  private double getCurrentAngle() {
    return currentAngle = ticksToDegrees(wrist_motor.getSelectedSensorPosition());
  }

  @Override
  public void periodic() {
    //calculates motor power
    motorPower = pidController.calculate(getCurrentAngle());
    // This method will be called once per scheduler run
    wrist_motor.set(TalonFXControlMode.PercentOutput, -(MathUtil.clamp(motorPower, -0.5, 0.5)));
  }
}
