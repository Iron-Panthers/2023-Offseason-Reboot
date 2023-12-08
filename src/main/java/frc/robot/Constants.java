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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class Elevator {
    /** the gear ratio of the motor to the final gear revolutions */
    public static final double GEAR_RATIO = 0.1008;
    /** The number of ticks per motor revolution */
    public static final double TICKS_PER_REVOLUTION = 2048;
    /** The gear circumferance for distance */
    public static final double GEAR_CIRCUMFERENCE = 1.432 * Math.PI;
  }
  public final class Wrist {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int WRIST_MOTOR_DEVICE_NUMBER = 16;
    public static final double TICKS = 2048;
    public static final double DEGREES = 360;
    public static final double GEAR_RATIO = 0.061;
  }
  public final class Intake {
    public static final int MOTOR_PORT = 18;
    
  }
}

