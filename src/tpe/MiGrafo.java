package tpe;

import java.util.Iterator;
import java.util.List;

public class MiGrafo {

	public static void main(String[] args) {
		GrafoDirigido miGrafo = new GrafoDirigido();

		ServicioBFS bfs = new ServicioBFS(miGrafo);
		ServicioDFS dfs = new ServicioDFS(miGrafo);

		miGrafo.agregarVertice(1);
		miGrafo.agregarVertice(2);
		miGrafo.agregarVertice(3);
		miGrafo.agregarVertice(4);
		miGrafo.agregarVertice(5);

		miGrafo.agregarArco(1, 5, "1-5");
		miGrafo.agregarArco(4, 1, "4-1");
		miGrafo.agregarArco(1, 2, "1-2");
		miGrafo.agregarArco(2, 3, "2-3");
		miGrafo.agregarArco(4, 3, "4-3");
		miGrafo.agregarArco(4, 5, "4-5");
		miGrafo.agregarArco(5, 4, "5-4");

		System.out.println(miGrafo.existeArco(1, 5));
		System.out.println(miGrafo.existeArco(2, 3));
		System.out.println(miGrafo.existeArco(4, 3));

		System.out.println();
		System.out.println(miGrafo.existeArco(1, 5));
		System.out.println(miGrafo.existeArco(1, 2));

		System.out.println("Cantidad de vertices: " + miGrafo.cantidadVertices());

		Iterator<Integer> vertices = miGrafo.obtenerVertices();
		int primero = vertices.next();

		System.out.println("primero: " + primero);

		Iterator it = miGrafo.obtenerAdyacentes(1);
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("--");

		List<Integer> listaBFS = bfs.bfsForest();

		System.out.println("Lista BFS");
		for (Integer vertice : listaBFS) {
			System.out.println(vertice);
		}

		System.out.println("--");

		List<Integer> listaDFS = dfs.dfsForest();

		System.out.println("Lista DFS");
		for (Integer vertice : listaDFS) {
			System.out.println(vertice);
		}

		ServicioCaminos caminos = new ServicioCaminos(miGrafo, 1, 3, 2);

		List<List<Integer>> listaDeCaminos = caminos.caminos();

		System.out.println("Cantidad de caminos: " + listaDeCaminos.size());

		int contador = 0;
		for (List<Integer> camino : listaDeCaminos) {
			contador++;
			System.out.print("Camino " + contador + " : ");
			for (Integer vertice : camino) {
				System.out.print(vertice + ", ");
			}
			System.out.println(); // Agregar un salto de línea al final de cada camino impreso
		}

	}

}