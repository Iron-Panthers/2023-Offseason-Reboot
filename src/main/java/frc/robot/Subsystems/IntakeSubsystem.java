// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

  // MOTORS
  TalonFX intakeMotor;
  private double motorPower;

  private LinearFilter filter;
  private double filterOutput;

  private boolean isCone;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {

    // setup the motor
    intakeMotor = new TalonFX(Constants.Intake.INTAKE_MOTOR_NUMBER);

    intakeMotor.configFactoryDefault();

    intakeMotor.clearStickyFaults();

    intakeMotor.setSelectedSensorPosition(0d);

    intakeMotor.setNeutralMode(NeutralMode.Brake);

    filter = LinearFilter.movingAverage(30);
  }

  public boolean IsLoaded() { // returns true when the cube or cone has finished loading
    boolean loaded = false;
    if (isCone && filterOutput >= Constants.Intake.CONE_STATOR_LIMIT) {
      loaded = true;
    } else if (!isCone && filterOutput >= Constants.Intake.CONE_STATOR_LIMIT) {
      loaded = true;
    }
    return loaded;
  }

  public void SetMotorPower(double motorPower) {
    this.motorPower = motorPower;
  }

  //to set the object as either a cone or a cube
  //to be called in commands alongside of set motor power
  public void SetObjectType(boolean isCone) {
    this.isCone = isCone;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    filterOutput = filter.calculate(intakeMotor.getStatorCurrent());

    // set the motor power to the var
    intakeMotor.set(TalonFXControlMode.PercentOutput, motorPower);

    // // if we are done loading than set the motor power to 0
    // if (IsLoaded()) SetMotorPower(0);
  }
}
