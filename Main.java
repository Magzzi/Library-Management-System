import javax.swing.SwingUtilities;
import gui.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryLogin().setVisible(true));
    }
}
