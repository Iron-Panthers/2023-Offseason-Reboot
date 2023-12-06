// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeSequentailCommands extends SequentialCommandGroup{

  private final IntakeSubsystem subsystem;

  /** Creates a new IntakeCommand. */
  public IntakeSequentailCommands(IntakeSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subsystem = subsystem;

    addRequirements(subsystem);

    addCommands(
      new IntakeCommand(subsystem), 
    new OutakeCommand(subsystem)
    );

  }
}
