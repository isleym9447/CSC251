package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Circle implements Shape2D {
    private double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double r) {
        if (r <= 0) throw new IllegalArgumentException("r must be greater than 0.");
        this.radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/circlePic.PNG"));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Map<String, Double> calculate() {
        Map<String, Double> result = new HashMap<>();
        result.put("Area", getArea());
        result.put("Circumference", getPerimeter());
        return result;
    }
}
