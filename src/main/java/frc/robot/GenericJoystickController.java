package frc.robot;

public interface GenericJoystickController {
    void update();

    double getLeftX();

    double getLeftY();

    double getRightX();

    double getRightY();
}