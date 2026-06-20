package persistencia;

import clases.Grafo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoGrafo {

    public Grafo leerGrafo(String ruta, boolean noDirigido) 
            throws IOException {
        
        BufferedReader lector = new BufferedReader(new FileReader(ruta));

        int vertices = Integer.parseInt(lector.readLine());
        int aristas = Integer.parseInt(lector.readLine());
        Grafo grafo = new Grafo(vertices, aristas);

        for (int i = 0; i < aristas; i++) {
            String linea = lector.readLine();
            String[] partes = linea.split(" ");

            int origen = Integer.parseInt(partes[0]);
            int destino = Integer.parseInt(partes[1]);
            int peso = Integer.parseInt(partes[2]);

            grafo.agregarArista(i, origen, destino, peso, noDirigido);
        }

        lector.close();
        return grafo;
    }

    public void escribirArchivo(String ruta, String contenido) 
            throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta));
        escritor.write(contenido);
        escritor.close();
    }
    
}
