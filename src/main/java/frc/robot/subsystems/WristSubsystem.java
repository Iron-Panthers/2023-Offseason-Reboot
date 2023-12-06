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
import frc.robot.Constants.Wrist;


public class WristSubsystem extends SubsystemBase {
 /** Creates a new ExampleSubsystem. */
 private TalonFX motor;
 /** leader */
 private PIDController pidController;
 private final ShuffleboardTab WristTab = Shuffleboard.getTab("Elevator");


 private double targetAngle;
 private double motorPower;
 private double currentAngle;
 
 
 //creates the WristSubsystem 
  public WristSubsystem() {
    motor = new TalonFX(16);
    motorPower = 0;
    targetAngle = 0; //sets the "targetAngle" variable to 0 by default
    currentAngle = 0; //sets the current height that you are at to 0 by defualt


    //creates the new PID :) WOOHOOOO
    pidController = new PIDController(0.1, 0, 0);


    //
    WristTab.addNumber("Current Motor Power", () -> motorPower);  
    WristTab.addNumber("Target Angle", () -> this.targetAngle);
    WristTab.addNumber("Current Angle", () -> this.currentAngle);
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

//periodic every 20ms it does this stuff...
 @Override
 public void periodic() {
    currentAngle = this.ticksToInches(motor.getSelectedSensorPosition());
    motorPower = pidController.calculate(currentAngle); //calculates the motor power based on the PID?
    motor.set(TalonFXControlMode.PercentOutput, motorPower); 
    // ^ basically makes it so whatever the motor power is it actually moves the motor :0 

 }
}