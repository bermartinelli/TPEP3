package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServicioBFS {

	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
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
			
			
			Iterator<Integer> vecinos = grafo.obtenerAdyacentes(primero);
			int vec = vecinos.next();
			
			if(!visited[vec-1]) {
				visited[vec-1] = true;
				bfs.add(primero);
				
				while(vecinos.hasNext()) {
					list.add(vecinos.next());
				}
			}
			
		}

		return bfs;
		
	
	}
	
}
