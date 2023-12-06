// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {

  IntakeSubsystem intakeSubsystem;
  boolean isCone; // wheather or not your dealing with a cone or a cube
  boolean isIntake; // if its intake or outtake

  /** Creates a new LoadCube. */
  public IntakeCommand(IntakeSubsystem intakeSubsystem, boolean isCone, boolean isIntake) {
    this.intakeSubsystem = intakeSubsystem;
    this.isCone = isCone;
    this.isIntake = isIntake;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (isCone && isIntake) {
      intakeSubsystem.SetMotorPower(Constants.Intake.CONE_LOADING_SPEED);
    } else if (!isCone && isIntake) {
      intakeSubsystem.SetMotorPower(Constants.Intake.CUBE_LOADING_SPEED);
    } else if (isCone && !isIntake) {
      intakeSubsystem.SetMotorPower(Constants.Intake.CONE_UNLOADING_SPEED);
    } else if (!isCone && !isIntake) {
      intakeSubsystem.SetMotorPower(Constants.Intake.CUBE_UNLOADING_SPEED);
    }

    // set the object type - used in the stoter currents
    intakeSubsystem.SetObjectType(isCone);
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
    return intakeSubsystem.IsLoaded();
  }
}
