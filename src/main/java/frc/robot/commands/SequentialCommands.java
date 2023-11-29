// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;
import frc.robot.Commands.WristCommand;
import frc.robot.subsystems.WristSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class SequentialCommands extends SequentialCommandGroup {
  /** Creates a new TestCommand. */
  public SequentialCommands(WristSubsystem wristSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addCommands(
    new WristCommand(wristSubsystem, 0),
    new WristCommand(wristSubsystem, 20),
    new WristCommand(wristSubsystem, 40)
    );
  }

  // // Called when the command is initially scheduled.
  // @Override
  // public void initialize() {}

  // // Called every time the scheduler runs while the command is scheduled.
  // @Override
  // public void execute() {}

  // // Called once the command ends or is interrupted.
  // @Override
  // public void end(boolean interrupted) {}

  // // Returns true when the command should end.
  // @Override
  // public boolean isFinished() {
  //   return false;
  // }
}
