import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;

public class spacechellenge {

    public static void main(String args[]) {

        Simulation Sim = new Simulation();

        ArrayList<Rocket> U1 = Sim.LoadU1();
        ArrayList<Rocket> U2 = Sim.LoadU2();

        String U1_podsumowanie =Sim.runSimulation(U1);
        String U2_podsumowanie =Sim.runSimulation(U2);

        System.out.println(U1_podsumowanie);
        System.out.println(U2_podsumowanie);
    }
}
