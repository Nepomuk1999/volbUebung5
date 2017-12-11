import com.cyberbotics.webots.controller.Accelerometer;
import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

public class UltimateBallTerminator extends DifferentialWheels {

    private int TIME_STEP = 15;
    private AccelerometerHandler accelerometerHandler;
    private CameraHandler cameraHandler;
    private DistanceHandler distanceHandler;

    public UltimateBallTerminator() {
        accelerometerHandler = new AccelerometerHandler(this);
        cameraHandler = new CameraHandler(this);
        distanceHandler = new DistanceHandler(this);
    }

    private void run() {
        while (step(TIME_STEP) != -1) {
            //muss gestoppt werden: Ball an der Wan
            if (!accelerometerHandler.isBallAtWall()) {

            }
            //Wird ausgeführt wenn Ball erreicht ist
            if (cameraHandler.ballInFront() && distanceHandler.ballReached()) {

            }
            //Wird ausgeführt wenn Ball nicht erreicht aber gefunden ist
            if (cameraHandler.ballInFront() && !distanceHandler.ballReached()) {

            }
            //Wirdimmer uasgeführt: Ball suchen


        }
    }


    public static void main(String[] args) {
        UltimateBallTerminator controller = new UltimateBallTerminator();
        controller.run();
    }


}
