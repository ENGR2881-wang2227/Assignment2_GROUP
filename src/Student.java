import java.util.ArrayList;

public class Student {
    private String lastName= "Null", firstName= "Null", studentID = "Null",degree= "Null";
    private int topicCount = 0;
    private ArrayList<Topic> result = new ArrayList<>();


    public Student(String input) {
        String[] list = input.split(",");
        this.degree = list[0];
        this.studentID = list[1];
        this.firstName = list[2];
        this.lastName = list[3];

    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getDegree() {
        if(degree.equals("S")){return "Science";}
        else if(degree.equals("A")){ return " Art";}
        else if(degree.equals("M")){ return "Medicine";}
        else
        return degree;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public ArrayList<Topic> getResult() {
        return result;
    }

    public void addResult(String input)
    {
        if(result.size()<24);
        String[] list = input.split(",");
        result.add(new Topic(list[2], list[3], Integer.valueOf(list[4])));
        topicCount++;
    }


    public String show() {
        String print1 = "";
        print1 += firstName + " " + lastName + " (Student ID: " + studentID + ")\n";
        print1 += "Degree: " + getDegree();
        if (result.size() != 0)
        {
            print1+="\n";
            for (int i = 0; i < result.size(); i++)
            {
                print1 += "Topic Code: "+result.get(i).getCode() + ", Grade: " + result.get(i).getGrade() + ", Mark: " + result.get(i).getMark() + ". \n";
            }
        }
        print1 += "\n";
        return print1;
    }


}