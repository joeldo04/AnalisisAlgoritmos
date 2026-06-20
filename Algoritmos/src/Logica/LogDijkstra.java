package logica;

import clases.Grafo;

public class LogDijkstra {

    public String obtenerCaminos(Grafo grafo, int inicio) {
        int[] distancia = new int[grafo.numeroVertices + 1];
        int[] anterior = new int[grafo.numeroVertices + 1];
        boolean[] visitado = new boolean[grafo.numeroVertices + 1];

        for (int i = 1; i <= grafo.numeroVertices; i++) {
            distancia[i] = -1;
        }

        distancia[inicio] = 0;

        for (int i = 1; i <= grafo.numeroVertices; i++) {
            int actual = buscarMenor(distancia, visitado, grafo.numeroVertices);

            if (actual != 0) {
                visitado[actual] = true;

                for (int j = 1; j <= grafo.numeroVertices; j++) {
                    if (grafo.matriz[actual][j] > 0 && visitado[j] == false) {
                        int suma = distancia[actual] + grafo.matriz[actual][j];

                        if (distancia[j] == -1 || suma < distancia[j]) {
                            distancia[j] = suma;
                            anterior[j] = actual;
                        }
                    }
                }
            }
        }

        String texto = "RESULTADO DIJKSTRA\n";
        texto += "Vertice inicial: " + inicio + "\n\n";
        texto += "Aristas escogidas:\n";

        int costoTotal = 0;

        for (int i = 1; i <= grafo.numeroVertices; i++) {
            if (anterior[i] != 0) {
                texto += anterior[i] + " -> " + i + " peso " + grafo.matriz[anterior[i]][i] + "\n";
                costoTotal = costoTotal + grafo.matriz[anterior[i]][i];
            }
        }

        texto += "\nCosto total del arbol generado: " + costoTotal + "\n\n";
        texto += "Distancias minimas:\n";

        for (int i = 1; i <= grafo.numeroVertices; i++) {
            texto += inicio + " -> " + i + " = " + distancia[i] + "\n";
        }

        return texto;
    }

    public int buscarMenor(int[] distancia, boolean[] visitado, int n) {
        int menor = 0;

        for (int i = 1; i <= n; i++) {
            if (visitado[i] == false && distancia[i] != -1) {
                if (menor == 0 || distancia[i] < distancia[menor]) {
                    menor = i;
                }
            }
        }

        return menor;
    }
}