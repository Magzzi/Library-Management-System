import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryDashboard extends JFrame {

    private static final Color BUTTON_COLOR = new Color(60, 106, 117);
    private static final Color BUTTON_HOVER_COLOR = new Color(80, 126, 137); // Lighter shade for hover
    private static final Color BACKGROUND_COLOR = new Color(240, 240, 240);
    private static final Color CARD_BACKGROUND_COLOR = new Color(255, 255, 255);
    private static final Color CARD_BORDER_COLOR = new Color(60, 106, 117);
    private static final Font USER_ROLE_FONT = new Font("Arial", Font.ITALIC, 12);
    private static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 24);
    private static final Font ICON_FONT = new Font("SansSerif", Font.PLAIN, 50);
    private static final Font VALUE_FONT = new Font("SansSerif", Font.BOLD, 24);
    private static final Font DESC_FONT = new Font("SansSerif", Font.PLAIN, 16);
    private static final int SIDEBAR_WIDTH = 200;

    public LibraryDashboard() {
        setupFrame();
        JPanel topBar = createTopBar();
        JPanel sidebar = createSidebar();
        JPanel mainPanel = createMainPanel();

        // Add panels to the frame
        add(topBar, BorderLayout.NORTH);
        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    private void setupFrame() {
        setTitle("Library Book Reservation Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setPreferredSize(new Dimension(getWidth(), 60));
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Title label
        JLabel titleLabel = new JLabel("Library Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(TITLE_FONT);
        topBar.add(titleLabel, BorderLayout.CENTER);

        // User info panel
        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userInfoPanel.setBackground(Color.WHITE);
        userInfoPanel.add(new JLabel("👤"));
        userInfoPanel.add(new JLabel("Mark Eron Diaz"));
        JLabel userRole = new JLabel("Admin");
        userRole.setFont(USER_ROLE_FONT);
        userInfoPanel.add(userRole);
        topBar.add(userInfoPanel, BorderLayout.WEST);

        // Time panel
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        timePanel.setBackground(Color.WHITE);
        JLabel timeLabel = new JLabel();
        updateTime(timeLabel);
        new Timer(1000, _ -> updateTime(timeLabel)).start();
        timePanel.add(timeLabel);
        timePanel.add(new JLabel("⚙️"));
        timePanel.add(createCloseButton());
        topBar.add(timePanel, BorderLayout.EAST);

        return topBar;
    }

    private JButton createCloseButton() {
        JButton closeButton = new JButton("Close");
        closeButton.setBackground(BUTTON_COLOR);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(BUTTON_FONT);
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(80, 30));
        closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(_ -> System.exit(0));
        return closeButton;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[][] stats = {
            {"0", "Books Listed", "📚", "#28A745"},
            {"0", "Times Book Issued", "📑", "#007BFF"},
            {"0", "Times Books Returned", "♻️", "#FFC107"},
            {"0", "Registered Users", "👤", "#DC3545"},
            {"0", "Authors Listed", "👨‍💻", "#17A2B8"},
            {"0", "Listed Categories", "📂", "#6F42C1"}
        };

        for (String[] stat : stats) {
            JPanel card = createCard(stat[0], stat[1], stat[2], Color.decode(stat[3]));
            mainPanel.add(card);
        }

        return mainPanel; 
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(BUTTON_COLOR);
        sidebar.setPreferredSize(new Dimension(SIDEBAR_WIDTH, getHeight()));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Added padding

        String[] buttonLabels = {"Books", "Author", "Member", "Transaction", "Logout"};
        for (String label : buttonLabels) {
            JButton button = createMenuButton(label);
            button.addActionListener(_ -> openPage(label));
            sidebar.add(button);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        return sidebar;
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(180, 60));
        button.setForeground(Color.WHITE);
        button.setBackground(BUTTON_COLOR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(BUTTON_FONT);
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(BUTTON_HOVER_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(BUTTON_COLOR);
            }
        });
        
        return button;
    }

    private JPanel createCard(String value, String description, String icon, Color bgColor) {
        JPanel card = new JPanel();
        card.setBackground(CARD_BACKGROUND_COLOR);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(CARD_BORDER_COLOR, 2));
        card.setPreferredSize(new Dimension(200, 100));
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconLabel.setFont(ICON_FONT);
        iconLabel.setForeground(bgColor);

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(VALUE_FONT);

        JLabel descLabel = new JLabel(description, SwingConstants.CENTER);
        descLabel.setFont(DESC_FONT);

        card.add(iconLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        card.add(descLabel, BorderLayout.SOUTH);

        return card;
    }

    private void openPage(String page) {
        switch (page) {
            case "Books":
                new BooksPage().setVisible(true);
                break;
            case "Author":
                new AuthorsPage().setVisible(true);
                break;
            case "Member":
                new MembersPage().setVisible(true);
                break;
            case "Transaction":
                new TransactionsPage().setVisible(true);
                break;
            case "Logout":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private void updateTime(JLabel label) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a\nMMM dd, yyyy");
        label.setText(dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryDashboard::new);
    }
}