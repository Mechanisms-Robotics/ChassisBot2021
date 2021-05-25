package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.GenericJoystickController;

public class JoystickDriver implements GenericJoystickController {
    private Joystick leftJoystick;
    private Joystick rightJoystick;

    private double[] leftVec = new double[2];
    private double[] rightVec = new double[2];

    public JoystickDriver(int leftId, int rightId) {
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