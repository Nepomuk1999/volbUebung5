import com.cyberbotics.webots.controller.DifferentialWheels;

public class BallanceBallHandler {

    private UltimateBallTerminator _robot;
    private DistanceHandler _distanceHandler;
    private static int S_FRONT_LEFT = 0; // Sensor front left
    private static int S_FRONT_RIGHT = 1; // Sensor front right
    private static int SENSOR_VALUE = 1900;

    public BallanceBallHandler(UltimateBallTerminator ultimateBallTerminator, DistanceHandler distanceHandler) {
        _robot = ultimateBallTerminator;
        _distanceHandler = distanceHandler;
    }

    public void balanceBallTowardsWall() {
        double[] distances = _distanceHandler.getDistanceValues();
        if (distances[S_FRONT_LEFT] < SENSOR_VALUE && distances[S_FRONT_RIGHT] < SENSOR_VALUE) {
            _robot.driveForward();
            System.out.println("Forward");
        } else if (distances[S_FRONT_LEFT] < distances[S_FRONT_RIGHT]) {
            _robot.driveRight();
            System.out.println("Right");
        } else {
            _robot.driveLeft();
            System.out.println("Left");
        }
    }
}
