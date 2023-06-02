import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 1)
    void setDegree(String command,String degree) {
        Student test = new Student(command);
        test.setDegree(degree);
        String output = test.getDegree();
        assertEquals(degree,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 11)
    void getLastName(String command) {
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getLastName();
        assertEquals(points[3],output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 21)
    void getFirstName(String command) {
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getLastName();
        assertEquals(points[2],output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 31)
    void getStudentID(String command) {
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getLastName();
        assertEquals(points[1],output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 41)
    void getDegree(String command) {
        Student test = new Student(command);
        String[] points = command.split(",");
        String output = test.getLastName();
        assertEquals(points[0],output);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,5,10,20})
    void getTopicCount(int num) {
        Student test = new Student("S,9800123,Smith,John Paul");
        for (int i=0;i<num;i++){
            test.addResult("1,1,1");
        }
        int output = test.getTopicCount();
        assertEquals(num,output);
    }

    //Testing an incorrect degree input (F is not a valid degree)
    @Test
    public void IncorrectDegreeTest() {
        String testInput = "F,1000001,Student,Test";
        assertThrows(IllegalArgumentException.class, () -> {
            Student test = new Student(testInput);
        });
    }

    //Testing a student ID of incorrect length (expecting an exception or message)
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
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Student test = new Student(testInput);
        });
    }


    @Test
    void addResult() {
        Student test = new Student("S,9800123,Smith,John Paul");
        for (int i=0;i<10;i++){
            test.addResult(i+","+i+","+i);
        }
        ArrayList<Topic> output = test.getResult();
        String out = "";
        String expected = "";
        for (int i=0;i<output.size();i++){
            out += output.get(i).show()+"|";
            expected += i+","+i+","+i+"|";
        }
        assertEquals(expected,out);
    }

    @Test
    void resultSize() {
        Student test = new Student("S,9800123,Smith,John Paul");
        for (int i=0;i<5;i++){
            test.addResult("1,1,1");
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
                "Topic Code: AAAA1111, Grade: DN. \n", test.show());
    }

    //Testing two results for the same topic code
    @Test
    public void AddDuplicateResultsTest() {
        String testInput = "S,1000001,Student,Test";
        String testResult1 = "R,1000001,AAAA1111,DN,82";
        String testResult2 = "R,1000001,AAAA1111,CR,67";
        Student test = new Student(testInput);
        test.addResult(testResult1);
        assertThrows(IllegalArgumentException.class, () -> {
            test.addResult(testResult2);
        });
    }

    //Testing result input with too few arguments
    @Test
    public void AddIncorrectResultInput() {
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111";
        Student test = new Student(testInput);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            test.addResult(testResult);
        });
    }

    @Test
    void show() {
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,DN,82";
        Student test = new Student(testInput);
        test.addResult(testResult);
        assertEquals("Test Student (Student ID: 1000001)\n" +
                "Degree: Science\n" +
                "Topic Code: AAAA1111, Grade: DN, Mark: 82. \n", test.show());
    }
}