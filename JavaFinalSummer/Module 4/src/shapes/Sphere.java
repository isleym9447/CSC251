package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Sphere implements Shape3D {
    private double radius;

    public Sphere() {}

    public Sphere(double radius) {
        this.radius = radius;
    }

    public void setRadius(double r) {
        if (r <= 0) throw new IllegalArgumentException("r must be greater than 0.");
        this.radius = r;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "Sphere";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/spherePic.PNG"));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Map<String, Double> calculate() {
        Map<String, Double> result = new HashMap<>();
        result.put("Volume", getVolume());
        result.put("Surface Area", getSurfaceArea());
        return result;
    }
}
