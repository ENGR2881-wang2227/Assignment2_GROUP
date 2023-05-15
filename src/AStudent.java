
public class AStudent extends Student{

    private String major = "Null";
    private String minor = "Null";
    public AStudent(String input) {
        super(input);
        String[] list1 = input.split(",");
        if(list1.length>4){
            this.major = list1[4];
        }
        if(list1.length>5){
            this.minor = list1[5];
        }
    }
    @Override
    public String show(){
        return super.show() +"Major: " + major + "\nMinor: " + minor;
    }




}
