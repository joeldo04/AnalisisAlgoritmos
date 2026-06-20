package clases;

public class Grafo {
    public int numeroVertices;
    public int numeroAristas;
    public Arista[] aristas;
    public int[][] matriz;

    public Grafo(int numeroVertices, int numeroAristas) {
        this.numeroVertices = numeroVertices;
        this.numeroAristas = numeroAristas;
        this.aristas = new Arista[numeroAristas];
        this.matriz = new int[numeroVertices + 1][numeroVertices + 1];
    }

    public void agregarArista(int posicion, int origen, int destino, int peso, boolean noDirigido) {
        aristas[posicion] = new Arista(origen, destino, peso);

        matriz[origen][destino] = peso;

        if (noDirigido) {
            matriz[destino][origen] = peso;
        }
    }

    public int getNumeroVertices() {
        return numeroVertices;
    }

    public int getNumeroAristas() {
        return numeroAristas;
    }

    public Arista[] getAristas() {
        return aristas;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
