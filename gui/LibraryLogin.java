import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryLogin extends JFrame {
    public LibraryLogin() {
        // Set up the frame
        setTitle("Library Book Reservation Login");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set up the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(null);
        
        // Logo label with image
        String logoPath = "D:\\CS0070L\\Paul (D;)\\Pictures\\Screenshots\\Screenshot 2024-11-12 221248.png";
        ImageIcon logoIcon = new ImageIcon(logoPath);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(100, 20, 200, 120); // Adjust bounds as needed
        mainPanel.add(logoLabel);
        
        // Username field
        JTextField usernameField = new JTextField("Username");
        usernameField.setBounds(100, 150, 200, 40);
        mainPanel.add(usernameField);
        
        // Password field
        JPasswordField passwordField = new JPasswordField("Password");
        passwordField.setBounds(100, 210, 200, 40);
        mainPanel.add(passwordField);
        
        // Forgot Password label
        JLabel forgotPasswordLabel = new JLabel("Forgot password?");
        forgotPasswordLabel.setForeground(Color.BLUE.darker());
        forgotPasswordLabel.setBounds(150, 260, 100, 20);
        mainPanel.add(forgotPasswordLabel);
        
        // Sign In button
        JButton signInButton = new JButton("SIGN IN");
        signInButton.setBounds(100, 300, 200, 40);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        mainPanel.add(signInButton);
        
        // Sign Up button
        JButton signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(100, 360, 200, 40);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        mainPanel.add(signUpButton);
        
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

        forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "Forgot Password clicked");
            }
        });
        
        // Add main panel to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryLogin().setVisible(true);
            }
        });
    }
}