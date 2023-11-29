// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Elevator;

// private PIDController controller;

public class ElevatorSubsystem extends SubsystemBase {

  private TalonFX rightMotor;
  private TalonFX leftMotor;
  private PIDController controller;
  private double targetHeight;
  private double motorPower;
  private double currentHeight;
  

  
  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem() {
    leftMotor = new TalonFX(14);
    rightMotor = new TalonFX(15);
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
    motorPower = controller.calculate(targetHeight);

    leftMotor.set(TalonFXControlMode.PercentOutput, motorPower);
    currentHeight = ticksToInches(-leftMotor.getSelectedSensorPosition());
  }



  public boolean nearTargetHeight(){
    if(targetHeight -0.5 <= currentHeight && currentHeight <= targetHeight +0.5){
      return true;
    }
    return false;
  }
    
}
