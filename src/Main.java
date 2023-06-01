import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        StudentDatabase studentDataBase = new StudentDatabase();
//        File tmpDir;
//        String filename;
//         do {
//             System.out.println("enter a valid filepath to a .txt database file");
//             Scanner myObj = new Scanner(System.in);
//             filename = myObj.nextLine();
//             tmpDir = new File(filename);
//         }
//         while (tmpDir.exists());
//         System.out.println("valid path inputted");
//         System.out.println();
//
//         studentDataBase.readFile(filename);
//         ArrayList<Student> db =  studentDataBase.getDb();
//         System.out.println("read "+db.size()+" students");
//
//
//         do{
//             System.out.println("enter a valid destination path");
//             Scanner myObj = new Scanner(System.in);
//             filename = myObj.nextLine();
//             tmpDir = new File(filename);
//         }
//         while(tmpDir.exists() || tmpDir.isDirectory());
//
//         studentDataBase.recordsToFile(filename);
//         System.out.println("file written");


        System.out.println("Add student:");
        System.out.println(studentDataBase.addStudent("S,9800123,Smith,John Paul"));
        System.out.println(studentDataBase.addStudent("M,9821012,Jones,Mary,Chemistry Prize 1998"));
        System.out.println(studentDataBase.addStudent("A,9987654,Howard,John,Politics,Economics"));
        System.out.println("Add result: ");
        System.out.println(studentDataBase.addResult("R,9821012,BIOL1000,HD,89","9821012"));
        System.out.println(studentDataBase.addResult("R,9821012,CHEM1001,HD,92","9821012"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1002,PS,55","9800123"));
        System.out.println(studentDataBase.addResult("R,9821012,COMP1003,DN,75","9821012"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1004,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1005,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1006,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1007,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1008,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1009,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10010,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10011,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10012,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10013,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10014,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10015,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10016,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10017,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10018,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10019,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1002,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10021,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10022,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10023,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10024,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10025,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10026,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10027,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP10028,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1001,DN,77","9800123"));



        //System.out.println(studentDataBase.addResult("R,9800123,HIST1234,HD","9800123"));
        System.out.println(studentDataBase.addResult("R,9821012,PHYS1010,HD,93","9821012"));
        System.out.println(studentDataBase.addResult("R,9800123,PSYC0123,FL,42","9800123"));

        System.out.println("Add reward: ");
        System.out.println(studentDataBase.addRewards("9821012,prize X,template Y,topic Z"));
        System.out.print("Find student: ");
        String test = studentDataBase.findStudent("9821012").show();
        System.out.println(test);
        System.out.println("Not find student in system.");
        if(studentDataBase.findStudent("982112") == null)
        {
            System.out.println("Not find student in system." );
        }
        System.out.println("Find Topic: ");
        System.out.println(studentDataBase.findResults("CHEM1001"));
        System.out.println("Print all record: ");
        System.out.println(studentDataBase.printRecords());
        studentDataBase.clearRecords();
        System.out.println("After clear");
        System.out.println(studentDataBase.printRecords());

    }
}
