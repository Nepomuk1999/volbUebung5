package janbangbang;

import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.DifferentialWheels;

public class CameraHandler {

    private Camera _camera;
    private int red;
    private int green;
    private int blue;

    public CameraHandler(DifferentialWheels differentialWheels) {
        _camera = differentialWheels.getCamera("camera");
        _camera.enable(10);
    }


    public boolean ballInFront() {
        //Prüfen ob der mittlere Pixel Rot ist
        int[] image = _camera.getImage();
        int pixel = image[(image.length/2)];
        int red = Camera.pixelGetRed(pixel);
        int green = Camera.pixelGetGreen(pixel);
        int blue = Camera.pixelGetBlue(pixel);
        int gray = Camera.pixelGetGray(pixel);
        
        //System.out.println("red: " + red + " green: " + green + " blue: " + blue);
        //System.out.println("gray: " + gray);
        if (gray < 90) {
            return true;
        } else {
            return false;
        }
    }
    

    public void driveToBall() {
        int[] image = _camera.getImage();

    }
}
