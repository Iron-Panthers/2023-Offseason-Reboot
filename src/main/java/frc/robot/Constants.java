// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

@SuppressWarnings("java:S1118")
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class Intake {

    public static final int INTAKE_MOTOR_NUMBER = 18;

    public static final double CUBE_LOADING_SPEED = .5d;
    public static final double CONE_LOADING_SPEED = -.5d;

    public static final double CUBE_UNLOADING_SPEED = -.5d;
    public static final double CONE_UNLOADING_SPEED = .5d;

    public static final double CUBE_STATOR_LIMIT = 90;
    public static final double CONE_STATOR_LIMIT = 70;
  }

  public static class Elevator{
    public static final double ELEVATOR_GEAR_RATIO = 0.1008;

    private static final double CARRIAGE_RATIO = 2;

    private static final double ELEVATOR_SPROCKET_DIAMETER_INCHES = 1.432;

    private static final double FALCON_CPR = 2048;

    /**number of ticks per motor revolution */
    public static final double TICKS = 2048;
    //tciks per revoultion
    public static final double GEAR_CIRCUMFERENCE = 1.432* Math.PI;

  }
}
