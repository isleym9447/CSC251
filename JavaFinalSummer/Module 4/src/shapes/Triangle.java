package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Triangle implements Shape2D {
    private double a, b, c;

    public Triangle() {}

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setSides(double a, double b, double c) {
        if (a <= 0) throw new IllegalArgumentException("a must be greater than 0.");
        if (b <= 0) throw new IllegalArgumentException("b must be greater than 0.");
        if (c <= 0) throw new IllegalArgumentException("c must be greater than 0.");
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("The sum of any two sides must be greater than the third.");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/Triangle2.PNG"));
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
