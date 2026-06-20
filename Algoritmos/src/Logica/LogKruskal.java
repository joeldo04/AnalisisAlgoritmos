package logica;

import clases.Grafo;
import clases.Arista;

public class LogKruskal {

    public String obtenerArbol(Grafo grafo) {
        ordenarAristas(grafo);

        int[] grupo = new int[grafo.numeroVertices + 1];

        for (int i = 1; i <= grafo.numeroVertices; i++) {
            grupo[i] = i;
        }

        String texto = "RESULTADO KRUSKAL\n\n";
        texto += "Aristas escogidas:\n";

        int costoTotal = 0;
        int aristasEscogidas = 0;

        for (int i = 0; i < grafo.numeroAristas; i++) {
            Arista arista = grafo.aristas[i];

            int origen = arista.origen;
            int destino = arista.destino;
            int peso = arista.peso;

            if (grupo[origen] != grupo[destino]) {
                texto += origen + " - " + destino + " peso " + peso + "\n";

                costoTotal = costoTotal + peso;
                aristasEscogidas++;

                unirGrupos(grupo, grafo.numeroVertices, grupo[origen], grupo[destino]);
            }

            if (aristasEscogidas == grafo.numeroVertices - 1) {
                i = grafo.numeroAristas;
            }
        }

        texto += "\nCosto total del arbol de recubrimiento minimo: " + costoTotal + "\n";

        return texto;
    }

    public void ordenarAristas(Grafo grafo) {
        for (int i = 0; i < grafo.numeroAristas - 1; i++) {
            for (int j = 0; j < grafo.numeroAristas - 1; j++) {
                if (grafo.aristas[j].peso > grafo.aristas[j + 1].peso) {
                    Arista aux = grafo.aristas[j];
                    grafo.aristas[j] = grafo.aristas[j + 1];
                    grafo.aristas[j + 1] = aux;
                }
            }
        }
    }

    public void unirGrupos(int[] grupo, int n, int grupoOrigen, int grupoDestino) {
        for (int i = 1; i <= n; i++) {
            if (grupo[i] == grupoDestino) {
                grupo[i] = grupoOrigen;
            }
        }
    }
}