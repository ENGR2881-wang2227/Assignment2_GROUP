public class Topic {
    private String code, grade;
    private int mark;


    public Topic(String code, String grade, int mark) {
        this.code = code;
        this.grade = grade;
        this.mark = mark;
    }

    public String getCode() {
        return code;
    }

    public String getGrade() {
        return grade;
    }

    public int getMark() {
        return mark;
    }
    public String show(){
        String s = code + " " + grade + " " + mark;
        return s;
    }
}
