// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class WristSubsystem extends SubsystemBase {
 /** Creates a new ExampleSubsystem. */
 private TalonFX motor;
 /** leader */
 private PIDController pidController;
 private final ShuffleboardTab WristTab = Shuffleboard.getTab("Elevator");


 private double targetAngle;
 private double motorPower;
 
 //creates the WristSubsystem 
  public WristSubsystem() {
    motor = new TalonFX(16);
    motorPower = 0;
    targetAngle = 0; //sets the "targetAngle" variable to 0 by default

    //creates the new PID :) WOOHOOOO
    pidController = new PIDController(0, 0, 0);


    //
    WristTab.addNumber("Current Motor Power", () -> motorPower);  
    WristTab.addNumber("Target Angle", () -> this.targetAngle);
  }
 

  public static double inchesToTicks(double height) {
    return height * ((Wrist.GEAR_RATIO * Wrist.TICKS_PER_REVOLUTION) / (Wrist.GEAR_CIRCUMFERENCE));
  }
  public static double ticksToInches(double ticks) {
    return (ticks * Wrist.GEAR_CIRCUMFERENCE) / (Wrist.TICKS_PER_REVOLUTION * Wrist.GEAR_RATIO);
  }


// updates the "targetAngle" variable if you change the value in WristCommand in public void execute
public void setTargetAngle(double targetAngle) {
  this.targetAngle = targetAngle;
}

 @Override
 public void periodic() {
   motor.set(TalonFXControlMode.PercentOutput, motorPower);
   
 }
}