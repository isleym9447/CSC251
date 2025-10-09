package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import shapes.*;

public class MainGUI extends JFrame {
    private List<shapes.Shape> calculatedShapes = new ArrayList<>();

    public MainGUI() {
        setTitle("Shape Calculator");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Apply main window styling
        GUIStyleManager.styleMainWindow(this);

        // Create styled components
        String[] shape2DNames = {"Circle", "Square", "Rectangle", "Parallelogram", "Triangle", "Pentagon"};
        String[] shape3DNames = {"Cube", "Sphere", "Right Circular Cone", "Right Circular Cylinder", "Rectangular Solid", "Cone Frustum", "Square/Rectangular Pyramid"};

        JComboBox<String> shape2DMenu = new JComboBox<>(shape2DNames);
        JComboBox<String> shape3DMenu = new JComboBox<>(shape3DNames);
        JButton calc2D = GUIStyleManager.createPrimaryButton("Calculate 2D Shape");
        JButton calc3D = GUIStyleManager.createPrimaryButton("Calculate 3D Shape");

        // Create selection panel with professional styling
        JPanel selectionPanel = GUIStyleManager.createSelectionPanel(shape2DMenu, shape3DMenu, calc2D, calc3D);

        calc2D.addActionListener(e -> handleShapeSelection((String) shape2DMenu.getSelectedItem()));
        calc3D.addActionListener(e -> handleShapeSelection((String) shape3DMenu.getSelectedItem()));

        add(selectionPanel, BorderLayout.NORTH);

        // Create utility panel with styled buttons
        JButton compareBtn = GUIStyleManager.createSecondaryButton("Compare Shapes");
        JButton saveBtn = GUIStyleManager.createSuccessButton("Export to .txt");
        JButton clearBtn = GUIStyleManager.createDangerButton("Clear All");
        JButton exitBtn = GUIStyleManager.createSecondaryButton("Exit");

        compareBtn.addActionListener(e -> compareShapes());
        saveBtn.addActionListener(e -> exportToFile());
        clearBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Clear all stored shapes?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                calculatedShapes.clear();
                JOptionPane.showMessageDialog(this, "All shapes cleared.");
            }
        });
        exitBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Exit the program?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        JPanel utilityPanel = GUIStyleManager.createUtilityPanel(compareBtn, saveBtn, clearBtn, exitBtn);
        add(utilityPanel, BorderLayout.SOUTH);
    }

    private void handleShapeSelection(String shapeName) {
        shapes.Shape shape = null;
        Map<String, JTextField> inputFields = new LinkedHashMap<>();
        ImageIcon icon = null;

        // Configure shape-specific inputs and load icons
        switch (shapeName) {
            case "Circle" -> {
                inputFields.put("Radius", new JTextField());
                shape = new Circle();
                icon = loadIcon("circlePic.PNG");
            }
            case "Square" -> {
                inputFields.put("Side", new JTextField());
                shape = new Square();
                icon = loadIcon("squarePic.PNG");
            }
            case "Rectangle" -> {
                inputFields.put("Length", new JTextField());
                inputFields.put("Width", new JTextField());
                shape = new shapes.Rectangle();
                icon = loadIcon("rectanglePic.PNG");
            }
            case "Parallelogram" -> {
                inputFields.put("Base", new JTextField());
                inputFields.put("Height", new JTextField());
                inputFields.put("Side", new JTextField());
                shape = new Parallelogram();
                icon = loadIcon("parallelogramPic_2.PNG");
            }
            case "Triangle" -> {
                inputFields.put("Side A", new JTextField());
                inputFields.put("Side B", new JTextField());
                inputFields.put("Side C", new JTextField());
                shape = new Triangle();
                icon = loadIcon("Triangle2.PNG");
            }
            case "Pentagon" -> {
                inputFields.put("Side", new JTextField());
                inputFields.put("Apothem", new JTextField());
                shape = new Pentagon();
                icon = loadIcon("Pentagon.PNG");
            }
            case "Cube" -> {
                inputFields.put("Side", new JTextField());
                shape = new Cube();
                icon = loadIcon("cubePic.PNG");
            }
            case "Sphere" -> {
                inputFields.put("Radius", new JTextField());
                shape = new Sphere();
                icon = loadIcon("spherePic.PNG");
            }
            case "Right Circular Cone" -> {
                inputFields.put("Radius", new JTextField());
                inputFields.put("Height", new JTextField());
                shape = new RightCircularCone();
                icon = loadIcon("rightCircConePic_2.PNG");
            }
            case "Right Circular Cylinder" -> {
                inputFields.put("Radius", new JTextField());
                inputFields.put("Height", new JTextField());
                shape = new RightCircularCylinder();
                icon = loadIcon("rightCircCylPic.PNG");
            }
            case "Rectangular Solid" -> {
                inputFields.put("Length", new JTextField());
                inputFields.put("Width", new JTextField());
                inputFields.put("Height", new JTextField());
                shape = new RectangularSolid();
                icon = loadIcon("recSolidPic.PNG");
            }
            case "Cone Frustum" -> {
                inputFields.put("Small Radius (r)", new JTextField());
                inputFields.put("Large Radius (R)", new JTextField());
                inputFields.put("Height", new JTextField());
                inputFields.put("Slant Height", new JTextField());
                shape = new RightCircularConeFrustum();
                icon = loadIcon("rightCircConeFrPic_2.PNG");
            }
            case "Square/Rectangular Pyramid" -> {
                inputFields.put("Length", new JTextField());
                inputFields.put("Width", new JTextField());
                inputFields.put("Height", new JTextField());
                shape = new SquareRectangularPyramid();
                icon = loadIcon("squareRecPyPic.PNG");
            }
        }

        // Create professionally styled input dialog
        JPanel panel = GUIStyleManager.createInputDialogPanel(inputFields, icon);

        int result = JOptionPane.showConfirmDialog(this, panel, "Input for " + shapeName,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                List<Double> values = new ArrayList<>();
                for (JTextField tf : inputFields.values()) {
                    values.add(Double.parseDouble(tf.getText()));
                }

                // Set shape dimensions (same logic as before)
                switch (shapeName) {
                    case "Circle" -> ((Circle) shape).setRadius(values.get(0));
                    case "Square" -> ((Square) shape).setSide(values.get(0));
                    case "Rectangle" -> ((shapes.Rectangle) shape).setDimensions(values.get(0), values.get(1));
                    case "Parallelogram" -> ((Parallelogram) shape).setDimensions(values.get(0), values.get(1), values.get(2));
                    case "Triangle" -> ((Triangle) shape).setSides(values.get(0), values.get(1), values.get(2));
                    case "Pentagon" -> ((Pentagon) shape).setDimensions(values.get(0), values.get(1));
                    case "Cube" -> ((Cube) shape).setSide(values.get(0));
                    case "Sphere" -> ((Sphere) shape).setRadius(values.get(0));
                    case "Right Circular Cone" -> ((RightCircularCone) shape).setDimensions(values.get(0), values.get(1));
                    case "Right Circular Cylinder" -> ((RightCircularCylinder) shape).setDimensions(values.get(0), values.get(1));
                    case "Rectangular Solid" -> ((RectangularSolid) shape).setDimensions(values.get(0), values.get(1), values.get(2));
                    case "Cone Frustum" -> ((RightCircularConeFrustum) shape).setDimensions(values.get(0), values.get(1), values.get(2), values.get(3));
                    case "Square/Rectangular Pyramid" -> ((SquareRectangularPyramid) shape).setDimensions(values.get(0), values.get(1), values.get(2));
                }

                calculatedShapes.add(shape);
                StringBuilder sb = new StringBuilder(shape.getName() + ":\n");
                shape.calculate().forEach((k, v) -> sb.append(k).append(" = ").append(v).append("\n"));

                JTextArea resultArea = new JTextArea(sb.toString());
                GUIStyleManager.styleTextArea(resultArea);
                resultArea.setEditable(false);
                
                JOptionPane.showMessageDialog(this, new JScrollPane(resultArea), "Results", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Number Format Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void compareShapes() {
    if (calculatedShapes.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No shapes to compare.");
        return;
    }

    String result = services.ShapeComparator.getComparison(calculatedShapes);
    JOptionPane.showMessageDialog(this, result, "Comparison Result", JOptionPane.INFORMATION_MESSAGE);
}


    private void exportToFile() {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file.exists()) {
                int confirm = JOptionPane.showConfirmDialog(this, "File exists. Overwrite?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (shapes.Shape shape : calculatedShapes) {
                    writer.write(shape.getName() + ":\n");
                    for (Map.Entry<String, Double> entry : shape.calculate().entrySet()) {
                        writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
                    }
                    writer.write("\n");
                }
                JOptionPane.showMessageDialog(this, "File saved successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage());
            }
        }
    }

    private ImageIcon loadIcon(String filename) {
        try {
            BufferedImage image = javax.imageio.ImageIO.read(new File("resources/images/" + filename));
            return new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            return new ImageIcon();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}