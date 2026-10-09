
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    JTextField name, regno;
    JRadioButton male, female;
    JCheckBox reading, music, sports;
    JComboBox<String> course;
    JButton submit, clear;
    JTextArea result;

    StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(500, 500);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));

        form.add(new JLabel("Name:"));
        name = new JTextField();
        form.add(name);

        form.add(new JLabel("Register Number:"));
        regno = new JTextField();
        form.add(regno);

        form.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        form.add(genderPanel);

        form.add(new JLabel("Course:"));
        course = new JComboBox<>(new String[]{
            "BCA", "BSc Computer Science", "BTech", "MCA"
        });
        form.add(course);

        form.add(new JLabel("Hobbies:"));
        JPanel hobbyPanel = new JPanel();
        reading = new JCheckBox("Reading");
        music = new JCheckBox("Music");
        sports = new JCheckBox("Sports");
        hobbyPanel.add(reading);
        hobbyPanel.add(music);
        hobbyPanel.add(sports);
        form.add(hobbyPanel);

        submit = new JButton("Submit");
        clear = new JButton("Clear");
        form.add(submit);
        form.add(clear);

        result = new JTextArea(5, 30);
        result.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(result), BorderLayout.CENTER);

        submit.addActionListener(this);
        clear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" : "Not selected";

            String hobbies = "";
            if (reading.isSelected()) hobbies += "Reading ";
            if (music.isSelected()) hobbies += "Music ";
            if (sports.isSelected()) hobbies += "Sports ";

            result.setText(
                "Student Details\n" +
                "Name: " + name.getText() + "\n" +
                "Register No: " + regno.getText() + "\n" +
                "Gender: " + gender + "\n" +
                "Course: " + course.getSelectedItem() + "\n" +
                "Hobbies: " + hobbies
            );
        } else if (e.getSource() == clear) {
            name.setText("");
            regno.setText("");
            male.setSelected(false);
            female.setSelected(false);
            bgReset();
            course.setSelectedIndex(0);
            reading.setSelected(false);
            music.setSelected(false);
            sports.setSelected(false);
            result.setText("");
        }
    }

    void bgReset() {
        // ButtonGroup selection is cleared by selecting neither radio button.
        male.setSelected(false);
        female.setSelected(false);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
