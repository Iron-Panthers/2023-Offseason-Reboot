import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;


/**
* This class is where the bulk of the robot should be declared. Since Command-based is a
* "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
* periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
* subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
 // The robot's subsystems and commands are defined here...
 private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    // Configure the button bindings
    configureButtonBindings();
  }

 private final ElevatorBaseCommand ElevatorBaseCommand = new ElevatorBaseCommand(elevatorSubsystem);
private final ManualArmCommand ManualArmCommand = new ManualArmCommand(elevatorSubsystem);


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
   driverA.y().onTrue(new ElevatorBaseCommand(elevatorSubsystem, 20));
   driverA.x().onTrue(new ElevatorBaseCommand(elevatorSubsystem, 15d));
   driverA.b().onTrue(new ElevatorBaseCommand(elevatorSubsystem, 10d));
   driverA.a().onTrue(new ElevatorBaseCommand(elevatorSubsystem, 3d));
 }


 /**
  * Use this method to define your button->command mappings. Buttons can be created by
  * instantiating a {@link GenericHID} or one of its subclasses ({@link
  * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
  * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
  */
 private void configureButtonBindings() {}


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


