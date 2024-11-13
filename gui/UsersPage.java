import javax.swing.*;
import java.awt.*;

public class UsersPage extends JFrame {
    public UsersPage() {
        setTitle("Users Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Basic layout and label for demonstration
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(new JLabel("Welcome to the Users Page"));
        add(panel);
    }
}