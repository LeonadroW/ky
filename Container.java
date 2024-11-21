import java.util.*;

public class Container {
    private  double amount = 0;
    private  ArrayList<Container> containers = new ArrayList<Container>();
    public double getAmount(){
        return amount;
    };
    public void connectTo(Container other){
        containers.add(other);
        other.(this);
        double total = getAmount();
        for(Container c : containers){
             total += c.getAmount();
         }
         total = total/(containers.size()+1);
        //now total means mean water in cupboard

        for(Container c : containers){
            c.addWater(total-c.getAmount());//因为不能直接修改水容量，只能这样
        }
        addWater(total-getAmount());
    };
    public void addWater(double amount){
        this.amount += amount;
    };

    public static void main(String[] args) {
      Container a = new Container();
      Container b = new Container();
      Container c = new Container();
      Container d = new Container();
      a.addWater(12);
      d.addWater(8);
      a.connectTo(b);
      System.out.println(a.getAmount() + " " + b.getAmount()+
              " "+c.getAmount() + " " + d.getAmount());
      b.connectTo(c);
      System.out.println(a.getAmount() + " " + b.getAmount()+
                " "+c.getAmount() + " " + d.getAmount());
      b.connectTo(d);
      System.out.println(a.getAmount() + " " + b.getAmount()+
                " "+c.getAmount() + " " + d.getAmount());
    }
}
