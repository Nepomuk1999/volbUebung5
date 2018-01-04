package janproportional;

import com.cyberbotics.webots.controller.Accelerometer;
import com.cyberbotics.webots.controller.DifferentialWheels;

public class AccelerometerHandler {

    private Accelerometer _accelerometer;
    double[] previousAccValues;
    private static final int ACC_DEVIATION = 0;

    public AccelerometerHandler(DifferentialWheels differentialWheels) {
        _accelerometer = differentialWheels.getAccelerometer("accelerometer");
        _accelerometer.enable(10);
        previousAccValues = new double[]{0.0, 0.0, 0.0};
    }

    public boolean isBallAtWall() {
        boolean ballatWall = false;
        double[] values = _accelerometer.getValues();
        //System.out.println(values.length);
        //System.out.println("1: " +values[0]);
        System.out.println("2: " +values[1]);
        //System.out.println("3: " +values[2]);
        if(values[1] > 7.5 || values[1] < -7.5){
        return true;
        }
        return false;
    }

    private boolean isBetween(double value, double previousAccValue, int accDeviation) {
        if ((value == previousAccValue) ||
                (value <= previousAccValue + 10 && value >= previousAccValue - 10)) {
            return true;
        }
        return false;
    }
}
