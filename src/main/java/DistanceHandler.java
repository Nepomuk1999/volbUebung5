import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

public class DistanceHandler {

    private DistanceSensor[] _distanceSensors;

    public DistanceHandler(DifferentialWheels differentialWheels) {
        _distanceSensors = new DistanceSensor[]{differentialWheels.getDistanceSensor("ps7"),
                differentialWheels.getDistanceSensor("ps0")};
        for (DistanceSensor ds : _distanceSensors) {
            ds.enable(10);
        }
    }


    public boolean ballReached() {
        if (_distanceSensors[0].getValue() > 100 && _distanceSensors[1].getValue() > 100) {
            return true;
        }
        return false;
    }
}
