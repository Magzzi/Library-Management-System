import javax.swing.*;
import java.awt.*;

public class CatalogPage extends JFrame {
    public CatalogPage() {
        setTitle("Catalog Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Basic layout and label for demonstration
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(new JLabel("Welcome to the Catalog Page"));
        add(panel);
    }
}