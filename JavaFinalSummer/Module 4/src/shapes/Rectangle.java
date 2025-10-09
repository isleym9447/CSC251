package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rectangle implements Shape2D {
    private double length, width;

    public Rectangle() {}

    public Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    public void setDimensions(double l, double w) {
        if (l <= 0) throw new IllegalArgumentException("l must be greater than 0.");
        if (w <= 0) throw new IllegalArgumentException("w must be greater than 0.");
        this.length = l;
        this.width = w;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/rectanglePic.PNG"));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Map<String, Double> calculate() {
        Map<String, Double> result = new HashMap<>();
        result.put("Area", getArea());
        result.put("Perimeter", getPerimeter());
        return result;
    }
}
