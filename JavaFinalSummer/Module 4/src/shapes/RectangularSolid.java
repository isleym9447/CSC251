package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RectangularSolid implements Shape3D {
    private double length, width, height;

    public RectangularSolid() {}

    public RectangularSolid(double l, double w, double h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    public void setDimensions(double l, double w, double h) {
        if (l <= 0) throw new IllegalArgumentException("l must be greater than 0.");
        if (w <= 0) throw new IllegalArgumentException("w must be greater than 0.");
        if (h <= 0) throw new IllegalArgumentException("h must be greater than 0.");
        this.length = l;
        this.width = w;
        this.height = h;
    }

    @Override
    public double getVolume() {
        return length * width * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (length * width + width * height + height * length);
    }

    @Override
    public String getName() {
        return "Rectangular Solid";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/recSolidPic.PNG"));
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
