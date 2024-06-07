package modelo;

import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class SortTask extends RecursiveAction {
	// Atributos
	private int[] vector;
	private int izquierda;
	private int derecha;

	// Constructor
	public SortTask(int[] vector, int izquierda, int derecha) {
		this.vector = vector;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	// Metodo recursivo con concurrencia
	@Override
	protected void compute() {
		if (izquierda >= derecha) {												// Condicion de corte de recursividad
			return;																// Si se cumple la condicion, quiere decir que izquierda es igual o mayor a derecha y
		}																		// no tiene sentido continuar ordenando

		int pivotPos = QuickSort.partition(vector, izquierda, derecha);			// Se obtiene la posicion del pivot
		SortTask firstHalfTask = new SortTask(vector, izquierda, pivotPos);		// Primera tarea: QuickSort del sub-arreglo a la izquierda del pivot
		SortTask secondHalfTask = new SortTask(vector, pivotPos + 1, derecha);	// Segunda tarea: QuickSort del sub-arreglo a la derecha del pivot

		invokeAll(firstHalfTask, secondHalfTask);								// Tareas que se van a ejecutar en paralelo
	}

}
