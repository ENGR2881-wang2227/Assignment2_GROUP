import java.util.ArrayList;

public class Student {
    private String lastName= "Null", firstName= "Null", studentID = "Null",degree= "Null";
    private int topicCount = 0;
    private ArrayList<Topic> result = new ArrayList<>();


    public Student(String input) {
        String[] list = input.split(",");
        if (list[0].equals("S") || list[0].equals("M") || list[0].equals("A")) {
            this.degree = list[0];
        } else throw new IllegalArgumentException("Degree must be A, M or S");
        if (list[1].length() == 7 && list[1].matches("\\d+")) {
            this.studentID = list[1];
        } else throw new IllegalArgumentException("Student ID must be a 7 digit integer.");
        this.firstName = list[2];
        this.lastName = list[3];

    }

    public void setDegree(String degree) {
        if (degree.equals("A") || degree.equals("M") || degree.equals("S")) {
            this.degree = degree;
        } else throw new IllegalArgumentException("Degree must be A, M, S");

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
        else if(degree.equals("A")){ return "Arts";}
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

    public Topic getTopicResult(String TopicCode) {
        for (Topic t : result) {
            if (t.getCode().matches(TopicCode)){
                return t;
            }
        }
        return null;
    }

    public void addResult(String input)
    {
        if(result.size()<24){
            String[] list = input.split(",");
            if (list.length == 4) {
                int mk = 0;
                switch (list[3]) {
                    case "FL" -> mk = 0;
                    case "PS" -> mk = 50;
                    case "CR" -> mk = 65;
                    case "DN" -> mk = 75;
                    case "HD" -> mk = 85;
                }
                result.add(new Topic(list[2], list[3], mk));
            } else if (list.length == 5) {
                result.add(new Topic(list[2], list[3], Integer.parseInt(list[4])));
            } else throw new IllegalArgumentException("Malformed result line");
            topicCount++;
        }
    }
    public boolean checkResult(String input){
        for(int i = 0; i<result.size();i++){
            String[] list = input.split(",");
            if(list[2].equals(result.get(i).getCode())){
                return false;
            }
        }
        return true;
    }

    public int resultSize(){
        return result.size();
    }

    public String showName() {
        String print1 = "";
        print1 +=  lastName + " " + firstName + " (Student ID: " + studentID + ")\n";
        print1 += "Degree: " + getDegree();
        return print1;
    }

//    public String showResults() {
//        String print1 = "";
//        if (result.size() != 0)
//        {
//            print1+="\n";
//            for (int i = 0; i < result.size(); i++)
//            {
//                print1 += "Topic Code: "+result.get(i).getCode() + ", Grade: " + result.get(i).getGrade() + ", Mark: " + result.get(i).getMark() + ".\n";
//            }
//        }
//        print1 += "\n";
//        return print1.trim();
//    }

    public String showResults1() {
        String print1 = "";
        if (result.size() != 0)
        {
            print1+="\n";
            for (int i = 0; i < result.size(); i++)
            {
                print1 += result.get(i).show() + "\n";
            }
        }
        print1 += "\n";
        return print1.trim();
    }
    public String show() {
        String print1 = "";
        print1 +=  lastName + " " + firstName + " (Student ID: " + studentID + ")\n";
        print1 += "Degree: " + getDegree();
        if (result.size() != 0)
        {
            print1+="\n";
            print1+= showResults1();
        }
        print1 += "\n";
        return print1.trim();
    }


}