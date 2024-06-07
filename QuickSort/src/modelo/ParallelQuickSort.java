package modelo;

import java.util.concurrent.ForkJoinPool;

public class ParallelQuickSort {

	// Metodo que genera tarea, pileta e invoca la tarea para concurrencia
	public static void parallelQuickSort(int[] vector, int izquierda, int derecha) {
		SortTask mainTask = new SortTask(vector, izquierda, derecha);	// Se genera una tarea
		ForkJoinPool pool = new ForkJoinPool();				// Se genera una pileta de hilos
		pool.invoke(mainTask);						// Desde la pileta se invoca la tarea
	}

}
