import java.util.ArrayList;
public class MStudent extends Student{
    private ArrayList<Prize> prizes = new ArrayList<>();
    public MStudent(String input) {
        super(input);
        String[] list = input.split(",");
        if (list.length > 4) {
            for (int i = 4; i < list.length; i++) {
                Prize p = new Prize (list[i], "null", "null");
                prizes.add(p);
            }
        }
    }
    public void addPrizes(String name, String template,String topic){
        if (prizes.size()<10){
            prizes.add(new Prize(name,template,topic));}}

    public void addPrize(Prize p) {
        prizes.add(p);
    }

    @Override
    public String show(){
        String print1 = "";
        print1 += super.showName() + "\n";
        if(prizes.size()!=0){
            for(Prize p : prizes) {
                print1 += "Prize: " + p.getName() + "\n";
            }
        }
        print1+= super.showResults1();
        return print1.trim();
    }

    public String getList() {
        String out = "";
        for (Prize p: prizes) {
            out += p.getName() + "\n";
        }
        return out.trim();
    }


}