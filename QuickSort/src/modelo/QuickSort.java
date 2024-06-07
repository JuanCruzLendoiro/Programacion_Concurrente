package modelo;

public class QuickSort {

	// Metodo recursivo sin concurrencia
	public static void quickSort(int[] vector, int izquierda, int derecha) {
		if (izquierda >= derecha) {								// Condicion de corte de recursividad
			return;												// Si se cumple la condicion, quiere decir que izquierda es igual o mayor a derecha y
		}														// no tiene sentido continuar ordenando

		int pivotPos = partition(vector, izquierda, derecha);	// Se obtiene la posicion del pivot
		quickSort(vector, izquierda, pivotPos);					// Recursividad: QuickSort del sub-arreglo a la izquierda del pivot
		quickSort(vector, pivotPos + 1, derecha);				// Recursividad: QuickSort del sub-arreglo a la derecha del pivot
	}

	// Metodo que retorna la posicion del pivot y ordena el vector de menor a mayor (se invoca desde el metodo no concurrente y concurrente)
	public static int partition(int[] vector, int izquierda, int derecha) {
		int pivot = vector[izquierda];		// El pivot será el elemento en la posicion izquierda que llega por parametros
		int i = izquierda - 1;				// Se decrementa 1 para incrementarlo en do while
		int j = derecha + 1;				// Se incrementa 1 para decrementarlo en do while

		while (true) {						// Bucle infinito que termina cuando se cumpla la condicion del if y retorne
			do {
				i++;
			} while (vector[i] < pivot);	// Bucle hasta que el contenido de vector[i] sea mayor o igual al pivot
			do {
				j--;
			} while (vector[j] > pivot);	// Bucle hasta que el contenido de vector[j] sea menor o igual al pivot
			if (i >= j) {					// Si la posicion i(izquierda) es igual o mayor a j(derecha), el vector (entre izquierda y derecha de parametros)
				return j;					// esta ordenado y entonces j es la posicion del pivot que se retorna
			}
			int auxiliar = vector[i];		// Si se supera el if, se realiza el intercambio
			vector[i] = vector[j];
			vector[j] = auxiliar;
		}
	}

}
