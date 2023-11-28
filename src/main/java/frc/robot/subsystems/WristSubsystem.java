// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class WristSubsystem extends SubsystemBase {
 /** Creates a new ExampleSubsystem. */
 private TalonFX left_motor;
 /** leader */
 private TalonFX right_motor;
 private PIDController pidController;
 private final ShuffleboardTab ElevatorTab = Shuffleboard.getTab("Elevator");


 private double targetHeight;
 private double motorPower;
  public WristSubsystem() {









 }
 
 @Override
 public void periodic() {
   
 }


 @Override
 public void simulationPeriodic() {
   // This method will be called once per scheduler run during simulation
   }
 }