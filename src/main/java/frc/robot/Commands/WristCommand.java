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
private DoubleSupplier speedSupplier;
 /**
  * Creates a new ExampleCommand.
  *
  * @param subsystem The subsystem used by this command.
  */
 public WristCommand(WristSubsystem wristSubsystem, DoubleSupplier speedSupplier) {
   this.wristSubsystem = wristSubsystem;
   this.speedSupplier = speedSupplier;
   // Use addRequirements() here to declare subsystem dependencies.
   addRequirements(wristSubsystem);
 }


 // Called when the command is initially scheduled.
 @Override
 public void initialize() {}


 // Called every time the scheduler runs while the command is scheduled.
 @Override
 public void execute() {
  wristSubsystem.setTargetAngle(50); //update the targetAngle here 


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