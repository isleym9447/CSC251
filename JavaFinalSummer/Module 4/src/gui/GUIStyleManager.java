package gui;

import java.awt.*;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Manages all styling and visual appearance for the Shape Calculator GUI
 * Provides consistent, professional color schemes and layout configurations
 */
public class GUIStyleManager {
    
    // Professional Color Palette
    public static final Color PRIMARY_DARK = new Color(45, 52, 62);      // Dark blue-gray
    public static final Color PRIMARY_LIGHT = new Color(240, 242, 245);  // Light gray
    public static final Color ACCENT_BLUE = new Color(74, 144, 226);     // Professional blue
    public static final Color ACCENT_HOVER = new Color(59, 130, 210);    // Darker blue for hover
    public static final Color SUCCESS_GREEN = new Color(46, 160, 67);    // Success green
    public static final Color WARNING_ORANGE = new Color(255, 159, 67);  // Warning orange
    public static final Color ERROR_RED = new Color(231, 76, 60);        // Error red
    public static final Color TEXT_PRIMARY = new Color(52, 73, 94);      // Dark text
    public static final Color TEXT_SECONDARY = new Color(127, 140, 141); // Gray text
    public static final Color BACKGROUND = new Color(248, 249, 250);     // Light background
    public static final Color CARD_BACKGROUND = Color.WHITE;             // Card background
    
    // Fonts
    public static final Font HEADING_FONT = new Font("Segoe UI", Font.BOLD, 16);
    public static final Font BODY_FONT = new Font("Segoe UI", Font.PLAIN, 12);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 12);
    public static final Font LABEL_FONT = new Font("Segoe UI", Font.PLAIN, 11);
    
    // Border configurations
    public static final Border CARD_BORDER = BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(220, 221, 225), 1),
        BorderFactory.createEmptyBorder(15, 15, 15, 15)
    );
    
    public static final Border BUTTON_BORDER = BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(ACCENT_BLUE, 1),
        BorderFactory.createEmptyBorder(8, 16, 8, 16)
    );
    
    /**
     * Styles the main application window
     */
    public static void styleMainWindow(JFrame frame) {
        frame.getContentPane().setBackground(BACKGROUND);
        frame.setFont(BODY_FONT);
    }
    
    /**
     * Creates and styles a primary button with professional appearance
     */
    public static JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setForeground(Color.WHITE);
        button.setBackground(ACCENT_BLUE);
        button.setBorder(BUTTON_BORDER);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_HOVER);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_BLUE);
            }
        });
        
        return button;
    }
    
    /**
     * Creates and styles a secondary button (for less prominent actions)
     */
    public static JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setForeground(TEXT_PRIMARY);
        button.setBackground(PRIMARY_LIGHT);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
    
    /**
     * Creates and styles a danger button (for destructive actions)
     */
    public static JButton createDangerButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setForeground(Color.WHITE);
        button.setBackground(ERROR_RED);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ERROR_RED, 1),
            BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
    
    /**
     * Creates and styles a success button (for positive actions)
     */
    public static JButton createSuccessButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setForeground(Color.WHITE);
        button.setBackground(SUCCESS_GREEN);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SUCCESS_GREEN, 1),
            BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
    
    /**
     * Styles a JComboBox with professional appearance
     */
    public static void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(BODY_FONT);
        comboBox.setBackground(CARD_BACKGROUND);
        comboBox.setForeground(TEXT_PRIMARY);
        comboBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 221, 225), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }
    
    /**
     * Styles a JTextField with professional appearance
     */
    public static void styleTextField(JTextField textField) {
        textField.setFont(BODY_FONT);
        textField.setBackground(CARD_BACKGROUND);
        textField.setForeground(TEXT_PRIMARY);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 221, 225), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        textField.setCaretColor(ACCENT_BLUE);
    }
    
    /**
     * Styles a JLabel with professional appearance
     */
    public static void styleLabel(JLabel label, boolean isHeading) {
        if (isHeading) {
            label.setFont(HEADING_FONT);
            label.setForeground(TEXT_PRIMARY);
        } else {
            label.setFont(LABEL_FONT);
            label.setForeground(TEXT_SECONDARY);
        }
    }
    
    /**
     * Creates a styled panel with card-like appearance
     */
    public static JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(CARD_BACKGROUND);
        panel.setBorder(CARD_BORDER);
        return panel;
    }
    
    /**
     * Creates a centered button panel for dialog boxes
     */
    public static JPanel createCenteredButtonPanel(JButton... buttons) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(CARD_BACKGROUND);
        
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }
        
        return buttonPanel;
    }
    
    /**
     * Creates a professional input dialog panel with centered layout
     */
    public static JPanel createInputDialogPanel(java.util.Map<String, JTextField> inputFields, ImageIcon icon) {
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(CARD_BACKGROUND);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Image panel (top)
        if (icon != null) {
            JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            imagePanel.setBackground(CARD_BACKGROUND);
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
            imagePanel.add(imageLabel);
            mainPanel.add(imagePanel, BorderLayout.NORTH);
        }
        
        // Input panel (center)
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(CARD_BACKGROUND);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        int row = 0;
        for (java.util.Map.Entry<String, JTextField> entry : inputFields.entrySet()) {
            JLabel label = new JLabel(entry.getKey() + ":");
            styleLabel(label, false);
            
            JTextField textField = entry.getValue();
            styleTextField(textField);
            textField.setPreferredSize(new Dimension(200, 30));
            
            gbc.gridx = 0;
            gbc.gridy = row;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.NONE;
            inputPanel.add(label, gbc);
            
            gbc.gridx = 1;
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            inputPanel.add(textField, gbc);
            
            row++;
        }
        
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    /**
     * Creates a professional selection panel for the main window
     */
    public static JPanel createSelectionPanel(JComboBox<String> shape2DMenu, JComboBox<String> shape3DMenu,
                                            JButton calc2D, JButton calc3D) {
        JPanel mainPanel = createCardPanel();
        mainPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.anchor = GridBagConstraints.CENTER;
        
        // 2D Shapes section
        JLabel label2D = new JLabel("2D Shapes:");
        styleLabel(label2D, true);
        styleComboBox(shape2DMenu);
        
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(label2D, gbc);
        
        gbc.gridx = 1; gbc.gridy = 0;
        mainPanel.add(shape2DMenu, gbc);
        
        gbc.gridx = 2; gbc.gridy = 0;
        mainPanel.add(calc2D, gbc);
        
        // 3D Shapes section
        JLabel label3D = new JLabel("3D Shapes:");
        styleLabel(label3D, true);
        styleComboBox(shape3DMenu);
        
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(label3D, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        mainPanel.add(shape3DMenu, gbc);
        
        gbc.gridx = 2; gbc.gridy = 1;
        mainPanel.add(calc3D, gbc);
        
        return mainPanel;
    }
    
    /**
     * Creates a professional utility panel for the main window
     */
    public static JPanel createUtilityPanel(JButton compareBtn, JButton saveBtn, 
                                          JButton clearBtn, JButton exitBtn) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panel.setBackground(BACKGROUND);
        
        panel.add(compareBtn);
        panel.add(saveBtn);
        panel.add(clearBtn);
        panel.add(exitBtn);
        
        return panel;
    }
    
    /**
     * Styles a JTextArea for results display
     */
    public static void styleTextArea(JTextArea textArea) {
        textArea.setFont(BODY_FONT);
        textArea.setBackground(CARD_BACKGROUND);
        textArea.setForeground(TEXT_PRIMARY);
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }
    
    /**
     * Creates a professional comparison options dialog
     */
    public static JPanel createComparisonDialog(Set<String> availableMetrics) {
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(CARD_BACKGROUND);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel titleLabel = new JLabel("Choose Comparison Type", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(TEXT_PRIMARY);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Main content panel
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(CARD_BACKGROUND);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Comparison type selection
        JLabel typeLabel = new JLabel("Comparison Type:");
        styleLabel(typeLabel, true);
        
        String[] comparisonTypes = {
            "Compare Largest vs Smallest", 
            "Compare All Shapes (Ranked)"
        };
        JComboBox<String> typeCombo = new JComboBox<>(comparisonTypes);
        styleComboBox(typeCombo);
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        contentPanel.add(typeLabel, gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        contentPanel.add(typeCombo, gbc);
        
        // Metric selection
        JLabel metricLabel = new JLabel("Compare By:");
        styleLabel(metricLabel, true);
        
        JComboBox<String> metricCombo = new JComboBox<>();
        
        // Add common metrics first
        metricCombo.addItem("Area");
        metricCombo.addItem("Volume");
        metricCombo.addItem("Perimeter");
        metricCombo.addItem("Surface Area");
        
        // Add separator
        metricCombo.addItem("--- Available Metrics ---");
        
        // Add all available metrics
        for (String metric : availableMetrics) {
            if (!metric.equals("Area") && !metric.equals("Volume") && 
                !metric.equals("Perimeter") && !metric.equals("Surface Area")) {
                metricCombo.addItem(metric);
            }
        }
        
        styleComboBox(metricCombo);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        contentPanel.add(metricLabel, gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        contentPanel.add(metricCombo, gbc);
        
        // Instructions
        JTextArea instructions = new JTextArea(
            "• 'Compare Largest vs Smallest' will show you the two extreme shapes for the selected metric\n" +
            "• 'Compare All Shapes' will rank all your shapes from largest to smallest by the selected metric\n" +
            "• Choose a metric to determine what aspect of the shapes to compare"
        );
        instructions.setFont(LABEL_FONT);
        instructions.setForeground(TEXT_SECONDARY);
        instructions.setBackground(CARD_BACKGROUND);
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 221, 225), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        contentPanel.add(instructions, gbc);
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // Store references to the combo boxes in the panel for later retrieval
        mainPanel.putClientProperty("typeCombo", typeCombo);
        mainPanel.putClientProperty("metricCombo", metricCombo);
        
        return mainPanel;
    }
}