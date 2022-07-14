import java.util.Random;
import java.util.Vector;

public class Rocket implements Spaceship{

    public String name= "none";
    public double LaunchExplosinChance = 0.0;
    public double LandExplosinChance = 0.0;
    public int cost=0;
    public int weight=0;
    public int maxweight=0;
    public Vector<Item> zaladowane=new Vector<Item>();
    @Override
    public Boolean launch() {
        Random rand = new Random();
        double chances = LaunchExplosinChance*((double)weight/maxweight);
        if (rand.nextDouble(100.0) > chances)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean land() {
        Random rand = new Random();
        double chances = LandExplosinChance*((double)weight/maxweight);
        if (rand.nextDouble(100.0) > chances)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean canCarry(Item ladunek) {
        if(ladunek.weight>maxweight-weight)
        {
            return false;
        }
        return true;
    }

    @Override
    public void carry(Item ladunek) {
        zaladowane.add(ladunek);
        weight+=ladunek.weight;
    }
}
