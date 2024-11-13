import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryDashboard extends JFrame {
    public LibraryDashboard() {
        // Set up the frame
        setTitle("Library Book Reservation Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Start maximized
        setUndecorated(true); // Remove window decorations for full-screen mode
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Sidebar panel with dynamic layout
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(47, 54, 64)); // Darker blue-gray background for the sidebar
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(200, getHeight())); // Fixed width, dynamic height

        // Logo on the sidebar
        JLabel logoLabel = new JLabel(new ImageIcon("logo.png")); // Adjust the path for your image
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(logoLabel);

        // Sidebar buttons
        JButton dashboardButton = createSidebarButton("Dashboard", "🏠");
        JButton catalogButton = createSidebarButton("Catalog", "🔍");
        JButton booksButton = createSidebarButton("Books", "📚");
        JButton usersButton = createSidebarButton("Users", "👥");
        JButton logoutButton = createSidebarButton("Logout", "🔓");

        // Add action listeners for page navigation
        catalogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CatalogPage().setVisible(true);
            }
        });

        booksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BooksPage().setVisible(true);
            }
        });

        usersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UsersPage().setVisible(true);
            }
        });

        sidebar.add(dashboardButton);
        sidebar.add(catalogButton);
        sidebar.add(booksButton);
        sidebar.add(usersButton);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(logoutButton);

        // Main panel for content
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 240, 240)); // Light background
        mainPanel.setLayout(new BorderLayout());

        // Top bar panel for user info and settings
        JPanel topBar = new JPanel();
        topBar.setLayout(new BorderLayout());
        topBar.setPreferredSize(new Dimension(getWidth(), 50));
        topBar.setBackground(Color.WHITE);

        // User info on the top bar
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setBackground(Color.WHITE);
        userInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel userIcon = new JLabel("👤");
        JLabel userName = new JLabel("PAUL DACALAN");
        JLabel userRole = new JLabel("Admin");
        userRole.setFont(new Font("Arial", Font.ITALIC, 12));
        userInfoPanel.add(userIcon);
        userInfoPanel.add(userName);
        userInfoPanel.add(userRole);

        // Time and date on the top bar
        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.WHITE);
        timePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel timeLabel = new JLabel();
        updateTime(timeLabel);
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime(timeLabel);
            }
        });
        timer.start();
        timePanel.add(timeLabel);

        // Settings icon
        JLabel settingsIcon = new JLabel("⚙️");
        timePanel.add(settingsIcon);

        // Close button (add to the top bar)
        JButton closeButton = new JButton("Close");
        closeButton.setBackground(new Color(60, 106, 117)); // Darker teal button background
        closeButton.setForeground(Color.WHITE); // White button text
        closeButton.setFont(new Font("Roboto", Font.BOLD, 14));
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(60, 40)); // Set size
        closeButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Rounded corners
        closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application
            }
        });
        timePanel.add(closeButton);

        // Add user info and time/date to top bar
        topBar.add(userInfoPanel, BorderLayout.WEST);
        topBar.add(timePanel, BorderLayout.EAST);

        // Add top bar and sidebar to main frame
        add(sidebar, BorderLayout.WEST);
        add(topBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Adjust size and visibility
        setVisible(true);
    }

    private JButton createSidebarButton(String text, String icon) {
        JButton button = new JButton(icon + " " + text);
        button.setMaximumSize(new Dimension(200, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(60, 106, 117)); // Teal button background
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        return button;
    }

    private void updateTime(JLabel label) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a\nMMM dd, yyyy");
        label.setText(dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryDashboard().setVisible(true);
            }
        });
    }
}
