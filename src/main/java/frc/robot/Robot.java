package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Robot extends TimedRobot {

  private JoystickDriver joystickDriver; // Contains joystick objects and joystick
  private XboxDriver xboxDriver; // cotrol xbox

  private TalonSRX leftDrive;   // Talon object
  private TalonSRX rightDrive;  // Talon object
  private VictorSPX leftSlave;  // Talon object
  private VictorSPX rightSlave; // Talon object

  public static final int rightMasterId = 0; // Talon ID
  public static final int rightSlaveId = 1;  // Talon ID
  public static final int leftMasterId =  2;  // Talon ID
  public static final int leftSlaveId =  3;  // Talon ID

  public Robot() {
    //joystickController = new JoystickController(0, 1);
    xboxDriver = new XboxDriver(0);

    leftDrive = new TalonSRX(leftMasterId);
    rightDrive = new TalonSRX(rightMasterId);
    leftSlave = new VictorSPX(leftSlaveId);
    rightSlave = new VictorSPX(rightSlaveId);

    leftSlave.follow(leftDrive);
    rightSlave.follow(rightDrive);

    leftDrive.setInverted(true);
    leftSlave.setInverted(true);

  }
  
  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {
 
  }

  @Override
  public void teleopInit() {}

  public void openLoop(double left, double right) {
    leftDrive.set(ControlMode.PercentOutput, left);
    rightDrive.set(ControlMode.PercentOutput, right);
  }

  public void tankDrive() {
    
    rightDrive.set(ControlMode.PercentOutput, joystickDriver.getRightY());
    leftDrive.set(ControlMode.PercentOutput, joystickDriver.getLeftY());
  }

  public void arcadeDrive(double throttle, double steer) {
    double throttleVal = Math.abs(throttle) > 0.1 ? throttle : 0;
    double steerVal = Math.abs(steer) > 0.1 ? steer : 0; 

    openLoop(throttleVal + steerVal, throttleVal - steerVal);
  }
   
  @Override
  public void teleopPeriodic() {
    xboxDriver.update();

    arcadeDrive(xboxDriver.getLeftY(), xboxDriver.getRightX());
  }

  @Override
  public void disabledInit() {
    openLoop(0.0, 0.0);
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

}
