import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MStudentTest {

    @ParameterizedTest
    @CsvFileSource(resources = "TestingData/StudentDataP.csv", numLinesToSkip = 1)
    void addPrizesTest(String name, String template, String topic) {
        MStudent test = new MStudent("M,1000001,Student,Test");
        test.addPrizes(name, template, topic);
        String output = test.show();
        String expected = "Test Student (Student ID: 1000001)\n";
        expected += "Degree: Medicine\n";
        expected += "Prize: " + name;
        assertEquals(expected, output);
    }

    @Test
    void testConstructor() {
        String testInput = "M,1000001,Student,Test";
        Student test = new MStudent(testInput);
        assertAll(
                () -> assertEquals("Medicine", test.getDegree()),
                () -> assertEquals("1000001", test.getStudentID()),
                () -> assertEquals("Student", test.getFirstName()),
                () -> assertEquals("Test", test.getLastName())
        );
    }

    @Test
    void testConstructorWithPrize() {
        String testInput = "M,1000001,Student,Test,TestPrize";
        Student test = new MStudent(testInput);
        assertAll(
                () -> assertEquals("Medicine", test.getDegree()),
                () -> assertEquals("1000001", test.getStudentID()),
                () -> assertEquals("Student", test.getFirstName()),
                () -> assertEquals("Test", test.getLastName())
        );
    }

    @Test
    void testConstructorWithMultiplePrizes() {
        String testInput = "M,1000001,Student,Test,TestPrize1,TestPrize2,TestPrize3";
        Student test = new MStudent(testInput);
        assertAll(
                () -> assertEquals("Medicine", test.getDegree()),
                () -> assertEquals("1000001", test.getStudentID()),
                () -> assertEquals("Student", test.getFirstName()),
                () -> assertEquals("Test", test.getLastName())
        );
    }

    @Test
    void testAddPrizes() {
        String testInput = "M,1000001,Student,Test";
        MStudent test = new MStudent(testInput);
        test.addPrizes("Test Prize", "TEMPLATE", "1");
        assertEquals("Test Prize", test.getList());
    }

    @Test
    void testAddPrize() {
        String testInput = "M,1000001,Student,Test";
        MStudent test = new MStudent(testInput);
        Prize testP = new Prize("Test Prize", "TEMPLATE", "1");
        test.addPrize(testP);
        assertEquals("Test Prize", test.getList());
    }

    @Test
    void testAddMulitplePrizes() {
        String testInput = "M,1000001,Student,Test";
        MStudent test = new MStudent(testInput);
        Prize testP = new Prize("Test Prize", "TEMP", "1");
        Prize testP1 = new Prize("Test Prize1", "TEMP", "1");
        Prize testP2 = new Prize("Test Prize2", "TEMP", "1");
        test.addPrize(testP);
        test.addPrize(testP1);
        test.addPrize(testP2);
        assertEquals("Test Prize\nTest Prize1\nTest Prize2", test.getList());
    }

    @Test
    void testShow() {
        String testInput = "M,1000001,Student,Test";
        MStudent test = new MStudent(testInput);
        assertEquals("Test Student (Student ID: 1000001)\n" +
                "Degree: Medicine", test.show());
    }

    @Test
    void testShowWithPrizes() {
        String testInput = "M,1000001,Student,Test";
        MStudent test = new MStudent(testInput);
        Prize testP = new Prize("Test Prize", "TEMPLATE", "1");
        Prize testP1 = new Prize("Test Prize1", "TEMPLATE", "1");
        Prize testP2 = new Prize("Test Prize2", "TEMPLATE", "1");
        test.addPrize(testP);
        test.addPrize(testP1);
        test.addPrize(testP2);
        assertEquals("Test Student (Student ID: 1000001)\n" +
                "Degree: Medicine\nPrize: Test Prize\nPrize: Test Prize1\nPrize: Test Prize2", test.show());
    }
}