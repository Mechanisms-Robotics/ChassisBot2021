package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Robot extends TimedRobot {

  private Joystick leftJoystick;  // Left joystick object
  private Joystick rightJoystick; // Right joystick object

  private TalonSRX leftDrive;   // Talon object
  private TalonSRX rightDrive;  // Talon object
  private VictorSPX leftSlave;  // Talon object
  private VictorSPX rightSlave; // Talon object

  public static final int rightTalonId = 2; // Talon ID
  public static final int leftTalonId =  0;  // Talon ID
  public static final int leftSlaveId =  1;  // Talon ID
  public static final int rightSlaveId = 3;  // Talon ID

  private double[] rightJoystickVec = new double[2];
  private double[] leftJoystickVec = new double[2];

  public Robot() {
    leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);

    leftDrive = new TalonSRX(leftTalonId);
    rightDrive = new TalonSRX(rightTalonId);
    leftSlave = new VictorSPX(leftSlaveId);
    rightSlave = new VictorSPX(rightSlaveId);

    leftSlave.follow(leftDrive);
    rightSlave.follow(rightDrive);

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

  @Override
  public void teleopPeriodic() {
    updateJoysticks();

    rightDrive.set(ControlMode.Velocity, rightJoystickVec[1]);
    leftDrive.set(ControlMode.Velocity, leftJoystickVec[1]);
  }

  @Override
  public void disabledInit() {
    rightDrive.set(ControlMode.Velocity, 0.0);
    leftDrive.set(ControlMode.Velocity, 0.0);
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  public void updateJoysticks() {
    leftJoystickVec[0] = leftJoystick.getX();
    leftJoystickVec[1] = leftJoystick.getY();

    rightJoystickVec[0] = rightJoystick.getX();
    rightJoystickVec[1] = rightJoystick.getY();
  }

  public double[] getLeftJoystick() {
    return leftJoystickVec;
  }

  public double[] getRightJoystick() {
    return rightJoystickVec;
  }
}
