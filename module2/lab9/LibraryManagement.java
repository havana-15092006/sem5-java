
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LibraryManagement extends JFrame implements ActionListener {

    JTextField id, title, author;
    JComboBox<String> category;
    JTable table;
    DefaultTableModel model;
    JButton add, delete, clear;

    LibraryManagement() {
        setTitle("Library Book Management");
        setSize(700, 400);
        setLayout(new BorderLayout(5, 5));

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));

        form.add(new JLabel("Book ID:"));
        id = new JTextField();
        form.add(id);

        form.add(new JLabel("Book Title:"));
        title = new JTextField();
        form.add(title);

        form.add(new JLabel("Author:"));
        author = new JTextField();
        form.add(author);

        form.add(new JLabel("Category:"));
        category = new JComboBox<>(new String[]{
            "Fiction", "Science", "Technology", "History"
        });
        form.add(category);

        model = new DefaultTableModel(
            new String[]{"Book ID", "Title", "Author", "Category"}, 0
        );

        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        JPanel buttons = new JPanel();
        add = new JButton("Add Book");
        delete = new JButton("Delete Book");
        clear = new JButton("Clear");

        buttons.add(add);
        buttons.add(delete);
        buttons.add(clear);

        add.addActionListener(this);
        delete.addActionListener(this);
        clear.addActionListener(this);

        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            if (id.getText().trim().isEmpty() ||
                title.getText().trim().isEmpty() ||
                author.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                    "Please fill all book details!");
                return;
            }

            model.addRow(new Object[]{
                id.getText(),
                title.getText(),
                author.getText(),
                category.getSelectedItem()
            });

            JOptionPane.showMessageDialog(this,
                "Book added successfully!");

        } else if (e.getSource() == delete) {
            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this,
                    "Please select a book to delete!");
            } else {
                model.removeRow(table.convertRowIndexToModel(row));
                JOptionPane.showMessageDialog(this,
                    "Book deleted successfully!");
            }

        } else if (e.getSource() == clear) {
            id.setText("");
            title.setText("");
            author.setText("");
            category.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new LibraryManagement();
    }
}
