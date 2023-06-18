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

    public ArrayList<Double> tempos;
    public boolean infinite = false;
    public List<Nodo> saidas;

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
        if(capacity > 0)
            this.capacity = capacity;
        else{
            infinite = true;
            capacity = 1000000;
        }
            

        this.minArrival = minArrival;
        this.maxArrival = maxArrival;

        this.minService = minService;
        this.maxService = maxService;

        this.tempos = new ArrayList<Double>();
        for (int i = 0; i < tempos.size(); i++) {
            tempos.add(0.0);
        }
    }

    public void setTempoAtual(int index, double deltaT) {
        if(tempos.size() > index)
            this.tempos.set(index, deltaT+tempos.get(index));
        else {
            this.tempos.add(deltaT+tempos.get(index));
        }
        
    }
}
