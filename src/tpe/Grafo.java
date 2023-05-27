package tpe;

import java.util.Iterator;

public interface Grafo<T> {
	
	// Agrega un vertice. 
	// Este método tiene una complejidad de tiempo constante, O(1), 
	// Ya que añadir un vértice es rápido y no depende del tamaño del grafo, por lo que es una operación rápida.
	public void agregarVertice(int verticeId);

	// Borra un vertice
	// Este método tiene una complejidad de tiempo lineal, O(n).
	// Eliminar un vértice lleva más tiempo porque hay que eliminar todas las conexiones asociadas a ese vértice. Cuantos más vértices haya, más tiempo tomará esta operación.
	public void borrarVertice(int verticeId);

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	// Este método tiene una complejidad de tiempo constante, O(1).
	// Añadir un arco es rápido y no depende del tamaño del grafo, por lo que es una operación rápida.
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta);

	// Borra el arco que conecta el verticeId1 con el verticeId2
	// Este método tiene una complejidad de tiempo lineal, O(n).
	// Eliminar un arco lleva más tiempo porque hay que buscar el arco específico en la estructura de datos. Cuantos más arcos haya, más tiempo tomará esta operación.
	public void borrarArco(int verticeId1, int verticeId2);

	// Verifica si existe un vertice
	// Este método tiene una complejidad de tiempo constante, O(1).
	// Comprobar si un vértice existe es rápido y no depende del tamaño del grafo, por lo que es una operación rápida.
	public boolean contieneVertice(int verticeId);  

	// Verifica si existe un arco entre dos vertices
	// Este método tiene una complejidad de tiempo constante o lineal, O(1) o O(n).
	// Comprobar si existe un arco entre dos vértices puede ser rápido si se utiliza una estructura de datos eficiente para almacenar las conexiones. 
	// Sin embargo, si se utiliza una lista de adyacencia, puede llevar más tiempo ya que hay que buscar en la lista.
	public boolean existeArco(int verticeId1, int verticeId2);
	
	// Obtener el arco que conecta el verticeId1 con el verticeId2
	// Este método tiene una complejidad de tiempo constante o lineal, O(1) o O(n).
	// Obtener un arco específico puede ser rápido si se utiliza una estructura de datos eficiente para almacenar las conexiones. 
	// Pero si se utiliza una lista de adyacencia, puede llevar más tiempo ya que hay que buscar en la lista.
	public Arco<T> obtenerArco(int verticeId1, int verticeId2);

	// Devuelve la cantidad total de vertices en el grafo
	// Este método tiene una complejidad de tiempo constante, O(1).
	// Contar la cantidad de vértices es rápido y no depende del tamaño del grafo, por lo que es una operación rápida.
	public int cantidadVertices();

	// Devuelve la cantidad total de arcos en el grafo
	// Este método tiene una complejidad de tiempo constante o lineal, O(1) o O(n).
	// Contar la cantidad de arcos puede ser rápido si se utiliza una estructura de datos eficiente para almacenar los arcos. 
	// Pero, si se necesita recorrer todas las conexiones, puede llevar más tiempo.
	public int cantidadArcos();

	// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
	// Este método tiene una complejidad de tiempo lineal, O(n).
	// Obtener todos los vértices lleva más tiempo ya que hay que recorrer todos los elementos almacenados en la estructura de datos.
	public Iterator<Integer> obtenerVertices();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
	// Este método tiene una complejidad de tiempo constante o lineal, O(1) o O(n).
	// Obtener los vértices adyacentes a un vértice específico puede ser rápido si se utiliza una estructura de datos eficiente para almacenar las conexiones. 
	// Pero, si se utiliza una lista de adyacencia, puede llevar más tiempo ya que hay que buscar en la lista.
	public Iterator<Integer> obtenerAdyacentes(int verticeId);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	// Este método tiene una complejidad de tiempo lineal, O(n).
	// Obtener todos los arcos lleva más tiempo ya que hay que recorrer todos los elementos almacenados en la estructura de datos.
	public Iterator<Arco<T>> obtenerArcos();
		
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	// Este método tiene una complejidad de tiempo constante o lineal, O(1) o O(n).
	// Obtener los arcos salientes de un vértice específico puede ser rápido si se utiliza una estructura de datos eficiente para almacenar las conexiones. 
	// Sin embargo, si se utiliza una lista de adyacencia, puede llevar más tiempo ya que hay que buscar en la lista.
	public Iterator<Arco<T>> obtenerArcos(int verticeId);
	
	
}