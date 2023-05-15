import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Panels extends JFrame {
    Panels() {
        setTitle("Student Program Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setBounds(100, 100, 635, 550);


        //Setting up top menu
        String[] MenuOptions = {"File", "Null", "Null"};
        JComboBox<String> MenuDropDown = new JComboBox<>(MenuOptions);
        add(MenuDropDown);
        MenuDropDown.setBounds(5, 8, 100, 18);
        add(MenuDropDown);
        StudentDatabase studentDatabase = new StudentDatabase();
        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = getContentPane();

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);

        JLabel Student = new JLabel("Student Details");
        Student.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel StudentID = new JLabel("Student Number");
        JLabel LastName = new JLabel("Last Name");
        JLabel FirstName = new JLabel("First Name(s)");
        JLabel Degree = new JLabel("Degree");
        String[] DegreesToChoose = {"Science", "Art", "Medicine"};

        panel.add(Student);
        Student.setBounds(10, 0, 500, 50);

        panel.add(StudentID);
        StudentID.setBounds(20, 30, 100, 50);

        JTextField StudentIDTxt = new JTextField();
        panel.add(StudentIDTxt);
        StudentIDTxt.setBounds(120, 45, 100, 20);

        panel.add(LastName);
        LastName.setBounds(21, 60, 100, 50);

        JTextField LastNameTxt = new JTextField();
        panel.add(LastNameTxt);
        LastNameTxt.setBounds(120, 75, 100, 20);

        panel.add(FirstName);
        FirstName.setBounds(22, 105, 100, 20);

        JTextField FirstNameTXT = new JTextField();
        panel.add(FirstNameTXT);
        FirstNameTXT.setBounds(120, 108, 100, 20);

        panel.add(Degree);
        Degree.setBounds(22, 135, 100, 20);

        JComboBox<String> DegreeDropDown = new JComboBox<>(DegreesToChoose);
        panel.add(DegreeDropDown);
        DegreeDropDown.setBounds(120, 140, 100, 20);


        ///////PANEL 2
        String[] GradesArr = {"FL", "PS", "CR", "DN", "HD"};

        JLabel Topic = new JLabel("Topic Details");
        Topic.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel TopicCode = new JLabel("Topic Code");
        JLabel Grade = new JLabel("Grade");
        JLabel Mark = new JLabel("Mark");

        JButton AddTopicResult = new JButton("Add Topic Result");
        JButton FindTopicResult = new JButton("Find Topic Result");

        panel2.add(Topic);
        Topic.setBounds(10, 0, 500, 50);


        panel2.add(TopicCode);
        TopicCode.setBounds(20, 30, 100, 50);

        JTextField TopicCodeTXT = new JTextField();
        panel2.add(TopicCodeTXT);
        TopicCodeTXT.setBounds(120, 45, 100, 20);


        panel2.add(Grade);
        Grade.setBounds(21, 60, 100, 50);

        JComboBox<String> GradeDropDown = new JComboBox<>(GradesArr);
        panel2.add(GradeDropDown);
        GradeDropDown.setBounds(120, 75, 50, 20);


        panel2.add(Mark);
        Mark.setBounds(22, 105, 100, 20);

        JTextField MarkTXT = new JTextField();
        panel2.add(MarkTXT);
        MarkTXT.setBounds(120, 108, 100, 20);

        panel2.add(AddTopicResult);
        AddTopicResult.setBounds(10, 140, 150, 20);

        panel2.add(FindTopicResult);
        FindTopicResult.setBounds(10, 165, 150, 20);

        JLabel DegreeOptions = new JLabel("Degree Options");
        DegreeOptions.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel Major = new JLabel("Major");
        JLabel Minor = new JLabel("Minor");
        JLabel Prizes = new JLabel("Prizes");
        JButton AddStudent = new JButton("Add Student");
        JButton FindStudent = new JButton("Find Student");

        panel3.add(DegreeOptions);
        DegreeOptions.setBounds(10, 0, 500, 50);

        panel3.add(Major);
        Major.setBounds(20, 30, 100, 50);

        JTextField MajorTXT = new JTextField();
        panel3.add(MajorTXT);
        MajorTXT.setBounds(120, 45, 100, 20);

        panel3.add(Minor);
        Minor.setBounds(21, 60, 100, 50);

        JTextField MinorTXT = new JTextField();
        panel3.add(MinorTXT);
        MinorTXT.setBounds(120, 75, 100, 20);

        panel3.add(Prizes);
        Prizes.setBounds(21, 110, 100, 20);

        JTextArea PrizesTXT = new JTextArea();
        JScrollPane scroll = new JScrollPane(PrizesTXT);
        panel3.add(scroll);
        scroll.setBounds(120, 110, 100, 100);

        panel3.add(AddStudent);
        AddStudent.setBounds(5, 230, 120, 20);

        panel3.add(FindStudent);
        FindStudent.setBounds(130, 230, 120, 20);


        /////PANEL 4
        JLabel AwardPrizes = new JLabel("Award Prizes");
        AwardPrizes.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel PrizeName = new JLabel("Prize Name");
        JLabel Template = new JLabel("Template");
        JLabel NoOfTopics = new JLabel("Number of Topics");
        JButton AwardPrize = new JButton("Award Prize");
        JButton PrintAllRecords = new JButton("Print All Records");
        JButton ClearAllRecords = new JButton("Clear All Records");

        panel4.add(AwardPrizes);
        AwardPrizes.setBounds(10, 0, 500, 50);

        panel4.add(PrizeName);
        PrizeName.setBounds(20, 30, 100, 50);

        JTextField PrizeNameTXT = new JTextField();
        panel4.add(PrizeNameTXT);
        PrizeNameTXT.setBounds(120, 45, 100, 20);

        panel4.add(Template);
        Template.setBounds(21, 60, 100, 50);

        JTextField TemplateTXT = new JTextField();
        panel4.add(TemplateTXT);
        TemplateTXT.setBounds(120, 75, 100, 20);

        panel4.add(NoOfTopics);
        NoOfTopics.setBounds(22, 105, 150, 20);

        JTextField NoOfTopicsTXT = new JTextField();
        panel4.add(NoOfTopicsTXT);
        NoOfTopicsTXT.setBounds(130, 108, 100, 20);

        panel4.add(AwardPrize);
        AwardPrize.setBounds(170, 150, 120, 20);

        panel4.add(PrintAllRecords);
        PrintAllRecords.setBounds(3, 200, 130, 20);

        panel4.add(ClearAllRecords);
        ClearAllRecords.setBounds(140, 200, 140, 20);


        //////Setting size of all four panels
        panel.setBounds(10, 30, 300, 200);
        //Panel 1

        panel2.setBounds(309, 30, 300, 200);
        //Panel 2

        panel3.setBounds(10, 220, 300, 270);
        //Panel 3

        panel4.setBounds(309, 220, 300, 270);
        //Panel 4


        AddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ChosenDegree = DegreeDropDown.getSelectedItem().toString();
                String Mark = MarkTXT.getText();
                String Grade = GradeDropDown.getSelectedItem().toString();
                String TopicCode = TopicCodeTXT.getText();
                String StudentID = StudentIDTxt.getText();
                String LastName = LastNameTxt.getText();
                String FirstName = FirstNameTXT.getText();
                String Major = MajorTXT.getText();
                String Minor = MinorTXT.getText();

                if (FirstNameTXT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, "Please Enter First Name");
                } else if (StudentIDTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, "Please Enter Student ID");
                } else if (LastNameTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, "Please Enter Last Name");
                } else if (FirstNameTXT.getText().isEmpty() && StudentIDTxt.getText().isEmpty() && StudentIDTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, "please Enter all fields");
                } else {
                    if (ChosenDegree.equals("Science")) {
                        ChosenDegree = "S";
                        String test = studentDatabase.addStudent(ChosenDegree + "," + StudentID + "," + LastName + "," + FirstName);
                        JOptionPane.showMessageDialog(c, test);
                    } else if (ChosenDegree.equals("Art")) {
                        ChosenDegree = "A";
                        String test = studentDatabase.addStudent(ChosenDegree + "," + StudentID + "," + LastName + "," + FirstName + "," + Major + "," + Minor);
                        JOptionPane.showMessageDialog(c, test);

                    } else if (ChosenDegree.equals("Medicine")) {
                        ChosenDegree = "M";
                        String test = studentDatabase.addStudent(ChosenDegree + "," + StudentID + "," + LastName + "," + FirstName);
                        JOptionPane.showMessageDialog(c, test);
                    }

                }


            }
        });

        FindStudent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String StudentID = StudentIDTxt.getText();
                if (StudentIDTxt.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(
                            null, "Please Enter Student Number");
                } else {
                    Student s = studentDatabase.findStudent(StudentID);
                    if (s != null) {
                        JOptionPane.showMessageDialog(c,
                                s.show());
                    } else {
                        JOptionPane.showMessageDialog(c, "Can't find student");
                    }

                }

            }
        });

        AddTopicResult.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String Mark = MarkTXT.getText();
                String Grade = GradeDropDown.getSelectedItem().toString();
                String TopicCode = TopicCodeTXT.getText();
                String StudentID = StudentIDTxt.getText();
                String result = "R," + StudentID + "," + TopicCode + "," + Grade + "," + Mark;
                String result1 = "No Added";
                if (studentDatabase.addResult(result, StudentID) == true) {
                    result1 = "Added";
                }
                JOptionPane.showMessageDialog(c, result1
                );
            }
        });
        FindTopicResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TopicCode = TopicCodeTXT.getText();
                JOptionPane.showMessageDialog(c, studentDatabase.findResults(TopicCode)
                );
            }
        });

        AwardPrize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prizeName = PrizeNameTXT.getText();
                String template = TemplateTXT.getText();
                String numberOfTopic = NoOfTopicsTXT.getText();
                String StudentID = StudentIDTxt.getText();
                String reward = StudentID + "," + prizeName + "," + template + "," + numberOfTopic;
                String result1 = "Null";
                if (studentDatabase.addRewards(reward) == true) {
                    result1 = "Added";
                }
                JOptionPane.showMessageDialog(c, result1
                );
            }
        });

        PrintAllRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(c, studentDatabase.printRecords()
                );
            }
        });
        ClearAllRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentDatabase.clearRecords();
            }
        });


        panel.setBorder(br);
        panel2.setBorder(br);
        panel3.setBorder(br);
        panel4.setBorder(br);

        //adding the panel to the Container of the JFrame
        c.add(panel);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Panels();
    }
}