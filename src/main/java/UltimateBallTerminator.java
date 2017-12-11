import com.cyberbotics.webots.controller.Accelerometer;
import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

public class UltimateBallTerminator extends DifferentialWheels {

    private int TIME_STEP = 15;
    private AccelerometerHandler accelerometerHandler;
    private CameraHandler cameraHandler;
    private DistanceHandler distanceHandler;
    private BallanceBallHandler ballanceBallHandler;

    private double MAXSPEED = 1000;
    private double MINSPEED = 0;
    private double TURNSPEED = 500;

    public UltimateBallTerminator() {
        accelerometerHandler = new AccelerometerHandler(this);
        cameraHandler = new CameraHandler(this);
        distanceHandler = new DistanceHandler(this);
        ballanceBallHandler = new BallanceBallHandler(this, distanceHandler);
    }

    private void run() {
        while (step(TIME_STEP) != -1) {
            //muss gestoppt werden: Ball an der Wand
            if (!accelerometerHandler.isBallAtWall()) {
                findNextBall();
            }
            //Wird ausgeführt wenn Ball erreicht ist
            if (cameraHandler.ballInFront() && distanceHandler.ballReached()) {
                ballanceBallHandler.balanceBallTowardsWall();
            }
            //Wird ausgeführt wenn Ball nicht erreicht aber gefunden ist
            if (cameraHandler.ballInFront() && !distanceHandler.ballReached()) {

            }
            //Wirdimmer uasgeführt: Ball suchen
            findNextBall();
        }
    }

    private void ballanceBallTowadsWall() {
    }

    private void findNextBall() {
        while (!cameraHandler.ballInFront()) {
            setSpeed(MINSPEED, TURNSPEED);
        }
    }

    public void driveForward() {
        setSpeed(MAXSPEED, MAXSPEED);
    }

    public void driveLeft() {
        setSpeed(TURNSPEED, MAXSPEED);
    }

    public void driveRight() {
        setSpeed(MAXSPEED, TURNSPEED);
    }


    public static void main(String[] args) {
        UltimateBallTerminator controller = new UltimateBallTerminator();
        controller.run();
    }


}
