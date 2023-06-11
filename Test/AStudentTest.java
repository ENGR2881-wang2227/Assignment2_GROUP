import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AStudentTest {
    @Test
    void testConstructor() {
        String testInput = "A,1000001,Student,Test,Major,Minor";
        AStudent test = new AStudent(testInput);
        assertAll(
                () -> assertEquals("Art", test.getDegree()),
                () -> assertEquals("1000001", test.getStudentID()),
                () -> assertEquals("Student", test.getFirstName()),
                () -> assertEquals("Test", test.getLastName()),
                () -> assertEquals("Major", test.getMajor()),
                () -> assertEquals("Minor", test.getMinor())
        );
    }

    @Test
    void testShow() {
        String testInput = "A,1000001,Student,Test,Major,Minor";
        AStudent test = new AStudent(testInput);
        assertEquals("Test Student (Student ID: 1000001)\n" +
                "Degree: Art\nMajor: Major\nMinor: Minor", test.show());
    }
}
