import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static ArrayList<Item> loadItems(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);

        ArrayList<Item> Itemy = new ArrayList<Item>();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] doprzetrawienia=line.split("=");
            Item Item=new Item();
            Item.NameOfItem=doprzetrawienia[0];
            Item.weight=Integer.parseInt(doprzetrawienia[1]);
            Itemy.add(Item);
        }
        return Itemy;
    }

    public static ArrayList<Rocket> LoadU1()
    {
        ArrayList<Item> ListaItemowP1 = new ArrayList<Item>();
        ArrayList<Item> ListaItemowP2 = new ArrayList<Item>();
        Simulation Sim = new Simulation();
        try {
            ListaItemowP1.addAll(Sim.loadItems("phase-1.txt"));
            ListaItemowP2.addAll(Sim.loadItems("phase-2.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("one file not found!");
            System.exit(1);
        }

        ArrayList<Rocket> Rakiety=new ArrayList<Rocket>();

        while(!ListaItemowP1.isEmpty()){
            U1 rakietka = new U1();
            ArrayList<Item>  temporary = new ArrayList<Item>();
            temporary.addAll(ListaItemowP1);
            for(Item pojedynczy : temporary) {
                if (rakietka.canCarry(pojedynczy)) {
                    rakietka.carry(pojedynczy);
                    ListaItemowP1.remove(pojedynczy);
                }
            }
            Rakiety.add(rakietka);
        }

        while(!ListaItemowP2.isEmpty()){
            U1 rakietka = new U1();
            ArrayList<Item>  temporary = new ArrayList<Item>();
            temporary.addAll(ListaItemowP2);
            for(Item pojedynczy : temporary) {
                if (rakietka.canCarry(pojedynczy)) {
                    rakietka.carry(pojedynczy);
                    ListaItemowP2.remove(pojedynczy);
                }
            }
            Rakiety.add(rakietka);
        }
        return Rakiety;
    }

    public static ArrayList<Rocket> LoadU2()
    {
        ArrayList<Item> ListaItemowP1 = new ArrayList<Item>();
        ArrayList<Item> ListaItemowP2 = new ArrayList<Item>();
        Simulation Sim = new Simulation();
        try {
            ListaItemowP1.addAll(Sim.loadItems("phase-1.txt"));
            ListaItemowP2.addAll(Sim.loadItems("phase-2.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("one file not found!");
            System.exit(1);
        }

        ArrayList<Rocket> Rakiety=new ArrayList<Rocket>();

        while(!ListaItemowP1.isEmpty()){
            U2 rakietka = new U2();
            ArrayList<Item>  temporary = new ArrayList<Item>();
            temporary.addAll(ListaItemowP1);
            for(Item pojedynczy : temporary) {
                if (rakietka.canCarry(pojedynczy)) {
                    rakietka.carry(pojedynczy);
                    ListaItemowP1.remove(pojedynczy);
                }
            }
            Rakiety.add(rakietka);
        }

        while(!ListaItemowP2.isEmpty()){
            U2 rakietka = new U2();
            ArrayList<Item>  temporary = new ArrayList<Item>();
            temporary.addAll(ListaItemowP2);
            for(Item pojedynczy : temporary) {
                if (rakietka.canCarry(pojedynczy)) {
                    rakietka.carry(pojedynczy);
                    ListaItemowP2.remove(pojedynczy);
                }
            }
            Rakiety.add(rakietka);
        }
        return Rakiety;
    }

    public static String runSimulation(ArrayList<Rocket> Rakiety){
        int budzet= Rakiety.size()*Rakiety.get(0).cost;
        String nameofrocket = Rakiety.get(0).name;
        for(Rocket rakietka : Rakiety)
        {
            while((rakietka.launch() && rakietka.land()) == false){
                budzet += rakietka.cost;
            }
        }
        return "Koszt wyprawy to " + budzet + "mln na rakietach " + nameofrocket;
    }


}
