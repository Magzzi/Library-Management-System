import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BooksPage extends JFrame {

    private JTable booksTable;
    private DefaultTableModel tableModel;

    public BooksPage() {
        setTitle("Books Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setupUI();
    }

    private void setupUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"Title", "Author", "ISBN", "Publication Date", "Available Copies"};
        tableModel = new DefaultTableModel(columnNames, 0);
        booksTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(booksTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField isbnField = new JTextField();
        JTextField pubDateField = new JTextField();
        JTextField availableCopiesField = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("ISBN:"));
        inputPanel.add(isbnField);
        inputPanel.add(new JLabel("Publication Date:"));
        inputPanel.add(pubDateField);
        inputPanel.add(new JLabel("Available Copies:"));
        inputPanel.add(availableCopiesField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(_ -> addBook(titleField, authorField, isbnField, pubDateField, availableCopiesField));
        JButton removeButton = new JButton("Remove Book");
        removeButton.addActionListener(_ -> removeBook());
        JButton updateButton = new JButton("Update Book");
        updateButton.addActionListener(_ -> updateBook(titleField, authorField, isbnField, pubDateField, availableCopiesField));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void addBook(JTextField titleField, JTextField authorField, JTextField isbnField, JTextField pubDateField, JTextField availableCopiesField) {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();
        String pubDate = pubDateField.getText();
        String availableCopies = availableCopiesField.getText();

        if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty() && !pubDate.isEmpty() && !availableCopies.isEmpty()) {
            tableModel.addRow(new Object[]{title, author, isbn, pubDate, availableCopies});
            clearFields(titleField, authorField, isbnField, pubDateField, availableCopiesField);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeBook() {
        int selectedRow = booksTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBook(JTextField titleField, JTextField authorField, JTextField isbnField, JTextField pubDateField, JTextField availableCopiesField) {
        int selectedRow = booksTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.setValueAt(titleField.getText(), selectedRow, 0);
            tableModel.setValueAt(authorField.getText(), selectedRow, 1);
            tableModel.setValueAt(isbnField.getText(), selectedRow, 2);
            tableModel.setValueAt(pubDateField.getText(), selectedRow, 3);
            tableModel.setValueAt(availableCopiesField.getText(), selectedRow, 4);
            clearFields(titleField, authorField, isbnField, pubDateField, availableCopiesField);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to update", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}