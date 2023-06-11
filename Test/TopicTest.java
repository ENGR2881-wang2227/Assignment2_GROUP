import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class TopicTest {

    @Test
    public void TopicConstructorTest() {
        Topic test = new Topic("TEST1000", "CR", 69);
        assertAll(
                () -> assertEquals("TEST1000", test.getCode()),
                () -> assertEquals("CR", test.getGrade()),
                () -> assertEquals(69, test.getMark())
        );
    }

    @Test
    void TopicShowTest() {
        Topic test = new Topic("TEST1000", "CR", 69);
        assertEquals("TEST1000 CR 69", test.show());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/badTopicData.csv", numLinesToSkip = 1)
    void ConstructorFailTest(String Code, String Grade,int Mark){
            assertThrows(IllegalArgumentException.class, () -> {
                Topic test = new Topic(Code,Grade,Mark);
            });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/topicData.csv", numLinesToSkip = 1)
    void ConstructorTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        String output = test.show();
        assertEquals(Code + " " + Grade + " " + Mark ,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/topicData.csv", numLinesToSkip = 1)
    void GetCodeTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        String output = test.getCode();
        assertEquals(Code ,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/topicData.csv", numLinesToSkip = 1)
    void GetGradeTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        String output = test.getGrade();
        assertEquals(Grade ,output);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/topicData.csv", numLinesToSkip = 1)
    void GetMarkTest(String Code, String Grade, int Mark){
        Topic test = new Topic(Code, Grade, Mark);
        int output = test.getMark();
        assertEquals(Mark ,output);
    }
}