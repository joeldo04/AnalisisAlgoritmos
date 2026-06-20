# Implementación de Kruskal y Dijkstra

## Asignatura: **Análisis de Algoritmos**

Implementación de los algoritmos **Kruskal** y **Dijkstra** usando Java, programación orientada a objetos y modelo de capas.

El programa trabaja con archivos planos `.txt`, lee un grafo no dirigido para Kruskal y un grafo dirigido para Dijkstra. Luego genera el resultado y lo guarda en un archivo de salida.


Se resolvió separando el código por capas para que cada parte tenga una responsabilidad.

Primero se leen los datos desde los archivos:

```text
grafo_no_dirigido.txt
grafo_dirigido.txt
```

Luego se aplican los algoritmos:

```java
String resultadoKruskal = logKruskal.obtenerArbol(grafoKruskal);
String resultadoDijkstra = logDijkstra.obtenerCaminos(grafoDijkstra, 1);
```

Finalmente, ambos resultados se unen y se escriben en un archivo:

```java
String resultado = resultadoKruskal + "\n\n" + resultadoDijkstra;

archivo.escribirArchivo(
        "C:/Users/jcvei/OneDrive/Escritorio/4 CICLO COMPUTACION/AnalisisAlgoritmos/Grafos/resultado.txt",
        resultado
);
```

## Arquitectura del proyecto

| Capa         | Paquete        | Clase          | Función                                                           |
| ------------ | -------------- | -------------- | ----------------------------------------------------------------- |
| Clases       | `clases`       | `Grafo`        | Guarda la información del grafo, como vértices, aristas y matriz. |
| Clases       | `clases`       | `Arista`       | Representa una conexión entre dos vértices con su peso.           |
| Lógica       | `logica`       | `LogKruskal`   | Aplica el algoritmo de Kruskal sobre el grafo no dirigido.        |
| Lógica       | `logica`       | `LogDijkstra`  | Aplica el algoritmo de Dijkstra desde un vértice inicial.         |
| Persistencia | `persistencia` | `ArchivoGrafo` | Lee los archivos `.txt` y escribe el resultado final.             |
| Presentación | `Presentar`    | `Presentar`    | Ejecuta el programa y muestra el resultado por consola.           |

## Código principal

```java
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
                true
        );

        Grafo grafoDijkstra = archivo.leerGrafo(
                "C:/Users/jcvei/OneDrive/Escritorio/4 CICLO COMPUTACION/AnalisisAlgoritmos/Grafos/grafo_dirigido.txt",
                false
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
```

## Archivos utilizados

| Archivo                 | Uso                                        |
| ----------------------- | ------------------------------------------ |
| `grafo_no_dirigido.txt` | Se usa para aplicar Kruskal.               |
| `grafo_dirigido.txt`    | Se usa para aplicar Dijkstra.              |
| `resultado.txt`         | Guarda la salida generada por el programa. |

## Explicación de Kruskal

Kruskal se usa para obtener el árbol de recubrimiento mínimo de un grafo no dirigido.

En el programa, primero se ordenan las aristas por peso de menor a mayor. Después se revisa cada arista y se escoge solo si no forma un ciclo. Para controlar eso se usa un arreglo de grupos, donde se verifica si dos vértices ya pertenecen al mismo grupo.

El algoritmo termina cuando se han escogido las aristas necesarias para conectar todos los vértices.

## Explicación de Dijkstra

Dijkstra se usa para encontrar las distancias mínimas desde un vértice inicial hacia los demás vértices del grafo dirigido.

En este caso, el algoritmo inicia desde el vértice `1`. Se van revisando los vértices con menor distancia encontrada y se actualizan los caminos cuando aparece una distancia menor.

Para esto se usan arreglos simples:

| Arreglo     | Función                                               |
| ----------- | ----------------------------------------------------- |
| `distancia` | Guarda el costo mínimo encontrado hacia cada vértice. |
| `visitado`  | Indica si un vértice ya fue revisado.                 |
| `anterior`  | Guarda desde qué vértice se llegó.                    |

## Resultado del programa

El programa muestra en consola el resultado de ambos algoritmos y también lo guarda en el archivo:

```text
resultado.txt
```
