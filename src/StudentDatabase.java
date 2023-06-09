import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class StudentDatabase {
    private ArrayList<Student> database = new ArrayList<>();
    private LinkedList<Prize> prizes =  new LinkedList<>();
    private int studentCount;

    public ArrayList<Student> getDb() {
        return database;
    }

    public StudentDatabase() {
    }

    public String addStudent(String student) {
        if (database.size() < 1000) {
            String[] list = student.split(",");
            for (int i = 0; i < database.size(); i++) {
                if (list[1].equals(database.get(i).getStudentID())) {
                    return "Already in system";
                }
            }
            switch (list[0]) {
                case "M":
                    database.add(new MStudent(student));
                    break;
                case "A":
                    database.add(new AStudent(student));
                    break;
                default:
                    database.add(new Student(student));
                    break;

            }
            return "Done";
        }
        return"More than 1000 students unable to add, please clear database";
    }


    public Student findStudent(String id) {
        for (int i = 0; i < database.size(); i++) {
            if (id.equals(database.get(i).getStudentID())) {
                return database.get(i);
            }
        }
        return null;
    }

    public boolean addResult(String result, String studentID) {
        boolean b = false;
        for (int i = 0; i < database.size(); i++) {
            if (studentID.equals(database.get(i).getStudentID())&&database.get(i).resultSize()<24) {
                if(database.get(i).checkResult(result) == true){
                    database.get(i).addResult(result);
                    b = true;
                }

            }
        }
        return b;
    }

    public String findResults(String topic) {
        String results = "Result record for Topic: " + topic + "\n";
        double average = 0;
        int count = 0;
        for (int i = 0; i < database.size(); i++) {
            for (int j = 0; j < database.get(i).getResult().size(); j++) {
                if (database.get(i).getResult().get(j).getCode().equals(topic)) {
                    average += database.get(i).getResult().get(j).getMark();
                    count++;
                    results += database.get(i).getResult().get(j).show() + "\n";
                }

            }

        }
        if (count != 0) {
            average = average / count;
        }
        if(count==0){
            return "No result found";
        }
        DecimalFormat decfor = new DecimalFormat("0.00");
        return results + "Average: " + decfor.format(average);

    }

    public boolean addPrize(String prize) {
        String[] list = prize.split(",");
        for (Prize p : prizes) {
            if (p.getName().equals(list[1])) {
                return false;
            }
        }
        prizes.add(new Prize(list[1], list[2], list[3]));
        return true;
    }

    public boolean awardPrize(Prize prize) {
        MStudent recipient = null; double highest = 0; int req = Integer.parseInt(prize.getTopicsRequired());
        for (Student m : database) {
            if (m instanceof MStudent) {
                ArrayList<Integer> scores = new ArrayList<>();
                for (Topic t : m.getResult()) {
                    if (t.getCode().substring(0,prize.getTemplate().length()).matches(prize.getTemplate())) {
                        scores.add(t.getMark());
                    }
                }
                if (scores.size() >= req) {
                    Collections.sort(scores);
                    double total = 0;
                    for (int i = 0; i < req; i++) {
                        total += scores.get(i);
                    }
                    if (total > highest) {
                        recipient = (MStudent) m;
                        highest = total;
                    }
                }
            }
        }
        if (recipient != null) {
            recipient.addPrize(prize);
            return true;
        } else {
            return false;
        }
    }


    public boolean addRewards(String reward) {
        String[] list = reward.split(",");
        boolean b = false;
        for (int i = 0; i < database.size(); i++) {
            if (list[0].equals(database.get(i).getStudentID())) {
                if (database.get(i) instanceof MStudent) {
                    ((MStudent) database.get(i)).addPrizes(list[1], list[2], list[3]);
                    b = true;
                }
            }
        }
        return b;
    }

    public boolean awardPrizes() {
        boolean b = false;
        for (Prize p : prizes) {
           if (awardPrize(p)) {
               b = true;
           }
        }
        prizes.clear();
        return b;
    }

    public String printRecords() {
//
        String output = "";
        if (database.size() != 0) {
            for (int i = 0; i < database.size(); i++) {
                output += "Academic record for ";
                output += database.get(i).show();
                output += "\n\n";
            }
        } else {
            output = "no records";
        }
        return output.trim();
    }

    public void clearRecords() {
        database.clear();
    }

    public ArrayList<Student> readFile(String filename){
        int line = 0;
        try {            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                line++;
                String[] command = data.split(",");
                switch (command[0]) {
                    case "S", "M", "A" -> {
                        if (command.length == 4 || command.length == 6) {
                            addStudent(data);
                        } else if (command[0].equals("M") && command.length > 4){
                            addStudent(data);
                        } else throw new Exception("Malformed student command on line " + line + ":[ " + data + "]");
                    }
                    case "R" -> {
                        if (command.length == 4 || command.length == 5) {
                            addResult(data,command[1]);
                        } else {
                            throw new Exception("Malformed result command on line " + line + ": [" + data + "]");
                        }
                    }
                    case "P" -> {
                        if (command.length == 4) {
                            addPrize(data);
                        } else {
                            throw new Exception("Malformed prize command, line " + line + ": [" + data + "]");
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        awardPrizes();
        return database;
    }

    public void recordsToFile(String destination){
        try {
            FileWriter Writer = new FileWriter(destination);
            Writer.write(printRecords());
            Writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
