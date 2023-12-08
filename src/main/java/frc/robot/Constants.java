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

    public static final double UNLOADING_WAIT_TIME = 2f;
  }

  public final class Wrist {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int WRIST_MOTOR_DEVICE_NUMBER = 16;
    public static final double TICKS = 2048;
    public static final double DEGREES = 360;
    public static final double GEAR_RATIO = 128;
    public static final double DOWN_STATOR_LIMIT = 70;
    public static final double DEFAULT_SPEED = 0.2;
  }
}
