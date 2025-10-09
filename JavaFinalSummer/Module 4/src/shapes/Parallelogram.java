package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Parallelogram implements Shape2D {
    private double base, height, side;

    public Parallelogram() {}

    public Parallelogram(double b, double h, double s) {
        this.base = b;
        this.height = h;
        this.side = s;
    }

    public void setDimensions(double b, double h, double s) {
        if (b <= 0) throw new IllegalArgumentException("b must be greater than 0.");
        if (h <= 0) throw new IllegalArgumentException("h must be greater than 0.");
        if (s <= 0) throw new IllegalArgumentException("s must be greater than 0.");
        this.base = b;
        this.height = h;
        this.side = s;
    }

    @Override
    public double getArea() {
        return base * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (base + side);
    }

    @Override
    public String getName() {
        return "Parallelogram";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/parallelogramPic_2.PNG"));
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
