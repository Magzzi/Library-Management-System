import javax.swing.*;
import java.awt.*;

public class BooksPage extends JFrame {
    public BooksPage() {
        setTitle("Books Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Basic layout and label for demonstration
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(new JLabel("Welcome to the Books Page"));
        add(panel);
    }
}