public class Nodo {
    public String name;
    public Fila src;
    public Fila trgt;
    public double probabilidade;

    public Nodo(String name, Fila src, Fila trgt, double probabilidade) {
        this.name = name;
        this.src = src;
        this.trgt = trgt;
        this.probabilidade = probabilidade;
    }

}
