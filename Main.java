import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{


        for (int i = 1; i <= 5; i++) {
            List<Nodo> nodos1 = new ArrayList<>();
            List<Nodo> nodos2 = new ArrayList<>();
            List<Nodo> nodos3 = new ArrayList<>();     

            Fila fila1 = new Fila("1", 2, 100000, 1.0, 4.0, 1.0, 1.5);
            Fila fila2 = new Fila("2", 3, 5, 0, 0, 5.0, 10.0);
            Fila fila3 = new Fila("3", 3, 5, 0, 0, 10.0, 20.0);

            nodos1.add(new Nodo("Nodo 1", fila1, fila2, 0.8));
            nodos1.add(new Nodo("Nodo 2", fila1, fila3, 0.2));
            nodos2.add(new Nodo("Nodo 3", fila2, fila1, 0.3));
            nodos2.add(new Nodo("Nodo 4", fila2, fila3, 0.5));
            nodos3.add(new Nodo("Nodo 5", fila3, fila2, 0.7));

            fila1.saidas = nodos1;
            fila2.saidas = nodos2;
            fila3.saidas = nodos3;

            double tempoInicial = 2.5;

            ArrayList<Fila> filaLst = new ArrayList<>();
            filaLst.add(fila1);
            filaLst.add(fila2);
            filaLst.add(fila3);

            Simulacao simulacao = new Simulacao( filaLst,tempoInicial, (i+1)*10,21,5000000011L,227,100);
            simulacao.ExecutaAlgoritmo();
        }      
       
    }
}
