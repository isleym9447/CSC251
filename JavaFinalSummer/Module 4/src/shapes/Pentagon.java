package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Pentagon implements Shape2D {
    private double side, apothem;

    public Pentagon() {}

    public Pentagon(double side, double apothem) {
        this.side = side;
        this.apothem = apothem;
    }

    public void setDimensions(double side, double apothem) {
        if (side <= 0) throw new IllegalArgumentException("side must be greater than 0.");
        if (apothem <= 0) throw new IllegalArgumentException("apothem must be greater than 0.");
        this.side = side;
        this.apothem = apothem;
    }

    @Override
    public double getArea() {
        return (5.0 / 2.0) * side * apothem;
    }

    @Override
    public double getPerimeter() {
        return 5 * side;
    }

    @Override
    public String getName() {
        return "Pentagon";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/Pentagon.PNG"));
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
