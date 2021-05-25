package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.GenericJoystickController;

public class XboxDriver implements GenericJoystickController {
    private XboxController x;

    private double[] leftVec = new double[2];
    private double[] rightVec = new double[2];

    public XboxDriver(int port) {
      x = new XboxController(port);
    }

    public void update() {
      leftVec[0] = x.getRawAxis(0);
      leftVec[1] = x.getRawAxis(1);

      rightVec[0] = -x.getRawAxis(4);
      rightVec[1] = x.getRawAxis(5);
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