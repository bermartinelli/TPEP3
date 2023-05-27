package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServicioBFS {

	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	// Tiempo lineal, O(V + E), donde V es la cantidad de vértices en el grafo y E es la cantidad de arcos.
	// El costo del método depende del número de vértices y arcos presentes en el grafo. 
	// El tiempo de ejecución aumenta linealmente con el número de vértices (V) y arcos (E) en el grafo. 
	// Si hay más vértices y arcos, el tiempo requerido será mayor. 
	// Por lo tanto, cuanto más grande sea el grafo y más conexiones tenga, mayor será el costo del método.
	public List<Integer> bfsForest() {
		
		boolean[]visited = new boolean[grafo.cantidadVertices()];
		List<Integer> bfs = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Iterator<Integer> vertices = grafo.obtenerVertices();
		int primero = vertices.next();
		visited[primero-1] = true;
		list.add(primero);
		
		while(!list.isEmpty()) {
			primero = list.remove(0);
			bfs.add(primero);
			
			Iterator<Integer> vecinos = grafo.obtenerAdyacentes(primero);
			
			while(vecinos.hasNext()) {
				int vec = vecinos.next();
				if(!visited[vec-1]) {
					visited[vec-1] = true;
					list.add(vec);
				}
			}
		}

		return bfs;
		
	
	}
	
}
