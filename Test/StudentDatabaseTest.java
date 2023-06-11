import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {

    @Test
    void getDb() {
        StudentDatabase testDB = new StudentDatabase();
        assertEquals(new ArrayList<Student>(), testDB.getDb());
    }

    //Test Student Constructor
    @Test
    public void AddStudentTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "S,1000001,Student,Test";
        testDB.addStudent(testInput1);
        assertEquals("Test Student (Student ID: 1000001)\n" +
                "Degree: Science", testDB.findStudent("1000001").showName());
    }

    @Test
    void addMultipleStudent() {
        StudentDatabase test = new StudentDatabase();
        for (int i=1000000;i<1000005;i++){
            test.addStudent("S,"+i+",A,B");
        }
        ArrayList<Student> db = test.getDb();
        int output = test.getDb().size();
        assertEquals(5, output);
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
    @ValueSource(strings = {"1000001","1000005","1000009"})
    void findStudent(String id) {
        StudentDatabase test = new StudentDatabase();
        for (int i=1000000;i<1000010;i++){
            test.addStudent("S," +i+",A,B");
        }
        Student output = test.findStudent(id);
        assertEquals(id,output.getStudentID());
    }

    @Test
    void findVoid(){
        StudentDatabase test = new StudentDatabase();
        for (int i=1000000;i<1000010;i++){
            test.addStudent("S,"+i+",A,B");
        }
        Student output = test.findStudent("10");
        assertEquals(null,output);
    }

    @Test
    void FindStudentTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "S,1000001,Student,Test";
        testDB.addStudent(testInput1);
        assertEquals("Student", testDB.findStudent("1000001").getFirstName());
    }

    @Test
    void FindMissingStudentTest() {
        StudentDatabase testDB = new StudentDatabase();
        assertEquals(null, testDB.findStudent("1000001"));
    }

    @Test
    void FindMultipleStudentTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "S,1000001,Student1,Test1";
        String testInput2 = "M,1000002,Student2,Test2";
        testDB.addStudent(testInput1);
        testDB.addStudent(testInput2);
        assertAll(
                () -> assertEquals("Student2", testDB.findStudent("1000002").getFirstName()),
                () -> assertEquals("Student1", testDB.findStudent("1000001").getFirstName())
        );
    }

    @Test
    void addResult() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,DN,82";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        assertEquals("AAAA1111 DN 82",testDB.findStudent("1000001").getTopicResult("AAAA1111").show());
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
    void AddPrizeTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "P,Test Prize,TEST0001,1";
        assertTrue(testDB.addPrize(testInput));
    }

    @Test
    void AddExistingPrizeTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "P,Test Prize,TEST0001,1";
        testDB.addPrize(testInput);
        assertFalse(testDB.addPrize(testInput));
    }

    @Test
    void AwardPrizeTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "M,1000001,Student,Test";
        String testResult = "R,1000001,BIOL1001,DN,82";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        Prize testP = new Prize("BIOL Prize1", "BIOL", "1");
        assertTrue(testDB.awardPrize(testP));
    }

    @Test
    void AwardPrizeRequirementNotMetTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "M,1000001,Student,Test";
        String testResult = "R,1000001,BIOL1001,DN,82";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        Prize testP = new Prize("BIOL Prize1", "BIOL", "2");
        assertFalse(testDB.awardPrize(testP));
    }

    @Test
    void AwardPrizeOutputTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "M,1000001,Student,Test";
        String testResult = "R,1000001,BIOL1001,DN,82";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        Prize testP = new Prize("BIOL Prize1", "BIOL", "1");
        testDB.awardPrize(testP);
        assertEquals("Academic record for Test Student (Student ID: 1000001)\n" +
                "Degree: Medicine\n" +
                "Prize: BIOL Prize1\n" +
                "BIOL1001 DN 82", testDB.printRecords());
    }

    @Test
    void AddRewardsTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "M,1000001,Student,Test";
        String testResult = "R,1000001,BIOL1001,DN,82";
        String testReward = "1000001,Test Prize,BIOL,1";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        assertTrue(testDB.addRewards(testReward));
    }

    @Test
    void AddRewardsForScienceTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "S,1000001,Student,Test";
        String testResult = "R,1000001,BIOL1001,DN,82";
        String testReward = "1000001,Test Prize,BIOL,1";
        testDB.addStudent(testInput);
        testDB.addResult(testResult, "1000001");
        assertFalse(testDB.addRewards(testReward));
    }

    @Test
    void addRewardsOutputTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput = "M,1000001,Student,Test";
        String testResult = "R,1000001,AAAA1111,CR,67";
        String testPrize = "1000001,AAAA Prize,AAAA,1";
        testDB.addStudent(testInput);
        testDB.addResult(testResult,"1000001");
        System.out.println(testDB.addRewards(testPrize));
        assertEquals("""
                Academic record for Test Student (Student ID: 1000001)
                Degree: Medicine
                Prize: AAAA Prize
                AAAA1111 CR 67""", testDB.printRecords().trim());
    }

    @Test
    void AwardPrizesTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "M,1000001,Student1,Test1";
        String testInput2 = "M,1000002,Student2,Test2";
        String testResult1 = "R,1000001,TEST1001,CR,67";
        String testResult2 = "R,1000001,TEST1002,DN,82";
        String testResult3 = "R,1000002,TEST1001,PS,50";
        String testResult4 = "R,1000002,TEST1002,PS,55";
        String testResult5 = "R,1000002,TEST1003,PS,57";
        String testPrize1 = "P,Test Prize,TEST,1";
        String testPrize2 = "P,Test Prize1,TEST,2";
        String testPrize3 = "P,Test Prize1,TEST,3";
        testDB.addStudent(testInput1);
        testDB.addStudent(testInput2);
        testDB.addResult(testResult1, "1000001");
        testDB.addResult(testResult2, "1000001");
        testDB.addResult(testResult3, "1000002");
        testDB.addResult(testResult4, "1000002");
        testDB.addResult(testResult5, "1000002");
        testDB.addPrize(testPrize1);
        testDB.addPrize(testPrize2);
        testDB.addPrize(testPrize3);
        assertTrue(testDB.awardPrizes());
    }

    @Test
    void AwardPrizesOutputTest() {
        StudentDatabase testDB = new StudentDatabase();
        String testInput1 = "M,1000001,Student1,Test1";
        String testInput2 = "M,1000002,Student2,Test2";
        String testResult1 = "R,1000001,TEST1001,CR,67";
        String testResult2 = "R,1000001,TEST1002,DN,82";
        String testResult3 = "R,1000002,TEST1001,PS,50";
        String testResult4 = "R,1000002,TEST1002,PS,55";
        String testResult5 = "R,1000002,TEST1003,PS,57";
        String testPrize1 = "P,Test Prize,TEST,1";
        String testPrize2 = "P,Test Prize1,TEST,2";
        String testPrize3 = "P,Test Prize2,TEST,3";
        testDB.addStudent(testInput1);
        testDB.addStudent(testInput2);
        testDB.addResult(testResult1, "1000001");
        testDB.addResult(testResult2, "1000001");
        testDB.addResult(testResult3, "1000002");
        testDB.addResult(testResult4, "1000002");
        testDB.addResult(testResult5, "1000002");
        testDB.addPrize(testPrize1);
        testDB.addPrize(testPrize2);
        testDB.addPrize(testPrize3);
        testDB.awardPrizes();
        assertEquals("Academic record for Test1 Student1 (Student ID: 1000001)\n" +
                "Degree: Medicine\n" +
                "Prize: Test Prize\n" +
                "Prize: Test Prize1\n" +
                "TEST1001 CR 67\n" +
                "TEST1002 DN 82\n" +
                "\n" +
                "Academic record for Test2 Student2 (Student ID: 1000002)\n" +
                "Degree: Medicine\n" +
                "Prize: Test Prize2\n" +
                "TEST1001 PS 50\n" +
                "TEST1002 PS 55\n" +
                "TEST1003 PS 57", testDB.printRecords());
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
                AAAA1111 CR 67""", testDB.printRecords().trim());
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
    void clearEmptyRecords() {
        StudentDatabase testDB = new StudentDatabase();
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
                COMP1000 PS 55
                COMP1001 DN 77
                HIST1234 HD 87
                PSYC0123 FL 42
                
                Academic record for Mary Jones (Student ID: 9821012)
                Degree: Medicine
                Prize: Chemistry Prize 1998
                BIOL1000 HD 89
                CHEM1001 HD 92
                COMP1000 DN 75
                PHYS1010 HD 93
                
                Academic record for John Howard (Student ID: 9987654)
                Degree: Arts
                Major: Politics
                Minor: Economics""", testDB.printRecords());
    }

    @Test
    void readFileNullStudent() {
        StudentDatabase testDB = new StudentDatabase();
        assertThrows(RuntimeException.class, () -> {
            testDB.readFile("TestResources/inputFiles/resultsForNullStudent.txt");
        });
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

    @Test
    void ReadWriteMaxSize() throws IOException {
        StudentDatabase testDB = new StudentDatabase();
        testDB.readFile("TestResources/inputFiles/MaxSize.txt");
        testDB.recordsToFile("TestResources/OutputFiles/out.txt");
        String Expected = Files.readString(Paths.get("TestResources/OutputFiles/MaxSizeCompare.txt"));
        String Actual = Files.readString(Paths.get("TestResources/OutputFiles/out.txt"));
        Files.delete(Path.of("TestResources/OutputFiles/out.txt"));
        assertEquals(Expected, Actual);
    }

    @Test
    void ReadWriteDupIDs() throws IOException {
        StudentDatabase testDB = new StudentDatabase();
        testDB.readFile("TestResources/inputFiles/duplicateIDs.txt");
        testDB.recordsToFile("TestResources/OutputFiles/out.txt");
        String Expected = Files.readString(Paths.get("TestResources/OutputFiles/DIDCompare.txt"));
        String Actual = Files.readString(Paths.get("TestResources/OutputFiles/out.txt"));
        //Files.delete(Path.of("TestResources/OutputFiles/out.txt"));
        assertEquals(Expected, Actual);
    }
}