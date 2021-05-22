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

  private JoystickController joystickController; // Contains joystick objects and joystick values

  private TalonSRX leftDrive;   // Talon object
  private TalonSRX rightDrive;  // Talon object
  private VictorSPX leftSlave;  // Talon object
  private VictorSPX rightSlave; // Talon object

  public static final int rightMasterId = 0; // Talon ID
  public static final int rightSlaveId = 1;  // Talon ID
  public static final int leftMasterId =  2;  // Talon ID
  public static final int leftSlaveId =  3;  // Talon ID

  public Robot() {
    joystickController = new JoystickController(0, 1);

    leftDrive = new TalonSRX(leftMasterId);
    rightDrive = new TalonSRX(rightMasterId);
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
    joystickController.update();

    rightDrive.set(ControlMode.PercentOutput, joystickController.getRightY());
    leftDrive.set(ControlMode.PercentOutput, joystickController.getLeftY());
  }

  @Override
  public void disabledInit() {
    rightDrive.set(ControlMode.PercentOutput, 0.0);
    leftDrive.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  public static class JoystickController {
    private Joystick leftJoystick;
    private Joystick rightJoystick;

    private double[] leftVec = new double[2];
    private double[] rightVec = new double[2];

    public JoystickController(int leftId, int rightId) {
      leftJoystick = new Joystick(leftId);
      rightJoystick = new Joystick(rightId);
    }

    public void update() {
      leftVec[0] = leftJoystick.getX();
      leftVec[1] = leftJoystick.getY();

      rightVec[0] = rightJoystick.getX();
      rightVec[1] = rightJoystick.getY();
    }

    public double getLeftX() {
      return leftVec[0];
    }

    public double getLeftY() {
      return leftVec[1];
    }

    public double getRightX() {
      return rightVec[0];
    }

    public double getRightY() {
      return rightVec[1];
    }
  }
}
