package services;

import shapes.*;

public class ShapeFactory {
    public static Shape createShape(String shapeName) {
        switch (shapeName.toLowerCase()) {
            case "circle":
                return new Circle();
            case "cube":
                return new Cube();
            // Add more shapes here
            default:
                throw new IllegalArgumentException("Shape not recognized: " + shapeName);
        }
    }
}
