import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        StudentDatabase studentDataBase = new StudentDatabase();
        File tmpDir;
        String filename;
         do {
             System.out.println("Enter a valid filepath to a .txt database file:");
             Scanner myObj = new Scanner(System.in);
             filename = myObj.nextLine();
             tmpDir = new File(filename);
         }
         while (!tmpDir.exists());
         System.out.println("File Read Success!");
         System.out.println();

         studentDataBase.readFile(filename);
         ArrayList<Student> db =  studentDataBase.getDb();
         System.out.println("Read "+db.size()+" students");

        File tmpDir1;
        boolean p = false;
         do{
             System.out.println("Enter destination path to write records to file, or type P to skip file output and print:");
             Scanner myObj = new Scanner(System.in);
             filename = myObj.nextLine();
             if ((p = filename.equalsIgnoreCase("p"))) {
                 break;
             }
             tmpDir1 = new File(filename);
             if (tmpDir1.exists()) {
                 System.out.println("File already exists");
             }
         }
         while(tmpDir1.exists() || tmpDir1.isDirectory());
         if (!p) {
             studentDataBase.recordsToFile(filename);
             System.out.println("\nFile written to " + filename + "\n");
         }
         System.out.println(studentDataBase.printRecords());
    }
}
