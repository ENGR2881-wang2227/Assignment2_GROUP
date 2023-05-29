import java.util.ArrayList;
public class MStudent extends Student{
    private ArrayList<Prize> prizes = new ArrayList<>();
    public MStudent(String input) {
        super(input);
    }
    public void addPrizes(String name, String template,String topic){
        if (prizes.size()<1){
            prizes.add(new Prize(name,template,topic));}}
    @Override
    public String show(){
        String prize = "";
        if(prizes.size()!=0){for(int i = 0; i<prizes.size() ;i++){prize+= prizes.get(i).show();}
        }
        return super.show() + "Prizes: " + prize;
    }


}
