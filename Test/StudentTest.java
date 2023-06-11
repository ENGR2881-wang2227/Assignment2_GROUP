import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 1)
    void setDegree(String command,String degree) {
        HashMap<String,String> expected = new HashMap<>();
        expected.put("S","Science");
        expected.put("A","Arts");
        expected.put("M","Medicine");
        Student test = new Student(command);
        test.setDegree(degree);
        String output = test.getDegree();
        assertEquals(expected.get(degree),output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 1)
    public void getLastName(String command) {
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getLastName();
        assertEquals(points[3],output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 1)
    public void getFirstName(String command) {
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getFirstName();
        assertEquals(points[2],output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 1)
    public void getStudentID(String command) {
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getStudentID();
        assertEquals(points[1],output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 1)
    public void getDegree(String command) {
        HashMap<String,String> expected = new HashMap<>();
        expected.put("S","Science");
        expected.put("A","Arts");
        expected.put("M","Medicine");
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getDegree();
        assertEquals(expected.get(points[0]),output);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,5,10,20})
    public void getTopicCount(int num) {
        Student test = new Student("S,9800123,Smith,John Paul");
        for (int i=0;i<num;i++){
            test.addResult("R,9800123,AAAA" + (1000 + i) + ",FL," + i);
        }
        int output = test.getTopicCount();
        assertEquals(num,output);
    }

    //Test Student Constructor
    @Test
    public void StudentConstructorTest() {
        String testInput = "S,1000001,Student,Test";
        Student test = new Student(testInput);
        assertAll(
                () -> assertEquals("Science", test.getDegree()),
                () -> assertEquals("1000001", test.getStudentID()),
                () -> assertEquals("Student", test.getFirstName()),
                () -> assertEquals("Test", test.getLastName())
        );
    }

    @Test
    void TestSetDegree() {
        String testInput = "S,1000001,Student,Test";
        Student test = new Student(testInput);
        test.setDegree("M");
        assertEquals("Medicine", test.getDegree());
    }

    @Test
    void TestSetIncorrectDegree() {
        String testInput = "S,1000001,Student,Test";
        Student test = new Student(testInput);
        assertThrows(IllegalArgumentException.class, () -> {
            test.setDegree("K");
        });
    }

    //Testing an incorrect degree input (F is not a valid degree)
    @Test
    public void IncorrectDegreeTest() {
        String testInput = "F,1000001,Student,Test";
        assertThrows(IllegalArgumentException.class, () -> {
            Student test = new Student(testInput);
        });
    }

    //Testing a student ID of incorrect length
    @Test
    public void IncorrectStudentIDLengthTest() {
        String testInput = "S,10001,Student,Test";
        assertThrows(IllegalArgumentException.class, () -> {
            Student test = new Student(testInput);
        });
    }

    //Testing a student ID input that is not a number
    @Test
    public void IncorrectStudentIDFormatTest() {
        String testInput = "S,StudentID,Student,Test";
        assertThrows(IllegalArgumentException.class, () -> {
            Student test = new Student(testInput);
        });
    }

    //Testing a blank student ID input
    @Test
    public void BlankStudentIDTest() {
        String testInput = "S,,Student,Test";
        assertThrows(IllegalArgumentException.class, () -> {
            Student test = new Student(testInput);
        });
    }

    //Testing a Student input with too few elements
    @Test
    public void IncorrectInputFormatTest() {
        String testInput = "S,1000001,Student";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Student test = new Student(testInput);
        });
    }

    //Testing a Student input with a blank name
    @Test
    public void BlankNameTest() {
        String testInput = "S,100001,Student,";
        assertThrows(IllegalArgumentException.class, () -> {
            Student test = new Student(testInput);
        });
    }


    @Test
    public void addResult() {
        Student test = new Student("S,9800123,Smith,John Paul");
        for (int i=0;i<10;i++){
            test.addResult("R,9800123,AAAA100"+i+",FL,"+i);
        }
        ArrayList<Topic> output = test.getResult();
        String out = "";
        String expected = "AAAA1000 FL 0|AAAA1001 FL 1|AAAA1002 FL 2|AAAA1003 FL 3|AAAA1004 FL 4|AAAA1005 FL 5|AAAA1006 FL 6|AAAA1007 FL 7|AAAA1008 FL 8|AAAA1009 FL 9|";
        for (int i=0;i<output.size();i++){
            out += output.get(i).show()+"|";
        }
        assertEquals(expected,out);
    }

    @Test
    public void resultSize() {
        Student test = new Student("S,9800123,Smith,John Paul");
        for (int i=0;i<5;i++){
            test.addResult("R,9800123,AAAA100" + i + ",DN,82");
        }
        assertEquals(10,test.getTopicCount() + test.resultSize());
    }

    //Testing result input with no mark
    @Test
    public void AddResultNoMarkTest() {
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,DN";
        Student test = new Student(testInput);
        test.addResult(testResult);
        assertEquals("Test Student (Student ID: 1000001)\n" +
                "Degree: Science\n" +
                "AAAA1111 DN 75", test.show());
    }

    @Test
    public void GetTopicResultTest() {
        Student test = new Student("S,1000001,Student,Test");
        test.addResult("R,1000001,TEST1001,HD,100");
        Topic expected = new Topic("TEST1001","HD",100);
        assertEquals(expected.show(), test.getTopicResult("TEST1001").show());
    }

    @Test
    public void GetNonExistantTopicResultTest() {
        Student test = new Student("S,1000001,Student,Test");
        assertEquals(null, test.getTopicResult("TEST1001"));
    }

    //Testing result input with too few arguments
    @Test
    public void AddIncorrectResultInput() {
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111";
        Student test = new Student(testInput);
        assertThrows(IllegalArgumentException.class, () -> {
            test.addResult(testResult);
        });
    }

    @Test
    public void show() {
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,DN,82";
        Student test = new Student(testInput);
        test.addResult(testResult);
        assertEquals("Test Student (Student ID: 1000001)\n" +
                "Degree: Science\n" +
                "AAAA1111 DN 82", test.show());
    }
}