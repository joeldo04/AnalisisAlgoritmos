package clases;

public class Arista {
    public int origen;
    public int destino;
    public int peso;

    public Arista() {
    }

    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Arista{" + "origen=" + origen + ", destino=" + destino + ", peso=" + peso + '}';
    }
    
}
