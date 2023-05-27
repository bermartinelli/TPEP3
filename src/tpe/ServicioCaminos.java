package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServicioCaminos {
    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;
    
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
        caminos(origen, destino, camino, resultado, 0); // Llamar al método caminos con un contador de arcos igual a 0
        
        return resultado;
    }
    
    private void caminos(Integer origen, Integer destino, List<Integer> camino, List<List<Integer>> res, int arcos) {
        if (origen.equals(destino) && arcos <= lim) { // Verificar que el origen sea igual al destino y que no se hayan superado el límite de arcos
            res.add(camino);
        } else if (arcos < lim) { // Verificar que no se hayan superado el límite de arcos
            Iterator<Integer> vertices = grafo.obtenerAdyacentes(origen);
            while (vertices.hasNext()) {
                Integer actual = vertices.next();
                List<Integer> parcial = new ArrayList<>(camino); // Crear una nueva lista para cada camino parcial
                if (!parcial.contains(actual)) {
                    parcial.add(actual);
                    caminos(actual, destino, parcial, res, arcos + 1); // Incrementar el contador de arcos en cada llamada recursiva
                }
            }
        }
    }
}
