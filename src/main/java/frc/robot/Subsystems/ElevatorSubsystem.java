// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Elevator;

// private PIDController controller;

public class ElevatorSubsystem extends SubsystemBase {

  private TalonFX rightMotor;
  private TalonFX leftMotor;
  private PIDController controller;
  private double targetHeight;
  private double motorPower;
  private double currentHeight = 0;
  private final ShuffleboardTab ElevatorTab = Shuffleboard.getTab("Elevator");

  
  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem() {
    
    leftMotor = new TalonFX(14);
    rightMotor = new TalonFX(15);

    
    leftMotor.configFactoryDefault();
    rightMotor.configFactoryDefault();
    
    rightMotor.clearStickyFaults();
    leftMotor.clearStickyFaults();

    rightMotor.follow(leftMotor);

    controller = new PIDController(0.4, 0, 0.0125);

    ElevatorTab.addNumber("Current Motor Power", () -> this.motorPower);
    ElevatorTab.addNumber("Target Height", () -> this.targetHeight);
    // ElevatorTab.addNumber("PID output", () -> this.controller);
    ElevatorTab.addNumber("Current Height", () -> this.currentHeight);
    ElevatorTab.add(controller);
    ElevatorTab.addNumber("Left Motor Speed", leftMotor::getSelectedSensorVelocity);
    ElevatorTab.addNumber("Right Motor Speed", rightMotor::getSelectedSensorVelocity);

    targetHeight = 0;
    currentHeight = 0;
  }

  
  public static double inchesToTicks(double height) {
    return height * ((Elevator.GEAR_RATIO * Elevator.TICKS) / (Elevator.GEAR_CIRCUMFERENCE));
  }
  public static double ticksToInches(double ticks) {
    return (ticks * Elevator.GEAR_CIRCUMFERENCE) / (Elevator.TICKS * Elevator.GEAR_RATIO);
  }
  public void setTargetHeight(double targetHeight){
    this.targetHeight = targetHeight;
  }
  


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double ticks = leftMotor.getSelectedSensorPosition();
    motorPower = controller.calculate(ticksToInches(ticks), targetHeight);
    leftMotor.set(TalonFXControlMode.PercentOutput, MathUtil.clamp(motorPower, -0.2, 0.2));
    
    currentHeight = ticksToInches(-leftMotor.getSelectedSensorPosition());
  }



  public boolean nearTargetHeight(){
    if(targetHeight -0.5 <= currentHeight && currentHeight <= targetHeight +0.5){
      return true;
    }
    return false;
  }
    
}
