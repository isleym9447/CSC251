package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RightCircularCylinder implements Shape3D {
    private double radius, height;

    public RightCircularCylinder() {}

    public RightCircularCylinder(double r, double h) {
        this.radius = r;
        this.height = h;
    }

    public void setDimensions(double r, double h) {
        if (r <= 0) throw new IllegalArgumentException("r must be greater than 0.");
        if (h <= 0) throw new IllegalArgumentException("h must be greater than 0.");
        this.radius = r;
        this.height = h;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "Right Circular Cylinder";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/rightCircCylPic.PNG"));
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
