public class Main
{
    public static void main(String[] args)
    {
        StudentDatabase studentDataBase = new StudentDatabase();
        System.out.println("Add student:");
        System.out.println(studentDataBase.addStudent("S,9800123,Smith,John Paul"));
        System.out.println(studentDataBase.addStudent("M,9821012,Jones,Mary,Chemistry Prize 1998"));
        System.out.println(studentDataBase.addStudent("A,9987654,Howard,John,Politics,Economics"));
        System.out.println("Add result: ");
        System.out.println(studentDataBase.addResult("R,9821012,BIOL1000,HD,89","9821012"));
        System.out.println(studentDataBase.addResult("R,9821012,CHEM1001,HD,92","9821012"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1000,PS,55","9800123"));
        System.out.println(studentDataBase.addResult("R,9821012,COMP1000,DN,75","9821012"));
        System.out.println(studentDataBase.addResult("R,9800123,COMP1001,DN,77","9800123"));
        System.out.println(studentDataBase.addResult("R,9800123,HIST1234,HD","9800123"));
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
