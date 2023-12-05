package frc.robot.subsystems;

public // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Wrist;

public class WristSubsystem extends SubsystemBase {
  /** Creates a new WristSubsystem. */
  private double targetAngle;

  private final ShuffleboardTab WristTab = Shuffleboard.getTab("Wrist");

  private double currentAngle;
  private TalonFX wrist_motor;
  private PIDController pidController;
  private double motorPower;

  public WristSubsystem() {

    this.targetAngle = targetAngle;
    this.wrist_motor = new TalonFX(Constants.Wrist.WRIST_MOTOR_DEVICE_NUMBER);
    this.wrist_motor.configFactoryDefault();
    this.wrist_motor.clearStickyFaults();
    this.wrist_motor.configForwardSoftLimitThreshold(0);
    this.wrist_motor.configReverseSoftLimitThreshold(degreesToTicks(90));
    this.wrist_motor.configReverseSoftLimitEnable(true, 0);
    this.wrist_motor.configForwardSoftLimitEnable(true, 0);
    this.wrist_motor.setNeutralMode(NeutralMode.Coast);
    this.wrist_motor.setSelectedSensorPosition(0);
    this.wrist_motor.configOpenloopRamp(.5); // can't go from 0 to 1 instantly

    pidController = new PIDController(0.1, 0, 0);
    WristTab.add(pidController);
    WristTab.addNumber("Current Motor Position", wrist_motor::getSelectedSensorPosition);
    WristTab.addBoolean("Is at target", this::nearTargetAngle);
    WristTab.addNumber("Target Angle", () -> this.targetAngle);
}

  public static double degreesToTicks(double angle) {
    return (angle*360d)/((Wrist.GEAR_RATIO * Wrist.TICKS));
  }

  public void setTargetAngle(double targetAngle) {
    this.targetAngle = targetAngle;
    pidController.setSetpoint(targetAngle);
  }

  public static double ticksToDegrees(double ticks) {
    return ((ticks / Wrist.TICKS) * Wrist.GEAR_RATIO*360);
  }

  private double getCurrentAngle() {
    currentAngle = ticksToDegrees(wrist_motor.getSelectedSensorPosition());
    return currentAngle;
  }

  public boolean nearTargetAngle() {
    if (targetAngle - 0.5 <= getCurrentAngle() && getCurrentAngle() <= targetAngle + 0.5)
      return true;
    return false;
  }

  @Override
  public void periodic() {
    // calculates motor power
    motorPower = pidController.calculate(getCurrentAngle());
    // This method will be called once per scheduler run
    wrist_motor.set(TalonFXControlMode.PercentOutput, -(MathUtil.clamp(motorPower, -0.5, 0.5)));
  }
}
 {
    
}
