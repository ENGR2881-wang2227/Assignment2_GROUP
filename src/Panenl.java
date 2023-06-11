import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        StudentIDTxt.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = StudentIDTxt.getText();
                int l = value.length();
                if (ke.getKeyChar() == 10) {
                } else if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    StudentIDTxt.setEditable(true);

                } else if (ke.getKeyChar() == 8) {
                } else {
                    StudentIDTxt.setText("");
                    JOptionPane.showMessageDialog(
                            null, "Please Enter vaild student ID");
                }
            }
        });

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
        MarkTXT.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = StudentIDTxt.getText();
                int l = value.length();
                if (ke.getKeyChar() == 10) {
                } else if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    StudentIDTxt.setEditable(true);

                } else if (ke.getKeyChar() == 8) {
                } else {
                    StudentIDTxt.setText("");
                    JOptionPane.showMessageDialog(
                            null, "Please Enter vaild Mark");
                }
            }
        });

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
                if (AddStudent.getText() == "New Student") {
                    DegreeDropDown.setSelectedItem("Science");
                    StudentIDTxt.setText("");
                    LastNameTxt.setText("");
                    FirstNameTXT.setText("");
                    MajorTXT.setText("");
                    MinorTXT.setText("");
                    PrizesTXT.setText("");
                    TopicCodeTXT.setText("");
                    GradeDropDown.setSelectedItem("FL");
                    MarkTXT.setText("");
                    AddStudent.setText("Add Student");
                } else {
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
                        String test = "";
                        if (StudentID.length() == 7) {
                            if (ChosenDegree.equals("Science")) {
                                ChosenDegree = "S";
                                test = studentDatabase.addStudent(ChosenDegree + "," + StudentID + "," + LastName + "," + FirstName);
                                JOptionPane.showMessageDialog(c, test);
                            } else if (ChosenDegree.equals("Art")) {
                                ChosenDegree = "A";
                                if (MajorTXT.getText().isEmpty() || MinorTXT.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(c, "Please enter an Arts Major and  Minor");
                                    test = "arts";
                                } else {
                                    test = studentDatabase.addStudent(ChosenDegree + "," + StudentID + "," + LastName + "," + FirstName + "," + Major + "," + Minor);
                                    JOptionPane.showMessageDialog(c, test);
                                }

                            } else if (ChosenDegree.equals("Medicine")) {
                                ChosenDegree = "M";
                                String add = "";
                                if (!PrizesTXT.getText().isEmpty()){
                                    String[] prizes = PrizesTXT.getText().split("\n");
                                    for (String s : prizes) {
                                        add += "," + s;
                                    }
                                }
                                test = studentDatabase.addStudent(ChosenDegree + "," + StudentID + "," + LastName + "," + FirstName + add);
                                JOptionPane.showMessageDialog(c, test);
                            }
                            if (!test.equals("Already in system") && !test.equals("arts") && !test.equals("")) {
                                AddStudent.setText("New Student");
                            } else if (test.equals("arts")){
                            } else {
                                StudentIDTxt.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "Please Enter 7 digits student ID");
                        }


                    }


                }
            }
        });

        FindStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StudentID = StudentIDTxt.getText();
                if (StudentIDTxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, "Please Enter Student Number");
                } else {
                    Student s = studentDatabase.findStudent(StudentID);
                    if (s != null) {
                        JOptionPane.showMessageDialog(c,
                                s.show());
                        StudentIDTxt.setText(s.getStudentID());
                        LastNameTxt.setText(s.getLastName());
                        FirstNameTXT.setText(s.getFirstName());
                        DegreeDropDown.setSelectedItem(s.getDegree());
                        if (s instanceof AStudent) {
                            MajorTXT.setText(((AStudent) s).getMajor());
                            MinorTXT.setText(((AStudent) s).getMinor());
                        } else {
                            MajorTXT.setText("");
                            MinorTXT.setText("");
                        }
                        if (s instanceof MStudent) {
                                String prizes = "";
                                PrizesTXT.setText(((MStudent) s).getList());
                        } else {
                            PrizesTXT.setText("");
                        }
                        AddStudent.setText("New Student");
                    }
                    else {
                        JOptionPane.showMessageDialog(c, "Can't find student");
                    }

                }

            }
        });

        AddTopicResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Mark = MarkTXT.getText();
                String Grade = GradeDropDown.getSelectedItem().toString();
                String TopicCode = TopicCodeTXT.getText();
                String StudentID = StudentIDTxt.getText();
                String result = Mark.isEmpty() ?
                        "R," + StudentID + "," + TopicCode + "," + Grade :
                        "R," + StudentID + "," + TopicCode + "," + Grade + "," + Mark;
                String result1 = "Topic already exists for this student";
                if (Mark.length() == 2 || Mark.length() == 1 || Mark.equals("100") || Mark.isEmpty()) {
                    if (TopicCode.matches("^[A-Z]{4}\\d{4}$")) {
                        if (studentDatabase.addResult(result, StudentID) == true) {
                            result1 = "Added";
                        } else {
                                Student s = studentDatabase.findStudent(StudentID);
                                if (s !=  null) {
                                Topic t = studentDatabase.findStudent(StudentID).getTopicResult(TopicCode);
                                GradeDropDown.setSelectedItem(t.getGrade());
                                MarkTXT.setText("" + t.getMark());
                                result1 += "\n" + t.show();
                            } else {
                                    result1 = "Enter valid student ID";
                                }
                        }
                        JOptionPane.showMessageDialog(c, result1
                        );
                    }
                    else{
                        JOptionPane.showMessageDialog(
                                null, "Please Enter a valid 8 digit TopicCode");
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Please Enter a valid Mark");
                }
            }
        });
        FindTopicResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StudentID = StudentIDTxt.getText();
                String TopicCode = TopicCodeTXT.getText();
                Student s; Topic T;
                if ((s = studentDatabase.findStudent(StudentID)) != null) {
                    if ((T = s.getTopicResult(TopicCode)) != null) {
                        String out = s.showName() + "\n" + T.show();
                        JOptionPane.showMessageDialog(c, out);
                        MarkTXT.setText(("" + T.getMark()));
                        GradeDropDown.setSelectedItem(T.getGrade());
                    } else {
                        JOptionPane.showMessageDialog(c, "No Result for this Topic");
                        MarkTXT.setText("" );
                        GradeDropDown.setSelectedItem("FL");
                    }
                } else {
                    JOptionPane.showMessageDialog(c,"There is no student with that ID");
                }
            }
        });

        AwardPrize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result1 = "Prize Awarded";
                if (PrizeNameTXT.getText().isEmpty()) {
                    result1 = "Please enter a prize name";
                } else if (TemplateTXT.getText().isEmpty()) {
                    result1 = "Please enter a template";
                } else if (NoOfTopicsTXT.getText().isEmpty()) {
                    result1 = "Please enter an integer for minimum number of topics required";
                } else {
                    String prizeName = PrizeNameTXT.getText();
                    String template = TemplateTXT.getText();
                    String numberOfTopic = NoOfTopicsTXT.getText();
                    if (numberOfTopic.matches("[0-9]{1,}")) {
                        String reward = "P," + prizeName + "," + template + "," + numberOfTopic;
                        if (!studentDatabase.addPrize(reward)) {
                            result1 = "Prize already exists.";
                        }
                        if (studentDatabase.awardPrizes()) {

                        } else {
                            result1 = "No student meets the requirements for this prize";
                        }
                        PrizeNameTXT.setText("");
                        TemplateTXT.setText("");
                        NoOfTopicsTXT.setText("");
                    } else {
                        result1 = "Please enter an integer for minimum number of topics required";
                        NoOfTopicsTXT.setText("");
                    }
                    //String StudentID = StudentIDTxt.getText();

                }
                JOptionPane.showMessageDialog(c, result1);
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
                DegreeDropDown.setSelectedItem("Science");
                StudentIDTxt.setText("");
                LastNameTxt.setText("");
                FirstNameTXT.setText("");
                MajorTXT.setText("");
                MinorTXT.setText("");
                PrizesTXT.setText("");
                TopicCodeTXT.setText("");
                GradeDropDown.setSelectedItem("FL");
                MarkTXT.setText("");
                AddStudent.setText("Add Student");
                JOptionPane.showMessageDialog(c, "Records Cleared");
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