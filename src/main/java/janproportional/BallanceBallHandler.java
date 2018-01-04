package janproportional;

import com.cyberbotics.webots.controller.DifferentialWheels;

public class BallanceBallHandler {
    private UltimateBallTerminator _robot;
    private DistanceHandler _distanceHandler;
    private double speedLeft = 0;
    private double speedRight = 0;
    double[][] k = {{1, 1},{0.2, 0.2},{0.4, 0.4}};
    private double maxspeed = 1000;

    public BallanceBallHandler(UltimateBallTerminator ultimateBallTerminator, DistanceHandler distanceHandler) {
        _robot = ultimateBallTerminator;
        _distanceHandler = distanceHandler;
    }

    public void balanceBallTowardsWall() {
        double[] distances = _distanceHandler.getDistanceValues();        
        evaluateSpeed(distances);
        speedLeft = 400 + speedLeft;
        speedRight = 400 + speedRight;
        if(speedLeft > maxspeed){
           speedLeft = maxspeed;
        }
        if(speedRight > maxspeed){
           speedRight = maxspeed;
        }
        _robot.drive(speedLeft, speedRight);   
    }
    
    public void evaluateSpeed(double[] distances) {
        speedLeft = k[0][1] * distances[1] + k[1][1] * distances[2]  + k[2][1] * distances[3];
        speedRight = k[0][0] * distances[0]  + k[1][0] * distances[5]  + k[2][0] * distances[4];
        //System.out.println("speedLeft" + speedLeft);
        //System.out.println("speedRight" + speedRight);   
    }
}
