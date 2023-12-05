package frc.robot;
import frc.robot.commands.ElevatorBaseCommand;
import frc.robot.commands.WristCommand;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.WristSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


/**
* This class is where the bulk of the robot should be declared. Since Command-based is a
* "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
* periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
* subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
 // The robot's subsystems and commands are defined here...
 private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
 private final WristSubsystem wristSubsystem = new WristSubsystem();


 private final CommandXboxController driverA = new CommandXboxController(0);
 private double targetHeight;


 /** The container for the robot. Contains subsystems, OI devices, and commands. */
 public RobotContainer() {


   double[] levels = {5d,10d,17d,8d,4d,7d,1d};


   for(double i :levels){
     targetHeight = i;
   }


   // Configure the button bindings
   configureButtonBindings();
  }


 /**
  * Use this method to define your button->command mappings. Buttons can be created by
  * instantiating a {@link GenericHID} or one of its subclasses ({@link
  * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
  * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
  */

  // Adds the button bindings and controls for the controller >:D so you can control what angle the wrist goes to 
 private void configureButtonBindings() {
   driverA.a().onTrue(new WristCommand(wristSubsystem, 25));
   driverA.x().onTrue(new WristCommand(wristSubsystem, 45));
   driverA.y().onTrue(new WristCommand(wristSubsystem, 65));
   driverA.b().onTrue(new WristCommand(wristSubsystem, 90));
 }

 /**
  * Use this to pass the autonomous command to the main {@link Robot} class.
  *
  * @return the command to run in autonomous
  */
 public Command getAutonomousCommand() {
   // An ExampleCommand will run in autonomous
   return new InstantCommand();
 }
}


