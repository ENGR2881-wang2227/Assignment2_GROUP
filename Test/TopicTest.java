import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class TopicTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/topicData.csv", numLinesToSkip = 1)
    void ConstructorFailTest(String Code, String Grade, String Mark){
            //assertThrows(class, () -> {

            //});
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/topicData.csv", numLinesToSkip = 1)
    void ConstructorTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        String output = test.show();
        assertEquals(Code + " " + Grade + " " + Mark ,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/topicData.csv", numLinesToSkip = 2)
    void GetCodeTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        String output = test.getCode();
        assertEquals(Code ,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/topicData.csv", numLinesToSkip = 3)
    void GetGradeTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        String output = test.getGrade();
        assertEquals(Grade ,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/topicData.csv", numLinesToSkip = 4)
    void GetMarkTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        int output = test.getMark();
        assertEquals(Mark ,output);
    }
}