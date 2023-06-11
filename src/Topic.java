public class Topic {
    private String code, grade;
    private int mark;


    public Topic(String code, String grade, int mark) {
        if (code.matches("^[A-Z]{4}\\d{4}$")) {
            this.code = code;
        } else throw new IllegalArgumentException("Invalid Topic Code");
        if (grade.equals("FL") || grade.equals("PS") || grade.equals("CR") || grade.equals("DN")|| grade.equals("HD")){
            this.grade = grade;
        } else throw new IllegalArgumentException("Grade must be FL,PS,CR,DN,HD");
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
