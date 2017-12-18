package jan;

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
    
    private boolean Wall;

    public UltimateBallTerminator() {
        accelerometerHandler = new AccelerometerHandler(this);
        cameraHandler = new CameraHandler(this);
        distanceHandler = new DistanceHandler(this);
        ballanceBallHandler = new BallanceBallHandler(this, distanceHandler);
        Wall = false;
    }

    private void run() {
        while (step(TIME_STEP) != -1) {
            //wenn
            //System.out.println("WALL: " + Wall);
            if(Wall == true){
              //System.out.println(cameraHandler.ballInFront());
              if(false == cameraHandler.ballInFront()){
                Wall = false;
              }
              turnAway();
            }
            //muss gestoppt werden: Ball an der Wand
            if (accelerometerHandler.isBallAtWall() && cameraHandler.ballInFront()) {
                System.out.println("Zurück");
                driveBack();  
                Wall = true;
            } 
            //Wird ausgeführt wenn Ball erreicht ist
            if (Wall == false && distanceHandler.ballReached()) {
                System.out.println("Balance");
                ballanceBallHandler.balanceBallTowardsWall(); 
            }
            if( Wall == false && !distanceHandler.ballReached()){
                System.out.println("to Ball");
                driveForward();
            }
            if(Wall == false && !cameraHandler.ballInFront() && !distanceHandler.ballReached()){
                System.out.println("find ball");
                findNextBall(); 
            }
        }
    }

    private void findNextBall() {
        setSpeed(-TURNSPEED, TURNSPEED);
    }
   
   private void turnAway(){
         setSpeed(-TURNSPEED, TURNSPEED);
   }
    public void driveForward() {
        setSpeed(MAXSPEED, MAXSPEED);
    }
    
    public void driveBack() {
          setSpeed(-MAXSPEED, -MAXSPEED);  
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
