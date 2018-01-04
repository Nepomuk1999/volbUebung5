package janproportional;

import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

public class DistanceHandler {

    private DistanceSensor[] _distanceSensors;
    private static int S_FRONT_LEFT = 0; // Sensor front left
    private static int S_FRONT_RIGHT = 1; // Sensor front right

    public DistanceHandler(DifferentialWheels differentialWheels) {
        _distanceSensors = new DistanceSensor[]{differentialWheels.getDistanceSensor("ps7"), differentialWheels.getDistanceSensor("ps0"), 
        differentialWheels.getDistanceSensor("ps2"), differentialWheels.getDistanceSensor("ps3"),
        differentialWheels.getDistanceSensor("ps4"), differentialWheels.getDistanceSensor("ps5")};
        for (DistanceSensor ds : _distanceSensors) {
            ds.enable(10);
        }
    }


    public boolean ballReached() {
        if (_distanceSensors[S_FRONT_LEFT].getValue() > 100 || _distanceSensors[S_FRONT_RIGHT].getValue() > 100) {
            //System.out.println("Left: " + _distanceSensors[S_FRONT_LEFT].getValue() + "Right: " + _distanceSensors[S_FRONT_RIGHT].getValue());
            return true;
        }
        //System.out.println("Left: " + _distanceSensors[S_FRONT_LEFT].getValue() + "Right: " + _distanceSensors[S_FRONT_RIGHT].getValue());
        return false;
    }

    public double[] getDistanceValues() {
        return new double[]{_distanceSensors[0].getValue(), _distanceSensors[1].getValue(), _distanceSensors[2].getValue()
        , _distanceSensors[3].getValue(), _distanceSensors[4].getValue(), _distanceSensors[5].getValue()};
    }
}
