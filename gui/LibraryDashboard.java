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
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Sidebar panel
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Color.BLACK);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(150, getHeight()));

        // Logo on the sidebar
        JLabel logoLabel = new JLabel(new ImageIcon("D:\\CS0070L\\Paul (D;)\\Pictures\\Screenshots\\Screenshot 2024-11-12 221248.png"));
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

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new BorderLayout());

        // Top bar panel for user and settings info
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

        // Add user info and time/date to top bar
        topBar.add(userInfoPanel, BorderLayout.WEST);
        topBar.add(timePanel, BorderLayout.EAST);

        // Add top bar and sidebar to main frame
        add(sidebar, BorderLayout.WEST);
        add(topBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    private JButton createSidebarButton(String text, String icon) {
        JButton button = new JButton(icon + " " + text);
        button.setMaximumSize(new Dimension(150, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
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