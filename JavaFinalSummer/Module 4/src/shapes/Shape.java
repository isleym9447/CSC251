package shapes;

import java.awt.image.BufferedImage;
import java.util.Map;

public interface Shape {
    String getName();
    BufferedImage getImage();
    Map<String, Double> calculate();
}
