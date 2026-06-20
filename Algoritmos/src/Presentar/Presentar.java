package Presentar;

import clases.Grafo;
import logica.LogDijkstra;
import logica.LogKruskal;
import persistencia.ArchivoGrafo;

public class Presentar {

    public static void main(String[] args) throws Exception {

        ArchivoGrafo archivo = new ArchivoGrafo();

        Grafo grafoKruskal = archivo.leerGrafo(
                "C:/Users/jcvei/OneDrive/Escritorio/4 CICLO COMPUTACION/AnalisisAlgoritmos/Grafos/grafo_no_dirigido.txt",
                false
        );

        Grafo grafoDijkstra = archivo.leerGrafo(
                "C:/Users/jcvei/OneDrive/Escritorio/4 CICLO COMPUTACION/AnalisisAlgoritmos/Grafos/grafo_dirigido.txt",
                true
        );

        LogKruskal logKruskal = new LogKruskal();
        LogDijkstra logDijkstra = new LogDijkstra();

        String resultadoKruskal = logKruskal.obtenerArbol(grafoKruskal);
        String resultadoDijkstra = logDijkstra.obtenerCaminos(grafoDijkstra, 1);

        String resultado = resultadoKruskal + "\n\n" + resultadoDijkstra;

        archivo.escribirArchivo(
                "C:/Users/jcvei/OneDrive/Escritorio/4 CICLO COMPUTACION/AnalisisAlgoritmos/Grafos/resultado.txt",
                resultado
        );

        System.out.println(resultado);
    }
}
