import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryLogin extends JFrame {

    public LibraryLogin() {
        // Set up the frame
        setTitle("Library Book Reservation Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Start maximized
        setUndecorated(true); // Remove window decorations for full-screen mode
        setLocationRelativeTo(null);

        // Main panel with GridBagLayout for structure
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(47, 54, 64)); // Darker blue-gray background

        // Title panel (background container for the title text)
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 106, 117)); // Darker teal background for title
        titlePanel.setLayout(new BorderLayout());

        // Set the height of the title panel to 30% of the screen height
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int titlePanelHeight = (int) (screenSize.height * 0.3); // 30% of the screen height
        titlePanel.setPreferredSize(new Dimension(screenSize.width, titlePanelHeight));

        // Title text
        JLabel titleLabel = new JLabel("Library Management System", JLabel.CENTER); // Center the text
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 36)); // Font style and size for the title
        titleLabel.setForeground(new Color(255, 255, 255)); // White text color

        titlePanel.add(titleLabel, BorderLayout.CENTER); // Add the title label to the center of the panel

        // Input container panel (background for the fields)
        JPanel inputContainerPanel = new JPanel();
        inputContainerPanel.setBackground(new Color(255, 255, 255)); // White background for the container
        inputContainerPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2)); // Soft gray border
        inputContainerPanel.setLayout(new GridBagLayout());

        // Input panel for username, password, and buttons inside the container
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 15); // Adjust left padding to 5px and right to 15px
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username field
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(new Color(80, 80, 80)); // Soft dark gray text
        inputContainerPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        JTextField usernameField = new JTextField(20);
        usernameField.setToolTipText("Enter Username");
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2)); // Soft border
        usernameField.setBackground(Color.WHITE); // White input fields for clarity
        usernameField.setForeground(new Color(50, 50, 50)); // Dark gray text for input
        inputContainerPanel.add(usernameField, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(80, 80, 80)); // Soft dark gray text
        inputContainerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setToolTipText("Enter Password");
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2)); // Soft border
        passwordField.setBackground(Color.WHITE); // White input fields for clarity
        passwordField.setForeground(new Color(50, 50, 50)); // Dark gray text for input
        inputContainerPanel.add(passwordField, gbc);

        // Forgot Password label
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel forgotPasswordLabel = new JLabel("Forgot password?");
        forgotPasswordLabel.setForeground(new Color(100, 100, 100)); // Soft gray text
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inputContainerPanel.add(forgotPasswordLabel, gbc);

        // Sign In button
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton signInButton = new JButton("SIGN IN");
        signInButton.setBackground(new Color(60, 106, 117)); // Darker teal button background
        signInButton.setForeground(new Color(255, 255, 255)); // White button text
        signInButton.setFont(new Font("Roboto", Font.BOLD, 14));
        signInButton.setFocusPainted(false);
        signInButton.setPreferredSize(new Dimension(150, 40)); // Set size
        signInButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Rounded corners
        signInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inputContainerPanel.add(signInButton, gbc);

        // Sign Up button
        gbc.gridy = 4;
        JButton signUpButton = new JButton("SIGN UP");
        signUpButton.setBackground(new Color(60, 106, 117)); // Darker teal button background
        signUpButton.setForeground(new Color(255, 255, 255)); // White button text
        signUpButton.setFont(new Font("Roboto", Font.BOLD, 14));
        signUpButton.setFocusPainted(false);
        signUpButton.setPreferredSize(new Dimension(150, 40)); // Set size
        signUpButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Rounded corners
        signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sign Up button clicked");
            }
        });
        inputContainerPanel.add(signUpButton, gbc);

        // Close button
        JButton closeButton = new JButton("CLOSE");
        closeButton.setBackground(new Color(60, 106, 117)); // Darker teal button background
        closeButton.setForeground(new Color(255, 255, 255)); // White button text
        closeButton.setFont(new Font("Roboto", Font.BOLD, 14));
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(150, 40)); // Set size
        closeButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Rounded corners
        closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application
            }
        });

        // Add panels to the main panel
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.weightx = 1.0;
        gbc2.weighty = 0.3;
        gbc2.fill = GridBagConstraints.BOTH;
        mainPanel.add(titlePanel, gbc2);

        gbc2.gridy = 1;
        gbc2.weighty = 0.6;
        mainPanel.add(inputContainerPanel, gbc2);

        gbc2.gridy = 2;
        gbc2.weighty = 0.1;
        gbc2.anchor = GridBagConstraints.EAST;
        mainPanel.add(closeButton, gbc2);

        // Add main panel to frame
        add(mainPanel);

        // Adjust size and visibility
        setVisible(true);

    // Add action listeners
    signInButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Open the dashboard window and close the login window
            new LibraryDashboard().setVisible(true);
            dispose(); // Close the login window
        }
    });
    
    signUpButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Sign Up button clicked");
        }
    });
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LibraryLogin().setVisible(true);
        });
    }
}