// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //hi
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to do things as the drivers gain control of the robot. We use it to vibrate the
   * driver b controller to notice accidental swaps.
   *
   * <p>Please use this very, very sparingly. It doesn't exist by default for good reason.
   */
  public void containerTeleopInit() {
    // runs when teleop happens
  }

  /**
   * Use this method to do things as soon as the robot starts being used. We use it to stop doing
   * things that could be harmful or undesirable during game play--rebooting the network switch is a
   * good example. Subsystems need to be explicitly wired up to this method.
   *
   * <p>Depending on which mode the robot is enabled in, this will either be called before auto or
   * before teleop, whichever is first.
   *
   * <p>Please use this very, very sparingly. It doesn't exist by default for good reason.
   */
  public void containerMatchStarting() {
    // runs when the match starts
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }
}
