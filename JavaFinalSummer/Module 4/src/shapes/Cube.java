package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Cube implements Shape3D {
    private double side;

    public Cube() {}

    public Cube(double side) {
        this.side = side;
    }

    public void setSide(double s) {
        if (s <= 0) throw new IllegalArgumentException("s must be greater than 0.");
        this.side = s;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getSurfaceArea() {
        return 6 * side * side;
    }

    @Override
    public String getName() {
        return "Cube";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/cubePic.PNG"));
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
