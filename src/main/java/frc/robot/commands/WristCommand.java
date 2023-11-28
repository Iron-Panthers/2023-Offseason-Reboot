// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WristSubsystem;

public class WristCommand extends CommandBase {
  /** Creates a new WristCommand. */
  private final WristSubsystem wristSubsystem;

  private double targetAngle;

  public WristCommand(WristSubsystem wristSubsystem, double targetAngle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.wristSubsystem = wristSubsystem;
    this.targetAngle = targetAngle;

    addRequirements(wristSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // sets target angle
    wristSubsystem.setTargetAngle(targetAngle);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}