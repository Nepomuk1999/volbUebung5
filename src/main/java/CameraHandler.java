import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.DifferentialWheels;

public class CameraHandler {

    private Camera _camera;

    public CameraHandler(DifferentialWheels differentialWheels) {
        _camera = differentialWheels.getCamera("camera");
        _camera.enable(10);
    }


    public boolean ballInFront() {
        //Prüfen ob der mittlere Pixel Rot ist
        int[] image = _camera.getImage();
        int red = _camera.imageGetRed(image, _camera.getWidth(), _camera.getWidth() / 2, _camera.getHeight() / 2);
        int green = _camera.imageGetGreen(image, _camera.getWidth(), _camera.getWidth() / 2, _camera.getHeight() / 2);
        int blue = _camera.imageGetBlue(image, _camera.getWidth(), _camera.getWidth() / 2, _camera.getHeight() / 2);
        System.out.println("red: " + red);
        System.out.println("green: " + green);
        System.out.println("blue: " + blue);
        if (red >= 180 && green < 100 && blue < 100) {
            return true;
        } else {
            return false;
        }
    }

    public void driveToBall() {
        int[] image = _camera.getImage();

    }
}
