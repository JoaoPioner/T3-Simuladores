import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Fila {

    public String name;

    public PrintWriter output;

    public int servers;
    public int capacity;
    public double minService;
    public double maxService;

    public double minArrival;
    public double maxArrival;

    public int size;
    public int loss;

    //public double[] tempos;
    private ArrayList<Double> tempos;// = new ArrayList<Double>();
    
    public List<Nodo> saidas;

    public boolean infinity;

    // public Fila(String name, int servers, int capacity, double minService, double maxService) throws FileNotFoundException { 
    //     this.name = name;

    //     output = new PrintWriter(new File(name+".csv"));

    //     this.servers = servers;
    //     this.capacity = capacity;
    //     this.minService = minService;
    //     this.maxService = maxService;
    //     this.tempos = new double[capacity+1];
    // }

    public Fila(String name,int servers, int capacity, double minArrival, double maxArrival, double minService, double maxService) throws FileNotFoundException {
        this.name = name;

        output = new PrintWriter(new File(name+".csv"));
        this.servers = servers;
        this.capacity = capacity;

        this.minArrival = minArrival;
        this.maxArrival = maxArrival;

        this.minService = minService;
        this.maxService = maxService;

        if (capacity == 0) {
            infinity = true;
            this.tempos = new ArrayList<Double>();
            tempos.add(0.0);
        } else {
            infinity = false;
            this.tempos = new ArrayList<Double>();
            for (int i = 0; i < this.capacity+1; i++) {
                tempos.add(0.0);
            }
        }

        //System.out.println(tempos.size());

        
    }

    public void setTempos(double deltaT) {
        if (size < tempos.size()) {
            tempos.set(size, tempos.get(size) + deltaT);
        } else {
            tempos.add(deltaT);
        }
    }

    public int getStatesNumber() {
        return tempos.size();
    }

    public double getTempoByIndex(int index) {
        return tempos.get(index);
    }
}
