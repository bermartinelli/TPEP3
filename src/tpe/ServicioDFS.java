package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class ServicioDFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Integer> visitados;
	private List<Integer> dfs;
	
	// clave valor: clave todos los vertices, valor 0= no visitado, 1=en transito, 2= ya visitado
	//
	//

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.dfs = new ArrayList<Integer>();
	}
	
	public List<Integer> dfsForest() {
		
		List<Integer> bfs = new ArrayList<>();

		
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while (vertices.hasNext()) {
			visitados.put(vertices.next(), 0);
		}
		
		
		visitados.put(1, 1);
	
		int indice = vertices.next();
		
		Iterator<Integer> hijos = grafo.obtenerAdyacentes(indice);
		if(hijos.hasNext() == false) {
			visitados.put(indice, 2);
			dfs.add(indice);
		} else {
			Iterator<Integer> nietos = grafo.obtenerAdyacentes(hijos.next());
			dfs.addAll(DFS(nietos));
		}
		
		
	    return dfs;
	}
	
	private List<Integer> DFS(Iterator<Integer> it) {
		List<Integer> tmp = new ArrayList<Integer>();
		
		
		if(it.hasNext() == false) {
			visitados.put(indice, 2);
			dfs.add(indice);
		
		return tmp;
	}
	
	

}
