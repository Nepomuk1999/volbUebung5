import com.cyberbotics.webots.controller.Accelerometer;
import com.cyberbotics.webots.controller.DifferentialWheels;

public class AccelerometerHandler {

    private Accelerometer _accelerometer;
    double[] previousAccValues;
    private static final int ACC_DEVIATION = 10;

    public AccelerometerHandler(DifferentialWheels differentialWheels) {
        _accelerometer = differentialWheels.getAccelerometer("accelerometer");
        _accelerometer.enable(10);
        previousAccValues = new double[]{0.0, 0.0, 0.0};
    }

    public boolean isBallAtWall() {
        boolean ballatWall = false;
        double[] values = _accelerometer.getValues();
        if (isBetween(values[0], previousAccValues[0], ACC_DEVIATION)) {
            if (isBetween(values[1], previousAccValues[1], ACC_DEVIATION)) {
                ballatWall = true;
            }
        }
        previousAccValues = values;
        return ballatWall;
    }

    private boolean isBetween(double value, double previousAccValue, int accDeviation) {
        if ((value == previousAccValue) ||
                (value <= previousAccValue + 10 && value >= previousAccValue - 10)) {
            return true;
        }
        return false;
    }
}
