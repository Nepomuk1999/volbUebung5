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
        System.out.println("0: " + values[0] + " _______ 1: " + values[1] + " ______ 2: " + values[2]);
        if(values[1] > 8 || values[1] < -8 || values[0] > 1.4 || values[0] < -1.4 || (values[0] > 0.1 && values[1] < -5) ){
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
