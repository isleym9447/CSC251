package services;

import java.util.*;
import shapes.Shape;

public class ShapeComparator {

    public static String getComparison(List<Shape> shapes) {
        if (shapes.isEmpty()) return "No shapes to compare.";

        StringBuilder sb = new StringBuilder();
        sb.append(compareByArea(shapes)).append("\n\n");
        sb.append(compareByPerimeter(shapes)).append("\n\n");
        sb.append(compareByVolume(shapes)).append("\n\n");
        sb.append(compareAll(shapes));

        return sb.toString();
    }

    public static String compareByArea(List<Shape> shapes) {
        Shape maxShape = null;
        Shape minShape = null;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for (Shape s : shapes) {
            Map<String, Double> values = s.calculate();
            if (values.containsKey("Area")) {
                double area = values.get("Area");
                if (area > max) {
                    max = area;
                    maxShape = s;
                }
                if (area < min) {
                    min = area;
                    minShape = s;
                }
            }
        }

        if (maxShape == null || minShape == null) return "➤ Compare by Area: No shapes with area data.";

        return String.format("➤ Compare by Area:\nLargest: %s (%.2f)\nSmallest: %s (%.2f)",
                maxShape.getName(), max, minShape.getName(), min);
    }

    public static String compareByPerimeter(List<Shape> shapes) {
        Shape maxShape = null;
        Shape minShape = null;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for (Shape s : shapes) {
            Map<String, Double> values = s.calculate();
            if (values.containsKey("Perimeter")) {
                double p = values.get("Perimeter");
                if (p > max) {
                    max = p;
                    maxShape = s;
                }
                if (p < min) {
                    min = p;
                    minShape = s;
                }
            }
        }

        if (maxShape == null || minShape == null) return "➤ Compare by Perimeter: No shapes with perimeter data.";

        return String.format("➤ Compare by Perimeter:\nLargest: %s (%.2f)\nSmallest: %s (%.2f)",
                maxShape.getName(), max, minShape.getName(), min);
    }

    public static String compareByVolume(List<Shape> shapes) {
        Shape maxShape = null;
        Shape minShape = null;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for (Shape s : shapes) {
            Map<String, Double> values = s.calculate();
            if (values.containsKey("Volume")) {
                double v = values.get("Volume");
                if (v > max) {
                    max = v;
                    maxShape = s;
                }
                if (v < min) {
                    min = v;
                    minShape = s;
                }
            }
        }

        if (maxShape == null || minShape == null) return "➤ Compare by Volume: No 3D shapes with volume data.";

        return String.format("➤ Compare by Volume:\nLargest: %s (%.2f)\nSmallest: %s (%.2f)",
                maxShape.getName(), max, minShape.getName(), min);
    }

    public static String compareAll(List<Shape> shapes) {
        if (shapes.isEmpty()) return "➤ Compare All: No shapes available.";

        Map<String, List<Shape>> grouped = new TreeMap<>();

        for (Shape s : shapes) {
            String type = s.getClass().getSimpleName();
            grouped.putIfAbsent(type, new ArrayList<>());
            grouped.get(type).add(s);
        }

        StringBuilder sb = new StringBuilder("➤ Compare All (by shape type):\n");

        for (Map.Entry<String, List<Shape>> entry : grouped.entrySet()) {
            sb.append("\n▶ ").append(entry.getKey()).append(":\n");
            for (Shape s : entry.getValue()) {
                sb.append("  - ").append(s.getName());
                Map<String, Double> values = s.calculate();
                for (Map.Entry<String, Double> val : values.entrySet()) {
                    sb.append(" | ").append(val.getKey()).append(": ")
                      .append(String.format("%.2f", val.getValue()));
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
