import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MStudentTest {

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentData.csv", numLinesToSkip = 1)
    void addPrizesTest(String name, String template, String topic) {
        MStudent test = new MStudent("M 1 A B");
        test.addPrizes(name, template, topic);
        String output = test.show();
        String expected = "A B (Student ID: 1)\n";
        expected += "Degree: M";
        expected += "Name: " + name + " Template: " + template + " Topics Required: " + topic + "\n";
        assertEquals(expected, output);
    }
}