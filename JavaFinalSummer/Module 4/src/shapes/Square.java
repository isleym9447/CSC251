package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Square implements Shape2D {
    private double side;

    public Square() {}

    public Square(double side) {
        this.side = side;
    }

    public void setSide(double s) {
        if (s <= 0) throw new IllegalArgumentException("s must be greater than 0.");
        this.side = s;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/squarePic.PNG"));
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
