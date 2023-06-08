import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {

    /*sanity student
    multiple student

    Student / result
    find amoung many
    find amoung similar
    find non existant

    add rewards
    add reward to non existant student
    add reward to multiple equal students

    print records
    print empty records

    empty records

    read from a file
    read an empty file

     */

    @Test
    void getDb() {
    }

    @Test
    void addStudent() {
        StudentDatabase test = new StudentDatabase();
        test.addStudent("S,1,A,B");
        ArrayList<Student> db = test.getDb();
        String output = db.get(0).show();
        String expected = "A B (Student ID 1)\n S";
        assertEquals(expected, output);
    }

    @Test
    void addMultipleStudent() {
        StudentDatabase test = new StudentDatabase();
        for (int i=0;i<5;i++){
            test.addStudent("S,"+i+",A,B");
        }
        ArrayList<Student> db = test.getDb();
        int output = test.getDb().size();
        assertEquals(5, output);
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

    //Testing the addition of an existing student
    @Test
    public void AddExistingStudentTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "S,1000001,Student,Test";
        String testInput2 = "S,1000001,Student,Test";
        testDB.addStudent(testInput1);
        assertEquals("Already in system", testDB.addStudent(testInput2));
    }

    //Testing an incorrect degree database input
    @Test
    public void IncorrectStudentDegreeTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "F,1000001,Student,Test";
        assertThrows(IllegalArgumentException.class, () -> {
            testDB.addStudent(testInput1);
        });
    }

    @Test
    public void IncorrecStudentIDTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "S,10000001,Student,Test";
        assertThrows(IllegalArgumentException.class, () -> {
            testDB.addStudent(testInput1);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","5","9"})
    void findStudent(String id) {
        StudentDatabase test = new StudentDatabase();
        for (int i=0;i<10;i++){
            test.addStudent("S," +i+",A,B");
        }
        Student output = test.findStudent(id);
        assertEquals(id,output.getStudentID());
    }

    @Test
    void findVoid(){
        StudentDatabase test = new StudentDatabase();
        for (int i=0;i<10;i++){
            test.addStudent("S,"+i+",A,B");
        }
        Student output = test.findStudent("10");
        assertEquals(null,output);
    }

    @Test
    void addResult() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,DN,82";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        assertEquals("Academic record for Test Student (Student ID: 1000001)\n" +
                "Degree: Science\n" +
                "Topic Code: AAAA1111, Grade: DN, Mark: 82.", testDB.printRecords().trim());
    }

    @Test
    void findResults() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,DN,82";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        assertEquals("""
                Result record for Topic: AAAA1111
                AAAA1111 DN 82
                Average: 82.00""", testDB.findResults("AAAA1111"));
    }

    @Test
    void addRewards() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,CR,67";
        String testPrize = "P,AAAA Prize,AAAA,1";
        testDB.addStudent(testInput);
        testDB.addResult(testResult,"1000001");
        testDB.addRewards(testPrize);
        assertEquals("""
                Academic record for Test Student (Student ID: 1000001)
                Degree: Science
                Prize: AAAA Prize
                Topic Code: AAAA1111, Grade: CR, Mark: 67.\s
                """, testDB.printRecords().trim());
    }

    @Test
    void printRecords() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,CR,67";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        assertEquals("""
                Academic record for Test Student (Student ID: 1000001)
                Degree: Science
                Topic Code: AAAA1111, Grade: CR, Mark: 67.""", testDB.printRecords().trim());
    }

    @Test
    void printEmptyRecords() {
        StudentDatabase testDB = new StudentDatabase();
        assertEquals("no records", testDB.printRecords());
    }

    @Test
    void clearRecords() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,DN,82";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        testDB.clearRecords();
        assertEquals("no records", testDB.printRecords());
    }

    @Test
    void readFile() {
        StudentDatabase testDB = new StudentDatabase();
        testDB.readFile("TestResources/inputFiles/standard.txt");
        assertEquals("""
                Academic record for John Paul Smith (Student ID: 9800123)
                Degree: Science
                Topic Code: COMP1000, Grade: PS, Mark: 55.\s
                Topic Code: COMP1001, Grade: DN, Mark: 77.\s
                Topic Code: HIST1234, Grade: HD, Mark: 87.\s
                Topic Code: PSYC0123, Grade: FL, Mark: 42.\s


                Academic record for Mary Jones (Student ID: 9821012)
                Degree: Medicine
                Topic Code: BIOL1000, Grade: HD, Mark: 89.\s
                Topic Code: CHEM1001, Grade: HD, Mark: 92.\s
                Topic Code: COMP1000, Grade: DN, Mark: 75.\s
                Topic Code: PHYS1010, Grade: HD, Mark: 93.\s
                
                Prizes:\s
                Academic record for John Howard (Student ID: 9987654)
                Degree:  Art
                Major: Politics
                Minor: Economics
                """, testDB.printRecords());
    }

    @Test
    void readEmptyFile() {
        StudentDatabase testDB = new StudentDatabase();
        testDB.readFile("TestResources/inputFiles/empty.txt");
        assertEquals("no records", testDB.printRecords());
    }

    @Test
    void recordsToFile() throws IOException {
        StudentDatabase testDB = new StudentDatabase();
        testDB.readFile("TestResources/inputFiles/standard.txt");
        testDB.recordsToFile("TestResources/OutputFiles/out.txt");
        String Expected = Files.readString(Paths.get("TestResources/OutputFiles/FileWriteCompare.txt"));
        String Actual = Files.readString(Paths.get("TestResources/OutputFiles/out.txt"));
        Files.delete(Path.of("TestResources/OutputFiles/out.txt"));
        assertEquals(Expected, Actual);
    }
}