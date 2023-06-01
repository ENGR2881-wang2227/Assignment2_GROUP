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

    @Test
    void show() {

    }
}