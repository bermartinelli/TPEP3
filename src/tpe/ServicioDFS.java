package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class ServicioDFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Integer> visitados;
	
	// clave valor: clave todos los vertices, valor 0= no visitado, 1=en transito, 2= ya visitado
	//
	//

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitados = new HashMap<Integer, Integer>();
	}
	
	// Este método realiza una iteración sobre todos los vértices del grafo y llama al método dfsVisit para cada vértice no visitado. 
	// El costo de este método depende del número de vértices en el grafo. 
	// Si hay N vértices, la complejidad sería O(N).
	public List<Integer> dfsForest() {
		
		List<Integer> dfs = new ArrayList<>();
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while (vertices.hasNext()) {
			visitados.put(vertices.next(), 0);
		}
		
		Iterator<Integer> vertices2 = grafo.obtenerVertices();
		while (vertices2.hasNext()) {
			if (visitados.get(vertices2.next()) == 0) {
				dfs.addAll(dfsVisit(vertices2.next()));
			}
		}
		
		return dfs;
	}
	// El costo de este método depende del número de vértices y aristas en el grafo. 
	// Si hay N vértices y M aristas, la complejidad sería O(N+M), ya que en el peor caso podría visitar todos los vértices y aristas del grafo.
	
	private List<Integer> dfsVisit(Integer vertice) {
		List<Integer> tmp = new ArrayList<Integer>();
		
		visitados.put(vertice, 1); //marca el vertice como en visita
		Iterator<Integer> it = grafo.obtenerAdyacentes(vertice);
		
		while(it.hasNext()) {
			Integer ints = it.next();
			if(visitados.get(ints) == 0) {
				tmp.addAll(dfsVisit(ints));
			} else {
				it.next();
			}
		}
		
		visitados.put(vertice, 2); //marcar el vertice como visitado.
		tmp.add(vertice);
		
		return tmp;
	}
	
	

}
