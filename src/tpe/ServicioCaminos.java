package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		List<List<Integer>> resultado = new ArrayList<>();
		List<Integer> camino = new ArrayList<>();
		
		camino.add(origen);
		Iterator<Integer> vertices = grafo.obtenerAdyacentes(origen);
		
		while(vertices.hasNext()) {
			Integer actual = vertices.next();
			List<Integer> parcial = camino;
			parcial.add(actual);
			caminos(actual, destino, parcial, resultado);
		}
		
		return resultado;
	}
	
	public void caminos(Integer origen, Integer destino, List<Integer> camino, List<List<Integer>> res) {
		if(origen == destino) {
			res.add(camino);
		} else {
			Iterator<Integer> vertices = grafo.obtenerAdyacentes(origen);
			while(vertices.hasNext()) {
				Integer actual = vertices.next();
				List<Integer> parcial = camino;
				if(!parcial.contains(actual)) {
					parcial.add(actual);
					caminos(actual, destino, parcial, res);
				}
			}
		}
	}

}
