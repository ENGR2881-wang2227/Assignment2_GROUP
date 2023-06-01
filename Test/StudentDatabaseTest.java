import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        test.addStudent("S 1 A B");
        ArrayList<Student> db = test.getDb();
        String output = db.get(0).show();
        String expected = "A B (Student ID 1)\n S";
        assertEquals(expected, output);
    }

    @Test
    void addMultipleStudent() {
        StudentDatabase test = new StudentDatabase();
        for (int i=0;i<5;i++){
            test.addStudent("S "+i+" A B");
        }
        ArrayList<Student> db = test.getDb();
        int output = test.getDb().size();
        assertEquals(5, output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","5","9"})
    void findStudent(String id) {
        StudentDatabase test = new StudentDatabase();
        for (int i=0;i<10;i++){
            test.addStudent("S "+i+" A B");
        }
        Student output = test.findStudent(id);
        assertEquals(id,output.getStudentID());
    }

    @Test
    void findVoid(){
        StudentDatabase test = new StudentDatabase();
        for (int i=0;i<10;i++){
            test.addStudent("S "+i+" A B");
        }
        Student output = test.findStudent("10");
        assertEquals(null,output);
    }

    @Test
    void addResult() {
    }

    @Test
    void findResults() {
    }

    @Test
    void addRewards() {
    }

    @Test
    void printRecords() {
    }

    @Test
    void clearRecords() {
    }

    @Test
    void readFile() {
    }

    @Test
    void recordsToFile() {
    }
}