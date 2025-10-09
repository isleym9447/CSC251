package shapes;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class RightCircularConeFrustum implements Shape3D {
    private double r, R, h, s;

    public RightCircularConeFrustum() {}

    public RightCircularConeFrustum(double r, double R, double h, double s) {
        this.r = r;
        this.R = R;
        this.h = h;
        this.s = s;
    }

    public void setDimensions(double r, double R, double h, double s) {
        if (r <= 0) throw new IllegalArgumentException("r must be greater than 0.");
        if (R <= 0) throw new IllegalArgumentException("R must be greater than 0.");
        if (h <= 0) throw new IllegalArgumentException("h must be greater than 0.");
        if (s <= 0) throw new IllegalArgumentException("s must be greater than 0.");
        this.r = r;
        this.R = R;
        this.h = h;
        this.s = s;
    }

    @Override
    public double getVolume() {
        return (Math.PI * h * (r * r + r * R + R * R)) / 3;
    }

    @Override
    public double getSurfaceArea() {
        return Math.PI * s * (R + r);
    }

    @Override
    public String getName() {
        return "Right Circular Cone Frustum";
    }

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File("resources/images/rightCircConeFrPic_2.PNG"));
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
