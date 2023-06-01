import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/prizeData.csv", numLinesToSkip = 1)
    void getNameTest(String name, String template, String topicsRequired) {
        Prize test = new Prize(name,template,topicsRequired);
        String output = test.getName();
        assertEquals(name,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/prizeData.csv", numLinesToSkip = 21)
    void getTemplateTest(String name, String template, String topicsRequired) {
        Prize test = new Prize(name,template,topicsRequired);
        String output = test.getTemplate();
        assertEquals(template,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/prizeData.csv", numLinesToSkip = 31)
    void getTopicsRequiredTest(String name, String template, String topicsRequired) {
        Prize test = new Prize(name,template,topicsRequired);
        String output = test.getTopicsRequired();
        assertEquals(topicsRequired,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/prizeData.csv", numLinesToSkip = 41)
    void showTest(String name, String template, String topicsRequired) {
        Prize Test = new Prize(name,template,topicsRequired);
        String output = Test.show();
        String expected = "Name: " + name + " Template: " + template + " Topics Required: " + topicsRequired + "\n";
        assertEquals(expected,output);
    }
}