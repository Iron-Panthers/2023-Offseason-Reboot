// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands;
import frc.robot.subsystems.WristSubsystem;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class WristCommand extends CommandBase {
 @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
 private final WristSubsystem wristSubsystem;
private double targetAngle;
/* 
  * Creates a new ExampleCommand.
  *
  * @param subsystem The subsystem used by this command.
  */
 public WristCommand(WristSubsystem wristSubsystem, double targetAngle) {
   this.wristSubsystem = wristSubsystem;
   this.targetAngle = targetAngle;
   // Use addRequirements() here to declare subsystem dependencies.
   addRequirements(wristSubsystem);
 }


 // Called when the command is initially scheduled.
 @Override
 public void initialize() {}


 // Called every time the scheduler runs while the command is scheduled.
 @Override
 public void execute() {
  wristSubsystem.setTargetAngle(targetAngle); //update the targetAngle here based on the controls in Robot Container


 }


 // Called once the command ends or is interrupted.
 @Override
 public void end(boolean interrupted) {}


 // Returns true when the command should end.
 @Override
 public boolean isFinished() {
   return false;
 }
}