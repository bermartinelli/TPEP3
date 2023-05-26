package tpe;

import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Integer>> vertices;
	private ArrayList<Arco<T>> arcos;
	
	
	
	public GrafoDirigido() {
		this.vertices = new HashMap<Integer, ArrayList<Integer>>();
		this.arcos = new ArrayList<Arco<T>>();
	}
	
	
	
	@Override
	public void agregarVertice(int verticeId) {
		
		if(vertices.get(verticeId) == null) {
			vertices.put(verticeId, new ArrayList<Integer>());
		}
	}

	
	@Override
	public void borrarVertice(int verticeId) {
		
		if(vertices.get(verticeId) != null) {
			vertices.remove(verticeId);
			
			for(Arco arco:arcos) {
				if(arco.getVerticeDestino() == verticeId) {
					arcos.remove(arco);
				}
			}
		}
		
		

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		
		boolean existen = (vertices.get(verticeId1) !=null && vertices.get(verticeId2)!=null);
		
		if(existen) {
			if (!existeArco(verticeId1, verticeId2)) {
				Arco<T> nuevo = new Arco(verticeId1, verticeId2, etiqueta);
				arcos.add(nuevo);
				
				vertices.get(verticeId1).add(verticeId2); //le agrega al arraylist del vertice 1 el adyacente.
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		
		if(existeArco(verticeId1, verticeId2)) {
			arcos.remove(obtenerArco(verticeId1, verticeId2));
			
			vertices.get(verticeId1).remove(Integer.valueOf(verticeId2));
		}

	}

	@Override
	public boolean contieneVertice(int verticeId) {
		 
		return (vertices.containsKey(verticeId));
	}

	
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		for (Arco arco: arcos) {
			int origen = arco.getVerticeOrigen();
			int destino = arco.getVerticeDestino();
			if (origen == verticeId1 && destino ==verticeId2) {
				return true;
			}	
		}
		return false;
	}

	
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		
		if(existeArco(verticeId1, verticeId2)) {
			for (Arco arco: arcos) {
				int origen = arco.getVerticeOrigen();
				int destino = arco.getVerticeDestino();
				if (origen == verticeId1 && destino ==verticeId2) {
					return arco;
				}
			}
		}
		
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return arcos.size();
	}

	@Override
	public Iterator obtenerVertices() {
		Iterator iter = vertices.keySet().iterator();
		return iter;
	}
	
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if(contieneVertice(verticeId)) {
			Iterator iter = vertices.get(verticeId).iterator();
			
			return iter;
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		
		Iterator<Arco<T>> iterador = arcos.iterator();
		return iterador;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco> tmp = new ArrayList<>();
		for(Arco arco:arcos) {
			if(arco.getVerticeOrigen() == verticeId) {
				tmp.add(arco);
			}
		}
		Iterator it = tmp.iterator();
		return it;
	}

}
