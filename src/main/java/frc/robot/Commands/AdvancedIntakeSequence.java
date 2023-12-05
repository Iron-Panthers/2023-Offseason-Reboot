// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.Subsystems.IntakeSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AdvancedIntakeSequence extends SequentialCommandGroup {
  /** Creates a new AdvancedIntakeSequence. */
  public AdvancedIntakeSequence(IntakeSubsystem intakeSubsystem, boolean isCone, boolean isIntake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    if (isIntake) {
      addCommands(
          new IntakeCommand(intakeSubsystem, isCone, isIntake),
          new StopIntakeMotorCommand(intakeSubsystem));
    } else {
      addCommands(
          new IntakeCommand(intakeSubsystem, isCone, isIntake)
              .withTimeout(Constants.Intake.UNLOADING_WAIT_TIME),
          new StopIntakeMotorCommand(intakeSubsystem));
    }
  }
}
