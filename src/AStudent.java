
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
        String print1 = "";
        print1 += super.showName() + "\n";
        print1 += "Major: " + getMajor() + "\n";
        print1 += "Minor: " + getMinor() + "\n";
        print1+= super.showResults1();
        return print1.trim();
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }




}
